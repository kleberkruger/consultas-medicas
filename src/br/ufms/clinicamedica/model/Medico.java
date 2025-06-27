package br.ufms.clinicamedica.model;

import java.time.LocalDate;

public class Medico extends Usuario {

    private String crm;

    /**
     * Cria um objeto Médico informando apenas os atributos obrigatórios.
     *
     * @param nome nome
     * @param cpf  cpf
     * @param crm  número de registro no Conselho Regional de Medicina (CRM)
     */
    public Medico(String nome, String cpf, String crm) {
        // este construtor chama o construtor abaixo para concentrar as inicializações em um mesmo lugar
        this(nome, cpf, crm, null, null, null);
    }

    /**
     * Cria um objeto Médico especificando todos os campos.
     *
     * @param nome           nome
     * @param cpf            cpf
     * @param crm            número de registro no Conselho Regional de Medicina (CRM)
     * @param email          email
     * @param telefone       telefone
     * @param dataNascimento data de nascimento
     */
    public Medico(String nome, String cpf, String crm, String email, String telefone,
                  LocalDate dataNascimento) {
        super(nome, cpf, email, telefone, dataNascimento);

        this.setCrm(crm);
    }

    public String getCrm() {
        return crm;
    }

    public String getCrmFormatado() {
        int numero = Integer.parseInt(crm.substring(0, crm.length() - 2));
        return String.format("%06d-%s", numero, crm.substring(crm.length() - 2));
    }

    public void setCrm(String crm) {
        if (crm == null || crm.isBlank()) {
            throw new IllegalArgumentException("O CRM não pode ser nulo ou vazio");
        }
        crm = crm.trim(); // elimina espaços adicionais no início ou final da string
        if (!crm.matches("^\\d{1,6}[A-Z]{2}$")) {
            throw new IllegalArgumentException("CRM inválido: " + crm);
        }
        this.crm = crm;
    }

    @Override
    public String toString() {
        return "Medico{nome='" + getNome() + '\'' +
                ", cpf='" + getCpf() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", telefone='" + getTelefone() + '\'' +
                ", dataNascimento='" + getDataNascimento() + '\'' +
                ", crm='" + crm + '\'' +
                '}';
    }
}
