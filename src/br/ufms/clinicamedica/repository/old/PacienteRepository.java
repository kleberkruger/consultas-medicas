package br.ufms.clinicamedica.repository.old;

import br.ufms.clinicamedica.model.Paciente;
import br.ufms.clinicamedica.repository.Repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class PacienteRepository implements Repository<Paciente, String> {

    private final Map<String, Paciente> pacientes;

    PacienteRepository() {
        pacientes = load();
    }

    private void save() {
        Path path = Paths.get(System.getProperty("user.home") + "/.clinica/pacientes.db");
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Paciente p : pacientes.values()) {
                writer.write(String.format("%s|%s|%s", p.getCpf(), p.getNome(), p.getTelefone()));
                writer.newLine();
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private Map<String, Paciente> load() {
        Map<String, Paciente> mapa = new HashMap<>();
        Path path = Paths.get(System.getProperty("user.home") + "/.clinica/pacientes.db");
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            while (reader.ready()) {
                String linha = reader.readLine();
                String[] info = linha.split("\\|");
                String cpf = info[0];
                String nome = info[1];
                String telefone = info[2];

                Paciente p = new Paciente(nome, cpf, null, telefone, null);
                mapa.put(cpf, p);
            }

        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }

        return mapa;
    }

    @Override
    public void save(Paciente paciente) throws Exception {
        pacientes.put(paciente.getCpf(), paciente);
        save();
    }

    @Override
    public void delete(String cpf) throws Exception {
        pacientes.remove(cpf);
        save();
    }

    @Override
    public Optional<Paciente> get(String cpf) throws Exception {
        return Optional.ofNullable(pacientes.get(cpf));
    }

    @Override
    public Collection<Paciente> getAll() throws Exception {
        return pacientes.values();
    }
}
