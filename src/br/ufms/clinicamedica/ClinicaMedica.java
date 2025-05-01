package br.ufms.clinicamedica;

import java.util.ArrayList;
import java.util.List;

public class ClinicaMedica {

    private String nome;
    private final String cnpj; // o CNPJ após inicializado não deve ser modificado
    // as listas também são "final" porque a referência não será modificada, isto é,
    // estas variáveis sempre apontarão para a mesma lista (isto é apenas uma boa prática)
    private final List<Medico> medicos;
    private final List<Secretario> secretarios;
    private final List<Paciente> pacientes;

    public ClinicaMedica(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;

        this.medicos = new ArrayList<Medico>();
        this.secretarios = new ArrayList<>();
        this.pacientes = new ArrayList<>();
    }

    // Implemente aqui os métodos que você considerar necessário para que o sistema
    // atenda a todas as funcionalidades descritas...
}
