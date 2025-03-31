package co.edu.uniquindio.poo.dto_record.Controller;

import co.edu.uniquindio.poo.dto_record.Modelo.Competencia;
import co.edu.uniquindio.poo.dto_record.Modelo.Equipo;
import co.edu.uniquindio.poo.dto_record.Modelo.Marcador;

import java.util.Collection;

public class MarcadorController {

    private Competencia competencia;

    /**
     *Metodo constructor de la clase
     * @param competencia
     */
    public MarcadorController(Competencia competencia) {
        this.competencia = competencia;
    }

    /**
     *Metodo que permite crear un marcador
     * @param Marcador
     * @return
     */
    public boolean crearMarcador(Marcador Marcador) {
        if (competencia == null) {
            System.err.println("Error: La competencia no ha sido inicializada.");
            return false;
        }
        return competencia.agregarMarcdaor(Marcador);
    }


    /**
     *Metodo que permite obtener la lista de marcadores
     * @return
     */
    public Collection<Marcador> ObtenerListaMarcador() {
        if (competencia == null) {
            System.err.println("Error: No se puede obtener la lista de marcadores porque la competencia es null.");
            return null;
        }
        return competencia.getMarcadores();
    }


    /**
     *Metodo que permite eliminar un marcador
     * @param marcador
     * @return
     */
    public boolean eliminarMarcador(Marcador marcador) {
        if (competencia == null) {
            System.err.println("Error: No se puede eliminar el marcador ya que la competencia es null.");
            return false;
        }
        return competencia.eliminarMarcador(marcador);
    }


    /**
     *metodo que permite obtener la lista de equipos
     * @return
     */
    public Collection<Equipo> obtenerListaEquipo() {
        if (competencia == null) {

        }
        return competencia.getEquipos();
    }



}
