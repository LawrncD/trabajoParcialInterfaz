package co.edu.uniquindio.poo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
public class CursoTest {
    private static final Logger LOG =  Logger.getLogger(EstudianteTest.class.getName());
   
    @Test
    public void datosCompletos(){
        LOG.info("Inicio datos completos");
        Curso curso1 = new Curso("Programacion 1");
        assertEquals("Programacion 1", curso1.getNombre());
        LOG.info("Fin de pruebas datos completos");

    }

    @Test
    public void registrarEstudiante(){
        LOG.info("Inicio registro estudiante");
        Curso curso1 = new Curso("Programacion 1");
        Estudiante estudiante = new Estudiante ("manuel","Pineda","1092455543","3045879300","manuel.pinedav@uqvirtual.edu.co ",(byte)19); 
        curso1.registrarEstudiante(estudiante);
        LOG.info("Fin registro estudiante");

    }
}