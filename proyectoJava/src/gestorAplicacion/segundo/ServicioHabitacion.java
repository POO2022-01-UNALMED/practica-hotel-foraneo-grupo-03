package gestorAplicacion.segundo;
import gestorAplicacion.primero.*;
public interface ServicioHabitacion {

	public static final String S1 = "1_JABON:_1500";
	public static final String S2 = "2_SHAMPOO:_2000";
	public static final String S3 = "3_TOALLA:_0";
	public static final String S4 = "4_CREMA DENTAL:_3000";
	public static final String S5 = "5_CEPILLO DENTAL:_4000";
	
	public String imprimirSuministros();
	public String proveerSuministros(Huesped huesped, int numSuministro, int cantidad);
	public String organizarHabitacion(Huesped huesped);
}


