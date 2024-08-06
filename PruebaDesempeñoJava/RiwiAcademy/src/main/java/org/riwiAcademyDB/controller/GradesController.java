package org.riwiAcademyDB.controller;

import org.riwiAcademyDB.entity.GradesEntity;
import org.riwiAcademyDB.model.GradesModel;
import org.riwiAcademyDB.persistence.iModel.IGradesModel;

import java.util.ArrayList;

public class GradesController {
    private IGradesModel gradesModel = (IGradesModel) new GradesModel();

    // Función para hacer más dinámica la creación del CRUD:
    public GradesEntity create(GradesEntity request) {
        return this.gradesModel.create(request);
    }

    // Función para hacer más dinámica la creación del CRUD:
    public GradesEntity update(GradesEntity gradesEntity, int id) {
        return this.gradesModel.update(gradesEntity, id);
    }

    // Función para hacer más dinámica la creación del CRUD:
    public ArrayList<GradesEntity> readAll() {
        return this.gradesModel.readAll();
    }
}
