package co.edu.uniquindio.poo.dto_record.Modelo;

import java.util.Collection;
import java.util.LinkedList;

public class Competencia {
    private String nombre;
    private Collection<Arbitro> arbitros;
    private Collection<PartidoDTO> partidos;
    private Collection<Equipo> equipos;
    private Collection<Jugador> jugadores;
    private Collection<JugadorDTO> jugadoresDTO;
    private Collection<ExamenMedico>examenes;
    private Collection<Marcador>marcadores;
    public Competencia(String nombre) {
        this.nombre = nombre;
        this.arbitros = new LinkedList<>();
        this.partidos = new LinkedList<>();
        this.equipos = new LinkedList<>();
        this.jugadores = new LinkedList<>();
        this.jugadoresDTO = new LinkedList<>();
        this.examenes = new LinkedList<>();
        this.marcadores = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Collection<Arbitro> getArbitros() {
        return arbitros;
    }

    public void setArbitros(Collection<Arbitro> arbitros) {
        this.arbitros = arbitros;
    }

    public Collection<PartidoDTO> getPartidos() {
        return partidos;
    }

    public void setPartidos(Collection<PartidoDTO> partidos) {
        this.partidos = partidos;
    }

    public Collection<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(Collection<Equipo> equipos) {
        this.equipos = equipos;
    }

    public Collection<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(Collection<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public Collection<JugadorDTO> getJugadoresDTO() {
        return jugadoresDTO;
    }

    public void setJugadoresDTO(Collection<JugadorDTO> jugadoresDTO) {
        this.jugadoresDTO = jugadoresDTO;
    }

    public Collection<ExamenMedico> getExamenes() {
        return examenes;
    }

    public void setExamenes(Collection<ExamenMedico> examenes) {
        this.examenes = examenes;
    }

    public Collection<Marcador> getMarcadores() {
        return marcadores;
    }

    public void setMarcadores(Collection<Marcador> marcadores) {
        this.marcadores = marcadores;
    }

    /**
     * Metodo que verifica la existencia de un arbitro
     *
     * @param cedula
     * @return true si la cedula del arbitro no existe en la lista; false si ya existe un arbitro registrado con esa cedula en la lista.
     */

    public boolean verificarArbitro(String cedula) {
        for (Arbitro arbitro : arbitros) {
            if (cedula.equals(arbitro.getCedula())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Metodo que permite agregar arbitros a la lista verificando que no esten duplicados.
     *
     * @param arbitro
     * @return true si el arbitro fue agregado exitosamente, false si el arbitro ya existe.
     */

    public boolean agregarArbitro(Arbitro arbitro) {
        boolean centinela = false;
        boolean esUnico = this.verificarArbitro(arbitro.getCedula());
        if (esUnico) {
            arbitros.add(arbitro);
            centinela = true;
            System.out.println("Arbitro agregado exitosamente");
        } else {
            System.out.println("El Arbitro ya existe");
        }
        return centinela;
    }


    /**
     * Metodo que permite eliminar un arbitro de la lista con su cedula.
     *
     * @param cedula
     * @return true si el arbitro fue eliminado exitosamente, false si no se encontró en la lista.
     */

    public boolean eliminarArbitro(String cedula) {
        boolean centinela = false;
        for (Arbitro arbitro : arbitros) {
            if (arbitro.getCedula().equals(cedula)) {
                arbitros.remove(arbitro);
                centinela = true;
                System.out.println("Arbitro eliminado exitosamente");
                break;
            }
        }
        return centinela;
    }

    /**
     * Metodo que permite actualizar un arbitro de la lista arbitros con su cedula.
     *
     * @param cedula
     * @param actualizado
     * @return true si el arbitro fue actualizado exitosamente, false si no se encontró en la lista.
     */

    public boolean actualizarArbitro(String cedula, Arbitro actualizado) {
        boolean centinela = false;

        for (Arbitro arbitro : this.arbitros) {
            if (arbitro.getCedula().equals(cedula)) {
                arbitro.setCedula(actualizado.getCedula());
                arbitro.setNombre(actualizado.getNombre());
                arbitro.setApellido(actualizado.getApellido());
                arbitro.setPartidosDirigidos(actualizado.getPartidosDirigidos());
                arbitro.setCategoria(actualizado.getCategoria());
                centinela = true;
                break;
            }
        }
        return centinela;
    }


    /**
     * Metodo que verifica la existencia de un partido
     *
     * @param codigoPartido
     * @return true si el codigoPartido del partido no existe en la lista; false si ya existe un partido registrado con esa codigo en la lista.
     */

    public boolean verificarPartidoDTO(String codigoPartido) {
        for (PartidoDTO partidoDTO : partidos) {
            if (codigoPartido.equals(partidoDTO.getCodigoPartido())) {
                return false;
            }
        }
        return true;
    }


    /**
     * Metodo que permite agregar partidos a la lista verificando que no esten duplicados.
     *
     * @param partidoDTO
     * @return true si el partido fue agregado exitosamente, false si el partido ya existe.
     */

    public boolean agregarPartido(PartidoDTO partidoDTO) {
        boolean centinela = false;
        boolean esUnico = this.verificarPartidoDTO(partidoDTO.getCodigoPartido());
        if (esUnico) {
            partidos.add(partidoDTO);
            centinela = true;
            System.out.println("Partido agregado exitosamente");
        } else {
            System.out.println("El partido ya existe");
        }
        return centinela;
    }


    /**
     * Metodo que permite eliminar un partido de la lista con su codigo.
     *
     * @param codigoPartido
     * @return true si el partido fue eliminado exitosamente, false si no se encontró en la lista.
     */

    public boolean eliminarPartidoDTO(String codigoPartido) {
        boolean centinela = false;
        for (PartidoDTO partidoDTO : partidos) {
            if (partidoDTO.getCodigoPartido().equals(codigoPartido)) {
                partidos.remove(partidoDTO);
                centinela = true;
                System.out.println("Partido eliminado exitosamente");
                break;
            }
        }
        return centinela;
    }


    /**
     * Metodo que permite actualizar un partido de la lista partidos con su codigo.
     *
     * @param codigoPartido
     * @param actualizado
     * @return true si el partido fue actualizado exitosamente, false si no se encontró en la lista.
     */

    public boolean actualizarPartidoDTO(String codigoPartido, PartidoDTO actualizado) {
        boolean centinela = false;

        for (PartidoDTO partidoDTO : this.partidos) {
            if (partidoDTO.getCodigoPartido().equals(codigoPartido)) {
                partidoDTO.setCodigoPartido(actualizado.getCodigoPartido());
                partidoDTO.setNombreArbitro(actualizado.getNombreArbitro());
                partidoDTO.setMarcador(actualizado.getMarcador());
                partidoDTO.setEquipo1(actualizado.getEquipo1());
                partidoDTO.setEquipo2(actualizado.getEquipo2());
                centinela = true;
                break;
            }
        }
        return centinela;
    }


    /**
     * Metodo que verifica la existencia de un equipo
     *
     * @param idEquipo
     * @return true si el id del equipo no existe en la lista; false si ya existe un equipo registrado con ese id en la lista.
     */

    public boolean verificarEquipo(int idEquipo) {
        for (Equipo equipo : equipos) {
            if (idEquipo == equipo.getIdEquipo()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Metodo que permite agregar equipos a la lista verificando que no esten duplicados.
     *
     * @param equipo
     * @return true si el equipo fue agregado exitosamente, false si el equipo ya existe.
     */

    public boolean agregarEquipo(Equipo equipo) {
        boolean centinela = false;
        boolean esUnico = this.verificarEquipo(equipo.getIdEquipo());
        if (esUnico) {
            equipos.add(equipo);
            centinela = true;
            System.out.println("Equipo agregado exitosamente");
        } else {
            System.out.println("El Equipo ya existe");
        }
        return centinela;
    }


    /**
     * Metodo que permite eliminar un equipo de la lista con su id.
     *
     * @param idEquipo
     * @return true si el equipo fue eliminado exitosamente, false si no se encontró en la lista.
     */

    public boolean eliminarEquipo(int idEquipo) {
        boolean centinela = false;
        for (Equipo equipo : equipos) {
            if (equipo.getIdEquipo() == idEquipo) {
                equipos.remove(equipo);
                centinela = true;
                System.out.println("Equipo eliminado exitosamente");
                break;
            }
        }
        return centinela;
    }

    /**
     * Metodo que permite actualizar un equipo de la lista equipos con su id.
     *
     * @param idEquipo
     * @param actualizado
     * @return true si el equipo fue actualizado exitosamente, false si no se encontró en la lista.
     */

    public boolean actualizarEquipo(int idEquipo, Equipo actualizado) {
        boolean centinela = false;

        for (Equipo equipo : this.equipos) {
            if (equipo.getIdEquipo() == idEquipo) {
                equipo.setIdEquipo(actualizado.getIdEquipo());
                equipo.setNombreEquipo(actualizado.getNombreEquipo());
                centinela = true;
                break;
            }
        }
        return centinela;
    }
    public boolean verificarJugador(String cedula) {
        for (Jugador jugador : jugadores) {
            if (cedula.equals(jugador.getCedula())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Metodo que permite agregar jugadores a la lista verificando que no esten duplicados.
     *
     * @param jugador
     * @return true si el jugador fue agregado exitosamente, false si el jugador ya existe.
     */

    public boolean agregarJugador(Jugador jugador) {
        boolean centinela = false;
        boolean esUnico = this.verificarJugador(jugador.getCedula());
        if (esUnico) {
            jugadores.add(jugador);
            centinela = true;
            System.out.println("Jugador agregado exitosamente");
        } else {
            System.out.println("El Jugador ya existe");
        }
        return centinela;
    }


    /**
     * Metodo que permite eliminar un jugador de la lista con su cedula.
     *
     * @param cedula
     * @return true si el jugador fue eliminado exitosamente, false si no se encontró en la lista.
     */

    public boolean eliminarJugador(String cedula) {
        boolean centinela = false;
        for (Jugador jugador : jugadores) {
            if (jugador.getCedula().equals(cedula)) {
                jugadores.remove(jugador);
                centinela = true;
                System.out.println("Jugador eliminado exitosamente");
                break;
            }
        }
        return centinela;
    }

    /**
     * Metodo que permite actualizar un jugador de la lista jugadores con su cedula.
     *
     * @param cedula
     * @param actualizado
     * @return true si el jugador fue actualizado exitosamente, false si no se encontró en la lista.
     */

    public boolean actualizarJugador(String cedula, Jugador actualizado) {
        boolean centinela = false;

        for (Jugador jugador : this.jugadores) {
            if (jugador.getCedula().equals(cedula)) {
                jugador.setCedula(actualizado.getCedula());
                jugador.setNombre(actualizado.getNombre());
                jugador.setApellido(actualizado.getApellido());
                jugador.setPosicion(actualizado.getPosicion());
                centinela = true;
                break;
            }
        }
        return centinela;
    }


    /**
     * Metodo que verifica la existencia de un jugadorDTO
     *
     * @param cedula
     * @return true si la cedula del jugadorDTO no existe en la lista; false si ya existe un jugadorDTO registrado con esa cedula en la lista.
     */

    public boolean verificarJugadorDTO(String cedula) {
        for (JugadorDTO jugadorDTO : jugadoresDTO) {
            if (cedula.equals(jugadorDTO.getCedula())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Metodo que permite agregar jugadoresDTO a la lista verificando que no esten duplicados.
     *
     * @param jugadorDTO
     * @return true si el jugadorDTO fue agregado exitosamente, false si el jugadorDTO ya existe.
     */

    public boolean agregarJugadorDTO(JugadorDTO jugadorDTO) {
        boolean centinela = false;
        boolean esUnico = this.verificarJugadorDTO(jugadorDTO.getCedula());
        if (esUnico) {
            jugadoresDTO.add(jugadorDTO);
            centinela = true;
            System.out.println("JugadorDTO agregado exitosamente");
        } else {
            System.out.println("El JugadorDTO ya existe");
        }
        return centinela;
    }


    /**
     * Metodo que permite eliminar un jugadorDTO de la lista con su cedula.
     *
     * @param cedula
     * @return true si el jugadorDTO fue eliminado exitosamente, false si no se encontró en la lista.
     */

    public boolean eliminarJugadorDTO(String cedula) {
        boolean centinela = false;
        for (JugadorDTO jugadorDTO : jugadoresDTO) {
            if (jugadorDTO.getCedula().equals(cedula)) {
                jugadoresDTO.remove(jugadorDTO);
                centinela = true;
                System.out.println("JugadorDTO eliminado exitosamente");
                break;
            }
        }
        return centinela;
    }

    /**
     * Metodo que permite actualizar un jugadorDTO de la lista jugadoresDTO con su cedula.
     *
     * @param cedula
     * @param actualizado
     * @return true si el jugadorDTO fue actualizado exitosamente, false si no se encontró en la lista.
     */

    public boolean actualizarJugadorDTO(String cedula, JugadorDTO actualizado) {
        boolean centinela = false;

        for (JugadorDTO jugadorDTO : this.jugadoresDTO) {
            if (jugadorDTO.getCedula().equals(cedula)) {
                jugadorDTO.setCedula(actualizado.getCedula());
                jugadorDTO.setNombre(actualizado.getNombre());
                jugadorDTO.setApellido(actualizado.getApellido());
                jugadorDTO.setNombreEquipo(actualizado.getNombreEquipo());
                jugadorDTO.setPosicion(actualizado.getPosicion());
                centinela = true;
                break;
            }
        }
        return centinela;
    }


    /**
     * Metodo que verifica la existencia de un Examen Medico
     *
     * @param codigo
     * @return true si el codigo del examen no existe en la lista; false si ya existe un examen registrado con ese codigo en la lista.
     */
    public boolean verificarExamen(String codigo) {
        for (ExamenMedico examen : examenes) {
            if (codigo.equals(examen.CodigoExamen())) {
                return false;
            }
        }

        return true;
    }

    /**
     * Metodo que permite agregar examenes a la lista verificando que no esten duplicados.
     *
     * @param examenMedico
     * @return true si el examen fue agregado exitosamente, false si el examen ya existe.
     */
    public Boolean agregarExamen(ExamenMedico examenMedico) {
        boolean esUnico = verificarExamen(examenMedico.CodigoExamen());
        boolean centinela = false;
        if (esUnico) {
            examenes.add(examenMedico);
            centinela = true;
            System.out.println("Empleado agregado exitosamente");
        } else {
            System.out.println("Empleado ya existe");
        }
        return centinela;
    }


    /**
     * Metodo que permite eliminar un Examen de la lista con su codigo.
     *
     * @param examenMedico
     * @return true si el examen fue eliminado exitosamente, false si no se encontró en la lista.
     */
    public Boolean eliminarExamen(ExamenMedico  examenMedico) {
        boolean esUnico = !verificarExamen(examenMedico.CodigoExamen());
        boolean centinela = false;
        if (esUnico) {
            examenes.remove(examenMedico);
            centinela = true;
            System.out.println("Empleado eliminado exitosamente");
        } else {
            System.out.println("Error");
        }
        return centinela;
    }

    /**
     * Metodo que verifica la existencia de un Marcador
     *
     * @param codigo
     * @return true si el codigo del marcador no existe en la lista; false si ya existe un marcador registrado con ese codigo en la lista.
     */
    public boolean verificarMarcador(String codigo) {
        for (Marcador marcador : marcadores) {
            if (codigo.equals(marcador.Codigo())) {
                return false;
            }
        }

        return true;
    }

    /**
     * Metodo que permite agregar marcadores a la lista verificando que no esten duplicados.
     *
     * @param marcador
     * @return true si el marcador fue agregado exitosamente, false si el marcador ya existe.
     */
    public Boolean agregarMarcdaor(Marcador marcador) {
        boolean esUnico = verificarMarcador(marcador.Codigo());
        boolean centinela = false;
        if (esUnico) {
            marcadores.add(marcador);
            centinela = true;
            System.out.println("Empleado agregado exitosamente");
        } else {
            System.out.println("Empleado ya existe");
        }
        return centinela;
    }


    /**
     * Metodo que permite eliminar un Marcdaor de la lista con su codigo.
     *
     * @param marcador
     * @return true si el marcador fue eliminado exitosamente, false si no se encontró en la lista.
     */
    public Boolean eliminarMarcador(Marcador  marcador) {
        boolean esUnico = !verificarMarcador(marcador.Codigo());
        boolean centinela = false;
        if (esUnico) {
            marcadores.remove(marcador);
            centinela = true;
            System.out.println("Empleado eliminado exitosamente");
        } else {
            System.out.println("Error");
        }
        return centinela;
    }

    @Override
    public String toString() {
        return "Competencia{" +
                "nombre='" + nombre + '\'' +
                ", arbitros=" + arbitros +
                ", partidos=" + partidos +
                ", equipos=" + equipos +
                ", jugadores=" + jugadores +
                ", jugadoresDTO=" + jugadoresDTO +
                ", examenes=" + examenes +
                ", marcadores=" + marcadores +
                '}';
    }
}


