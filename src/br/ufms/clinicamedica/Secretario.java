package br.ufms.clinicamedica;

import java.time.LocalDate;

public class Secretario {

    private String nome;
    private final String cpf; // este atributo após inicializado não será alterável
    private Endereco endereco;
    private String telefone;
    private LocalDate dataNascimento;
    private LocalDate dataIngresso;
    private double salario;

    /**
     * Constrói um objeto Secretario informando apenas os atributos obrigatórios.
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
        // inicializa os atributos chamando os métodos setters que validam os valores
        setNome(nome);
        setEndereco(endereco);
        setTelefone(telefone);
        setDataNascimento(dataNascimento);
        setDataIngresso(dataIngresso);
        setSalario(salario);

        // Por ser final, este atributo não tem método set, e deve ser inicializado no construtor
        this.cpf = validarCPF(cpf);
    }

    /**
     * @return o nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Altera o nome
     *
     * @param nome novo nome
     */
    public void setNome(String nome) {
        if (nome == null) {
            throw new IllegalArgumentException("O nome não pode ser nulo");
        }
        nome = nome.trim(); // elimina espaços adicionais no início ou final da string
        if (nome.isEmpty()) {
            throw new IllegalArgumentException("O nome pode ser em branco");
        } else if (!nome.matches("^[A-Za-zÀ-ÖØ-öø-ÿ'\\-\\s]+$")) {
            throw new IllegalArgumentException("O nome possui caracteres inválidos: " + nome);
        } else if (nome.split(" ").length < 2) {
            throw new IllegalArgumentException("O nome está incompleto. Informe o sobrenome");
        } else if (nome.length() < 3 || nome.length() > 60) {
            throw new IllegalArgumentException("O nome deve ter de 3 a 60 caracteres");
        }
        this.nome = nome;
    }

    /**
     * Altera o CPF
     *
     * @return novo CPF
     */
    public String getCpf() {
        return cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        telefone = telefone != null ? telefone.trim() : null;
        if (telefone != null && !telefone.matches("^(\\d{2}9\\d{8}|\\d{2}[1-8]\\d{7})$")) {
            throw new IllegalArgumentException("Telefone inválido. Informe somente dígitos (com DDD)");
        }
        this.telefone = telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        if (dataNascimento != null) {
            if (dataNascimento.isBefore(LocalDate.now().minusYears(150)) ||
                    dataNascimento.isAfter(LocalDate.now())) {
                throw new IllegalArgumentException("Data de nascimento inválida");
            } else if (dataNascimento.isAfter(LocalDate.now().minusYears(18))) {
                throw new IllegalArgumentException("O secretário deve ter pelo menos 18 anos");
            }
        }
        this.dataNascimento = dataNascimento;
    }

    public LocalDate getDataIngresso() {
        return dataIngresso;
    }

    public void setDataIngresso(LocalDate dataIngresso) {
        if (dataIngresso != null) {
            // não há como o secretário ter ingressado antes de ter feito 18 anos
            LocalDate minDataIngresso = dataNascimento != null ? dataNascimento.plusYears(18) : LocalDate.now();
            if (dataNascimento != null) {
                if (dataIngresso.isBefore(minDataIngresso) || dataIngresso.isAfter(LocalDate.now())) {
                    throw new IllegalArgumentException("Data de ingresso inválida");
                }
            }
        }
        this.dataIngresso = dataIngresso;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario < 0) {
            throw new IllegalArgumentException("O salário não pode ser negativo");
        }
        this.salario = salario;
    }

    private String validarCPF(String cpf) {
        if (cpf == null) {
            throw new IllegalArgumentException("CPF nulo");
        }
        cpf = cpf.trim();
        if (!cpf.matches("\\d{11}") || cpf.chars().distinct().count() == 1) {
            throw new IllegalArgumentException("CPF inválido");
        }

        int[] peso1 = {10, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] peso2 = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};

        int soma1 = 0, soma2 = 0;
        for (int i = 0; i < 9; i++) {
            int dig = Character.getNumericValue(cpf.charAt(i));
            soma1 += dig * peso1[i];
            soma2 += dig * peso2[i];
        }
        int dig1 = soma1 % 11 < 2 ? 0 : 11 - (soma1 % 11);
        soma2 += dig1 * peso2[9];
        int dig2 = soma2 % 11 < 2 ? 0 : 11 - (soma2 % 11);
        if (dig1 != Character.getNumericValue(cpf.charAt(9)) || dig2 != Character.getNumericValue(cpf.charAt(10))) {
            throw new IllegalArgumentException("CPF inválido");
        }
        return cpf;
    }
}
