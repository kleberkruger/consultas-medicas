package br.ufms.clinicamedica.model;

import java.time.LocalDate;

public class Secretario extends Usuario {

    private LocalDate dataIngresso;
    private double salario;

    /**
     * Cria um objeto Secretario informando apenas os atributos obrigatórios.
     *
     * @param nome    nome
     * @param cpf     cpf
     * @param salario salário
     */
    public Secretario(String nome, String cpf, double salario) {
        // este construtor chama o construtor abaixo para concentrar as inicializações em um mesmo lugar
        this(nome, cpf, null, null, null, null, salario);
    }

    /**
     * Cria um objeto Secretário especificando todos os campos.
     *
     * @param nome           nome
     * @param cpf            CPF
     * @param endereco       endereço
     * @param telefone       telefone
     * @param dataNascimento data de nascimento
     * @param dataIngresso   data de ingresso na clínica
     * @param salario        salário
     */
    public Secretario(String nome, String cpf, Endereco endereco, String telefone,
                      LocalDate dataNascimento, LocalDate dataIngresso, double salario) {
        // chama o construtor da super classe para inicializar os atributos obrigatórios
        super(nome, cpf);

        // inicializa os atributos chamando os métodos setters da super classe (Usuario) para validar os valores
        super.setEndereco(endereco);
        super.setTelefone(telefone);
        super.setDataNascimento(dataNascimento);

        // inicializa os atributos chamando os métodos setters desta classe para validar os valores
        this.setDataIngresso(dataIngresso);
        this.setSalario(salario);
    }


    /**
     * Obtém a data de ingresso na clínica.
     *
     * @return a data de ingresso
     */
    public LocalDate getDataIngresso() {
        return dataIngresso;
    }

    /**
     * Altera a data de ingresso na clínica.
     *
     * @param dataIngresso data de ingresso.
     */
    public void setDataIngresso(LocalDate dataIngresso) {
        if (dataIngresso != null && dataIngresso.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Data de ingresso inválida");
        }
        this.dataIngresso = dataIngresso;
    }

    /**
     * Obtém o salário.
     *
     * @return o novo salário
     */
    public double getSalario() {
        return salario;
    }

    /**
     * Altera o salário. O salário não pode ser negativo.
     *
     * @param salario novo salário
     */
    public void setSalario(double salario) {
        if (salario < 0) {
            throw new IllegalArgumentException("O salário não pode ser negativo");
        }
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Secretario{nome='" + getNome() + '\'' +
                ", cpf='" + getCpf() + '\'' +
                ", endereco=" + getEndereco() +
                ", telefone='" + getTelefone() + '\'' +
                ", dataNascimento=" + getDataNascimento() + '\'' +
                ", dataIngresso=" + dataIngresso + '\'' +
                ", salario='" + salario +
                '}';
    }
}
