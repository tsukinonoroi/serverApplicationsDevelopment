package org.example;

import java.util.ArrayList;
import java.util.Objects;

public class Student {
    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;
    private String adres;
    private String phoneNumber;
    private String faculty;
    private int course;
    private String groupp;


    public Student addToList(ArrayList<Student> studentsList) {
        studentsList.add(this);
        return this;
    }

    @Override
    public String toString() {
        return "Студент #" + id + ":\n" +
                "-----------------------------------\n" +
                "Фамилия       : " + surname + "\n" +
                "Имя           : " + name + "\n" +
                "Отчество      : " + patronymic + "\n" +
                "Дата рождения : " + dayOfBirth + " " + monthOfBirth + " " + yearOfBirth + "\n" +
                "Адрес         : " + adres + "\n" +
                "Телефон       : " + phoneNumber + "\n" +
                "Факультет     : " + faculty + "\n" +
                "Курс          : " + course + "\n" +
                "Группа        : " + groupp + "\n" +
                "-----------------------------------";
    }

    public Student(int id, String surname, String name, String patronymic, int dayOfBirth,
                   int monthOfBirth, int yearOfBirth, String adres, String phoneNumber, String faculty,
                   int course, String groupp) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.adres = adres;
        this.phoneNumber = phoneNumber;
        this.faculty = faculty;
        this.course = course;
        this.groupp = groupp;
    }

    public Student(int id, String surname, String name, String patronymic) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
    }

    public Student(int id, String faculty, int course, String groupp) {
        this.id = id;
        this.faculty = faculty;
        this.course = course;
        this.groupp = groupp;
    }

    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setDayOfBirth(int dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public void setMonthOfBirth(int monthOfBirth) {
        this.monthOfBirth = monthOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public int getDayOfBirth() {
        return dayOfBirth;
    }

    public int getMonthOfBirth() {
        return monthOfBirth;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public String getAdres() {
        return adres;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getFaculty() {
        return faculty;
    }

    public int getCourse() {
        return course;
    }

    public String getGroupp() {
        return groupp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }


    public void setAdres(String adres) {
        this.adres = adres;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public void setGroupp(String groupp) {
        this.groupp = groupp;
    }
}

