package baseDatos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import gestorAplicacion.segundo.Reserva;
import gestorAplicacion.primero.Administrador;
import gestorAplicacion.segundo.Habitacion;

public class Deserializador {
	private static File rutaTemp = new File("src\\baseDatos\\temp");
	public static void deserializar(Administrador adminis) {
		File[] docs = rutaTemp.listFiles();
		FileInputStream fis;
		ObjectInputStream ois;
		
		for(File file : docs){
			if (file.getAbsolutePath().contains("habitacion.txt")) {
				try {
					fis = new FileInputStream(file);
					ois = new ObjectInputStream(fis);
					
					adminis.setHabitacion((List<Habitacion>) ois.readObject());
				}catch(FileNotFoundException e) {
					e.printStackTrace();
				}catch(IOException e) {
					e.printStackTrace();
				}catch(ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
			
			else if(file.getAbsolutePath().contains("reservas.txt")) {
				try {
					fis = new FileInputStream(file);
					ois = new ObjectInputStream(fis);
							
					adminis.setReserva((List<Reserva>) ois.readObject());
				}catch (FileNotFoundException e) {
					e.printStackTrace();
				}catch (IOException e) {
					e.printStackTrace();
				}catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
			/*va otro*/
		}
	}


}
