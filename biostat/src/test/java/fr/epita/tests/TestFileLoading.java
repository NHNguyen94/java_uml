package fr.epita.tests;

import fr.epita.biostat.datamodel.Person;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

public class TestFileLoading {
    public static void main(String[] args) throws IOException {
        File file = new File("biostat/biostat.csv");
        if (!file.exists()) {
            System.out.println("file does not exist");
            return;
        }
        System.out.println("File exists, proceeding now");
        List<String> lines = Files.readAllLines(file.toPath());
        lines.remove(0);
        List<Person> persons = new ArrayList<>();
        System.out.println(lines);
        for (String line : lines) {
            Person person = new Person();
            String[] parts = line.split(",");
//            System.out.println(Arrays.deepToString(parts));
            person.setName(parts[0].trim());
            person.setGender(parts[1].trim());
            person.setAge(Integer.parseInt(parts[2].trim()));
            person.setHeight(Integer.parseInt(parts[3].trim()));
            person.setWeight(Integer.parseInt(parts[4].trim()));
//            System.out.println("person: " + person);
            persons.add(person);
        }
        System.out.println(persons.size());
        // Single computation
        double average = 0;
        for(Person person : persons) {
            average = average + person.getAge();
        }
        average = average / persons.size();
        System.out.println("avg age: " + average);

        // Stream is to split all the person in persons and perform computation parallell
        OptionalDouble avgAge = persons.stream()
//                .mapToInt(p -> p.getAge())
                .mapToInt(Person::getAge)
                .average();
        if (avgAge.isPresent()) {
            System.out.println("avg Age: " + avgAge.getAsDouble());
        }

        OptionalInt maxHeight = persons.stream()
//                .mapToInt(p -> p.getAge())
                .mapToInt(Person::getAge)
                .max();

        if (maxHeight.isPresent()) {
            System.out.println("max Height: " + maxHeight.getAsInt());
        }

        OptionalInt minWeight = persons.stream().mapToInt(p -> p.getWeight()).min();

        if (minWeight.isPresent()) {
            System.out.println("min Weight: " + minWeight.getAsInt());
        }

        Map<Integer, List<Person>> personsByAge = persons
                .stream()
                .collect(Collectors.groupingBy(p -> p.getAge()));

        System.out.println("personsByAge: " + personsByAge);

        Map<String, List<Person>> personsByGender = persons
                .stream()
                .collect(Collectors.groupingBy(p -> p.getGender()));

        System.out.println("personByGender: " + personsByGender);

        Map<String, Long> countsByGender = persons
                .stream()
                .collect(Collectors.groupingBy(Person::getGender, Collectors.counting()));

        System.out.println("counts by Gender: " + countsByGender);
    }
}
