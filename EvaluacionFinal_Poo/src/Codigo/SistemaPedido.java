package Codigo;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaPedido {
	private ArrayList<Pedido> pedidos;
	private Scanner loop;
	
	public SistemaPedido() {
		pedidos=new ArrayList <>();
		loop=new Scanner(System.in);
	}
	
	public void iniciar() {
		int opcion;
		do {
			mostrarMenu();
			opcion= loop.nextInt();
			loop.nextLine();
			switch (opcion) {
			case 1:
				mostrarProducto();//Llamamos a la funcion mostrar producto
				break;
			case 2:
				mostrarProveedores();//Llamamos a la funcion mostrar proveedores
				break;
			case 3:
				agregarPedidos();//Llamamos a la funcion agregar pedidos
				break;
			case 4:
				mostrarPedidoMayor();//Llamamos a la funcion mostrar pedido mayor
				break;
			case 5:
				mostrarTotalFacturado();//Llamamos a la funcion mostrar el total facturado
				break;
			case 6:
				
				break;
			default:
				System.out.println("Opcion incorreta ingrese una opcion correcta");
				break;
			}
		}while(opcion!=6);

	}
	
	public void mostrarMenu() {
		System.out.println("----Menu----");
		System.out.println("1.- Productos");
		System.out.println("2.- Proveedores");
		System.out.println("3.- Nuevo pedido");
		System.out.println("4.- Pedido mayor");
		System.out.println("5.- Total Facturado");
		System.out.println("6.- Salir");
		System.out.print("Seleccione una opcion");
	}
	
	public void mostrarProducto() {
		System.out.println("----Productos----");
		//Se muestran los productos guardados en el sistema
	}
	
	public void mostrarProveedores() {
		System.out.println("----Proveedores----");
		//Se muestran los proveedores guardados en el sistema
	}
	
	private void agregarPedidos() {
		System.out.println("----Nuevo Pedido----");
		System.out.print("Ingrese el producto");
		String producto= loop.nextLine();
		
		System.out.print("Ingrese el proveedor");
		String proveedor= loop.nextLine();
		
		System.out.print("Ingrese el precio unitario");
		double precioUnitario=loop.nextDouble();
		
		System.out.print("Ingrese la cantidad de unidades");
		int unidades=loop.nextInt();
		
		Pedido pedido= new Pedido(producto,proveedor,precioUnitario,unidades);
		pedidos.add(pedido);
		System.out.println("Pedido agregado correctamente");
	}
	
	private void mostrarPedidoMayor() {
		System.out.println("----Pedido Mayor----");
		Pedido pedidoMayor= null;
		double totalMayor=0;
		
		for(Pedido pedido: pedidos) {
			double totalPedido=pedido.precioTotal();
			if(totalPedido>totalMayor) {
				totalMayor=totalPedido;
				pedidoMayor=pedido;
			}
		}
		if (pedidoMayor!=null) {
			System.out.println("Producto"+pedidoMayor.getProducto());
			System.out.println("Proveedor"+pedidoMayor.getProveedor());
			System.out.println("Precio Unitario"+pedidoMayor.getprecioUnitario());
			System.out.println("Unidades"+pedidoMayor.getunidades());
			System.out.println("Total Facturado"+pedidoMayor.precioTotal());
		}else {
			System.out.println("No hay pedidos registrados");
		}
	}
	
	private void mostrarTotalFacturado() {
		System.out.println("");
		double totalFacturado=0;
		
		for(Pedido pedido:pedidos) {
			totalFacturado+=pedido.precioTotal();
		}
		System.out.println("Total Facturado"+totalFacturado);
	}
	
}