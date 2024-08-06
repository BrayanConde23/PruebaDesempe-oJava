package org.riwiAcademyDB.entity;

public class GradesEntity {

    // Inicializamos cada una de las variables a usar:
    private int id;
    private int grade;
    private String description;
    private int id_Course;

    // Construímos un constructor vacío para inicializar variables vacías sin problemas:
    public GradesEntity() {

    }

    // Constructor con cada una de las variables inicializadas previamente:
    public GradesEntity(int id, int grade, String description, int id_Course) {
        this.id = id;
        this.grade = grade;
        this.description = description;
        this.id_Course = id_Course;
    }

    // Constructor necesario para el proceso de vista para el usuario en "main":
    public GradesEntity(int gradeCourse, String descriptionGrade, int idCourse) {
        this.grade = gradeCourse;
        this.description = descriptionGrade;
        this.id_Course = idCourse;
    }

    // Getters para hacer posible la obtención de las variables:
    public int getId() {
        return this.id;
    }

    public int getGrade() {
        return this.grade;
    }

    public String getDescription() {
        return this.description;
    }

    public int getId_Course() {
        return this.id_Course;
    }

    // Setters para hacer posible la obtención de las variables:
    public void setId(int id) {
        this.id = id;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId_Course(int id_Course) {
        this.id_Course = id_Course;
    }

    // toString() para que el usuario pueda ver cada variable al solicitarla:
    @Override
    public String toString() {
        return "GradesEntity:" +
                "id: " + id + '\n' +
                "grade=" + grade + '\n' +
                "description='" + description + '\n' +
                "id_Course=" + id_Course + '\n';
    }
}
