package gestorAplicacion.primero;
import gestorAplicacion.segundo.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;



import baseDatos.Deserializador;

import java.io.Serializable;

public abstract class Persona {
	private int id;
	private String nombre;
	private String apellido;
	private String fechaNacimiento;
	String sexo;
	public static ArrayList<Persona> personas = new ArrayList<>();
	
	public Persona() {
		
	}
	
	public Persona(int id, String nombre, String apellido, String fechaNacimiento, String sexo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.sexo = sexo;
		personas.add(this);
	}
	
	
	
	
	public String descripcion() {
        return "Nombre: " + nombre + "- Apellido: " + apellido + "\n - fechaNacimieto: " + fechaNacimiento +
        		"- sexo: " + sexo + "\n";
        		
    }
	//metodo abstracto, lo implementan administrador y huesped
	public abstract String concatenarDatos();
	
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
}

