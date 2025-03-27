package co.edu.uniquindio.poo.dto_record.Modelo;


public class PartidoDTO {
    public String nombreArbitro;
    public String marcador;
    public Equipo equipo1,equipo2;
    public String codigoPartido;

    public PartidoDTO(String codigoPartido,Arbitro arbitro, Marcador marcador) {
        this.nombreArbitro = arbitro.getNombre();
        this.equipo1= marcador.equipo();
        this.equipo2= marcador.equipo2();
        this.marcador = marcador.Marcador();
        this.codigoPartido = codigoPartido;
    }

    public String getNombreArbitro() {
        return nombreArbitro;
    }

    public void setNombreArbitro(String nombreArbitro) {
        this.nombreArbitro = nombreArbitro;
    }

    public String getMarcador() {
        return marcador;
    }

    public void setMarcador(String marcador) {
        this.marcador = marcador;
    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(Equipo equipo2) {
        this.equipo2 = equipo2;
    }

    public String getCodigoPartido() {
        return codigoPartido;
    }
    public void setCodigoPartido(String codigoPartido) {
        this.codigoPartido = codigoPartido;
    }

    @Override
    public String toString() {
        return "PartidoDTO{" +
                "nombreArbitro='" + nombreArbitro + '\'' +
                ", marcador='" + marcador + '\'' +
                ", equipo1=" + equipo1 +
                ", equipo2=" + equipo2 +
                '}';
    }
}
