package org.riwiAcademyDB.persistence.iModel;

import org.riwiAcademyDB.entity.GradesEntity;
import org.riwiAcademyDB.persistence.crud.Create;
import org.riwiAcademyDB.persistence.crud.ReadAll;
import org.riwiAcademyDB.persistence.crud.Update;

// Extiendo cada una de las partes del CRUD implementandolos en los modelos de las entidades:
public interface IGradesModel extends
        Create<GradesEntity>,
        Update<GradesEntity, Integer>,
        ReadAll<GradesEntity> {

}
