package co.edu.uniquindio.poo.dto_record.Controller;

import co.edu.uniquindio.poo.dto_record.Modelo.Arbitro;
import co.edu.uniquindio.poo.dto_record.Modelo.Competencia;

import java.util.Collection;

public class ArbitroController {

    private Competencia competencia;

    public ArbitroController(Competencia competencia) {
        this.competencia = competencia;
    }

    /**
     * Metodo que agrega un nuevo doctor al hospital.
     * @param arbitro
     * @return true si el doctor fue agregado con éxito, false en caso de error.
     *
     */

    public boolean crearArbitro(Arbitro arbitro) {
        if (competencia == null) {
            System.err.println("Error: La Competnecia no ha sido inicializada.");
            return false;
        }
        return competencia.agregarArbitro(arbitro);
    }

    /**
     * Metodo que obtiene la lista de doctores registrados en el hospital.
     * @return Una colección de objetos Doctor si el hospital está inicializado.
     */

    public Collection<Arbitro> obtenerListaArbitro() {
        if (competencia == null) {
            System.err.println("Error: No se puede obtener la lista de arbitros porque la competencia es null.");
            return null;
        }
        return competencia.getArbitros();
    }

    /**
     * Metodo que elimina un doctor del hospital según su cédula.
     * @param cedula
     * @return true si el doctor fue eliminado con éxito, false en caso de error.
     */

    public boolean eliminarArbitro(String cedula) {
        if (competencia == null) {
            System.err.println("Error: No se puede eliminar Arbitro ya que la comptencia  es null.");
            return false;
        }
        return competencia.eliminarArbitro(cedula);
    }

    /**
     * Metodo que permite actualizar un doctor según su cedula.
     * @param cedula
     * @param arbitro
     * @return true si el doctor fue actualizado con éxito, false en caso de error.
     */
    public boolean actualizarArbtro(String cedula, Arbitro arbitro) {
        if (competencia == null) {
            System.err.println("Error: No se puede actualizar Arbitro porque la hospital es null.");
            return false;
        }
        return competencia.actualizarArbitro(cedula, arbitro);
    }
}
