package br.ufms.clinicamedica.service;

import br.ufms.clinicamedica.model.Secretario;

import java.util.List;
import java.util.Optional;

public interface SecretarioService {

    void salvarSecretario(Secretario secretario);

    void excluirSecretario(Secretario secretario);

    Optional<Secretario> buscarSecretario(String cpf);

    List<Secretario> listarSecretarios();
}
