package br.ufms.clinicamedica.service;

import br.ufms.clinicamedica.model.Medico;

import java.util.*;

public interface MedicoServiceInterface {

    void salvarMedico(Medico medico);

    void excluirMedico(Medico medico);

    Optional<Medico> buscarMedico(String cpf);

    Optional<Medico> buscarMedicoPorCRM(String crm);

    Collection<Medico> listarMedicos();

    /// Ações do médico
    void prescreverReceita(String crm, String codigoConsulta, String receita);

    default void pedirExame(String crm, String codigoConsulta, String exame) {
        pedirExames(crm, codigoConsulta, List.of(exame));
    }

    default void pedirExames(String crm, String codigoConsulta, String... exames) {
        pedirExames(crm, codigoConsulta, List.of(exames));
    }

    void pedirExames(String crm, String codigoConsulta, List<String> exames);
}
