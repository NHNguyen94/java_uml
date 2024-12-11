package fr.epita.tests;

import fr.epita.biostat.datamodel.Person;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

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
            person.setName(parts[0].trim());
            person.setGender(parts[1].trim());
            person.setAge(Integer.parseInt(parts[2].trim()));
            person.setHeight(Integer.parseInt(parts[3].trim()));
            person.setWeight(Integer.parseInt(parts[4].trim()));
//            System.out.println("person: " + person);
            persons.add(person);
        }
        System.out.println(persons.size());
    }
}
