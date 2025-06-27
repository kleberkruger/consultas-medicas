package br.ufms.clinicamedica.service;

import br.ufms.clinicamedica.model.Consulta;
import br.ufms.clinicamedica.model.Medico;
import br.ufms.clinicamedica.model.Paciente;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface MedicoService {

    /// Médicos
    void cadastrarMedico(Medico medico);

    void atualizarMedico(Medico medico);

    void excluirMedico(Medico medico);

    void aplicarReceita(Consulta consulta);

    void pedirExame(String... exames);

    void pedirExames(List<String> exames);

    Optional<Consulta> buscarConsulta(long  codigo);

    List<Consulta> listarTodasConsultas();

    List<Consulta> listarConsultasPorMedico(Medico medico);

    List<Consulta> listarConsultasPorPaciente(Paciente paciente);

    List<Consulta> listarConsultasPorData(LocalDate data);
}
