package co.edu.uniquindio.poo.dto_record.Modelo;

public class Jugador extends Persona{

    public enum Posicion{
        Delantero, Mediocampista, Defensa, Portero
    }
    public Posicion posicion;

    public Jugador(String nombre, String apellido,String Cedula,Posicion posicion ) {
        super(nombre,apellido,Cedula);
        this.posicion = posicion;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }
    //hola//

    @Override
    public String toString() {
        return "Jugador{" + super.toString() +
                "posicion=" + posicion +
                '}';
    }
}
