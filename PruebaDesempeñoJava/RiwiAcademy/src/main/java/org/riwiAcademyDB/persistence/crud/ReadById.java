package org.riwiAcademyDB.persistence.crud;

// Creación del método "ReadById":
public interface ReadById <Entity, Id>{
    public Entity readById (Id id);
}
