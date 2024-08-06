package org.riwiAcademyDB.persistence.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {
    static Connection connection = null;

    // Función para abrir la conexión con la base de datos:
    public static Connection openConnection(){

        // Pasamos cada uno de los datos necesarios para el enlazamiento con la base de datos:
        String URL = "jdbc:mysql://localhost:3306/RiwiAcademyDB";
        String user = "root";
        String password = "Rlwl2023.";

        // Try-Catch para manejar los errores posibles a la hora de conectar con base de datos:
        try{
            connection = DriverManager.getConnection(URL,user,password);
            System.out.println("Connection successful!");
        }catch (SQLException error){
            throw new RuntimeException("Driver failed! " + error.getMessage());
        }
        return connection;
    }

    // Función para cerrar la conexión con la base de datos:
    public static void closeConnection(){
        if(connection != null){

            // Try-Catch para manejar los errores posibles a la hora de desconectar con base de datos:
            try {
                connection.close();
                System.out.println("Connection closed!");
            }catch (SQLException error){
                if (error.getErrorCode() == 1062) {
                    System.out.println("Error: The document already exists!");
                } else {
                    error.printStackTrace();
                }
                throw new RuntimeException("Connection is not close! " + error.getMessage());
            }
        }
    }
}
