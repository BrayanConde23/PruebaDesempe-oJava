package org.riwiAcademyDB.persistence.iModel;

import org.riwiAcademyDB.entity.RegistrationEntity;
import org.riwiAcademyDB.persistence.crud.Create;
import org.riwiAcademyDB.persistence.crud.Delete;
import org.riwiAcademyDB.persistence.crud.ReadAll;
import org.riwiAcademyDB.persistence.crud.Update;

// Extiendo cada una de las partes del CRUD implementandolos en los modelos de las entidades:
public interface IRegistrationModel extends
        Create<RegistrationEntity>,
        Update<RegistrationEntity, Integer>,
        ReadAll<RegistrationEntity>,
        Delete<Integer> {

}
