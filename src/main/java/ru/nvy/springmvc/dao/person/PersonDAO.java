package ru.nvy.springmvc.dao.person;

import org.springframework.stereotype.Component;
import ru.nvy.springmvc.model.person.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "1590";
    private static Connection connection;

    static {
        //проверка на допустимость использования postgresql.Driver
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        //устанавливаем соединение с БД
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    /**
     * Show all people
     * @return
     */
    public List<Person> index() {
        List<Person> people = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM Person";
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setEmail(resultSet.getString("email"));
                person.setAge(resultSet.getInt("age"));

                people.add(person);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return people;
    }




    /**
     * Show only one Person
     * @param id
     * @return
     */
    public Person show(int id){
        //лямбда выражение
        //найти человека по id если не нашли вернуть null
 //       return people.stream().filter(items->items.getId() == id).findAny().orElse(null);
        return null;
    }

    /**
     * Add new person
     * @param person
     */
    public void save(Person person){
        try {
            Statement statement = connection.createStatement();
            String SQL = "INSERT INTO Person VALUES(" + 1 + ",'" + person.getName() +
                    "'," + person.getAge() + ",'" + person.getEmail() + "')";

            statement.executeUpdate(SQL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * Update all fields (without ID)
     * @param id
     * @param updatePerson
     */
    public void update(int id, Person updatePerson){
//        Person personToBeUpdated = show(id);
//        personToBeUpdated.setName(updatePerson.getName());
//        personToBeUpdated.setAge(updatePerson.getAge());
//        personToBeUpdated.setSurname(updatePerson.getSurname());
//        personToBeUpdated.setEmail(updatePerson.getEmail());
    }

    /**
     * Delete person by ID
     * @param id
     */
    public void delete(int id){
//        people.removeIf(item->item.getId() == id);
    }

}
