package org.riwiAcademyDB.persistence.crud;

import java.util.ArrayList;

// Creación del método "ReadAll":
public interface ReadAll <Entity>{
    public ArrayList<Entity> readAll();
}
