package org.riwiAcademyDB.model;

import org.riwiAcademyDB.entity.GradesEntity;
import org.riwiAcademyDB.persistence.connection.ConfigDB;
import org.riwiAcademyDB.persistence.iModel.IGradesModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GradesModel implements IGradesModel {

    // Inicializamos la conección nula para después poderla abrir y cerrar:
    Connection connection = null;

    // Proceso de creación de atributos de una tabla desde Java para la base de datos:
    @Override
    public GradesEntity create(GradesEntity gradesEntity) {

        // Abrimos la conexión con base de datos:
        connection = ConfigDB.openConnection();

        // Query para crear:
        String sqlQuery = "INSERT INTO GRADES (GRADE, DESCRIPTION, ID_COURSE) VALUES (?, ?, ?);";

        // Try-Catch para manejar los errores en el proceso de ejecución:
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setInt(1, gradesEntity.getGrade());
            preparedStatement.setString(2, gradesEntity.getDescription());
            preparedStatement.setInt(3, gradesEntity.getId_Course());

            boolean result = preparedStatement.execute();

            if(result) {
                return gradesEntity;
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
    public ArrayList<GradesEntity> readAll() {

        // Abrimos la conexión con base de datos:
        connection = ConfigDB.openConnection();

        // Instanciamos un array para almacenar lo que desea ser visto:
        ArrayList<GradesEntity> listGrade = new ArrayList<>();
        GradesEntity gradesEntity = new GradesEntity();

        // Query para seleccionar lo que deseamos mostrar al usuario:
        String sqlQuery = "SELECT * FROM GRADES;";

        // Try-Catch para manejar los errores en el proceso de ejecución:
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();

            while (resultSet.next()) {
                gradesEntity = new GradesEntity(
                        resultSet.getInt("id"),
                        resultSet.getInt("grade"),
                        resultSet.getString("description"),
                        resultSet.getInt("id_course")
                );
                listGrade.add(gradesEntity);
            }

            preparedStatement.close();
        } catch (SQLException error) {
            throw new RuntimeException("Query failed! " + error.getMessage());
        }

        // Cerramos la conexión con base de datos:
        ConfigDB.closeConnection();
        return listGrade;
    }

    // Proceso de editar/actualizar atributos de una tabla desde Java para la base de datos:
    @Override
    public GradesEntity update(GradesEntity gradesEntity, Integer id) {

        // Abrimos la conexión con base de datos:
        connection = ConfigDB.openConnection();

        // Query para seleccionar lo que deseamos editar/actualizar:
        String sqlQuery = "UPDATE GRADES SET GRADE = ?, DESCRIPTION = ?, ID_COURSE = ? WHERE ID = ?;";

        // Try-Catch para manejar los errores en el proceso de ejecución:
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setInt(1, gradesEntity.getGrade());
            preparedStatement.setString(2, gradesEntity.getDescription());
            preparedStatement.setInt(3, gradesEntity.getId_Course());
            preparedStatement.setInt(4, gradesEntity.getId());

            boolean result = preparedStatement.execute();

            if(result) {
                return gradesEntity;
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
