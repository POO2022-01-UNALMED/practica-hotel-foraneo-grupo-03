package gestorAplicacion.primero;

import gestorAplicacion.segundo.*;;

public class Cuenta {
	Reserva reserva;
	private float total;
	private String nombreCliente;
	private String detalle;
	private int numCuenta;
	
	public Cuenta() {
	}
	public Cuenta(Reserva reserva, float total, String nombreCliente, String detalle, int numCuenta) {
		super();
		this.reserva = reserva;
		this.total = total;
		this.nombreCliente = nombreCliente;
		this.detalle = detalle;
		this.numCuenta = numCuenta;
	}
	public Reserva getReserva() {
		return reserva;
	}
	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public int getNumCuenta() {
		return numCuenta;
	}
	public void setNumCuenta(int numCuenta) {
		this.numCuenta = numCuenta;
	}
}
