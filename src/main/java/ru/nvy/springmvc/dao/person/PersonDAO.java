package ru.nvy.springmvc.dao.person;

import org.springframework.stereotype.Component;
import ru.nvy.springmvc.model.person.Person;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private static int PEOPLE_COUNT;
    private List<Person> people;
    {
        //блок инициализации
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Tom", 35, "Ard", "test@email.com"));
        people.add(new Person(++PEOPLE_COUNT, "Mark", 51, "Wahlberg", "test1@email.com"));
        people.add(new Person(++PEOPLE_COUNT, "Nick", 20, "Yazykov", "test2@email.com"));
        people.add(new Person(++PEOPLE_COUNT, "Leon", 21, "Kennedy", "test3@email.com"));
    }
    public List<Person> index(){
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
        return people.stream().filter(items->items.getId() == id).findAny().orElse(null);
    }

    /**
     * Add new person
     * @param item
     */
    public void save(Person item){
        item.setId(++PEOPLE_COUNT); // устанавливаем Id, ибо человек не должен сам вводить id
        people.add(item);
    }

    /**
     * Update all fields (without ID)
     * @param id
     * @param updatePerson
     */
    public void update(int id, Person updatePerson){
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatePerson.getName());
        personToBeUpdated.setAge(updatePerson.getAge());
        personToBeUpdated.setSurname(updatePerson.getSurname());
        personToBeUpdated.setEmail(updatePerson.getEmail());
    }

    /**
     * Delete person by ID
     * @param id
     */
    public void delete(int id){
        people.removeIf(item->item.getId() == id);
    }

}
