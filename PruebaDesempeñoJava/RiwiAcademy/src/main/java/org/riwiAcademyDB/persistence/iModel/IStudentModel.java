package org.riwiAcademyDB.persistence.iModel;

import org.riwiAcademyDB.entity.StudentEntity;
import org.riwiAcademyDB.persistence.crud.*;

// Extiendo cada una de las partes del CRUD implementandolos en los modelos de las entidades:
public interface IStudentModel extends
        Create<StudentEntity>,
        Update<StudentEntity, Integer>,
        ReadAll<StudentEntity>,
        ReadById<StudentEntity, Integer>,
        ReadByEmail<StudentEntity, String> {

}
