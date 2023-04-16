package src;

public class TestLimonadaFactoria {

	public static void main(String[] args) {
		testPuestoLimonada();
	}

	private static void testPuestoLimonada() {
			System.out.println("Test de los puestos de limonadas y naranjadas: ");
			ContenedorLimonada puesto = FactoriaLimonada.leerLimonadas("./data/Lemonade2016-2-1.csv");
			System.out.println("Capítulo Friends: " + puesto);
		}
}
