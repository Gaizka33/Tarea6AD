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
	public static File ficheroElegido;
	private static String nombreFichero;
	private static int controlWhile = 0;
	public static ArrayList<File> ficherosdisponibles = new ArrayList<File>();
	private static DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	private static FileOutputStream conexionEscribir;
	private static ObjectOutputStream escribir;
	private static FileInputStream conexionleer;
	private static ObjectInputStream leer;

	// Método que muestra el menú principal
	private static void mostrarMenu() {
		System.out.println("Que quieres hacer?");
		System.out.println("1.Generar Fichero");
		System.out.println("2.Seleccionar Fichero");
		System.out.println("3.Cargar Alumno");
		System.out.println("4.Mostrar Alumnos");
		System.out.println("5.Salir");
	}

	// Método que ejecuta la opción seleccionada
	private static void ejecutarOpcion(int control) {
		switch (control) {
		case 1:
			generarFichero();
			break;
		case 2:
			seleccionarFichero();
			break;
		case 3:
			cargarAlumno();
			break;
		case 4:
			mostrarAlumnos();
			break;
		case 5:
			controlWhile = 2;
			break;
		}
	}

	// Método para generar un nuevo fichero
	private static void generarFichero() {
		System.out.println("Dame el nombre del fichero(si quieres obv, si no pones nada se llamara fichero.txt)");
		if (!(nombreFichero = abielto.next()).equals("")) {
			ficherodeseado = new File(nombreFichero);
		} else {
			ficherodeseado = new File("fichero.txt");
		}
		ficherosdisponibles.add(ficherodeseado);
	}

	// Método para seleccionar un fichero existente
	private static void seleccionarFichero() {
		System.out.println("Estos son los ficheros disponibles:");
		int i = 0;
		for (File f : ficherosdisponibles) {
			System.out.println(i + " " + f.getName());
			i++;
		}
		System.out.println("Cual quieres elegir?");
		ficheroElegido = ficherosdisponibles.get(abielto.nextInt());
	}

	// Método para cargar un alumno en el fichero seleccionado
	public static void cargarAlumno() {
		try {
			conexionEscribir = new FileOutputStream(ficheroElegido);
			escribir = new ObjectOutputStream(conexionEscribir);

			System.out.println("Dame la fecha de nacimiento del alumno (dd-MM-yyyy): ");
			String fechaNacimientoString = abielto.next();
			LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoString, formato);

			System.out.println(
					"Ahora Dame los datos del alumno (Nombre, Apellidos, Ciclo, Curso, Grupo, NIA y Genero): ");
			String nombre = abielto.next();
			String apellidos = abielto.next();
			String ciclo = abielto.next();
			String curso = abielto.next();
			String grupo = abielto.next();
			int nia = abielto.nextInt();
			char genero = abielto.next().charAt(0);

			Alumno alumno = new Alumno(nombre, apellidos, ciclo, curso, grupo, nia, genero, fechaNacimiento);
			escribir.writeObject(alumno);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			cerrarEscribir();
		}
	}

	// Método para mostrar los alumnos del fichero seleccionado
	private static void mostrarAlumnos() {
		try {
			conexionleer = new FileInputStream(ficheroElegido);
			leer = new ObjectInputStream(conexionleer);

			while (conexionleer.available() > 0) {
				Alumno a = (Alumno) leer.readObject();
				System.out.println("Los alumnos son: \n" + a.toString() + "\n");
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			cerrarLeer();
		}
	}

	// Método para cerrar la conexión de escritura
	private static void cerrarEscribir() {
		try {
			if (escribir != null) {
				escribir.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Método para cerrar la conexión de lectura
	private static void cerrarLeer() {
		try {
			if (leer != null) {
				leer.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		while (controlWhile != 2) {
			mostrarMenu();
			int control = abielto.nextInt();
			ejecutarOpcion(control);
		}
		abielto.close();
	}

}
