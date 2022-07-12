package ru.nvy.springmvc.model.person;

public class Person {
    //region Fields
    private int id;
    private String name;
    private int age;
    private String surname;
    private String email;
    //endregion

    public Person() { }

    public Person(int id, String name, int age, String surname, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.surname = surname;
        this.email = email;
    }

    // region Getter/Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    //endregion
}
