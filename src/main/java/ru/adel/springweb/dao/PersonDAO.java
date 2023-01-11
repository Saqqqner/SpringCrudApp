package ru.adel.springweb.dao;

import org.springframework.stereotype.Component;
import ru.adel.springweb.models.Person;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;
    {
        people= new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT,"Tom"));
        people.add(new Person(++PEOPLE_COUNT,"Camel"));
        people.add(new Person(++PEOPLE_COUNT,"Fikus"));
        people.add(new Person(++PEOPLE_COUNT,"James"));
    }
    public List<Person> index(){
        return people;
    }
    public Person show (int id){
        return people.stream().filter(person->person.getId()==id).findAny().orElse(null);
    }

}
