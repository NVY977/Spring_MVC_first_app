package ru.nvy.springmvc.dao.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.nvy.springmvc.model.person.Person;

import java.sql.*;
import java.util.List;

@Component
public class PersonDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate; //помещаем объект созданный в SpringConfig в DAO с помощью Spring
    }

    /**
     * Show all people
     *
     * @return people
     */
    public List<Person> index() {
        // new BeanPropertyRowMapper это упрощенное создание конкретного Mapper,
        // то есть просто перевод строк в наши сущности
        // пример того, что он делает: PersonMapper
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }

    /**
     * Show only one Person
     *
     * @param id
     * @return person
     */
    public Person show(int id) {
        // все запросы в JdbcTemplate безопасны и реализуются при помощи PreparedStatement
        // findAny возвращает Optional, а Optional в свою очередь инкапсулирует
        // то что может существовать или не может существовать
        return jdbcTemplate.query("SELECT * FROM Person WHERE id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(null);
    }

    /**
     * Add new person
     *
     * @param person
     */
    public void save(Person person) {
        // передача параметров с помощью varargs
        jdbcTemplate.update("INSERT INTO Person VALUES (1, ?, ?, ?, ?)", person.getName(), person.getAge(),
                person.getSurname(), person.getEmail());
    }

    /**
     * Update all fields (without ID)
     *
     * @param id
     * @param updatePerson
     */
    public void update(int id, Person updatePerson) {
        jdbcTemplate.update("UPDATE Person SET name=?, age=?, surname=?, email=? WHERE id=?", updatePerson.getName(),
                updatePerson.getAge(), updatePerson.getSurname(), updatePerson.getEmail(), id);
    }

    /**
     * Delete person by ID
     *
     * @param id
     */
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Person WHERE id=?", id);
    }
}