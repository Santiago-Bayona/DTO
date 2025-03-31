package co.edu.uniquindio.poo.dto_record.Controller;


import co.edu.uniquindio.poo.dto_record.Modelo.Competencia;
import co.edu.uniquindio.poo.dto_record.Modelo.Equipo;

import java.util.Collection;

public class EquipoController {
    private Competencia competencia;

    /**
     *Metodo constructor de la clase
     * @param competencia
     */
    public EquipoController(Competencia competencia) {
        this.competencia = competencia;
    }

    /**
     *Metodo que permite crear un equipo
     * @param Equipo
     * @return
     */
    public boolean crearEquipo(Equipo Equipo) {
        if (competencia == null) {
            System.err.println("Error: La competencia no ha sido inicializada.");
            return false;
        }
        return competencia.agregarEquipo(Equipo);
    }


    /**
     *Metodo que permite obtener la lista de equipos
     * @return
     */
    public Collection<Equipo> ObtenerListaEquipo() {
        if (competencia == null) {
            System.err.println("Error: No se puede obtener la lista de equipos porque la competencia es null.");
            return null;
        }
        return competencia.getEquipos();
    }


    /**
     *Metodo que permite eliminar un equipo
     * @param idEquipo
     * @return
     */
    public boolean eliminarEquipo(String idEquipo) {
        if (competencia == null) {
            System.err.println("Error: No se puede eliminar el equipo ya que la competencia es null.");
            return false;
        }
        return competencia.eliminarEquipo(Integer.parseInt(idEquipo));
    }


    /**
     *Metodo que permite actualizar un equipo
     * @param idEquipo
     * @param equipo
     * @return
     */
    public boolean actualizarEquipo(String idEquipo, Equipo equipo) {
        if (competencia == null) {
            System.err.println("Error: No se puede actualizar el equipo porque la competencia es null.");
            return false;
        }
        return competencia.actualizarEquipo(Integer.parseInt(idEquipo), equipo);
    }


}
