package co.edu.uniquindio.poo.dto_record.Modelo;

public record ExamenMedico(JugadorDTO persona, double peso, double altura, boolean diabetes, String CodigoExamen ) {
    public double CalcularIMC(){
        double resultado=0.0;
        resultado = peso/(altura*altura);
        if (resultado < 18.5) {
            System.out.println("Usted tiene un peso bajo según su IMC: " + resultado);
        } else if (resultado >= 18.5 && resultado < 24.9) {
            System.out.println("Usted tiene un peso normal según su IMC: " + resultado);
        } else if (resultado >= 24.9 && resultado < 29.9) {
            System.out.println("Usted tiene sobrepeso según su IMC: " + resultado);
        } else {
            System.out.println("Usted tiene obesidad según su IMC: " + resultado);
        }
        return resultado;
    }
}
