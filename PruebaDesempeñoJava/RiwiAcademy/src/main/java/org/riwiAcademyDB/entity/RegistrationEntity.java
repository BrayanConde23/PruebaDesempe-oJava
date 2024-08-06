package org.riwiAcademyDB.entity;

public class RegistrationEntity {

    // Inicializamos cada una de las variables a usar:
    private int id;
    private int course_id;
    private int id_Student;

    // Construímos un constructor vacío para inicializar variables vacías sin problemas:
    public RegistrationEntity() {

    }

    // Constructor con cada una de las variables inicializadas previamente:
    public RegistrationEntity(int id, int course_Name, int id_Student) {
        this.id = id;
        this.course_id = course_Name;
        this.id_Student = id_Student;
    }

    // Constructor necesario para el proceso de vista para el usuario en "main":
    public RegistrationEntity(int idCourse, int idStudent) {
        this.course_id = idCourse;
        this.id_Student = idStudent;
    }

    // Getters para hacer posible la obtención de las variables:
    public int getId() {
        return this.id;
    }

    public int getCourse_id() {
        return this.course_id;
    }

    public int getId_Student() {
        return this.id_Student;
    }

    // Setters para hacer posible la obtención de las variables:
    public void setId(int id) {
        this.id = id;
    }

    public void setCourse_Name(int course_id) {
        this.course_id = course_id;
    }

    public void setId_Student(int id_Student) {
        this.id_Student = id_Student;
    }

    // toString() para que el usuario pueda ver cada variable al solicitarla:
    @Override
    public String toString() {
        return "RegistrationEntity:" +
                "id: " + id + '\n' +
                "course_Name='" + course_id + '\n' +
                "id_Student=" + id_Student + '\n';
    }
}
