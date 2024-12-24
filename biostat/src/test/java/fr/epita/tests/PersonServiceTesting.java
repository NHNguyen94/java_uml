package fr.epita.tests;

import fr.epita.biostat.datamodel.Person;
import fr.epita.biostat.services.PersonService;

import java.io.IOException;
import java.util.*;

public class PersonServiceTesting {
    public static void main(String[] args) throws IOException {
        PersonService personService = new PersonService();
        List<Person> persons = personService.readPersons();
        System.out.println("total people: " + persons.size());

        OptionalDouble avgAge = personService.computeAvg(persons, "Age");
        if (avgAge.isPresent()) {
            System.out.println("avg Age: " + avgAge.getAsDouble());
        }

        OptionalInt maxHeight = personService.computeMax(persons, "Height");
        if (maxHeight.isPresent()) {
            System.out.println("max Height: " + maxHeight.getAsInt());
        }

        OptionalInt minWeight = personService.computeMin(persons, "Weight");
        if (minWeight.isPresent()) {
            System.out.println("min Weight: " + minWeight.getAsInt());
        }

        Map<Integer, List<Person>> personsByAge = personService.computeGroupByAge(persons);
        System.out.println("personsByAge: " + personsByAge);

        Map<String, List<Person>> personsByGender = personService.computeGroupByGender(persons);
        System.out.println("personByGender: " + personsByGender);

        Map<String, Long> countsByGender = personService.computeGroupByCountGender(persons);
        System.out.println("counts by Gender: " + countsByGender);
    }
}
