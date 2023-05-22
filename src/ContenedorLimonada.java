package src;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ContenedorLimonada implements Limonadas {
	
	//Atributo
		private static List<Limonada> puesto;
		
		
	//Constructores
	public ContenedorLimonada() {
		puesto = new ArrayList<Limonada>();
	}
	
	public ContenedorLimonada(Collection<Limonada> puesto) {
		ContenedorLimonada.puesto = new ArrayList<Limonada>(puesto);
	}
		
	public ContenedorLimonada(Stream<Limonada> puesto) {
		ContenedorLimonada.puesto = puesto.collect(Collectors.toList());
	}

	//Métodos
	public void añadirPuesto(Limonada l) {      
		puesto.add(l);
	    }
		    
	public void eliminarCap(Limonada l) {     
	    if (!puesto.contains(l)) {
	        throw new IllegalArgumentException("Este puesto es inexistente");
	    } else {
	    	puesto.remove(l);
	    }
	}
	
	public int calcularNumPuestos() {
		return puesto.size();
	}
	
	public boolean existePuesto(Limonada l) {
	    return puesto.contains(l); //Devuelve si existe el puesto en la lista
	}
	
	public boolean existePuesto2(Limonada l) {
	    return puesto.stream().anyMatch(p -> p.equals(l));
	}

	public Map<String, Integer> contarCiudades() {
		Map<String, Integer> m = new HashMap<String, Integer>();
		for (Limonada l : puesto) {
			String clave = l.getCiudad();
			if (m.containsKey(clave)) {
				m.put(clave, m.get(clave) + 1);
			} else {
				m.put(clave, 1);
			}
		}
		return m;
	}
	
	public Map<String, Integer> contarCiudades2() {
	    return puesto.stream()
	            .collect(Collectors.groupingBy(Limonada::getCiudad, Collectors.summingInt(e -> 1)));
	}
	
	public Map<Double, String> getCiudadPorTemperatura(){
		Map<Double, String> m = new HashMap<Double, String>();
		for (Limonada l: puesto) {
			Double clave = l.getTemperaturaF();
			if (m.containsKey(clave)) {
				m.put(clave, m.get(clave)+ l.getCiudad());
			} else {
				m.put(clave, l.getCiudad());
			}
		}
		return m;
	}
	
	public Map<Double, String> getCiudadPorTemperatura2() {
	    return puesto.stream()
	            .collect(Collectors.toMap(Limonada::getTemperaturaF, Limonada::getCiudad, (ciudad1, ciudad2) -> ciudad1 + ciudad2));
	}
	
	public Map<TipoLugar,List<Limonada>> getPuestoSegunLugar(){
		Map<TipoLugar,List<Limonada>> res = new HashMap<TipoLugar,List<Limonada>>();
		for(Limonada l: puesto) {
			if(res.containsKey(l.getLugar())){
				res.get(l.getLugar()).add(l);
			}
			else {
				ArrayList<Limonada> puesto = new ArrayList<>();
				puesto.add(l);
				res.put(l.getLugar(), puesto);
			}
		}
		return res;
	}
	
	public Map<TipoLugar,List<Limonada>> getPuestoSegunLugar2(){
		Map<TipoLugar,List<Limonada>> res = new HashMap<TipoLugar,List<Limonada>>();
		for(Limonada l: puesto) {
			if(res.containsKey(l.getLugar())){
				res.get(l.getLugar()).add(l);
			}
			else {
				ArrayList<Limonada> puesto = new ArrayList<>();
				puesto.add(l);
				res.put(l.getLugar(), puesto);
			}
		}
		return res;
	}
	
	public static Limonada obtenerCiudadMayorTemperatura() {
        Optional<Limonada> limonadaMayorTemperatura = puesto.stream()
                .filter(l -> l.getLimonadasVendidas() > 90)
                .max(Comparator.comparingDouble(Limonada::getTemperaturaF));

        return limonadaMayorTemperatura.orElse(null);
    }
	
	public static List<Limonada> seleccionarLimondas() {
        return puesto.stream()
                .filter(l -> l.getLimonadasVendidas() > 90 && l.getTemperaturaF() > 75.0)
                .sorted(Comparator.comparing(Limonada::getLimonadasVendidas).reversed())
                .collect(Collectors.toList());
    }
	
	public static List<Double> obtenerPreciosLimonadas() {
        return puesto.stream()
                .map(Limonada::getPrecio)
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        precios -> {
                            double promedio = precios.stream()
                                    .mapToDouble(Double::doubleValue)
                                    .average()
                                    .orElse(0.0);
                            return precios.stream()
                                    .map(precio -> precio + promedio)
                                    .collect(Collectors.toList());
                        }));      
    }
	
	public static Map<String, Limonada> obtenerMaximosMinimosLimonadasVendidas() {
        Map<String, Limonada> resultados = new HashMap<>();

        resultados.put("maximo", puesto.stream().max(Comparator.comparing(Limonada::getLimonadasVendidas)).orElse(null));
        resultados.put("minimo", puesto.stream().min(Comparator.comparing(Limonada::getLimonadasVendidas)).orElse(null));

        return resultados;
    }
	
	public static SortedMap<Integer, List<Limonada>> obtenerNLimonadasMasVendidas(int n) {
        SortedMap<Integer, List<Limonada>> resultados = puesto.stream()
                .collect(Collectors.groupingBy(Limonada::getLimonadasVendidas, TreeMap::new, Collectors.toList()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, List<Limonada>>comparingByKey().reversed())
                .limit(n)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (l1, l2) -> l1, TreeMap::new));

        return resultados;
    }
	
	public static LocalDate obtenerFechaMayorTemperatura() {
	    LocalDate fechaMayorTemperatura = null;
	    Double temperaturaMaxima = Double.MIN_VALUE;

	    for (Limonada limonada : puesto) {
	        if (limonada.getTemperaturaF() > temperaturaMaxima) {
	            temperaturaMaxima = limonada.getTemperaturaF();
	            fechaMayorTemperatura = limonada.getFecha();
	        }
	    }

	    return fechaMayorTemperatura;
	}



	@Override
	public String toString() {
		return "ContenedorLimonada [puesto de limonada y naranjada=" + puesto + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(puesto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContenedorLimonada other = (ContenedorLimonada) obj;
		return Objects.equals(puesto, other.puesto);
	}
		
}
