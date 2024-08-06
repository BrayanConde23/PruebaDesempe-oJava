package org.riwiAcademyDB.model;

import org.riwiAcademyDB.entity.StudentEntity;
import org.riwiAcademyDB.persistence.connection.ConfigDB;
import org.riwiAcademyDB.persistence.enums.EnumsRiwiAcademy;
import org.riwiAcademyDB.persistence.iModel.IStudentModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentModel implements IStudentModel {

    // Inicializamos la conección nula para después poderla abrir y cerrar:
    Connection connection = null;

    // Proceso de creación de atributos de una tabla desde Java para la base de datos:
    @Override
    public StudentEntity create(StudentEntity studentEntity) {

        // Abrimos la conexión con base de datos:
        connection = ConfigDB.openConnection();

        // Query para crear:
        String sqlQuery = "INSERT INTO STUDENT (NAME, LAST_NAME, EMAIL, STATUS) VALUES (?, ?, ?, ?);";

        // Try-Catch para manejar los errores en el proceso de ejecución:
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setString(1, studentEntity.getName());
            preparedStatement.setString(2, studentEntity.getLast_Name());
            preparedStatement.setString(3, studentEntity.getEmail());
            preparedStatement.setString(4, EnumsRiwiAcademy.ACTIVE.name());

            boolean result = preparedStatement.execute();

            if(result) {
                return studentEntity;
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
    public ArrayList<StudentEntity> readAll() {

        // Abrimos la conexión con base de datos:
        connection = ConfigDB.openConnection();

        // Instanciamos un array para almacenar lo que desea ser visto:
        ArrayList<StudentEntity> listStudent = new ArrayList<>();
        StudentEntity studentEntity = new StudentEntity();

        // Query para seleccionar lo que deseamos mostrar al usuario:
        String sqlQuery = "SELECT * FROM STUDENT;";

        // Try-Catch para manejar los errores en el proceso de ejecución:
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();

            while (resultSet.next()) {
                studentEntity = new StudentEntity(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        EnumsRiwiAcademy.valueOf(resultSet.getString("status"))
                );
                listStudent.add(studentEntity);
            }

            preparedStatement.close();
        } catch (SQLException error) {
            throw new RuntimeException("Query failed! " + error.getMessage());
        }

        // Cerramos la conexión con base de datos:
        ConfigDB.closeConnection();
        return listStudent;
    }

    // Proceso de mostrar atributos de una tabla con un "id" en específico desde Java para la base de datos:
    @Override
    public StudentEntity readById(Integer id) {

        // Abrimos la conexión con base de datos:
        connection = ConfigDB.openConnection();

        // Query para seleccionar lo que deseamos mostrar al usuario:
        String sqlQuery = "SELECT * FROM STUDENT WHERE ID = ?;";
        StudentEntity studentEntity = new StudentEntity();

        // Try-Catch para manejar los errores en el proceso de ejecución:
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setInt(1, id);
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();

            while (resultSet.next()) {
                studentEntity = new StudentEntity(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        EnumsRiwiAcademy.valueOf(resultSet.getString("status"))
                );
            }

            preparedStatement.close();
        } catch (SQLException error) {
            throw new RuntimeException("Query failed! " + error.getMessage());
        }

        // Cerramos la conexión con base de datos:
        ConfigDB.closeConnection();
        return studentEntity;
    }

    // Proceso de mostrar atributos de una tabla con un "email" en específico desde Java para la base de datos:
    @Override
    public StudentEntity readByEmail(String string) {

        // Abrimos la conexión con base de datos:
        connection = ConfigDB.openConnection();

        // Query para seleccionar lo que deseamos mostrar al usuario:
        String sqlQuery = "SELECT * FROM STUDENT WHERE EMAIL = ?;";
        StudentEntity studentEntity = new StudentEntity();

        // Try-Catch para manejar los errores en el proceso de ejecución:
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setString(1, string);
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();

            while (resultSet.next()) {
                studentEntity = new StudentEntity(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        EnumsRiwiAcademy.valueOf(resultSet.getString("status"))
                );
            }

            preparedStatement.close();
        } catch (SQLException error) {
            throw new RuntimeException("Query failed! " + error.getMessage());
        }

        // Cerramos la conexión con base de datos:
        ConfigDB.closeConnection();
        return studentEntity;
    }

    // Proceso de editar/actualizar atributos de una tabla desde Java para la base de datos:
    @Override
    public StudentEntity update(StudentEntity studentEntity, Integer id) {

        // Abrimos la conexión con base de datos:
        connection = ConfigDB.openConnection();

        // Query para seleccionar lo que deseamos editar/actualizar:
        String sqlQuery = "UPDATE STUDENT SET NAME = ?, LAST_NAME = ?, EMAIL = ?, STATUS = ? WHERE ID = ?;";

        // Try-Catch para manejar los errores en el proceso de ejecución:
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setString(1, studentEntity.getName());
            preparedStatement.setString(2, studentEntity.getLast_Name());
            preparedStatement.setString(3, studentEntity.getEmail());
            preparedStatement.setString(4, studentEntity.getStatus().name());
            preparedStatement.setInt(5, studentEntity.getId());

            boolean result = preparedStatement.execute();

            if (result) {
                return studentEntity;
            }

            preparedStatement.close();
        } catch (SQLException error) {
            throw new RuntimeException("Query failed! " + error.getMessage());
        }

        // Cerramos la conexión con base de datos:
        ConfigDB.closeConnection();
        return null;
    }

}
