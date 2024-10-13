package ej1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MainTest {

    private File ficheroTemporal;
    private final DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @BeforeEach
    void setUp() throws Exception {
        // Crea un archivo temporal para las pruebas
        ficheroTemporal = File.createTempFile("testFichero", ".txt");
        Main.ficherosdisponibles.add(ficheroTemporal);
        Main.ficheroElegido = ficheroTemporal;
    }

    @AfterEach
    void tearDown() throws Exception {
        // Elimina el archivo temporal después de cada prueba
        if (ficheroTemporal.exists()) {
            ficheroTemporal.delete();
        }
        Main.ficherosdisponibles.clear();
    }

    @Test
    void testGenerarFichero() {
        // Crea un fichero con un nombre
        String nombreFichero = "nuevoFichero.txt";
        File fichero = new File(nombreFichero);

        // Comprueba que se ha creado correctamente
        assertNotNull(fichero);
        assertEquals("nuevoFichero.txt", fichero.getName());
    }

    @Test
    void testCargarAlumno() throws IOException, ClassNotFoundException {
        // Prepara la información del alumno
        LocalDate fechaNacimiento = LocalDate.parse("01-01-2000", formato);
        Alumno alumno = new Alumno("Juan", "Pérez", "DAW", "2", "A", 12345, 'M', fechaNacimiento);

        // Carga el alumno en el fichero
        Main.cargarAlumno();

        // Lee el alumno del fichero y comprueba los datos
        FileInputStream fis = new FileInputStream(ficheroTemporal);
        ObjectInputStream ois = new ObjectInputStream(fis);

        Alumno alumnoLeido = (Alumno) ois.readObject();
        assertEquals("Juan", alumnoLeido.getNombre());
        assertEquals("Pérez", alumnoLeido.getApellidos());
        assertEquals(12345, alumnoLeido.getNia());
        assertEquals('M', alumnoLeido.getGenero());
        assertEquals(fechaNacimiento, alumnoLeido.getFechadenacimiento());

        ois.close();
    }
}
