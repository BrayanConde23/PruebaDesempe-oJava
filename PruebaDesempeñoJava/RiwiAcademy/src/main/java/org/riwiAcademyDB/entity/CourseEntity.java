package org.riwiAcademyDB.entity;

public class CourseEntity {

    // Inicializamos cada una de las variables a usar:
    private int id;
    private String course_Name;
    private int id_Student;

    // Construímos un constructor vacío para inicializar variables vacías sin problemas:
    public CourseEntity() {

    }

    // Constructor con cada una de las variables inicializadas previamente:
    public CourseEntity(int id, String course_Name, int id_Student) {
        this.id = id;
        this.course_Name = course_Name;
        this.id_Student = id_Student;
    }

    // Constructor necesario para el proceso de vista para el usuario en "main":
    public CourseEntity(String nameCourse, int idStudent) {
        this.course_Name = nameCourse;
        this.id_Student = idStudent;
    }

    // Getters para hacer posible la obtención de las variables:
    public int getId() {
        return this.id;
    }

    public String getCourse_Name() {
        return this.course_Name;
    }

    public int getId_Student() {
        return this.id_Student;
    }

    // Setters para hacer posible la obtención de las variables:
    public void setId(int id) {
        this.id = id;
    }

    public void setCourse_Name(String course_Name) {
        this.course_Name = course_Name;
    }

    public void setId_Student(int id_Student) {
        this.id_Student = id_Student;
    }

    // toString() para que el usuario pueda ver cada variable al solicitarla:
    @Override
    public String toString() {
        return "CourseEntity:" +
                "id: " + id + '\n' +
                "course_Name: " + course_Name + '\n' +
                "id_Student: " + id_Student + '\n';
    }
}
