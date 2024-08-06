package org.riwiAcademyDB.controller;

import org.riwiAcademyDB.entity.CourseEntity;
import org.riwiAcademyDB.model.CourseModel;
import org.riwiAcademyDB.persistence.iModel.ICourseModel;

import java.util.ArrayList;

public class CourseController {
    private ICourseModel courseModel = (ICourseModel) new CourseModel();

    // Función para hacer más dinámica la creación del CRUD:
    public CourseEntity create(CourseEntity request) {
        return this.courseModel.create(request);
    }

    // Función para hacer más dinámica la creación del CRUD:
    public CourseEntity update(CourseEntity courseEntity, int id) {
        return this.courseModel.update(courseEntity, id);
    }

    // Función para hacer más dinámica la creación del CRUD:
    public ArrayList<CourseEntity> readAll() {
        return this.courseModel.readAll();
    }

    // Función para hacer más dinámica la creación del CRUD:
    public Boolean delete(int id) {
        return this.courseModel.delete(id);
    }
}
