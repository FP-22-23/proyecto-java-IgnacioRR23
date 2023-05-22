package common;

public record Ventas(Integer limonadasVendidas, Integer naranjadasVendidas) {

	public String toString() {
		return "Ventas [limonadasVendidas=" + limonadasVendidas + ", naranjadasVendidas=" + naranjadasVendidas + "]";
	}

}
