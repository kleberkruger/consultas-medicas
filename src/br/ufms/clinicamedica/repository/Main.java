package br.ufms.clinicamedica.repository;

import br.ufms.clinicamedica.model.Paciente;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        try (PacienteRepository pacienteRepository = new PacienteRepository()) {
            Paciente paciente = new Paciente(
                    "Angelo Darcy Molin",
                    "11144477735",
                    null,
                    "67999999999",
                    LocalDate.of(1986, 8, 17)
            );
            pacienteRepository.save(paciente);

            var r = pacienteRepository.get("11144477735");
            if (r.isPresent()) {
                Paciente p = r.get();
                System.out.println(p.getNome());
            } else {
                System.out.println("Paciente não encontrado");
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
