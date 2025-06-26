package br.ufms.clinicamedica.OLD.controller;

import br.ufms.clinicamedica.model.Consulta;
import br.ufms.clinicamedica.model.Medico;
import br.ufms.clinicamedica.model.Paciente;
import br.ufms.clinicamedica.model.Secretario;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClinicaMedica {

    private String nome;
    private final String cnpj; // o CNPJ após inicializado não deve ser modificado
    // as listas também são "final" porque a referência não será modificada, isto é,
    // estas variáveis sempre apontarão para a mesma lista (isto é apenas uma boa prática)
    private final List<Medico> medicos;
    private final List<Secretario> secretarios;
    private final List<Paciente> pacientes;
    private final List<Consulta> consultas;

    public ClinicaMedica(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;

        this.medicos = new ArrayList<>();
        this.secretarios = new ArrayList<>();
        this.pacientes = new ArrayList<>();
        this.consultas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    /**
     * Adiciona um médico à lista de médicos verificando se ele(a) já existe.
     *
     * @param medico médico a ser adicionado
     */
    public void adicionarMedico(Medico medico) {
        if (medico == null) {
            throw new IllegalArgumentException("Médico nulo");
        } else if (medicos.contains(medico)) {
            throw new IllegalArgumentException("Médico já adicionado");
        }
        medicos.add(medico);
    }

    /**
     * Adiciona vários médicos à lista de médicos verificando se eles(eles) já existem.
     *
     * @param medicos médicos a serem adicionados
     */
    public void adicionarMedicos(Medico... medicos) {
        for (Medico medico : medicos) {
            adicionarMedico(medico);
        }
    }

    public void removerMedico(Medico medico) {
        if (medico == null) {
            throw new IllegalArgumentException("Médico nulo");
        } else if (!medicos.contains(medico)) {
            throw new IllegalArgumentException("Médico não encontrado");
        }
        // E se o médico estiver consultas agendadas, o que acontece?
        // Implemente suas validações conforme achar necessário...
        // ...
        // Ao final, o médico deve ser removido da lista de médicos
        medicos.remove(medico);
    }

    /**
     * Retorna uma lista imutável com todos os médicos cadastrados.
     *
     * @return a lista de médicos
     */
    public List<Medico> getMedicos() {
        // retorna uma cópia da lista de médicos para que o usuário não possa alterá-la
        return Collections.unmodifiableList(medicos);
    }

    /**
     * Adiciona um secretário à lista de secretários verificando se ele(a) já existe.
     *
     * @param secretario secretário a ser adicionado
     */
    public void adicionarSecretario(Secretario secretario) {
        if (secretario == null) {
            throw new IllegalArgumentException("Secretario nulo");
        } else if (secretarios.contains(secretario)) {
            throw new IllegalArgumentException("Secretario já adicionado");
        }
        secretarios.add(secretario);
    }

    /**
     * Adiciona vários secretários à lista de secretários verificando se eles(eles) já
     * existem.
     *
     * @param secretarios secretários a serem adicionados
     */
    public void adicionarSecretarios(Secretario... secretarios) {
        for (Secretario secretario : secretarios) {
            adicionarSecretario(secretario);
        }
    }

    public void removerSecretario(Secretario secretario) {
        if (secretario == null) {
            throw new IllegalArgumentException("Secretario nulo");
        } else if (!secretarios.contains(secretario)) {
            throw new IllegalArgumentException("Secretario não encontrado");
        }
        secretarios.remove(secretario);
    }

    /**
     * Retorna uma lista imutável com todos os secretários cadastrados.
     *
     * @return a lista de secretários
     */
    public List<Secretario> getSecretarios() {
        // retorna uma cópia da lista de secretários para que o usuário não possa alterá-la
        return Collections.unmodifiableList(secretarios);
    }

    // Implemente aqui os métodos que você considerar necessário para que o sistema
    // atenda a todas as funcionalidades descritas. Exemplos...

    public void adicionarPaciente(Paciente paciente) {
        // Implemente aqui...
    }

    public void adicionarPacientes(Paciente... pacientes) {
        // Implemente aqui...
    }

    public void removerPaciente(Paciente paciente) {
        // Implemente aqui...
    }

    public List<Paciente> getPacientes() {
        return Collections.unmodifiableList(pacientes);
    }

    public Consulta agendarConsulta(Paciente paciente, Medico medico, String sintomas, LocalDateTime dataHora) {
        // Implemente aqui...
        return null;
    }

    public Consulta buscarConsulta(long codigo) {
        for (Consulta consulta : consultas) {
            if (consulta.getCodigo() == codigo) {
                return consulta;
            }
        }
        return null;
    }

    /**
     * Retorna uma lista com todas as consultas de um determinado médico.
     *
     * @param medico médico
     * @return lista com todas as consultas de um determinado médico
     */
    public List<Consulta> getConsultasPorMedico(Medico medico) {
        return getConsultasPorMedico(medico, null);
    }

    /**
     * Retorna uma lista com todas as consultas de um determinado médico.
     *
     * @param medico médico
     * @return lista com todas as consultas do médico
     */
    public List<Consulta> getConsultasPorMedico(Medico medico, LocalDate data) {
        List<Consulta> lista = new ArrayList<>();
        for (Consulta consulta : consultas) {
            if (consulta.getMedico().equals(medico) &&
                    // Se não informou uma data específica, então retorne todas as consultas deste médico...
                    // Caso tenha informado uma data específica, adicione somente as consultas nesta data
                    (data == null || consulta.getDataHora().toLocalDate().equals(data))) {
                lista.add(consulta);
            }
        }
        return lista;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }
}
