package uiMain;

import baseDatos.Serializador;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import gestorAplicacion.*;
import gestorAplicacion.primero.Administrador;
import gestorAplicacion.primero.Cuenta;
import gestorAplicacion.primero.Huesped;
import gestorAplicacion.primero.Persona;
import gestorAplicacion.segundo.Habitacion;
import gestorAplicacion.segundo.Reserva;
import gestorAplicacion.segundo.Restaurante;

import java.util.Scanner;

public class Principal {
	
	static Scanner sc = new Scanner(System.in);
	static long readLong() {
		return sc.nextLong();
	}
	static int readInt() {
		return sc.nextInt();
	}
	static String readln () {
		sc.nextLine ();
		return sc.next();
	}
	static float readFloat() {
		return sc.nextFloat();
	}
	public static void main(String[] args) {
		
	
		Administrador adminis = new Administrador();
		Reserva reserva = new Reserva();
		Restaurante restaurante = new Restaurante();
		Huesped huesped = new Huesped();
		Cuenta cuenta = new Cuenta();
//		reserva.agregar(1, 1, "22/05/2022", "22/05/2022", "23/05/2022", 80000);
//		System.out.println(Reserva.reserva);
//		
//		int b = Reserva.reserva.size();
//		
//		for(int i=0; i<b; i++ ) {
//			System.out.println(reserva.reserva.get(i).getPago());
//			System.out.println(reserva.reserva.get(i).getFechaLlegada());
//			System.out.println(reserva.reserva.get(i).getFechaSalida());
//			System.out.println(reserva.reserva.get(i).getNumeroReserva());
//			
//		}
		

		
	
	    
	    int opcion;
		do {
			
			System.out.println("Que operacion desea realizar");
			System.out.println("1. Hacer una Reserva");
			System.out.println("2. Mostrar Reservas ");
			System.out.println("3. Modificar Fecha de la Reserva");
			System.out.println("4. Usar Restaurante");
			System.out.println("5. Pedir Cuenta");
			System.out.println("6. Ingresar habitacion");
			System.out.println("7. mostrar habitaciones");
			System.out.println("8. ingresar persona");
			System.out.println("9. mostrar personas");
			System.out.println("10. Salir");
			System.out.println("teclee opcion");
			opcion = (int) readLong();
			switch(opcion) {
			case 1: hacerReserva(adminis);
				break;
			case 2: mostrarReservas(adminis); 
				break;
			case 3: modificarFechaReserva(adminis);
				break;
			case 4: usarRestaurante(restaurante);
				break;
			
			case 6: ingresarHabitacion(adminis);
				break;
			case 7: mostrarHabitaciones(adminis);
				break;
			case 8: ingresarPersona(adminis);
				break;
			case 9: mostrarPersonas(adminis);
				break;
			case 10: salirDelsistema(adminis); 
				break;
			
		}
		}while (opcion !=11);
	}
	
	
	static void ingresarHabitacion(Administrador resv) {
		System.out.print("Numero de la habitacion: ");
		int numerohabitacion = readInt ();
		System.out.print("Ingresa su precio: ");
		float precioHabitacion = readFloat();
		System.out.print("Ingresa el numero de camas: ");
		int numeroCamas = readInt();
		System.out.print("Ingresa su tipo: ");
		int tipo = readInt();
		System.out.print("capacidad de la habitacion: ");
		int capacidad = readInt();
		Habitacion habitacion = resv.nuevaHabitacion(numerohabitacion,precioHabitacion, true,  numeroCamas, tipo, capacidad);
		System.out.println("ingresada con exito");
	}
	
	static void mostrarHabitaciones(Administrador reser) {
		System.out.println(reser.listaHabitaciones());
	}
	
	//public void hacerPedido( int numPlato,int cantidadPlatos, int numBebida,  int cantidadBebidas)
	static void usarRestaurante(Restaurante restaurante) {
		System.out.println(restaurante.imprimirMenu());
		System.out.println(restaurante.imprimirBebidas());
		System.out.println("Ingresa el numero del plato: ");
		int numeroPlato = readInt();
		System.out.println("Ingresa la cantidad: ");
		int cantidadPlatos = readInt();
		System.out.println("Ingresa el numero de la bebida: ");
		int numeroBebida = readInt();
		System.out.println("Ingresa la cantidad: ");
		int cantidadBebidas = readInt();
		restaurante.hacerPedido(numeroPlato, cantidadPlatos, numeroBebida, cantidadBebidas);
	}
	static void modificarFechaReserva(Administrador adminis) {
		System.out.println("Numero Reserva: ");	
		int numeroReserva = readInt ();
		System.out.println("Ingresa la nueva fecha de llegada: ");
		String nuevaFechaLlegada = sc.next();
		System.out.println("Ingresa la nueva fecha de salida: ");
		String nuevaFechaSalida = sc.next();
		
		adminis.editarFechas(numeroReserva, nuevaFechaLlegada, nuevaFechaSalida);
		//resv.editarFechas(numeroReserva, nuevaFechaLlegada, nuevaFechaSalida);
		System.out.println("Fecha modificada con exito");
	}
	
	
	//////////
	static void hacerReserva(Administrador resv) {
		System.out.print("Numero de la habitacion: ");
		int numerohabitacion = readInt ();
		Habitacion habi = resv.buscarDisponibilidad(numerohabitacion);
		if (habi == null) {
			System.out.println("habitacion no disponible");
		}
		else {
			
			System.out.print("Ingresa la fecha se reserva: ");
			String fehares = readln();
			System.out.print("Ingresa la fecha de llegada: ");
			String fechall = readln();
			System.out.print("Ingresa la fecha de salida: ");
			String fechasal = readln();
			float pago = resv.buscarCodigoHabitacion(numerohabitacion);
			resv.cambiarDisponibilidad(numerohabitacion);
			Reserva reserva = resv.nuevaReserva(numerohabitacion,fehares, fechall,  fechasal, pago);
			System.out.println("reservada con exito");
		}
	}
	///////////
	static void mostrarReservas(Administrador reser) {
		System.out.println(reser.listaReservas());
	}
	
	
	//public Persona(int id, String nombre, String apellido, String fechaNacimiento, String sexo)
	static void ingresarPersona(Administrador resv)  {
		System.out.print("Ingresa el ID: ");
		int id = readInt ();
		System.out.print("Ingresa el nombre: ");
		String nombre = readln();
		System.out.print("Ingresa fecha nacimiento: ");
		String fecha = readln();
		System.out.print("Ingresa el sexo: ");
		String sexo = readln();
		Persona person = resv.nuevaPersona(id, nombre, fecha, sexo);
		System.out.println("ingresada con exito");
	}
	
