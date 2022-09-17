package ru.balovin.spring.domain;

public class Student {
    private final String surname;
    private final String name;

    public Student(String surname, String name) {
        this.surname = surname;
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }
    public String getName() {
        return name;
    }
}
