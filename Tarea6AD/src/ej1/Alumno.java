package ej1;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Clase que representa un alumno con sus datos personales y académicos.
 */
public class Alumno implements Serializable {

	/** Nombre del alumno. */
	private String nombre;

	/** Apellidos del alumno. */
	private String apellidos;

	/** Ciclo académico que cursa el alumno. */
	private String ciclo;

	/** Curso en el que está inscrito el alumno. */
	private String curso;

	/** Grupo al que pertenece el alumno. */
	private String grupo;

	/** Número de identificación del alumno (NIA). */
	private int nia;

	/** Género del alumno. */
	private char genero;

	/** Fecha de nacimiento del alumno. */
	private LocalDate fechadenacimiento;

	/**
	 * Constructor de la clase Alumno.
	 *
	 * @param nombre            Nombre del alumno.
	 * @param apellidos         Apellidos del alumno.
	 * @param ciclo             Ciclo que cursa el alumno.
	 * @param curso             Curso en el que está inscrito el alumno.
	 * @param grupo             Grupo al que pertenece el alumno.
	 * @param nia               Número de identificación del alumno.
	 * @param genero            Género del alumno.
	 * @param fechadenacimiento Fecha de nacimiento del alumno.
	 */
	public Alumno(String nombre, String apellidos, String ciclo, String curso, String grupo, int nia, char genero,
			LocalDate fechadenacimiento) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.ciclo = ciclo;
		this.curso = curso;
		this.grupo = grupo;
		this.nia = nia;
		this.genero = genero;
		this.fechadenacimiento = fechadenacimiento;
	}

	/**
	 * Devuelve el nombre del alumno.
	 * 
	 * @return Nombre del alumno.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del alumno.
	 * 
	 * @param nombre Nombre del alumno.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve los apellidos del alumno.
	 * 
	 * @return Apellidos del alumno.
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Establece los apellidos del alumno.
	 * 
	 * @param apellidos Apellidos del alumno.
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * Devuelve el ciclo académico del alumno.
	 * 
	 * @return Ciclo del alumno.
	 */
	public String getCiclo() {
		return ciclo;
	}

	/**
	 * Establece el ciclo académico del alumno.
	 * 
	 * @param ciclo Ciclo del alumno.
	 */
	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	/**
	 * Devuelve el curso del alumno.
	 * 
	 * @return Curso del alumno.
	 */
	public String getCurso() {
		return curso;
	}

	/**
	 * Establece el curso del alumno.
	 * 
	 * @param curso Curso del alumno.
	 */
	public void setCurso(String curso) {
		this.curso = curso;
	}

	/**
	 * Devuelve el grupo del alumno.
	 * 
	 * @return Grupo del alumno.
	 */
	public String getGrupo() {
		return grupo;
	}

	/**
	 * Establece el grupo del alumno.
	 * 
	 * @param grupo Grupo del alumno.
	 */
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	/**
	 * Devuelve el número de identificación del alumno (NIA).
	 * 
	 * @return NIA del alumno.
	 */
	public int getNia() {
		return nia;
	}

	/**
	 * Establece el número de identificación del alumno (NIA).
	 * 
	 * @param nia Número de identificación del alumno.
	 */
	public void setNia(int nia) {
		this.nia = nia;
	}

	/**
	 * Devuelve el género del alumno.
	 * 
	 * @return Género del alumno.
	 */
	public char getGenero() {
		return genero;
	}

	/**
	 * Establece el género del alumno.
	 * 
	 * @param genero Género del alumno.
	 */
	public void setGenero(char genero) {
		this.genero = genero;
	}

	/**
	 * Devuelve la fecha de nacimiento del alumno.
	 * 
	 * @return Fecha de nacimiento del alumno.
	 */
	public LocalDate getFechadenacimiento() {
		return fechadenacimiento;
	}

	/**
	 * Establece la fecha de nacimiento del alumno.
	 * 
	 * @param fechadenacimiento Fecha de nacimiento del alumno.
	 */
	public void setFechadenacimiento(LocalDate fechadenacimiento) {
		this.fechadenacimiento = fechadenacimiento;
	}

	/**
	 * Devuelve una representación en cadena de los datos del alumno.
	 * 
	 * @return String con la información del alumno.
	 */
	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", apellidos=" + apellidos + ", ciclo=" + ciclo + ", curso=" + curso
				+ ", grupo=" + grupo + ", nia=" + nia + ", genero=" + genero + ", fechadenacimiento="
				+ fechadenacimiento + "]";
	}
}
