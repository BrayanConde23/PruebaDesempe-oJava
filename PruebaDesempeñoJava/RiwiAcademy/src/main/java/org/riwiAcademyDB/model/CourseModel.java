package org.riwiAcademyDB.model;

import org.riwiAcademyDB.entity.CourseEntity;
import org.riwiAcademyDB.persistence.connection.ConfigDB;
import org.riwiAcademyDB.persistence.iModel.ICourseModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CourseModel implements ICourseModel {

    // Inicializamos la conexión nula para después poderla abrir y cerrar:
    Connection connection = null;

    // Proceso de creación de atributos de una tabla desde Java para la base de datos:
    @Override
    public CourseEntity create(CourseEntity courseEntity) {

        // Abrimos la conexión con base de datos:
        connection = ConfigDB.openConnection();

        // Query para crear:
        String sqlQuery = "INSERT INTO COURSE (COURSE_NAME, ID_STUDENT) VALUES (?, ?);";

        // Try-Catch para manejar los errores en el proceso de ejecución:
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setString(1, courseEntity.getCourse_Name());
            preparedStatement.setInt(2, courseEntity.getId_Student());

            boolean result = preparedStatement.execute();

            if(result) {
                return courseEntity;
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
    public ArrayList<CourseEntity> readAll() {

        // Abrimos la conexión con base de datos:
        connection = ConfigDB.openConnection();

        // Instanciamos un array para almacenar lo que desea ser visto:
        ArrayList<CourseEntity> listCourse = new ArrayList<>();
        CourseEntity courseEntity = new CourseEntity();

        // Query para seleccionar lo que deseamos mostrar al usuario:
        String sqlQuery = "SELECT * FROM COURSE;";

        // Try-Catch para manejar los errores en el proceso de ejecución:
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();

            while (resultSet.next()) {
                courseEntity = new CourseEntity(
                        resultSet.getInt("id"),
                        resultSet.getString("course_name"),
                        resultSet.getInt("id_student")
                );
                listCourse.add(courseEntity);
            }

            preparedStatement.close();
        } catch (SQLException error) {
            throw new RuntimeException("Query failed! " + error.getMessage());
        }

        // Cerramos la conexión con base de datos:
        ConfigDB.closeConnection();
        return listCourse;
    }

    // Proceso de editar/actualizar atributos de una tabla desde Java para la base de datos:
    @Override
    public CourseEntity update(CourseEntity courseEntity, Integer id) {

        // Abrimos la conexión con base de datos:
        connection = ConfigDB.openConnection();

        // Query para seleccionar lo que deseamos editar/actualizar:
        String sqlQuery = "UPDATE COURSE SET COURSE_NAME = ?, ID_STUDENT = ? WHERE ID = ?;";

        // Try-Catch para manejar los errores en el proceso de ejecución:
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setString(1, courseEntity.getCourse_Name());
            preparedStatement.setInt(2, courseEntity.getId_Student());
            preparedStatement.setInt(3, courseEntity.getId());

            boolean result = preparedStatement.execute();

            if(result) {
                return courseEntity;
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
        String sqlQuery= "DELETE FROM COURSE WHERE ID = ?;";

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
