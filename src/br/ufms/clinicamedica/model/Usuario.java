package br.ufms.clinicamedica.model;

import java.time.LocalDate;

public class Usuario {

    private String nome;
    private final String cpf; // final, pois este atributo após inicializado não será alterável
    private String email;
    private String telefone;
    private LocalDate dataNascimento;

    /**
     * Cria um objeto Usuario informando apenas os atributos obrigatórios.
     * Este construtor é protegido, logo, não é possível criar DIRETAMENTE um objeto dessa classe. Ele é utilizado
     * apenas pelas classes que herdam Usuario.
     *
     * @param nome nome
     * @param cpf  cpf
     */
    protected Usuario(String nome, String cpf) {
        this(nome, cpf, null, null, null);
    }

    /**
     * Cria um objeto Usuario informando todos os atributos.
     * Este construtor é protegido, logo, não é possível criar DIRETAMENTE um objeto dessa classe. Ele é utilizado
     * apenas pelas classes que herdam Usuario.
     *
     * @param nome           nome da pessoa
     * @param cpf            cpf
     * @param email          email
     * @param telefone       telefone
     * @param dataNascimento data de nascimento
     */
    protected Usuario(String nome, String cpf, String email, String telefone, LocalDate dataNascimento) {
        setNome(nome);
        setEmail(email);
        setTelefone(telefone);
        setDataNascimento(dataNascimento);

        this.cpf = validarCPF(cpf);
    }

    /**
     * Obtém o nome.
     *
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
            throw new IllegalArgumentException("O nome não pode estar em branco");
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
     * Obtém o CPF.
     *
     * @return o cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Obtém o email.
     *
     * @return o email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Altera o email
     *
     * @param email novo email
     */
    public void setEmail(String email) {
        email = email.trim(); // elimina espaços adicionais no início ou final da string
        if (email.isEmpty()) {
            throw new IllegalArgumentException("O email não pode estar em branco");
        } else if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
            throw new IllegalArgumentException("O email possui caracteres inválidos: " + email);
        } else if (email.length() < 6 || email.length() > 60) {
            throw new IllegalArgumentException("O email deve ter de 6 a 60 caracteres");
        }
        this.email = email;
    }

    /**
     * Obtém o telefone.
     *
     * @return o telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Altera o telefone. O telefone deve ser válido.
     *
     * @param telefone novo telefone
     */
    public void setTelefone(String telefone) {
        telefone = telefone != null ? telefone.trim() : null;
        if (telefone != null && !telefone.matches("^(\\d{2}9\\d{8}|\\d{2}[1-8]\\d{7})$")) {
            throw new IllegalArgumentException("Telefone inválido. Informe somente dígitos (com DDD)");
        }
        this.telefone = telefone;
    }

    /**
     * Obtém a data de nascimento.
     *
     * @return a data de nascimento
     */
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    /**
     * Altera a data de nascimento.
     *
     * @param dataNascimento nova data de nascimento.
     */
    public void setDataNascimento(LocalDate dataNascimento) {
        if (dataNascimento != null && (
                dataNascimento.isBefore(LocalDate.now().minusYears(150)) ||
                        dataNascimento.isAfter(LocalDate.now()))
        ) {
            throw new IllegalArgumentException("Data de nascimento inválida");
        }
        this.dataNascimento = dataNascimento;
    }

    /**
     * Método que valida o CPF.
     *
     * @param cpf cpf
     * @return o cpf validado
     */
    private static String validarCPF(String cpf) {
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

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Usuario usuario)) return false;

        return cpf.equals(usuario.cpf);
    }

    @Override
    public int hashCode() {
        return cpf.hashCode();
    }

    @Override
    public String toString() {
        return "Usuario{nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                '}';
    }
}
