package br.ufms.clinicamedica;

import java.time.LocalDate;

public class Paciente extends Usuario {

    /**
     * Cria um objeto Paciente informando apenas os atributos obrigatórios.
     *
     * @param nome nome
     * @param cpf  cpf
     */
    public Paciente(String nome, String cpf) {
        // este construtor chama o construtor abaixo para concentrar as inicializações em um mesmo lugar
        this(nome, cpf, null, null, null);
    }

    /**
     * Cria um objeto Paciente informando todos os atributos.
     *
     * @param nome           nome
     * @param cpf            cpf
     * @param endereco       endereço
     * @param telefone       telefone
     * @param dataNascimento data de nascimento
     */
    public Paciente(String nome, String cpf, Endereco endereco, String telefone, LocalDate dataNascimento) {
        super(nome, cpf, endereco, telefone, dataNascimento);
    }

    @Override
    public String toString() {
        return "Paciente{nome='" + getNome() + '\'' +
                ", cpf='" + getCpf() + '\'' +
                ", endereco=" + getEndereco() +
                ", telefone='" + getTelefone() + '\'' +
                ", dataNascimento=" + getDataNascimento() +
                '}';
    }
}
