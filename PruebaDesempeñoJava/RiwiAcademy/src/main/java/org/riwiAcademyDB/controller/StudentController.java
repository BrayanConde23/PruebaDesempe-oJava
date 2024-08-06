package org.riwiAcademyDB.controller;

import org.riwiAcademyDB.entity.StudentEntity;
import org.riwiAcademyDB.model.StudentModel;
import org.riwiAcademyDB.persistence.iModel.IStudentModel;

import java.util.ArrayList;

public class StudentController {
    private IStudentModel studentModel = new StudentModel();

    // Función para hacer más dinámica la creación del CRUD:
    public StudentEntity create(StudentEntity request) {
        return this.studentModel.create(request);
    }

    // Función para hacer más dinámica la creación del CRUD:
    public StudentEntity update(StudentEntity studentEntity, int id){
        return this.studentModel.update(studentEntity, id);
    }

    // Función para hacer más dinámica la creación del CRUD:
    public ArrayList<StudentEntity> readAll() {
        return this.studentModel.readAll();
    }

    // Función para hacer más dinámica la creación del CRUD:
    public StudentEntity readById(int id) {
        return this.studentModel.readById(id);
    }

    // Función para hacer más dinámica la creación del CRUD:
    public StudentEntity readByEmail(String string) {
        return this.studentModel.readByEmail(string);
    }
}
