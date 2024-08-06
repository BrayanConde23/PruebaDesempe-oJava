package org.riwiAcademyDB.persistence.iModel;

import org.riwiAcademyDB.entity.CourseEntity;
import org.riwiAcademyDB.persistence.crud.*;

// Extiendo cada una de las partes del CRUD implementandolos en los modelos de las entidades:
public interface ICourseModel extends
        Create<CourseEntity>,
        Update<CourseEntity, Integer>,
        ReadAll<CourseEntity>,
        Delete<Integer> {

}
