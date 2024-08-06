package org.riwiAcademyDB.entity;

import org.riwiAcademyDB.persistence.enums.EnumsRiwiAcademy;

public class StudentEntity {

    // Inicializamos cada una de las variables a usar:
    private int id;
    private String name;
    private String last_Name;
    private String email;
    private EnumsRiwiAcademy status;

    // Construímos un constructor vacío para inicializar variables vacías sin problemas:
    public StudentEntity() {

    }

    // Constructor con cada una de las variables inicializadas previamente:
    public StudentEntity(int id, String name, String last_Name, String email, EnumsRiwiAcademy status) {
        this.id = id;
        this.name = name;
        this.last_Name = last_Name;
        this.email = email;
        this.status = status;
    }

    // Constructor necesario para el proceso de vista para el usuario en "main":
    public StudentEntity(String nameStudent, String lastNameStudent, String emailStudent) {
        this.name = nameStudent;
        this.last_Name = lastNameStudent;
        this.email = emailStudent;
    }

    // Constructor necesario para el proceso de vista para el usuario en "main":
    public StudentEntity(String nameStudent, String lastNameStudent, String emailStudent, EnumsRiwiAcademy status) {
        this.name = nameStudent;
        this.last_Name = lastNameStudent;
        this.email = emailStudent;
        this.status = status;
    }

    // Getters para hacer posible la obtención de las variables:
    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getLast_Name() {
        return this.last_Name;
    }

    public String getEmail() {
        return this.email;
    }

    public EnumsRiwiAcademy getStatus() {
        return this.status;
    }

    // Setters para hacer posible la obtención de las variables:
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStatus(EnumsRiwiAcademy status) {
        this.status = status;
    }

    // toString() para que el usuario pueda ver cada variable al solicitarla:
    @Override
    public String toString() {
        return "StudentEntity:" +
                "id: " + id + '\n' +
                "name: " + name + '\n' +
                "last_Name: " + last_Name + '\n' +
                "email: " + email + '\n' +
                "status: " + status + '\n';
    }
}
