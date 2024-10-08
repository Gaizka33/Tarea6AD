package ej1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static Scanner abielto = new Scanner(System.in);
	private static File ficherodeseado;
	private static File ficheroElegido;
	private static String nombreFichero;
	private static int controlWhile = 0;
	private static ArrayList<File> ficherosdisponibles = new ArrayList<File>();
	private static DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	private static FileOutputStream conexionEscribir;
	private static ObjectOutputStream escribir;
	private static FileInputStream conexionleer;
	private static ObjectInputStream leer;

	public static void main(String[] args) {
		while (controlWhile != 2) {
			
			System.out.println("Que quieres hacer?");
			System.out.println("1.Generar Fichero");
			System.out.println("2.Seleccionar Fichero");
			System.out.println("3.Cargar Alumno");
			System.out.println("4.Mostrar Alumnos");
			System.out.println("5.Salir");
			
			int control = abielto.nextInt();
			switch (control) {
			case 1:

				System.out.println(
						"Dame el nombre del fichero(si quieres obv, si no pones nada" + " se llamara fichero.txt)");
				if (!(nombreFichero = abielto.next()).equals("")) {
					ficherodeseado = new File(nombreFichero);
				} else {
					ficherodeseado = new File("fichero.txt");
				}
				ficherosdisponibles.add(ficherodeseado);
				break;

			case 2:
				System.out.println("Estos son los ficheros disponibles:");
				int i = 0;
				for (File f : ficherosdisponibles) {
					System.out.println(i + " " + f.getName());
				}
				System.out.println("Cual quieres elegir?");
				ficheroElegido = ficherosdisponibles.get(abielto.nextInt());
				break;

			case 3:
				try {
					conexionEscribir = new FileOutputStream(ficheroElegido);
					escribir = new ObjectOutputStream(conexionEscribir);

					System.out.println("Dame la fecha de nacimiento del alumno (dd-MM-yyyy): ");
					String fechaNacimientoString = abielto.next();
					LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoString, formato); // Parsea la fecha

					// Solicita los datos del alumno
					System.out.println(
							"Ahora Dame los datos del alumno (Nombre, Apellidos, Ciclo, Curso, Grupo, NIA y Genero): ");

					String nombre = abielto.next(); // Nombre del alumno
					String apellidos = abielto.next(); // Apellidos del alumno
					String ciclo = abielto.next(); // Ciclo que cursa
					String curso = abielto.next(); // Curso actual
					String grupo = abielto.next(); // Grupo al que pertenece
					int nia = abielto.nextInt(); // Número de identificación del alumno
					char genero = abielto.next().charAt(0); // Género del alumno

					// Crea un objeto Alumno con los datos recogidos
					Alumno alumno = new Alumno(nombre, apellidos, ciclo, curso, grupo, nia, genero, fechaNacimiento);
					escribir.writeObject(alumno);
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						if (escribir != null) {
							escribir.close();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				break;

			case 4:
				try {
					conexionleer = new FileInputStream(ficheroElegido);
					leer = new ObjectInputStream(conexionleer);

					while (conexionleer.available() > 0) {
						Alumno a = (Alumno) leer.readObject();
						System.out.println("Los alumnos son: /n" + a.toString() + "/n");
					}

				} catch (IOException | ClassNotFoundException e) {
					e.printStackTrace();
				} finally {
					// Cierra el DataOutputStream
					try {
						if (leer != null) {
							leer.close();
						}
					} catch (Exception e) {
						e.printStackTrace(); // Imprime la traza de la excepción al cerrar
					}
				}
				
				break;
				
			case 5:
				controlWhile = 2;
				break;
			}
		}

		abielto.close();

	}
}
