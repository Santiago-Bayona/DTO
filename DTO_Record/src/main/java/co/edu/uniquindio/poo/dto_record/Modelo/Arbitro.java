package co.edu.uniquindio.poo.dto_record.Modelo;

public class Arbitro extends Persona{
    public int PartidosDirigidos;
    public enum  Categoria{
        FIFA,NACIONAL,REGIONAL
    }
    public Categoria categoria;

    public Arbitro( String nombre, String apellido,String cedula, int PartidosDirigidos, Categoria categoria ){
        super(nombre,apellido,cedula);
        this.PartidosDirigidos = PartidosDirigidos;
        this.categoria = Categoria.NACIONAL;
    }

    public int getPartidosDirigidos() {
        return PartidosDirigidos;
    }

    public void setPartidosDirigidos(int partidosDirigidos) {
        PartidosDirigidos = partidosDirigidos;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Arbitro{" + super.toString() +
                "PartidosDirigidos=" + PartidosDirigidos +
                ", categoria=" + categoria +
                '}';
    }
}
