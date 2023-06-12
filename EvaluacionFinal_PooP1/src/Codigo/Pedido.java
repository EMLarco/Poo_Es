package Codigo;

public class Pedido {//Creamos una clase privada por los datos
	private String producto;
	private String proveedor;
	private double precioUnitario;
	private int unidades;
	
	public Pedido(String producto, String proveedor, double precioUnitario, int unidades) {
		this.producto=producto;
		this.proveedor=proveedor;
		this.precioUnitario=precioUnitario;
		this.unidades=unidades;
	}



	public String getProducto(){
		
	return producto;

	}

	public String getProveedor() {
		
	return proveedor;
	
	}

	public double getprecioUnitario() {
		
	return precioUnitario;
	
	}

	public int getunidades() {
		
	return unidades;
	
	}
	public double precioTotal() {
		
		return precioUnitario*unidades;
		
	}
	public String toString() {
		return producto+proveedor+precioUnitario+unidades; 
	}
}
