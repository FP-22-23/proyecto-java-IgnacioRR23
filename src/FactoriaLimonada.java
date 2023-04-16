package src;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

public class FactoriaLimonada {
	public static Limonada parseaLimonada(String s){
		Limonada res;
		utiles.Checkers.checkNoNull(s);
		String [] trozos = s.split(",");
		utiles.Checkers.check("Formato no válido", trozos.length == 8);
		
		LocalDateTime fecha= LocalDateTime.parse(trozos[0].trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
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
	
	public static ContenedorLimonada leerLimonadas(String ruta) {
		ContenedorLimonada res=null;
		try {
			Stream<Limonada>  limonadas=Files.lines(Paths.get(ruta))
					.skip(1)
					.map(FactoriaLimonada::parseaLimonada);
					res = new ContenedorLimonada(limonadas);
			} catch(IOException e) {
			e.printStackTrace();
		}
	return res;
	}
}
