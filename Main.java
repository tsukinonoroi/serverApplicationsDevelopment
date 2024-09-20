package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Student student = new Student(1, "Seytumerov", "Edem", "Rustemovich", 05, 04, 2005,
                "1st Hormy Army 3", "+79781668832", "FEMaIT", 3, "I-1-21").addToList(students);

        Student student1 = new Student(2, "Ivanov", "Ivan", "Ivanovich", 07, 06, 2004,
                "1st Hormy Army 3", "+79781668832", "FEMaIT", 4, "I-1-21").addToList(students);

        Student student2 = new Student(3, "Sergeenko", "Vladislav", "Vladimirovich", 05, 04, 2004,
                "1st Hormy Army 3", "+79781668832", "FEMaIT", 4, "I-1-21").addToList(students);

        Student student3 = new Student(4, "Alexeev", "Ivan", "Alexndravich", 05, 04, 2005,
                "1st Hormy Army 3", "+79781668832", "FEMaIT", 2, "I-1-23").addToList(students);

        Student student4 = new Student(5, "Rudov", "Ilya", "Sergeevich", 05, 04, 2006,
                "1st Hormy Army 3", "+79781668832", "FEMaIT", 4, "I-1-21").addToList(students);

        Student student5 = new Student(6, "FEMaIT", 3, "I-2-22").addToList(students);


    }

    public static void getAllObjects() {
        students.stream()
                .forEach(student -> System.out.println(student));
    }

    public static void getListStudentsOfGroup(String groupp) {
        System.out.println("Students from groupp " + groupp + " :");
        students.stream()
                .filter(student -> student.getGroupp().equals(groupp))
                .forEach(student -> System.out.println(student + "\n"));
    }
    public static void getStudentFromFaculty(String faculty) {
        System.out.println("---------------Students from Faculty " + faculty + "-------------------------");
        students.stream()
                .filter(student -> student.getFaculty().equals(faculty))
                .forEach(student -> System.out.println(student + "\n"));
    }

    public static void getStudentFromBirthDate() {
        students.stream()
                .filter(student -> student.getYearOfBirth() == 2005)
                .forEach(student -> System.out.println(student + "\n"));

    }

    public static void getStudentsFromFacultyCourse() {
        HashSet<String> setFaculty = students.stream()
                .map(Student::getFaculty)
                .collect(Collectors.toCollection(HashSet::new));
        HashSet<Integer> setCourse = students.stream()
                .map(Student::getCourse)
                .collect(Collectors.toCollection(HashSet::new));

        setFaculty.stream()
                .forEach(faculty -> {
                    System.out.println("Students from facluty " + faculty);
                    setCourse.forEach(course -> {
                        System.out.println("Students from course " + course);

                    students.stream()
                            .filter(student -> student.getFaculty().equals(faculty) && student.getCourse() == course)
                            .forEach(student -> System.out.println(" " + student));
                        });
            });
    }
}