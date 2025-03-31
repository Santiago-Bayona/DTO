package co.edu.uniquindio.poo.dto_record.Controller;

import co.edu.uniquindio.poo.dto_record.App;
import co.edu.uniquindio.poo.dto_record.Modelo.Arbitro;
import co.edu.uniquindio.poo.dto_record.Modelo.Competencia;
import co.edu.uniquindio.poo.dto_record.Modelo.Jugador;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JugadorController {
    private Competencia competencia;

    public JugadorController(Competencia competencia) {
        this.competencia = competencia;
    }

    /**
     * Metodo que agrega un nuevo Jugador a la competencia.
     * @param jugador
     * @return true si el jugador fue agregado con éxito, false en caso de error.
     *
     */

    public boolean crearJugador(Jugador jugador) {
        if (competencia == null) {
            System.err.println("Error: La Competnecia no ha sido inicializada.");
            return false;
        }
        return competencia.agregarJugador(jugador);
    }

    /**
     * Metodo que obtiene la lista de jugadores registrados en la competencia.
     * @return Una colección de objetos Jugador si competencia está inicializado.
     */

    public Collection<Jugador> obtenerListaJugadores() {
        if (competencia == null) {
            System.err.println("Error: No se puede obtener la lista de jugadores porque la competencia es null.");
            return null;
        }
        return competencia.getJugadores();
    }

    /**
     * Metodo que elimina un jugador del competencia según su cédula.
     * @param cedula
     * @return true si el jugador fue eliminado con éxito, false en caso de error.
     */

    public boolean eliminarJugador(String cedula) {
        if (competencia == null) {
            System.err.println("Error: No se puede eliminar Jugador ya que la comptencia  es null.");
            return false;
        }
        return competencia.eliminarJugador(cedula);
    }

    /**
     * Metodo que permite actualizar un Jugador según su cedula.
     * @param cedula
     * @param jugador
     * @return true si el Jugador fue actualizado con éxito, false en caso de error.
     */
    public boolean actualizarJugador(String cedula, Jugador jugador) {
        if (competencia == null) {
            System.err.println("Error: No se puede actualizar Arbitro porque la hospital es null.");
            return false;
        }
        return competencia.actualizarJugador(cedula, jugador);
    }
}
