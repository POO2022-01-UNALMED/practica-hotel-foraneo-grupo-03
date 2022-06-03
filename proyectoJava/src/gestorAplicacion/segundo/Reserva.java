package gestorAplicacion.segundo;
import java.util.*;
import java.io.Serializable;
import java.util.Date;

import gestorAplicacion.primero.Administrador;
import gestorAplicacion.primero.Cuenta;
import baseDatos.Serializador;
public class Reserva implements Serializable {
	private static final long serialversionUID = 1L;
	//public static int numReserva = 0;
	private int numHabitacion;
	private String fechaReserva;
	private String fechaLlegada;
	private String fechaSalida;
	private float pago;
	int numReserva;
	private static int codigo;
	
	private ArrayList <Habitacion> habitaciones = new ArrayList<>();
	private Cuenta cuenta;
	public static ArrayList <Reserva> reserva = new ArrayList<>();
	public static ArrayList<Habitacion> habReserva = new ArrayList<>();
	// anadimos al constructor indice, esta pendiente y se puede quitar, 
	
	public Reserva() {}
//	agregar(int numero, int numeroHabitacion, String fechaReserva, String fechaInicio, String fechaFinal, float pago)
	
	public Reserva(int numeroHabitacion, String fechaReserva, String fechaLlegada, String fechaSalida, float pago) {
		super();
		//habitaciones.add(habitacion);
		this.numHabitacion = numeroHabitacion;
		this.numReserva = generarCodigo ();
		this.fechaReserva = fechaReserva;
		this.fechaLlegada = fechaLlegada;
		this.fechaSalida = fechaSalida;
		this.pago = pago;
		//cuenta = new Cuenta(this, 0,ring nombreCliente, String detalle, int numCuenta) {
		//reserva.add(this);
	}
	private static int generarCodigo () {
		return codigo ++;
	}
	public String descripcion() {
		return "Numero de reserva: " + numReserva + 
				"\tNumero de habitacion: " + numHabitacion + 
				"\tFecha de reserva: " + fechaReserva + 
				"\tFecha de llegada: " + fechaLlegada + 
				"\tFecha de salida: " + fechaSalida + 
				"\tpago: " + pago;
	}
		
	//metodos o atributos que se necesitan para este metodo:
	//de Habitacion, ver disponibilidad, y especificaciones como: numero de camas y capacidad de personas
	
	
	
	
    

/*
	public static String agregarHabitacion(int numeroHabitacion, int numeroReserva, int pago) {
		String mensaje = "";
		for(Habitacion hab: Habitacion.habitacion) {
			
			if(hab.getNumero()==numeroHabitacion && hab.isEstado()==true) { 
				
				for(Reserva rev: reserva) {
					if(rev.getNumeroReserva()==numeroReserva && hab.isEstado()==true) {
						rev.habitaciones.add(hab);
						rev.agregarGastoReserva(pago);
						mensaje = "Habitación agregada a la reserva num: " + rev.getNumeroReserva();
						break;
					}
					else 
						mensaje = "Habitacion no disponible";
				}
			
			}
			
		}
		return mensaje;
	}
				
		*/		
	
	public static String eliminar(int numero) {
		for(Reserva rev: reserva) {
			if(rev.numReserva==numero) { 
				reserva.remove(rev);
				break;
			}
		}
		return "Reserva eliminada con exito";
	}
	
	
	
	
	
	/*public String confirmar() {
		if(habitacion.getPrecio()==pago) {
			return "Reserva confirmada con exito";
		}
		else {
			return (habitacion.getPrecio()-pago)+ "Saldo pendiente por pagar";
		}
	}*/
	
	
	
	public void agregarGastoReserva(float gasto) {
		float aux = cuenta.getTotal();
		aux+=gasto;
		cuenta.setTotal(aux);
	}
	
	
	    // metodo para encontrar la diferencia entre dos fechas: concretamente sera la diferencia entre
		// la hora de realizada la reserva y la fecha actual, para determinar si se pueden hacer o no cancelaciones de reservas 
		// o modificaciones, para cancelar sera antes de 1 dia y para modificar antes de 2 dias, despues de pasados dos dias no 
		// se pueden hacer modificaciones ni cancelaciones
	
	/*public static long diferenciaDias(String start_date, String end_date) {    
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
		String firtsDate = start_date;
		String secondDate = end_date;
		LocalDate date1 = LocalDate.parse(firtsDate, formatter);
		LocalDate date2 = LocalDate.parse(secondDate, formatter);
		long daysBetween = ChronoUnit.DAYS.between(date1, date2);
		if(daysBetween> -1)
			return daysBetween;
		else
			return daysBetween*-1;
    }*/
	
	public int getNumeroReserva() {
		return numReserva;
	}
	public void setNumeroReserva(int numero) {
		this.numReserva = numero;
	}
//	public int getNumeroHabitacion() {
//		return numeroHabitacion;
//	}
//	public void setNumeroHabitacion(int numeroHabitacion) {
//		this.numeroHabitacion = numeroHabitacion;
//	}
	public String getFechaLlegada() {
		return fechaLlegada;
	}
	public void setFechaLlegada(String fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}
	public String getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	
	
	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	/*public Habitacion getHabitacion() {
		return habitacion;
	}*/
	/*public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}*/
	public float getPago() {
		return pago;
	}
	public void setPago(float precio) {
		this.pago = precio;
	}
	public static ArrayList<Reserva> getReserva() {
		return reserva;
	}
	public static void setReserva(ArrayList<Reserva> reserva) {
		Reserva.reserva = reserva;
	}
}
