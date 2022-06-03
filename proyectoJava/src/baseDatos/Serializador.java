package baseDatos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import gestorAplicacion.primero.Administrador;
import gestorAplicacion.segundo.Habitacion;
import gestorAplicacion.segundo.Reserva;

public class Serializador {
	private static File rutaTemp = new File("src\\baseDatos\\temp");
	
	public static void serializar(Administrador adminis) {
		FileOutputStream fos;
		ObjectOutputStream oos;
		File[] docs = rutaTemp.listFiles();
		PrintWriter pw;
		
		for (File file : docs) {
			try {
				pw = new PrintWriter(file);
			}catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		for(File file:docs) {
			if (file.getAbsolutePath().contains("habitacion.txt")) {
				try {
					fos = new FileOutputStream(file);
					oos = new ObjectOutputStream(fos);
					oos.writeObject( adminis.getHabitaciones()
							);
				}catch (FileNotFoundException e) {
					e.printStackTrace();
				}catch (IOException e) {
					e.printStackTrace();
				}
				
			}else if(file.getAbsolutePath().contains("reservas.txt")) {
				try {
					fos = new FileOutputStream(file);
					oos = new ObjectOutputStream(fos);
					oos.writeObject( adminis.getReservas()
							);
				}catch(FileNotFoundException e) {
					e.printStackTrace();
				}catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
}
