package baseDatos;

import java.util.ArrayList;
import java.util.List;

import gestorAplicacion.primero.Persona;
import gestorAplicacion.segundo.Habitacion;
import gestorAplicacion.segundo.Reserva;

public class BDReserva {
	public static List<Habitacion> habitaciones = new ArrayList<Habitacion>();
	public static List<Persona> personas = new ArrayList<Persona>();
	public static List<Reserva> reservaciones = new ArrayList<Reserva>();
	
	public static void agregarHabitacioon(Habitacion habitacion) {
       	habitaciones.add(habitacion);
    }
    
    public static List<Habitacion> getHabitacion(){
    	return habitaciones;
    }
    
    public static void setHabitaciones(ArrayList<Habitacion> habitacion) {
    	BDReserva.habitaciones = habitacion;
    }
    
    public static void agregarReserva(Reserva reserva) {
       	reservaciones.add(reserva);
    }
    
    public static List<Reserva> getReserva(){
    	return reservaciones;
    }
    
    public static void setReservaciones(ArrayList<Reserva> reservacion) {
    	BDReserva.reservaciones = reservacion;
    }
    public static void agregarPersonas(Persona persona) {
       	personas.add(persona);
    }
    
    public static List<Persona> getPersona(){
    	return personas;
    }
    public static void setPersonas(ArrayList<Persona> persona) {
    	BDReserva.personas = persona;
    }
}
