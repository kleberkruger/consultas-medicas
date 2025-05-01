package br.ufms.clinicamedica;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        try {
            Secretario secretario = new Secretario(
                    "Kleber Kruger",
                    "12345678909",
                    null,
                    "67991234567",
                    LocalDate.of(1988, 12, 8),
                    LocalDate.now(), 30000
            );

            ClinicaMedica clinica = new ClinicaMedica("Clínica Universitária", "");
            // Implemente seus testes aqui...
            // Experimente cadastrar um secretário, médico, paciente, agendar uma consulta...

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}
