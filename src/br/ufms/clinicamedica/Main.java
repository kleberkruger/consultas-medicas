package br.ufms.clinicamedica;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        try {
            ClinicaMedica clinica = new ClinicaMedica("Clínica Universitária", "");

            Secretario s1 = new Secretario(
                    "Kleber Kruger",
                    "12345678909",
                    null,
                    "67991234567",
                    LocalDate.of(1988, 12, 8),
                    LocalDate.now(), 30000
            );

            Secretario s2 = new Secretario(
                    "Kleber Kruger",
                    "12345678909",
                    null,
                    "67991234567",
                    LocalDate.of(1988, 12, 8),
                    LocalDate.now(), 30000
            );

            clinica.adicionarSecretario(s1);
            clinica.adicionarSecretario(s2);

            for (Secretario s : clinica.getSecretarios()) {
//                System.out.println(s.getNome());
                System.out.println(s);
            }

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}
