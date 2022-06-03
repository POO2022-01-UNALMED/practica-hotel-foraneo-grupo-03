package gestorAplicacion.primero;
import gestorAplicacion.segundo.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;



import baseDatos.Deserializador;

import java.io.Serializable;

public class Administrador extends Persona implements Serializable{
	private static final long serialversionUID = 1L;
	
	private float sueldo;
	private int antiguedad;
	private String horario;
	private static float precio;
	Reserva reserva;
	Cuenta cuenta;
	Huesped huesped;
	Persona persona;
	ServicioHabitacion servicioHabitacion;
	Restaurante restaurante;
	public  List<Habitacion> habitaciones = new ArrayList<Habitacion>();
	public  List<Persona> personas = new ArrayList<Persona>();
	public  List<Reserva> reservas = new ArrayList<Reserva>();  //uno
	
	public Administrador () {
		super();
		Deserializador.deserializar(this);
	}

	public Administrador (int id, String nombre, String apellido, String fechaNacimiento, String sexo) {
		super(id, nombre, apellido, fechaNacimiento, sexo);
	}
	
	
	public List<Habitacion> getHabitaciones(){
		return habitaciones;
	}
	@Override
	public String concatenarDatos() {
		String datos = this.descripcion();
		datos += "\nSueldo: " + this.getSueldo() + 
				"\nAntiguedad: " + Integer.toString(this.getAntiguedad()) + 
				"\nHorario " + this.horario;
				
		return datos;
	}
	
	
	public void setHabitacion(List<Habitacion>habitacion) {
		this.habitaciones = habitacion;
	}
	
	public String listaHabitaciones() {
		Iterator<Habitacion> iterator = habitaciones.iterator();
		StringBuffer lista = new StringBuffer ();
		while (iterator.hasNext()) {
			Habitacion habitacion =
			(Habitacion) iterator.next();
			lista.append(habitacion.descripcion() + "\n");
		}
		return lista.toString();
	}
	
	public Habitacion nuevaHabitacion (int numero, float precio, boolean estado, int numeroCamas,int tipo, int capacidad) {
		Habitacion habitacion = new Habitacion(numero, precio, estado, numeroCamas, tipo, capacidad);
		habitaciones.add(habitacion);
		return habitacion;
	}
	
	public List<Persona> getPersonas(){
		return personas;
	}
	
	public void setPersonas(List<Persona>personas) {
		this.personas = personas;
	}
	
	public String listaPersonas() {
		Iterator<Persona> iterator = personas.iterator();
		StringBuffer lista = new StringBuffer ();
		while (iterator.hasNext()) {
			Persona persona =
			(Persona) iterator.next();
			lista.append(persona.descripcion() + "\n");
		}
		return lista.toString();
	}
	
//	public Huesped(int id, String nombre, String apellido, String fechaNacimiento, String sexo) {
//		super(id, nombre, apellido, fechaNacimiento, sexo);
//	}
	
	public Persona nuevaPersona (int id,  String nombre, String apellido, String fechanacimeinto, String sexo) {
		Persona persona = new Huesped(id, nombre, apellido, fechanacimeinto, sexo);
		personas.add(persona);
		return persona;
	}
	
	
	//El administrador crea una persona, si esta no se encuentra registrada en la base de datos, pues no
	//es posible crear una reserva sin tener registrada la persona, además valida que no se duplique.
	public String agregarPersona(int id, String nombre, String apellido, String fechaNacimiento, String sexo) {
		String aux = "";
		boolean duplicado = false;
		
		for(Persona per: Persona.personas) {
			if(per.getId() == id && per.getNombre() == nombre && per.getApellido() == apellido
					&& per.getFechaNacimiento() == fechaNacimiento) {
					aux = "El registro ya existe, por favor verifique";
					duplicado = true;
					break;
			}		
		}
		
		if (duplicado == false) {
			Persona per = new Huesped(id, nombre, apellido, fechaNacimiento, sexo);
			aux = "Persona agregada a la base de datos";
		}
		return aux;
	}
	
	//la búsqueda por ID espera únicamente un resultado, es mucho más 
	//específico
	public String buscarPersona(int id) {
		String aux = "La persona no está registrada";
		
		for(Persona per: Persona.personas) {
			if(per.getId()==id) {
				aux = per.toString();
			}			
		}
		return aux;
	}
	
