package br.ufms.clinicamedica;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Consulta {

    private final long codigo;
    private final Medico medico;
    private final Paciente paciente;
    private String sintomas;
    private LocalDateTime dataHora;
    private double valor;
    private String receita;
    private List<String> exames;

    private static long proximoCodigo = 0;

    public Consulta(Medico medico, Paciente paciente, String sintomas, LocalDateTime dataHora, double valor) {
        this.codigo = ++proximoCodigo;
        this.medico = medico;
        this.paciente = paciente;
        this.sintomas = sintomas;
        this.dataHora = dataHora;
        this.valor = valor;
    }

    public long getCodigo() {
        return codigo;
    }

    public Medico getMedico() {
        return medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        if (dataHora == null) {
            throw new IllegalArgumentException("Data e hora não pode ser nula");
        } else if (dataHora.isBefore(LocalDateTime.now().minusYears(10))) {
            throw new IllegalArgumentException("Data e hora muito antiga");
        }
        this.dataHora = dataHora;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("Valor não pode ser negativo");
        }
        this.valor = valor;
    }

    public String getReceita() {
        return receita;
    }

    public void setReceita(String receita) {
        if (receita == null || receita.isBlank()) {
            throw new IllegalArgumentException("Receita não pode ser nula ou vazia");
        }
        this.receita = receita.trim();
    }

    /**
     * Adiciona um exame a esta consulta.
     *
     * @param exame
     */
    public void pedirExame(String exame) {
        if (exame == null || exame.isBlank()) {
            throw new IllegalArgumentException("Exame não pode ser nulo ou vazio");
        }
        exames.add(exame.trim());
    }

    /**
     * Adiciona um conjunto de exames a esta consulta.
     *
     * @param exame
     */
    public void pedirExames(String... exame) {
        for (String e : exame) {
            pedirExame(e);
        }
    }

    /**
     * Obtém uma lista imutável com os exames pedidos.
     *
     * @return a lista de exames
     */
    public List<String> getExames() {
        return Collections.unmodifiableList(exames);
    }

    public void setExames(List<String> exames) {
        // se a nova lista de exames é nula, defina uma nova lista vazia, caso contrário, defina a nova lista
        this.exames = exames == null ? new ArrayList<>() : exames;
    }

    /**
     * Verifica se a consulta já foi atendida. Se o médico aplicou uma receita ou pediu algum exame,
     * então a consulta foi atendida.
     *
     * @return verdadeiro se esta consulta foi atendida, falso caso contrário
     */
    public boolean isAtendida() {
        return (receita != null && !receita.isBlank() || !exames.isEmpty());
    }
}
