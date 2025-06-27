package br.ufms.clinicamedica.service;

import br.ufms.clinicamedica.model.Paciente;

import java.util.List;
import java.util.Optional;

public interface PacienteServiceInterface {

    void salvarPaciente(Paciente paciente);

    void excluirPaciente(Paciente paciente);

    Optional<Paciente> buscarPaciente(String cpf);

    List<Paciente> listarPacientes();
}
