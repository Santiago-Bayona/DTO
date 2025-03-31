package co.edu.uniquindio.poo.dto_record.Controller;


import co.edu.uniquindio.poo.dto_record.Modelo.Competencia;
import co.edu.uniquindio.poo.dto_record.Modelo.Equipo;
import co.edu.uniquindio.poo.dto_record.Modelo.Jugador;
import co.edu.uniquindio.poo.dto_record.Modelo.JugadorDTO;

import java.util.Collection;

public class JugadorDTOController {
    private Competencia competencia;

    public JugadorDTOController(Competencia competencia) {
        this.competencia = competencia;
    }

    public boolean crearJugadorDTO(JugadorDTO jugadorDTO) {
        if (competencia == null || competencia.verificarJugadorDTO(jugadorDTO.getCedula())==false) {
            System.err.println("Error: La Competnecia no ha sido inicializada.");
            return false;
        }

        return competencia.agregarJugadorDTO(jugadorDTO);
    }

    /**
     * Metodo que obtiene la lista de JugadoresDTO registrados en la competencia.
     * @return Una colección de objetos JugadorDTO si competencia está inicializado.
     */

    public Collection<JugadorDTO> obtenerListaJugadoresDTO() {
        if (competencia == null) {
            System.err.println("Error: No se puede obtener la lista de partidos porque la competencia es null.");
            return null;
        }
        return competencia.getJugadoresDTO();
    }

    /**
     * Metodo que elimina un jugadordto de competencia según su cédula.
     * @param cedula
     * @return true si el jugador fue eliminado con éxito, false en caso de error.
     */

    public boolean eliminarJugadorDTO(String cedula) {
        if (competencia == null) {
            System.err.println("Error: No se puede eliminar JugadorDTO ya que la comptencia es null.");
            return false;
        }
        return competencia.eliminarJugadorDTO(cedula);
    }

    /**
     * Metodo que actualiza un jugadordto de competencia según su cédula.
     * @param cedula
     * @param jugadorDTO
     * @return true si el jugadordto fue actualizado con éxito, false en caso de error.
     */
    public boolean actualizarJugadorDTO(String cedula, JugadorDTO jugadorDTO) {
        if (competencia == null) {
            System.err.println("Error: No se puede actualizar jugadorDTO porque la competencia es null.");
            return false;
        }
        return competencia.actualizarJugadorDTO(cedula, jugadorDTO);
    }


    /**
     * Metodo que obtiene la lista de Jugadores registrados en la competencia.
     * @return Una colección de objetos Jugador si competencia está inicializada.
     */
    public Collection<Jugador> obtenerListaJugadores(){
        if (competencia == null) {

        }
        return competencia.getJugadores();
    }
    /**
     * Metodo que obtiene la lista de equipos registrados en la competencia.
     * @return Una colección de objetos Equipo si Competencial está inicializado.
     */
    public Collection<Equipo> obtenerListaEquipos(){
        if (competencia == null) {

        }
        return competencia.getEquipos();
    }
}
