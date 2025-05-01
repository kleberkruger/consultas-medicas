package br.ufms.clinicamedica;

import java.util.ArrayList;
import java.util.List;

public class ClinicaMedica {

    private String nome;
    private String cnpj;
    private List<Medico> medicos;
    private List<Secretario> secretarios;
    private List<Paciente> pacientes;

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
