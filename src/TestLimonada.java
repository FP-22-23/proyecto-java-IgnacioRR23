package src;


import java.time.LocalDate;
import java.util.List;

import common.Ventas;

public class TestLimonada {
	
	public static void testContarCiudades(ContenedorLimonada p) {
		System.out.println(p.contarCiudades());
	}
	
	public static void testObtenerNLimonadasMasVendidas(ContenedorLimonada p, int n) {
		System.out.println(ContenedorLimonada.obtenerNLimonadasMasVendidas(n));
	}

	public static void main(String[] args) {

//		//Constructor 1
		Ventas v = new Ventas(60, 50);
		Limonada l = new Limonada(LocalDate.now(), "Los Ángeles", 90.0, 90, 0.5);
		Limonada l1 = new Limonada(LocalDate.now(), "Los Ángeles", 90.0, 90, 0.5);
		l.incorpora(v);
		l.setLugar(TipoLugar.BEACH);
		l1.setLugar(TipoLugar.PARK);
//		System.out.println(l);
//		System.out.println("El Hash Code de l es: " + l.hashCode());
//		System.out.println("El Hash Code de l1 es: " +l1.hashCode());
//		System.out.println("¿Son l y l1 iguales? " + l.equals(l1));
//		System.out.println("l comparado con l1: " + l.compareTo(l1));
//		//Constructor 2
//		Limonada l2 = new Limonada("Orlando", 87.0, 90);
//		System.out.println(l2);
		
		List<Limonada> puesto = FactoriaLimonada.leerLimonadas2("./data/Lemonade2016AC.csv");
		ContenedorLimonada p = new ContenedorLimonada(puesto);
		testContarCiudades(p);
		testObtenerNLimonadasMasVendidas(p,5);
	}		
}

