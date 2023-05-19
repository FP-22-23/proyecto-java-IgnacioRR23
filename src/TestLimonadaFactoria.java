package src;

import java.util.List;


public class TestLimonadaFactoria {

	public static void main(String[] args) {

		List<Limonada> puesto = FactoriaLimonada.leerLimonadas2("./data/Lemonade2016A.csv");
		System.out.println("Se han leido " + puesto.size() + " datos de puestos");
		for (Limonada l : puesto) {
			System.out.println(l);
			}
	}
}

//	private static void testPuestoLimonada() {
//			System.out.println("Test de los puestos de limonadas y naranjadas: ");
//			List<Limonada> puesto = FactoriaLimonada.leerLimonadas2("./data/prueba1.csv");
//			System.out.println("Puesto limonada: " + puesto);
//		}
//	
//	}
//}
