package br.ufms.clinicamedica.repository;

import java.io.Serializable;
import java.util.Collection;
import java.util.Optional;

public interface Repository<Entity, Id extends Serializable> {

    void save(Entity entity) throws Exception;

    void delete(Id id) throws Exception;

    Optional<Entity> get(Id id) throws Exception;

    Collection<Entity> getAll() throws Exception;
}