	//la búsqueda por nombre/apellido puede arrojar 
	//varios resultados
	public String buscarPersona(String nombre, String apellido) {
		String aux = "Resultados encontrados: \n";
		
		for(Persona per: Persona.personas) {
			if(per.getNombre()==nombre || per.getApellido()==apellido) {
				aux += per.toString() + "\n";
			}
		}
		
		if(aux.length()<= 24)
			aux = "La persona no está registrada";
		
		return aux;
	}
	
	public String buscarHuesped(int id) {
		String aux = "No está registrado";
		for(Huesped hues: Huesped.huespedes) {
			if(hues.getId()==id) {
				aux = hues.getNombre();
			}			
		}
		return aux;
	}
	
	//public String crearReserva()
	
	public String buscarHuesped(String nombre) {
		String aux = "";
		return aux;
	}
	
	public String buscarHuesped(String nombre, String apellido) {
		String aux = "";
		return aux;
	}
	
	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}

	public int getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

     

	
	public void setReserva(List<Reserva>reserva) {  //uno
		this.reservas = reserva;
	}
	
	public String listaReservas() {									//uno
		Iterator<Reserva> iterator = reservas.iterator();
		StringBuffer lista = new StringBuffer ();
		while (iterator.hasNext()) {
			Reserva reserva =
			(Reserva) iterator.next();
			lista.append(reserva.descripcion() + "\n");
		}
		return lista.toString();
	}
	public Reserva nuevaReserva ( int numeroHabitacion, String fechaReserva, String fechaLlegada, String fechaSalida, float pago) {   //uno
		Reserva reserva = new Reserva(numeroHabitacion, fechaReserva, fechaLlegada, fechaSalida, pago);
		reservas.add(reserva);
		return reserva;
	}
	
	public float buscarCodigoHabitacion (int codigo) {
		Iterator<Habitacion> iterator = habitaciones.iterator();
		while (iterator.hasNext()) {
			Habitacion habitacion =
			(Habitacion) iterator.next();
			if (habitacion.getNumero() == codigo)
			      precio = habitacion.getPrecio();
		}
		return precio;
	}
	public void cambiarDisponibilidad (int codigo) {
		Iterator<Habitacion> iterator = habitaciones.iterator();
		while (iterator.hasNext()) {
			Habitacion habitacion =
			(Habitacion) iterator.next();
			if (habitacion.getNumero() == codigo)
			      habitacion.setEstado(false);
		}
	}
	
	public Habitacion buscarDisponibilidad (int codigo) {
		
		Iterator<Habitacion> iterator = habitaciones.iterator();
		while (iterator.hasNext()) {
			Habitacion habitacion =
			(Habitacion) iterator.next();
			if (habitacion.isEstado() == true);
			      return habitacion;
		}
		return null;
	}
	public List<Reserva> getReservas(){
		return reservas;
	}
	public Habitacion reservar (int codigo) {
		Iterator<Habitacion> iterator = habitaciones.iterator();
		while (iterator.hasNext()) {
			Habitacion habitacion =
			(Habitacion) iterator.next();
			if (habitacion.getNumero() == codigo)
				return habitacion;
		}
		return null;
	}
	
	
	public void editarFechas(int numReserva, String fechaInicio, String fechaFinal) {
		for(Reserva rev: this.reservas) {
			if(rev.getNumeroReserva()==numReserva) { 
				//System.out.println("ENtrando");
				rev.setFechaLlegada(fechaInicio);
				rev.setFechaSalida(fechaFinal);
			}	
		}
	}
}
	
/////////////////////////////	
	
	
//	public static String crearReserva(int numeroHabitacion, String fechaReserva, String fechaInicio, String fechaFinal, int pago) {
//		String mensaje = "";
//		for(Administrador hab: hab.habitaciones) {
//			if(hab.getNumero()==numeroHabitacion && hab.isEstado()==true) { 
//				hab.setEstado(false);
//				Reserva nuevaReserva = new Reserva(hab, fechaReserva,fechaInicio,fechaFinal, pago);
//				reserva.add(nuevaReserva);
//				mensaje = "Reserva creada, num: " + nuevaReserva.getNumeroReserva();
//				break;
//			}
//			else {
//				mensaje = "Habitacion no disponible";
//			}
//	    }
//		return mensaje;
//	}


//creando las habitaciones
//Habitacion(int numero, float precio, boolean estado, int numeroCamas, int capacidad)
//Administrador va a ser en donde interactuan la mayoria de las clases, 
//ya que el se encarga de:   
//1. Crear las reservas por lo que tiene que verificar si hay habitaciones disponibles,
//2. Verificar el valor de las reservas
//3. Sacar la cuenta total


// ver disponibilidad:


//	
//public void gestionarReserva() {
//	if(habitacion.disponibles)
//	
//}
