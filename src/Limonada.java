package src;

import java.time.LocalDate;

public class Limonada {
	
	//Atributos
	private LocalDate fecha;
	private String ciudad;
	private LugarVenta lugar;
	private Integer limonesVendidos;
	private Integer naranjasVendidas;
	private Integer temperaturaF;
	private Integer temperaturaC;
	private Float folletosSuficientes;
	private Double precio;
	
	//Constructores
	public Limonada (LocalDate fecha, String ciudad, Integer limonesVendidos, Integer naranjasVendidas, Integer temperaturaF, Float folletosSuficientes, Double precio) {
		this.fecha = fecha;
		this.ciudad = ciudad;
		this.limonesVendidos = limonesVendidos;
		this.naranjasVendidas = naranjasVendidas;
		this.temperaturaF = temperaturaF;
		this.folletosSuficientes = folletosSuficientes;
		this.precio = precio;
		lugar = null;	
	}

}
