package src;

import java.time.LocalDate;

public class Limonada {
	
	//Atributos
	private LocalDate fecha;
	private String ciudad;
	private LugarVenta lugar;
	private Integer limonadasVendidas;
	private Integer naranjadasVendidas;
	private Integer temperaturaF;
	private Integer temperaturaC;
	private Float folletosSuficientes;
	private Double precio;
	
	//Constructores
	public Limonada (LocalDate fecha, String ciudad, Integer limonesVendidos, Integer naranjasVendidas, Integer temperaturaF, Float folletosSuficientes, Double precio) {
		this.fecha = fecha;
		this.ciudad = ciudad;
		this.limonadasVendidas = limonesVendidos;
		this.naranjadasVendidas = naranjasVendidas;
		this.temperaturaF = temperaturaF;
		this.folletosSuficientes = folletosSuficientes;
		this.precio = precio;
		lugar = null;	
	}

	@Override
	public String toString() {
		return "Limonada [A fecha= " + fecha + ", en la ciudad de =" + ciudad + ", en el lugar= " + lugar + ", la cantidad de limonadas vendidas fue de= "
				+ limonadasVendidas + ", la cantidad de naranjas vendidas fue de= " + naranjadasVendidas + ", a una temperatura Fahrenheit de= " + temperaturaF
				+ ", en Celsius= " + temperaturaC + ", fueron repartidos los suficientes folletos= " + folletosSuficientes + ", a un precio por limonada/naranjada de= "
				+ precio + "]";
	}

}
