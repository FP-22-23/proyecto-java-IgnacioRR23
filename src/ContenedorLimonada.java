package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ContenedorLimonada {
	
	//Atributo
		private List<Limonada> puesto;
		
		
	//Constructores
	public ContenedorLimonada() {
		this.puesto = new ArrayList<>();
	}
		
	public ContenedorLimonada(Stream<Limonada> st) {
		this.puesto = st.collect(Collectors.toList());
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
	
	public int calcularNumPuestos(List<Limonada> puesto) {
		return puesto.size();
	}
	
	public boolean existePuesto(List<Limonada> puesto, Limonada l) {
	    return puesto.contains(l); //Devuelve si existe el puesto en la lista
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
