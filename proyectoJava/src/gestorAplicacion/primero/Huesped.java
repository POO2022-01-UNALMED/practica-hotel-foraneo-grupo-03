package gestorAplicacion.primero;
import gestorAplicacion.segundo.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;



import baseDatos.Deserializador;

import java.io.Serializable;


public class Huesped extends Persona implements ServicioHabitacion {
	
	private Reserva reserva;
	private ArrayList <Persona> acompanantes = new ArrayList<>();
	public static ArrayList <Huesped> huespedes = new ArrayList<>();
	public Huesped() {}
	public Huesped(int id, String nombre, String apellido, String fechaNacimiento, String sexo) {
		super(id, nombre, apellido, fechaNacimiento, sexo);
	}
	
	public Huesped(Reserva reserva, int puntos, int frecuencia, ArrayList<Persona> acompanantes) {
		super();
		this.reserva = reserva;
		this.acompanantes = acompanantes;
		huespedes.add(this);
	}
	
	
	@Override
	public String imprimirSuministros() {
		String suministros = ServicioHabitacion.S1.replace("_", " ") + "\n" + 
								ServicioHabitacion.S2.replace("_", " ") + "\n" + 
								ServicioHabitacion.S3.replace("_", " ") + "\n" + 
								ServicioHabitacion.S4.replace("_", " ") + "\n" + 
								ServicioHabitacion.S5.replace("_", " ") + "\n" ; 
				
	    
	    return suministros;
	}
	@Override
	public String proveerSuministros(Huesped huesped, int numSuministro, int cantidad) {
		float auxPrecio = 0;
		ArrayList <String> sumin = new ArrayList<>();
		sumin.add(ServicioHabitacion.S1.replace("_", " "));
		sumin.add(ServicioHabitacion.S2.replace("_", " "));
		sumin.add(ServicioHabitacion.S3.replace("_", " "));
		sumin.add(ServicioHabitacion.S4.replace("_", " "));
		sumin.add(ServicioHabitacion.S5.replace("_", " "));
		
		for(String str: sumin) {
			if(str.charAt(0)==numSuministro) {
				String aux = str.substring(str.lastIndexOf(" ")+1);
				auxPrecio=Float.parseFloat(aux)*cantidad;
			}
		}		
		huesped.getReserva().agregarGastoReserva(auxPrecio);
		return "Suministros agregados con éxito, suma: $" + auxPrecio;
	}
    
	@Override
	public String concatenarDatos() {
		String datos = this.descripcion();
		datos += "Numero reserva: " + reserva.getNumeroReserva() + 
				"Acompañantes: \n" + mostrarAcompanantes(); 
		return datos;
	}
	
	@Override
	public String organizarHabitacion(Huesped huesped) {
		return " ";
	}
	
	public String mostrarAcompanantes() {
		String acomp = "";
		for (Persona per: acompanantes) {
			acomp += per.getNombre() + " " + per.getApellido() + "\n";
		}
		
		return acomp;
	}
	
	
	public void servicioHabitacion(Huesped this) {	
	}
	public void usarRestaurante(Huesped this) {
	}
	public Reserva getReserva() {
		return reserva;
	}
	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public ArrayList<Persona> getAcompanantes() {
		return acompanantes;
	}
	public void setAacompanantes(ArrayList<Persona> acompanantes) {
		this.acompanantes = acompanantes;
	}
    public String agregarGastoReserva(float gasto) {
    	this.reserva.agregarGastoReserva(gasto);
    	return "Gasto agregado con exito";
    }
}

