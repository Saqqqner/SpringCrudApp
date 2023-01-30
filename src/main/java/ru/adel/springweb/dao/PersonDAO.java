package ru.adel.springweb.dao;

import org.springframework.stereotype.Component;
import ru.adel.springweb.models.Person;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private final List<Person> people;
    {
        people= new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT,"Tom","Ticket" , 34 ,"Adels@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT,"Camel","Ticket" , 4 ,"Adels@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT,"Fikus","Ticket" , 5 ,"Adels@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT,"James","Ticket" , 12 ,"Adels@mail.ru"));
    }
    public List<Person> index(){
        return people;
    }
    public Person show (int id){
        return people.stream().filter(person->person.getId()==id).findAny().orElse(null);
    }

    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }
    public void update (int id ,Person updatedPerson){
        Person personToBeUpdated = show(id);

        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setSurname(updatedPerson.getSurname());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());

    }
    public void delete(int id){
        people.removeIf(person -> person.getId()==id);

    }

}
