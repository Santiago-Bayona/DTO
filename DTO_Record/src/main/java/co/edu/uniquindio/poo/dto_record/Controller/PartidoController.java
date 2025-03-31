package co.edu.uniquindio.poo.dto_record.Controller;

import co.edu.uniquindio.poo.dto_record.Modelo.*;

import java.util.Collection;

public class PartidoController {

    private Competencia competencia;

    public PartidoController(Competencia competencia) {
        this.competencia = competencia;
    }

    public boolean crearPartido(PartidoDTO partidoDTO) {
        if (competencia == null) {
            System.err.println("Error: La Competnecia no ha sido inicializada.");
            return false;
        }
        return competencia.agregarPartido(partidoDTO);
    }

    /**
     * Metodo que obtiene la lista de doctores registrados en el hospital.
     * @return Una colección de objetos Doctor si el hospital está inicializado.
     */

    public Collection<PartidoDTO> obtenerListaPartidos() {
        if (competencia == null) {
            System.err.println("Error: No se puede obtener la lista de partidos porque la competencia es null.");
            return null;
        }
        return competencia.getPartidos();
    }

    /**
     * Metodo que elimina un doctor del hospital según su cédula.
     * @param codigo
     * @return true si el doctor fue eliminado con éxito, false en caso de error.
     */

    public boolean eliminarPartido(String codigo) {
        if (competencia == null) {
            System.err.println("Error: No se puede eliminar Partido ya que la comptencia es null.");
            return false;
        }
        return competencia.eliminarPartidoDTO(codigo);
    }

    public boolean actualizarPartido(String codigo, PartidoDTO partidoDTO) {
        if (competencia == null) {
            System.err.println("Error: No se puede actualizar partido porque la hospital es null.");
            return false;
        }
        return competencia.actualizarPartidoDTO(codigo, partidoDTO);
    }


    public Collection<Arbitro> obtenerListaArbitros(){
            if (competencia == null) {

        }
        return competencia.getArbitros();
    }

    public Collection<Marcador> obtenerListaMarcador(){
        if (competencia == null) {

        }
        return competencia.getMarcadores();
    }
}
