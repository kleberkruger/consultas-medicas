package br.ufms.clinicamedica.OLD.controller;

import br.ufms.clinicamedica.model.Consulta;
import br.ufms.clinicamedica.model.Medico;
import br.ufms.clinicamedica.model.Paciente;
import br.ufms.clinicamedica.model.Secretario;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ServicosSecretario {

    /// Secretário
    void cadastrarSecretario(Secretario secretario);

    void atualizarSecretario(Secretario secretario);

    void excluirSecretario(Secretario secretario);

    /// Médicos
    void cadastrarMedico(Medico medico);

    void atualizarMedico(Medico medico);

    void excluirMedico(Medico medico);

    /// Pacientes
    void cadastrarPaciente(Paciente paciente);

    void atualizarPaciente(Paciente paciente);

    void excluirPaciente(Paciente paciente);

    /// Consultas
    Consulta agendarConsulta(Paciente paciente, Medico medico, String sintomas, LocalDateTime dataHora);

    void editarConsulta(Consulta consulta);

    void excluirConsulta(Consulta consulta);

    Optional<Consulta> buscarConsulta(long codigo);

    List<Consulta> listarTodasConsultas();

    List<Consulta> listarConsultasPorMedico(Medico medico);

    List<Consulta> listarConsultasPorPaciente(Paciente paciente);

    List<Consulta> listarConsultasPorData(LocalDate data);
}
