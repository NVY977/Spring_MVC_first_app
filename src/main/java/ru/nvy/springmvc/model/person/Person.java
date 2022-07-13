package ru.nvy.springmvc.model.person;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Person {
    //region Fields
    private int id;
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 20, message = "Name should not be between 2 and 20 characters")
    private String name;
    @Min(value = 10, message = "Age should be greater than 10")
    private int age;

    @NotEmpty(message = "Surname should not be empty")
    @Size(min = 2, max = 20, message = "Surname should not be between 2 and 20 characters")
    private String surname;
    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email should be valid")
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
