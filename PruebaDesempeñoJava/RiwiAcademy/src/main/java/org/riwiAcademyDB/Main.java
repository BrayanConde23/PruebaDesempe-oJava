package org.riwiAcademyDB;

import org.riwiAcademyDB.controller.CourseController;
import org.riwiAcademyDB.controller.GradesController;
import org.riwiAcademyDB.controller.RegistrationController;
import org.riwiAcademyDB.controller.StudentController;
import org.riwiAcademyDB.entity.CourseEntity;
import org.riwiAcademyDB.entity.GradesEntity;
import org.riwiAcademyDB.entity.RegistrationEntity;
import org.riwiAcademyDB.entity.StudentEntity;
import org.riwiAcademyDB.persistence.enums.EnumsRiwiAcademy;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Menu principal al ejecutar el programa, con su respectiva opción para entrar a las interfaces de cada tabla en la base de datos:

        String optionInterface = "";

        do {
            optionInterface = JOptionPane.showInputDialog("""
                    Welcome to RiwiAcademyDB! | What do you want to do?
                    
                    1 - Enter to student
                    
                    2 - Enter to course
                    
                    3 - Enter to registration
                    
                    4 - Enter to grades
                    
                    5 - Exit
                    """);

            switch (optionInterface) {

                // Si la opción en este menú principal es "1" se le redirecciona al usuario a la interfaz (menú) de "student" y se le da un mensaje de bienvenida:
                case "1" -> {
                    JOptionPane.showMessageDialog(null, "Welcome to student section!");
                    studentInterface();
                }

                // Si la opción en este menú principal es "2" se le redirecciona al usuario a la interfaz (menú) de "course" y se le da un mensaje de bienvenida:
                case "2" -> {
                    JOptionPane.showMessageDialog(null, "Welcome to course section!");
                    courseInterface();
                }

                // Si la opción en este menú principal es "3" se le redirecciona al usuario a la interfaz (menú) de "registration" y se le da un mensaje de bienvenida:
                case "3" -> {
                    JOptionPane.showMessageDialog(null, "Welcome to registration section!");
                    registrationInterface();
                }

                // Si la opción en este menú principal es "4" se le redirecciona al usuario a la interfaz (menú) de "grades" y se le da un mensaje de bienvenida:
                case "4" -> {
                    JOptionPane.showMessageDialog(null, "Welcome to grades section!");
                    gradesInterface();
                }
            }

            // Si la opción del usuario es 5, para inmediatamente la ejecución del programa y se le da un mensaje de despedida:
        } while (!optionInterface.equals("5")); {
            JOptionPane.showMessageDialog(null, "Thank you for using our services!");
        }
    }

    // Interfaz (menú) para los procesos en la tabla "Student", con su respectiva lógica de negocios:
    public static void studentInterface() {

        // Instacia:
        StudentController studentController = new StudentController();
        StudentEntity student = new StudentEntity();

        String option = "";

        do {
            option = showOption();

            switch (option) {

                // Agregar un estudiante nuevo a su respectiva tabla:
                case "1" -> {
                    String name_Student = JOptionPane.showInputDialog("Enter the student name:");
                    String lastName_student = JOptionPane.showInputDialog("Enter the student last name:");
                    String email_Student = JOptionPane.showInputDialog("Enter the student email:");

                    student = new StudentEntity(name_Student, lastName_student, email_Student);
                    studentController.create(student);

                    JOptionPane.showMessageDialog(null, "Student created!");
                }

                // Mostrar los estudiantes de los cuales se tiene registro en la base de datos:
                case "2" -> {
                    JOptionPane.showMessageDialog(null, "These are the students so far:");
                    JOptionPane.showMessageDialog(null, studentController.readAll());
                }

                // Mostrar un estudiante el cual fue buscado por un "id" en específico:
                case "3" -> {
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Give me the student id:"));
                    JOptionPane.showMessageDialog(null, studentController.readById(id));
                }

                // Mostrar un estudiante el cual fue buscado por un "email" en específico:
                case "4" -> {
                    String email = JOptionPane.showInputDialog("Give me the student email:");
                    JOptionPane.showMessageDialog(null, studentController.readByEmail(email));
                }

                // Editar/Actualizar un estudiante mediante un "id" dado el cual hace referencia a ese estudiante por editar/actualizar:
                case "5" -> {
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Give me the id of the student you want to update:"));

                    String name_Student = JOptionPane.showInputDialog("Enter the student name:");
                    String lastName_student = JOptionPane.showInputDialog("Enter the student last name:");
                    String email_Student = JOptionPane.showInputDialog("Enter the student email:");
                    EnumsRiwiAcademy status = (EnumsRiwiAcademy) JOptionPane.showInputDialog(null, "Choice: Active or inactive student:" + EnumsRiwiAcademy.class + ": ", "", JOptionPane.QUESTION_MESSAGE, null, EnumsRiwiAcademy.values(), EnumsRiwiAcademy.values());

                    student = new StudentEntity(id, name_Student, lastName_student, email_Student, status);
                    studentController.update(student, id);

                    JOptionPane.showMessageDialog(null, "Student updated!");
                }

                // Ya que en el enunciado no se nos pide eliminar un estudiante de su tabla le decimos al usuario que no es posible hacer ese procedimiento:
                case "6" -> {
                    JOptionPane.showMessageDialog(null, "¡OPTION NOT AVAILABLE HERE!");
                }
            }

            // Si la opción ingresada del usuario es "7" se le devolverá al menú principal:
        } while (!option.equals("7")); {
            JOptionPane.showMessageDialog(null, "Redirecting to menu...");
        }
    }

    // Interfaz (menú) para los procesos en la tabla "Course", con su respectiva lógica de negocios:
    public static void courseInterface() {

        // Instancia:
        CourseController courseController = new CourseController();
        CourseEntity courseEntity = new CourseEntity();

        String option = "";

        do {
            option = showOption();

            switch (option) {

                // Agregar un curso nuevo a su respectiva tabla:
                case "1" -> {
                    String name_Course = JOptionPane.showInputDialog("Enter the course name:");
                    int id_student = Integer.parseInt(JOptionPane.showInputDialog("Enter the student id:"));

                    courseEntity = new CourseEntity(name_Course, id_student);
                    courseController.create(courseEntity);

                    JOptionPane.showMessageDialog(null, "Course created!");
                }

                // Mostrar los cursos de los cuales se tiene registro en la base de datos:
                case "2" -> {
                    JOptionPane.showMessageDialog(null, "These are the courses so far:");
                    JOptionPane.showMessageDialog(null, courseController.readAll());
                }

                // Ya que en el enunciado no se nos pide buscar por atributos en específico un curso de su tabla le decimos al usuario que no es posible hacer ese procedimiento:
                case "3", "4" -> {
                    JOptionPane.showMessageDialog(null, "¡OPTION NOT AVAILABLE HERE!");
                }

                // Editar/Actualizar un curso mediante un "id" dado el cual hace referencia a ese curso por editar/actualizar:
                case "5" -> {
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Give me the id of the course you want to update:"));

                    String name_Course = JOptionPane.showInputDialog("Enter the course name:");
                    int id_student = Integer.parseInt(JOptionPane.showInputDialog("Enter the student id:"));

                    courseEntity = new CourseEntity(id, name_Course, id_student);
                    courseController.update(courseEntity, id);

                    JOptionPane.showMessageDialog(null, "Course updated!");
                }

                // Eliminar un curso mediante un "id" en específico dado por el usuario:
                case "6" -> {
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Give me the id course you want to delete:"));
                    courseController.delete(id);

                    JOptionPane.showMessageDialog(null,"Course deleted!");
                }
            }

            // Si la opción ingresada del usuario es "7" se le devolverá al menú principal:
        } while (!option.equals("7")); {
            JOptionPane.showMessageDialog(null, "Redirecting to menu...");
        }
    }

    // Interfaz (menú) para los procesos en la tabla "Registration", con su respectiva lógica de negocios:
    public static void registrationInterface() {

        // Instancia:
        RegistrationController registrationController = new RegistrationController();
        RegistrationEntity registration = new RegistrationEntity();

        String option = "";

        do {
            option = showOption();

            switch (option) {

                // Agregar un registro nuevo a su respectiva tabla:
                case "1" -> {
                    int id_course = Integer.parseInt(JOptionPane.showInputDialog("Enter the course id:"));
                    int id_student = Integer.parseInt(JOptionPane.showInputDialog("Enter the student id:"));

                    registration = new RegistrationEntity(id_course, id_student);
                    registrationController.create(registration);

                    JOptionPane.showMessageDialog(null, "Registration created!");
                }

                // Mostrar los registros de los cuales se tiene registro en la base de datos:
                case "2" -> {
                    JOptionPane.showMessageDialog(null, "These are the registrations so far:");
                    JOptionPane.showMessageDialog(null, registrationController.readAll());
                }

                // Ya que en el enunciado no se nos pide buscar por atributos en específico un registro de su tabla le decimos al usuario que no es posible hacer ese procedimiento:
                case "3", "4" -> {
                    JOptionPane.showMessageDialog(null, "¡OPTION NOT AVAILABLE HERE!");
                }

                // Editar/Actualizar un registro mediante un "id" dado el cual hace referencia a ese registro por editar/actualizar:
                case "5" -> {
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Give me the id of the registration you want to update:"));

                    int id_course = Integer.parseInt(JOptionPane.showInputDialog("Enter the course id:"));
                    int id_student = Integer.parseInt(JOptionPane.showInputDialog("Enter the student id:"));

                    registration = new RegistrationEntity(id, id_course, id_student);
                    registrationController.update(registration, id);

                    JOptionPane.showMessageDialog(null, "Registration created!");
                }

                // Eliminar un registro mediante un "id" en específico dado por el usuario:
                case "6" -> {
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Give me the id registration you want to delete:"));
                    registrationController.delete(id);

                    JOptionPane.showMessageDialog(null,"Registration deleted!");
                }
            }

            // Si la opción ingresada del usuario es "7" se le devolverá al menú principal:
        } while (!option.equals("7")); {
            JOptionPane.showMessageDialog(null, "Redirecting to menu...");
        }
    }

    // Interfaz (menú) para los procesos en la tabla "Grades", con su respectiva lógica de negocios:
    public static void gradesInterface() {

        // Instancia:
        GradesController gradesController = new GradesController();
        GradesEntity grades = new GradesEntity();

        String option = "";

        do {
            option = showOption();

            switch (option) {

                // Agregar una calificación nueva a su respectiva tabla:
                case "1" -> {
                    int grade_Course = Integer.parseInt(JOptionPane.showInputDialog("Enter the course grade (0-100):"));
                    if (grade_Course > -1) {
                        if(grade_Course <101) {
                            continue;
                        } else {
                            JOptionPane.showMessageDialog(null,"Incorrect rating, out of range! Try again");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null,"Incorrect rating, out of range! Try again");
                    }

                    String description_grade = JOptionPane.showInputDialog("Enter the grade description:");
                    int id_course = Integer.parseInt(JOptionPane.showInputDialog("Enter the course id:"));

                    grades = new GradesEntity(grade_Course, description_grade, id_course);
                    gradesController.create(grades);

                    JOptionPane.showMessageDialog(null, "Grade created!");
                }

                // Mostrar las calificaciones de las cuales se tiene registro en la base de datos:
                case "2" -> {
                    JOptionPane.showMessageDialog(null, "These are the grades so far:");
                    JOptionPane.showMessageDialog(null, gradesController.readAll());
                }

                // Ya que en el enunciado no se nos pide buscar ni eliminar por atributos en específico una  calificación de su tabla le decimos al usuario que no es posible hacer ese procedimiento:
                case "3", "4", "6" -> {
                    JOptionPane.showMessageDialog(null, "¡OPTION NOT AVAILABLE HERE!");
                }

                // Editar/Actualizar una calificación mediante un "id" dado el cual hace referencia a esa calificación por editar/actualizar:
                case "5" -> {
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Give me the id of the grade you want to update:"));

                    int grade_Course = Integer.parseInt(JOptionPane.showInputDialog("Enter the course grade (0-100):"));
                    String description_grade = JOptionPane.showInputDialog("Enter the grade description:");
                    int id_course = Integer.parseInt(JOptionPane.showInputDialog("Enter the course id:"));

                    grades = new GradesEntity(id, grade_Course, description_grade, id_course);
                    gradesController.update(grades, id);

                    JOptionPane.showMessageDialog(null, "Grade updated!");
                }

            }

            // Si la opción ingresada del usuario es "7" se le devolverá al menú principal:
        } while (!option.equals("7")); {
            JOptionPane.showMessageDialog(null, "Redirecting to menu...");
        }
    }

    // Función fija para mostrar la interfaz (menú) en cada una de las funciones anteriores donde vemos los procesos disponibles para cada tabla en la base de datos:
    public static String showOption(){
        String option = "";
        option = JOptionPane.showInputDialog("""
                1 - Create
                
                2 - Show all
                
                3 - Show by id
                
                4 - Show by email
                
                5 - Update
                
                6 - Delete
                
                7- Back
                """);
        return option;
    }
}
