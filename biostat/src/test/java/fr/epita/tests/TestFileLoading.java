package fr.epita.tests;

import fr.epita.biostat.datamodel.Person;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

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
        OptionalDouble avg = persons.stream()
//                .mapToInt(p -> p.getAge())
                .mapToInt(Person::getAge)
                .average();
        if (avg.isPresent()) {
            System.out.println("avg Age: " + avg.getAsDouble());
        }
    }
}
