package br.ufms.clinicamedica.repository;

import br.ufms.clinicamedica.model.Paciente;

public class PacienteRepository extends FileRepository<Paciente, String> {

    public PacienteRepository() {
        super("paciente");
    }

    @Override
    protected String getId(Paciente paciente) {
        return paciente.getCpf();
    }

    @Override
    protected String entityToText(Paciente paciente) {
        return String.format("%s|%s|%s|%s|%s", paciente.getCpf(), paciente.getNome(), paciente.getEndereco(), paciente.getTelefone(), paciente.getDataNascimento());
    }

    @Override
    protected Paciente textToEntity(String line) {
        String[] info = line.split("\\|");
        return new Paciente(info[1], info[0], null, info[3], null);
    }
}
