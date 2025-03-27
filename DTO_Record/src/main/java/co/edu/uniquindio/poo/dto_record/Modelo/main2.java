package co.edu.uniquindio.poo.dto_record.Modelo;

public class main2 {
    public static void main(String[] args) {
        Competencia competencia = new Competencia("djjs");
        System.out.println(competencia);

        Jugador jugadorn1= new Jugador("jose","martinez","ssh", Jugador.Posicion.Mediocampista);
        Equipo equipo = new Equipo(1645,"ruleta gang");
        Equipo equipo2 = new Equipo(165,"ruleta gang");

        JugadorDTO jugador1= new JugadorDTO(jugadorn1,equipo);


        ExamenMedico examen1 = new ExamenMedico(jugador1,66.2,1.78,false,"4");
        examen1.CalcularIMC();

        Marcador marcador = new Marcador(equipo,"2:0",equipo2,"1");
        System.out.println(marcador);




    }
}
