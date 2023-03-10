package src;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import common.Ventas;
import utiles.Checkers;


public class Limonada {
	
	//Atributos
	private LocalDateTime fecha;
	private String ciudad;
	private TipoLugar lugar;
	private Double temperaturaF;
	private Double temperaturaC;
	private Integer folletosRepartidos;
	private Double precio;
	private List<Ventas> ventasLN;
	
	public Boolean getfolletosSuficientes() {
		return (folletosRepartidos > 100); //Se considerarĂ¡ que se han repartido suficientes folletos a partir de 100.
	}
	
	//Constructores
	public Limonada (LocalDateTime fecha, String ciudad, Double temperaturaF, Integer folletosRepartidos, Double precio) {
		this.fecha = fecha;
		this.ciudad = ciudad;
		this.temperaturaF = temperaturaF;
		this.temperaturaC = (temperaturaF-32)/1.8;
		this.folletosRepartidos = folletosRepartidos;
		Checkers.check("Error en el precio", precio >=0);
		this.precio = precio;
		lugar = null;
		ventasLN = new LinkedList<Ventas>();
	}
	
	public Limonada(String ciudad, Double temperaturaF, Integer folletosRepartidos) {
		super();
		this.ciudad = ciudad;
		this.temperaturaF = temperaturaF;
		this.temperaturaC = (temperaturaF-32)/1.8;
		this.folletosRepartidos = folletosRepartidos;
	}

	public int hashCode() {
		return Objects.hash(ciudad, lugar, precio, temperaturaC, temperaturaF);
	}
	

	//Criterio de igualdad definido por la ciudad, el lugar, el precio y la temperatura.
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Limonada other = (Limonada) obj;
		return Objects.equals(ciudad, other.ciudad) && lugar == other.lugar
				&& Objects.equals(precio, other.precio) && Objects.equals(temperaturaC, other.temperaturaC)
				&& Objects.equals(temperaturaF, other.temperaturaF);
	}
	
	//Criterio de orden natural
	public int compareTo(Limonada l) {
		int res = this.getLugar().compareTo(l.getLugar());
		if (res==0) {
			res = this.getPrecio().compareTo(l.getPrecio());
		}
		return res;
	}

	public Double getPrecio() {
		return precio;
	}

	public TipoLugar getLugar() {
		return lugar;
	}

	public void setLugar(TipoLugar lugar) {
		this.lugar = lugar;
	}

	public List<Ventas> getVentasLN() {
		return ventasLN;
	}

	public void setVentasLN(List<Ventas> ventasLN) {
		this.ventasLN = ventasLN;
	}

	public void incorpora(Ventas v) {
		Checkers.check("Error, no se ha vendido ninguna cantidad", v.limonadasVendidas()>=0 && v.naranjadasVendidas()>=0);
		ventasLN.add(v);
	}
		
	//toString
	public String toString() {
		return "Limonada [A fecha= " + fecha + ", en la ciudad de =" + ciudad + ", en el lugar= " + getLugar() +", la cantidad de limonada y naranjas vendidas fue de= " + getVentasLN() + ", a una temperatura Fahrenheit de= " + temperaturaF
				+ ", en Celsius= " + temperaturaC + ", fueron repartidos los suficientes folletos= " + getfolletosSuficientes() + ", a un precio por limonada/naranjada de= "
				+ precio + "]";
	}

}