	static void mostrarPersonas(Administrador reser) {
		System.out.println(reser.listaPersonas());
	}
	
	private static void salirDelsistema(Administrador dpto) {
		System.out.println("vuelva pronto");
		Serializador.serializar(dpto);
		System.exit(0);
		
	}
	
}
		//public String agregar(int numero, int numeroHabitacion, String fechaReserva, 
		//String fechaInicio, String fechaFinal, int precio)
		
	//agregar(int numero, int numeroHabitacion, String fechaReserva, String fechaInicio, String fechaFinal, int pago)
	
	
	/****
	static void hacerReserva(Reserva reserva) {
//		 
			System.out.println(reserva.agregar(8, 1, "22/05/2022", "22/05/2022", "23/05/2022", 80000));
////			System.out.println("ingrese numero de la reserva");
////			int numero = readInt();
////			System.out.println("ingrese numero de la habitacion");
////			int numero2 = readInt();
////			System.out.println("ingrese la fecha de realizada la reserva");
////			String fechaReserva = readln();
////			System.out.println("Ingrese la fecha inical de su estadia");
////			String fechaInicial = readln();
////			System.out.println("Ingrese la fecha de Salida");
////			String fechaSalida = readln();
////			System.out.println("Ingrese el pago");
////			float numero3 = readFloat();
//			reserva.agregar(numero, numero2, fechaReserva, fechaInicial, fechaSalida, numero3);
			
			int a = Reserva.reserva.size();
			
			for(int i=0; i<a; i++ ) {
				System.out.println(Reserva.reserva.get(i).getNumeroReserva());
				
			}
			}
		
		 static void eliminarReserva(Reserva reserva) {
			System.out.print("Ingrese el numero de la reserva");
			int numero = readInt ();
			System.out.println(reserva.eliminar(numero));
			
			int a = Reserva.reserva.size();
			
			for(int i=0; i<a; i++ ) {
				System.out.println(Reserva.reserva.get(i).getNumeroReserva());
			}
		}
	
		
		
//		static void mostrarMatriculados (Departamento dpto) {
//			System.out.print("Codigo de la asignatura: ");
//			long codigo = readLong();
//			Asignatura asignatura = dpto.buscarAsignatura(codigo);
//			
//			if(asignatura == null) {
//				System.out.println("No existe la asignatura");
//				return;
//			}
//			System.out.println(asignatura.listaAlumnos());
//		}
//		
//		static void mostrarAsignaturas(Departamento dpto) {
//			System.out.println(dpto.listaAsignaturas());
//		}
//		
//		
//		private static void salirDelsistema(Departamento dpto) {
//			System.out.println("vuelva pronto");
//			Serializador.serializar(dpto);
//			System.exit(0);
//			
//		}
		
		
		
		//public Habitacion(int numero, float precio, boolean estado, int numeroCamas, int tipo, int capacidad)
		//tipo 1 sencilla numCamas 1
		//tipo 2 doble   numCamas 2
		//tipo 3 Familiar  numCamas 3
		//tipo 4 vip   numCamas 1
		
		
		

//		public Reserva(int numero, int numeroHabitacion, String fechaReserva, String fechaLlegada, String fechaSalida, int precio) {
//			super();
//			this.numero = numero;
//			this.numeroHabitacion = numeroHabitacion;
//			this.fechaReserva = fechaReserva;
//			this.fechaLlegada = fechaLlegada;
//			this.fechaSalida = fechaSalida;
//			this.precio = precio;
//			reserva.add(this);
//		}
		//"dd/MM/uuuu"
		
		//public Reserva(int numero, String fechaReserva, String fechaLlegada, String fechaSalida, int precio)
//		Reserva reserva1 = new Reserva(1, "22/05/2022","23/05/2022","25/05/2022",100000);
//		Reserva reserva2 = new Reserva(2, "22/05/2022","23/05/2022","25/05/2022",100000);
		
//		for(Reserva rev: Reserva.reserva) {
//			System.out.println(rev.getNumero());
//		}
	    
//	    System.out.println(Reserva.eliminar(1));
//	   
//	    System.out.println(Reserva.reserva.size());
//	    System.out.println(Habitacion.mostrarDisponibles());
}
	
*///////////