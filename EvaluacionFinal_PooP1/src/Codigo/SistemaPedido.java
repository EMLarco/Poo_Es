package Codigo;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaPedido {
	private ArrayList<Pedido> pedidos;
	private Scanner loop;
	private ArrayList<Producto> productos;

	
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
	        		mostrarProducto();
	        		break;
	        	case 2:
	        		mostrarProveedores();
	        		break;
	        	case 3:
	        		agregarPedidos();
	        		break;
	        	case 4:
	        		mostrarPedidoMayor();
	            	break;
	        	case 5:
	        		mostrarTotalFacturado();
	            	break;
	        	case 6:
	        		// Opción para salir del programa
	        		System.out.println("Saliendo del programa...");
	        		System.exit(0);
	        		break;
	        	case 7:
	        		agregarProducto();
	            	break;
	        	case 8:
	        		agregarProveedor();
	            	break;
	        	default:
	        		System.out.println("Opcion incorrecta. Ingrese una opcion correcta.");
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
	    System.out.print("Seleccione una opcion: ");
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
	
	public void agregarProducto() {
	    System.out.println("----Agregar Producto----");
	    System.out.print("Ingrese el nombre del producto: ");
	    String nombreProducto = loop.nextLine();

	    System.out.print("Ingrese la descripción del producto: ");
	    String descripcionProducto = loop.nextLine();

	    System.out.print("Ingrese el precio del producto: ");
	    double precioProducto = loop.nextDouble();
	    loop.nextLine(); // Consumir el salto de línea después de leer el double

	    // Crear una instancia del producto con los datos ingresados
	    Producto producto = new Producto(nombreProducto, descripcionProducto, precioProducto);

	    // Agregar el producto a la lista de productos en el sistema
	    productos.add(producto);

	    System.out.println("Producto agregado correctamente");
	}
	
	public void agregarProveedor() {
	    System.out.println("----Agregar Proveedor----");
	    System.out.print("Ingrese el nombre del proveedor: ");
	    String nombreProveedor = loop.nextLine();

	    System.out.print("Ingrese la dirección del proveedor: ");
	    String direccionProveedor = loop.nextLine();

	    System.out.print("Ingrese el número de teléfono del proveedor: ");
	    String telefonoProveedor = loop.nextLine();

	    // Crear una instancia del proveedor con los datos ingresados
	    Proveedor proveedor = new Proveedor(nombreProveedor, direccionProveedor, telefonoProveedor);

	    // Agregar el proveedor a la lista de proveedores en el sistema
	    proveedores.add(proveedor);

	    System.out.println("Proveedor agregado correctamente");
	}


	
}
