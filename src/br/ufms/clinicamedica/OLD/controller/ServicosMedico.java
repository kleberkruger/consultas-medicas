package br.ufms.clinicamedica.OLD.controller;

import br.ufms.clinicamedica.model.Consulta;
import br.ufms.clinicamedica.model.Medico;

import java.time.LocalDate;
import java.util.List;

public interface ServicosMedico {

    List<Consulta> listarAgendamentos(Medico medico);

    List<Consulta> listarAgendamentos(Medico medico, LocalDate data);

    List<Consulta> listarHistoricoConsultas(Medico medico);

    List<Consulta> listarHistoricoConsultas(Medico medico, LocalDate dataInicial, LocalDate dataFinal);

    void prescreverReceita(Consulta consulta, String receita);

    void pedirExame(Consulta consulta, String exame);

    void pedirExames(Consulta consulta, String... exames);

    void pedirExames(Consulta consulta, List<String> exames);
}
