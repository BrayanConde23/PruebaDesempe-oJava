package org.riwiAcademyDB.persistence.crud;

// Creación del método "ReadByEmail":
public interface ReadByEmail <Entity, String>{
    public Entity readByEmail (String string);
}
