package gestorAplicacion.segundo;
import java.util.*;
import java.util.Date;
import java.io.Serializable;

public class Habitacion implements Serializable {
	private static final long serialversionUID = 1L;
	private int numero;
	private float precio;
	//private int servicio;
	private boolean estado;
	private int tipo; 		//1:sencilla numCamas 1 **2:doble numCamas 2 **3:Familiar numCamas 3 **4:VIP numCamas 1
	private int numeroCamas;
	private int capacidad;
	
	
	public static ArrayList<String> suministros = new ArrayList<>();
	//public static ArrayList<Habitacion> habitaciones = new ArrayList<>();
	public static ArrayList<Integer> indiceHab = new ArrayList<>();
	//public static ArrayList <Habitacion> disponibles = new ArrayList<>();
	

	public Habitacion() {};

	public Habitacion(int numero, float precio, boolean estado, int numeroCamas,int tipo, int capacidad) {
		super();
		this.numero = numero;
		this.precio = precio;
		this.estado = estado;
		this.numeroCamas = numeroCamas;
		this.tipo = tipo;
		this.capacidad = capacidad;
	//	this.habitaciones.add(this);
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
//	public int getServicio() {
//		return servicio;
//	}
//	public void setServicio(int servicio) {
//		this.servicio = servicio;
//	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public int getNumeroCamas() {
		return numeroCamas;
	}
	public void setNumeroCamas(int numeroCamas) {
		this.numeroCamas = numeroCamas;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
    	
	public String descripcion() {
		return "Numero: " + numero + 
				"\tPrecio: " + precio + 
				"\tEstado: " + estado + 
				"\tNumero camas: " + numeroCamas + 
				"\tTipo: " + tipo + 
				"\tCapacidad: " + capacidad;
	}
}

	

