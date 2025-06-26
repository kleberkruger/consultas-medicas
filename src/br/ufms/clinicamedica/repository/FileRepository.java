package br.ufms.clinicamedica.repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public abstract class FileRepository<Entity, Id extends Serializable> implements Repository<Entity, Id>, AutoCloseable {

    private static final Path ROOT = Paths.get(System.getProperty("user.home"), ".clinica");

    private final Path filePath;
    protected final Map<Id, Entity> repository;

    public FileRepository(String entityName) {
        this.filePath = ROOT.resolve(entityName + ".db");
        this.repository = load();
    }

    protected Map<Id, Entity> load() {
        Map<Id, Entity> map = new HashMap<>();
        if (Files.exists(filePath)) {
            try (BufferedReader reader = Files.newBufferedReader(filePath)) {
                while (reader.ready()) {
                    Entity e = textToEntity(reader.readLine());
                    map.put(getId(e), e);
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
        return map;
    }

    protected void save() throws IOException {
        Files.createDirectories(filePath.getParent());

        try (BufferedWriter writer = Files.newBufferedWriter(filePath,
                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
            for (var entity : repository.values()) {
                writer.write(entityToText(entity));
                writer.newLine();
            }
        }
    }

    @Override
    public void close() throws Exception {
        save();
    }

    @Override
    public void save(Entity entity) throws Exception {
        repository.put(getId(entity), entity);
        save();
    }

    @Override
    public void delete(Id id) throws Exception {
        repository.remove(id);
        save();
    }

    @Override
    public Optional<Entity> get(Id id) throws Exception {
        return Optional.ofNullable(repository.get(id));
    }

    @Override
    public Collection<Entity> getAll() throws Exception {
        return repository.values();
    }

    protected abstract Id getId(Entity entity);

    protected abstract String entityToText(Entity entity);

    protected abstract Entity textToEntity(String line);
}
