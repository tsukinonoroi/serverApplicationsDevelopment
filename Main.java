package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static ArrayList<Student> students = new ArrayList<>();
    public static ArrayList<Car> taxopark = new ArrayList<>();
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

        Car audi1 = new Audi("Audi A8", 15,200, 120, 7000, 50, "Germany", 5000000, false).addToCarList(taxopark);
        Car audi2 = new Audi("Audi RS6", 15, 260, 130, 12000, 100, "Germany", 10000000, true).addToCarList(taxopark);
        Car bmw1 = new Bmw("BMW 530i", 12, 220, 100, 7000, 65, "Germany", 7500000, false).addToCarList(taxopark);
        Car bmw2 = new Bmw("BMW M5 530", 14, 270, 120,8000, 110, "Germany", 14000000, true).addToCarList(taxopark);
        Car mers1 = new Mercedes("Mercedes E200 2.0", 10,222,90, 6000, 60, "Germany", 4000000, false).addToCarList(taxopark);
        Car mers2 = new Mercedes("Mercedes S63 AMG", 19, 330, 90,20000, 120, "Germany", 2000000, true).addToCarList(taxopark);

        consoleApplicationTaxopark();

    }

    public static void getAllObjects() {
        students.stream()
                .forEach(System.out::println);
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


    /* lab 2*/

    public static void getAllCars() {
        taxopark.stream()
                .forEach(System.out::println);
    }

    public static void sortByFuel() {
        taxopark.stream()
                .sorted(Comparator.comparingInt(value -> value.getFuelConsumptionPer100Kilometers()))
                        .forEach(System.out::println);
        System.out.println("sorted by fuel");
    }

    public static void sumTaxopark() {
        int a = taxopark.stream()
                .mapToInt(value -> value.getCarPrice())
                .sum();

        System.out.println(a);
    }

    public static void consoleApplicationTaxopark() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Здравствуйте! Вы находитесь в таксопарке. Что Вас интересует?");
        System.out.println("1. Арендовать автомобиль" + '\n' +
                "2. Заказать такси");
        int choice = scan.nextInt();


        if (choice == 1) {
            System.out.println("Отлично! Перед вами 6 различных автомобилей.");
            rentCar();
        } else if (choice == 2) {
            System.out.println("Функция заказа такси пока недоступна."); //заглушка
            // сделано для того, чтобы консольное приложение не было огромным, как указано в пункте 6 ЛР№2
        } else {
            System.out.println("Ошибка выбора.");
        }
    }

    public static void rentCar() {
        Scanner scan = new Scanner(System.in);

        getAllCars();

        System.out.print("Введите название автомобиля, который хотите арендовать: ");
        String chosenCarName = scan.nextLine();

        Optional<Car> chosenCar = taxopark.stream()
                .filter(car -> car.getModel().equalsIgnoreCase(chosenCarName))
                .findFirst();

        if (chosenCar.isPresent()) {
            System.out.print("Введите количество дней аренды: ");
            int days = scan.nextInt();
            int pricePerDay = chosenCar.get().getCarPrice();
            int totalCost = pricePerDay * days;
            System.out.println("Стоимость аренды автомобиля " + chosenCarName + " на " + days + " дней: " + totalCost + " Руб.");
        } else {
            System.out.println("Такой автомобиль не найден.");
        }
    }


    }
