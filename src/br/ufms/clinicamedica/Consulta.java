package br.ufms.clinicamedica;

import java.time.LocalDateTime;
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

    public Consulta(Medico medico, Paciente paciente, String sintomas, LocalDateTime dataHora, double valor) {
        this.codigo = 0;
        this.medico = medico;
        this.paciente = paciente;
        this.sintomas = sintomas;
        this.dataHora = dataHora;
        this.valor = valor;
    }
}
