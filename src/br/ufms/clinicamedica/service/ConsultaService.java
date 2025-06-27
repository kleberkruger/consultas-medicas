package br.ufms.clinicamedica.service;

import br.ufms.clinicamedica.model.Consulta;
import br.ufms.clinicamedica.model.Medico;
import br.ufms.clinicamedica.model.Paciente;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ConsultaService {

    /**
     * Agenda uma consulta médica.
     *
     * @param paciente paciente
     * @param medico   médico
     * @param sintomas sintomas
     * @param dataHora data e hora da consulta
     * @return uma consulta agendada (persistida) na base de dados
     */
    Consulta agendarConsulta(Paciente paciente, Medico medico, String sintomas, LocalDateTime dataHora);

    /**
     * Edita os dados de uma consulta médica
     *
     * @param consulta consulta
     */
    void editarConsulta(Consulta consulta);

    /**
     * Exclui uma consulta médica
     *
     * @param consulta consulta
     */
    void excluirConsulta(Consulta consulta);

    /**
     * Busca por uma consulta médica mediante um código informado
     *
     * @param codigo código da consulta
     * @return a consulta armazenada na base de dados
     */
    Optional<Consulta> buscarConsulta(String codigo);

    /**
     * Lista todas as consultas armazenadas na base de dados
     *
     * @return uma lista de consultas
     */
    List<Consulta> listarTodasConsultas();

    /**
     * Lista todas as consultas da base de dados de uma data informada
     *
     * @param data data da consulta
     * @return uma lista de consultas
     */
    List<Consulta> listarConsultasPorData(LocalDate data);

    /**
     * Lista todas as consultas da base de dados conforme um período informado
     *
     * @param dataInicial data inicial
     * @param dataFinal   data final
     * @return uma lista de consultas
     */
    List<Consulta> listarConsultasPorPeriodo(LocalDate dataInicial, LocalDate dataFinal);

    /**
     * Lista todas as consultas de um determinado médico
     *
     * @param crm CRM do médico
     * @return uma lista de consultas
     */
    List<Consulta> listarConsultasPorMedico(String crm);

    /**
     * Lista todas as consultas de um determinado paciente
     *
     * @param cpf CPF do paciente
     * @return uma lista de consultas
     */
    List<Consulta> listarConsultasPorPaciente(String cpf);

    /**
     * Lista todas as consultas do paciente em um período informado
     *
     * @param cpf         CPF do paciente
     * @param dataInicial data inicial
     * @param dataFinal   data final
     * @return uma lista de consultas
     */
    List<Consulta> listarConsultasPorPacienteNoPeriodo(String cpf, LocalDate dataInicial, LocalDate dataFinal);

    /**
     * Lista todas as consultas anteriores (finalizadas) de um paciente informado
     *
     * @param cpf CPF do paciente
     * @return uma lista de consultas
     */
    List<Consulta> listarHistoricoPaciente(String cpf);

    /**
     * Lista todas as consultas finalizadas de um paciente da data inicial informada até hoje
     *
     * @param cpf         CPF do paciente
     * @param dataInicial data de início
     * @return uma lista de consultas
     */
    List<Consulta> listarHistoricoPacienteAteData(String cpf, LocalDate dataInicial);


    /**
     * Lista todas as consultas de um médico em uma data especificada
     *
     * @param crm  CRM do médico
     * @param data data
     * @return uma lista de consultas
     */
    List<Consulta> listarConsultasMedicoNaData(String crm, LocalDate data);
}
