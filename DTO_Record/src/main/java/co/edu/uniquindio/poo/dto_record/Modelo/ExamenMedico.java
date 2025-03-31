package co.edu.uniquindio.poo.dto_record.Modelo;

public record ExamenMedico(JugadorDTO persona, double peso, double altura, boolean diabetes, String CodigoExamen ) {
    public String calcularIMC() {
        double resultado = peso / (altura * altura);

        if (resultado < 18.5) {
            return "Bajo peso";
        } else if (resultado >= 18.5 && resultado < 24.9) {
            return "Normal";
        } else if (resultado >= 24.9 && resultado < 29.9) {
            return "Sobrepeso";
        } else {
            return "Obesidad";
        }
    }
}
