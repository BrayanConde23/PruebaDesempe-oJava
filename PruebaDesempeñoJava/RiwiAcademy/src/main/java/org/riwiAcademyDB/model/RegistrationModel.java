package org.riwiAcademyDB.model;

import org.riwiAcademyDB.entity.RegistrationEntity;
import org.riwiAcademyDB.persistence.connection.ConfigDB;
import org.riwiAcademyDB.persistence.iModel.IRegistrationModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RegistrationModel implements IRegistrationModel {

    // Inicializamos la conección nula para después poderla abrir y cerrar:
    Connection connection = null;

    // Proceso de creación de atributos de una tabla desde Java para la base de datos:
    @Override
    public RegistrationEntity create(RegistrationEntity registrationEntity) {

        // Abrimos la conexión con base de datos:
        connection = ConfigDB.openConnection();

        // Query para crear:
        String sqlQuery = "INSERT INTO REGISTRATION (ID_COURSE, ID_STUDENT) VALUES (?, ?);";

        // Try-Catch para manejar los errores en el proceso de ejecución:
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setInt(1, registrationEntity.getCourse_id());
            preparedStatement.setInt(2, registrationEntity.getId_Student());

            boolean result = preparedStatement.execute();

            if(result) {
                return registrationEntity;
            }

            preparedStatement.close();
        } catch (SQLException error) {
            throw new RuntimeException("Query failed! " + error.getMessage());
        }

        // Cerramos la conexión con base de datos:
        ConfigDB.closeConnection();
        return null;
    }

    // Proceso de mostrar atributos de una tabla desde Java para la base de datos:
    @Override
    public ArrayList<RegistrationEntity> readAll() {

        // Abrimos la conexión con base de datos:
        connection = ConfigDB.openConnection();

        // Instanciamos un array para almacenar lo que desea ser visto:
        ArrayList<RegistrationEntity> listRegistration = new ArrayList<>();
        RegistrationEntity registrationEntity = new RegistrationEntity();

        // Query para seleccionar lo que deseamos mostrar al usuario:
        String sqlQuery = "SELECT * FROM REGISTRATION;";

        // Try-Catch para manejar los errores en el proceso de ejecución:
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();

            while (resultSet.next()) {
                registrationEntity = new RegistrationEntity(
                        resultSet.getInt("id"),
                        resultSet.getInt("id_course"),
                        resultSet.getInt("id_student")
                );
                listRegistration.add(registrationEntity);
            }

            preparedStatement.close();
        } catch (SQLException error) {
            throw new RuntimeException("Query failed! " + error.getMessage());
        }

        // Cerramos la conexión con base de datos:
        ConfigDB.closeConnection();
        return listRegistration;
    }

    // Proceso de editar/actualizar atributos de una tabla desde Java para la base de datos:
    @Override
    public RegistrationEntity update(RegistrationEntity registrationEntity, Integer id) {

        // Abrimos la conexión con base de datos:
        connection = ConfigDB.openConnection();

        // Query para seleccionar lo que deseamos editar/actualizar:
        String sqlQuery = "UPDATE REGISTRATION SET ID_COURSE = ?, ID_STUDENT = ? WHERE ID = ?;";

        // Try-Catch para manejar los errores en el proceso de ejecución:
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setInt(1, registrationEntity.getCourse_id());
            preparedStatement.setInt(2, registrationEntity.getId_Student());
            preparedStatement.setInt(3, registrationEntity.getId());

            boolean result = preparedStatement.execute();

            if(result) {
                return registrationEntity;
            }

            preparedStatement.close();
        } catch (SQLException error) {
            throw new RuntimeException("Query failed! " + error.getMessage());
        }

        // Cerramos la conexión con base de datos:
        ConfigDB.closeConnection();
        return null;
    }

    // Proceso de borrar/eliminar atributos de una tabla desde Java para la base de datos:
    @Override
    public boolean delete(Integer id) {

        // Abrimos la conexión con base de datos:
        connection = ConfigDB.openConnection();

        // Query para seleccionar lo que deseamos editar/actualizar:
        String sqlQuery= "DELETE FROM REGISTRATION WHERE ID = ?;";

        // Try-Catch para manejar los errores en el proceso de ejecución:
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setInt(1, id);

            boolean result = preparedStatement.execute();

            if (result) {
                return true;
            }

            preparedStatement.close();
        } catch (SQLException error) {
            throw new RuntimeException("Query failed! " + error.getMessage());
        }

        // Cerramos la conexión con base de datos:
        ConfigDB.closeConnection();
        return false;
    }
}
