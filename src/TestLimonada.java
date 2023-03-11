package src;

import java.time.LocalDateTime;

import common.Ventas;

public class TestLimonada {

	public static void main(String[] args) {

		
		Ventas v = new Ventas(60, 50);
		Limonada l = new Limonada(LocalDateTime.now(), "Los Ángeles", 90.0, 90, 0.5);
		Limonada l1 = new Limonada(LocalDateTime.now(), "Los Ángeles", 90.0, 90, 0.5);
		l.incorpora(v);
		l.setLugar(TipoLugar.BEACH);
		l1.setLugar(TipoLugar.PARK);
		System.out.println(l);
		System.out.println(l.hashCode());
		System.out.println(l1.hashCode());
		System.out.println(l.equals(l1));
		System.out.println(l.compareTo(l1));
		Limonada l2 = new Limonada("Orlando", 87.0, 90);
		System.out.println(l2);
	}

}
