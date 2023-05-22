package src;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;





public class FactoriaLimonada {
	public static Limonadas leerLimonadas(String ruta) {
		Limonadas res=null;
		try {
			List<Limonada>  limonadas=Files.lines(Paths.get(ruta))
					.skip(1)
					.map(FactoriaLimonada::parseaLimonada)
					.collect(Collectors.toList());
					res = new ContenedorLimonada(limonadas);
			} catch(IOException e) {
			System.out.println("Fichero no encontrado: " + ruta);
			e.printStackTrace();
		}
	return res;
	
	}
	public static Limonada parseaLimonada(String s){
		utiles.Checkers.checkNoNull(s);
		String [] trozos = s.split(",");
		utiles.Checkers.check("Formato no válido", trozos.length == 8);
		
		LocalDate fecha= LocalDate.parse(trozos[0].trim(), DateTimeFormatter.ofPattern("M/dd/yyyy"));
		String ciudad = trozos[1].trim();
		TipoLugar lugar = TipoLugar.valueOf(trozos[2].trim().toUpperCase());
		Integer limonadasVendidas = Integer.parseInt(trozos[3].trim());
		Integer naranjadasVendidas = Integer.parseInt(trozos[4].trim());
		Double temperaturaF = Double.parseDouble(trozos[5].trim());
		Integer folletosRepartidos = Integer.parseInt(trozos[6].trim());
		Double precio = Double.parseDouble(trozos[7].trim());
		return new Limonada(fecha, ciudad, lugar, limonadasVendidas, naranjadasVendidas, temperaturaF, folletosRepartidos, precio);
	}
	
	public static List<Limonada> leerLimonadas2(String fichero){
		utiles.Checkers.checkNoNull(fichero);
		String errMsg = String.format("Error leyendo fichero <%s>", fichero);
		List<String> lineas = utiles.Ficheros.leeFichero(errMsg, fichero, StandardCharsets.UTF_8);
		
		List<Limonada> res = lineas.stream()
						.skip(1)
						.map(linea->parseaLimonada2(linea))
						.collect(Collectors.toList());
		return res;
	}
	
	private static Limonada parseaLimonada2(String lineaCSV) {
		Limonada res = null;
		utiles.Checkers.checkNoNull(lineaCSV);
		String [] trozos = lineaCSV.split(",");
		String msg=String.format("Formato Compra no válida <%s>", lineaCSV);
		utiles.Checkers.check(msg, trozos.length==8);
		
		LocalDate fecha = LocalDate.parse(trozos[0].trim(),
				DateTimeFormatter.ofPattern("M/d/yyyy")) ;
		String ciudad = trozos[1].trim();
		TipoLugar lugar = TipoLugar.valueOf(trozos[2].trim().toUpperCase());
		Integer limonadasVendidas = Integer.parseInt(trozos[3].trim());
		Integer naranjadasVendidas = Integer.parseInt(trozos[4].trim());
		Double temperaturaF = Double.parseDouble(trozos[5].trim());
		Integer folletosRepartidos = Integer.parseInt(trozos[6].trim());
		Double precio = Double.parseDouble(trozos[7].trim());
		res = new Limonada(fecha, ciudad, lugar, limonadasVendidas, naranjadasVendidas, temperaturaF, folletosRepartidos, precio);
	
		return res;
	}
}
