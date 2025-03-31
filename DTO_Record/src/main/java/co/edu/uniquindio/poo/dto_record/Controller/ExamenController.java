package co.edu.uniquindio.poo.dto_record.Controller;

import co.edu.uniquindio.poo.dto_record.Modelo.Arbitro;
import co.edu.uniquindio.poo.dto_record.Modelo.Competencia;
import co.edu.uniquindio.poo.dto_record.Modelo.ExamenMedico;
import co.edu.uniquindio.poo.dto_record.Modelo.JugadorDTO;

import java.util.Collection;

public class ExamenController {
    private Competencia competencia;

    public ExamenController(Competencia competencia) {
        this.competencia = competencia;
    }

    public boolean crearExamen(ExamenMedico examenMedico) {
        if (competencia == null) {
            System.err.println("Error: La Competnecia no ha sido inicializada.");
            return false;
        }
        return competencia.agregarExamen(examenMedico);
    }

    /**
     * Metodo que obtiene la lista de doctores registrados en el hospital.
     * @return Una colección de objetos Doctor si el hospital está inicializado.
     */

    public Collection<ExamenMedico> obtenerListaExamen() {
        if (competencia == null) {
            System.err.println("Error: No se puede obtener la lista de examenes porque la competencia es null.");
            return null;
        }
        return competencia.getExamenes();
    }

    /**
     * Metodo que elimina un doctor del hospital según su cédula.
     * @param examenMedico
     * @return true si el doctor fue eliminado con éxito, false en caso de error.
     */

    public boolean eliminarExamenes(ExamenMedico examenMedico) {
        if (competencia == null) {
            System.err.println("Error: No se puede eliminar Arbitro ya que la comptencia  es null.");
            return false;
        }
        return competencia.eliminarExamen(examenMedico);
    }


    public Collection<JugadorDTO> obtenerListaJugadorDTO(){
        if (competencia == null) {

        }
        return competencia.getJugadoresDTO();
    }
}
