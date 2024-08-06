package org.riwiAcademyDB.controller;

import org.riwiAcademyDB.entity.RegistrationEntity;
import org.riwiAcademyDB.model.RegistrationModel;
import org.riwiAcademyDB.persistence.iModel.IRegistrationModel;

import java.util.ArrayList;

public class RegistrationController {
    private IRegistrationModel registrationModel = (IRegistrationModel) new RegistrationModel();

    // Función para hacer más dinámica la creación del CRUD:
    public RegistrationEntity create(RegistrationEntity request) {
        return this.registrationModel.create(request);
    }

    // Función para hacer más dinámica la creación del CRUD:
    public RegistrationEntity update(RegistrationEntity registrationEntity, int id) {
        return this.registrationModel.update(registrationEntity, id);
    }

    // Función para hacer más dinámica la creación del CRUD:
    public ArrayList<RegistrationEntity> readAll() {
        return this.registrationModel.readAll();
    }

    // Función para hacer más dinámica la creación del CRUD:
    public Boolean delete(int id) {
        return this.registrationModel.delete(id);
    }
}
