package org.riwiAcademyDB.persistence.crud;

// Creación del método "Update":
public interface Update <Entity, Id>{
    public Entity update (Entity entity, Id id);
}
