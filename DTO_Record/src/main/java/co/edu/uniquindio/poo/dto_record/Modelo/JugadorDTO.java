package co.edu.uniquindio.poo.dto_record.Modelo;

public class JugadorDTO {
    private String nombre,cedula;
    private String apellido;
    private String nombreEquipo;
    public Jugador.Posicion posicion;
    public Jugador Jugador;
    public Equipo equipo;


    public JugadorDTO(Jugador jugador, Equipo equipo) {
        this.nombre = jugador.getNombre();
        this.apellido = jugador.getApellido();
        this.cedula= jugador.getCedula();
        this.posicion = jugador.getPosicion();
        this.nombreEquipo = equipo.getNombreEquipo();
        this.equipo = equipo;
        this.Jugador = jugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public Jugador.Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Jugador.Posicion posicion) {
        this.posicion = posicion;
    }

    public Equipo getEquipo() {
        return equipo;
    }
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
    public Jugador getJugador() {
        return Jugador;
    }
    public void setJugador(Jugador jugador) {
        Jugador = jugador;
    }

    @Override
    public String toString() {
        return "JugadorDTO{" +
                "nombre='" + nombre + '\'' +
                ", cedula='" + cedula + '\'' +
                ", apellido='" + apellido + '\'' +
                ", nombreEquipo='" + nombreEquipo + '\'' +
                ", posicion=" + posicion +
                '}';
    }
}
