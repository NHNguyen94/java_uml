package fr.epita.biostat.services;

import fr.epita.biostat.datamodel.Person;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

public class PersonService {

    private final List<String> ACCEPTED_ATTRIBUTE_TYPE = List.of(new String[]{"Height", "Weight", "Age"});
    private final List<String> ACCEPTED_COMPUTE_TYPE = List.of(new String[]{"Average", "Max", "Min"});
    private final String BIOSTAT_DS_PATH = "biostat/biostat.csv";

    public List<Person> readPersons() throws IOException {
        File file = new File(BIOSTAT_DS_PATH);
        if (!file.exists()) {
            System.out.println("file does not exist");
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
            persons.add(person);
        }
        return persons;
    }

    private void checkAttributeType(String attType) {
        if (!ACCEPTED_ATTRIBUTE_TYPE.contains(attType)) {
            throw new IllegalArgumentException("Attribute Type not supported");
        }
    }

    public OptionalDouble computeAvg(List<Person> persons, String type) {
        checkAttributeType(type);
        if (Objects.equals(type, "Height")) {
            return computeAvgHeigh(persons);
        } else if (Objects.equals(type, "Age")) {
            return computeAvgAge(persons);
        } else if (Objects.equals(type, "Weight")) {
            return computeAvgWeight(persons);
        }
        return OptionalDouble.empty();
    }

    private OptionalDouble computeAvgAge(List<Person> persons) {
        // Stream is to split all the person in persons and perform computation parallell
        return persons.stream()
                .mapToInt(Person::getAge)
                .average();
    }

    private OptionalDouble computeAvgHeigh(List<Person> persons) {
        return persons.stream()
                .mapToInt(Person::getHeight)
                .average();
    }

    private OptionalDouble computeAvgWeight(List<Person> persons) {
        return persons.stream()
                .mapToInt(Person::getWeight)
                .average();
    }

    public OptionalInt computeMax(List<Person> persons, String type) {
        checkAttributeType(type);
        if (Objects.equals(type, "Height")) {
            return computeMaxHeigh(persons);
        } else if (Objects.equals(type, "Age")) {
            return computeMaxAge(persons);
        } else if (Objects.equals(type, "Weight")) {
            return computeMaxWeight(persons);
        }
        return OptionalInt.empty();
    }

    private OptionalInt computeMaxAge(List<Person> persons) {
        return persons.stream()
                .mapToInt(Person::getAge)
                .max();
    }

    private OptionalInt computeMaxHeigh(List<Person> persons) {
        return persons.stream()
                .mapToInt(Person::getHeight)
                .max();
    }

    private OptionalInt computeMaxWeight(List<Person> persons) {
        return persons.stream()
                .mapToInt(Person::getWeight)
                .max();
    }

    public OptionalInt computeMin(List<Person> persons, String type) {
        checkAttributeType(type);
        if (Objects.equals(type, "Height")) {
            return computeMinHeigh(persons);
        } else if (Objects.equals(type, "Age")) {
            return computeMinAge(persons);
        } else if (Objects.equals(type, "Weight")) {
            return computeMinWeight(persons);
        }
        return OptionalInt.empty();
    }

    private OptionalInt computeMinAge(List<Person> persons) {
        return persons.stream()
                .mapToInt(Person::getAge)
                .min();
    }

    private OptionalInt computeMinHeigh(List<Person> persons) {
        return persons.stream()
                .mapToInt(Person::getHeight)
                .min();
    }

    private OptionalInt computeMinWeight(List<Person> persons) {
        return persons.stream()
                .mapToInt(Person::getWeight)
                .min();
    }

    public Long computeCount(List<Person> persons, String type) {
        checkAttributeType(type);
        if (Objects.equals(type, "Height")) {
            return computeCountHeight(persons);
        } else if (Objects.equals(type, "Age")) {
            return computeCountAge(persons);
        } else if (Objects.equals(type, "Weight")) {
            return computeCountWeight(persons);
        }
        return 0L;
    }

    private Long computeCountAge(List<Person> persons) {
        return persons.stream()
                .mapToInt(Person::getAge)
                .count();
    }

    private Long computeCountHeight(List<Person> persons) {
        return persons.stream()
                .mapToInt(Person::getHeight)
                .count();
    }

    private Long computeCountWeight(List<Person> persons) {
        return persons.stream()
                .mapToInt(Person::getWeight)
                .count();
    }

    public Map<Integer, List<Person>> computeGroupByHeight(List<Person> persons) {
        return persons.stream().collect(Collectors.groupingBy(Person::getHeight));
    }

    public Map<Integer, List<Person>> computeGroupByWeight(List<Person> persons) {
        return persons.stream().collect(Collectors.groupingBy(Person::getWeight));
    }

    public Map<String, List<Person>> computeGroupByGender(List<Person> persons) {
        return persons.stream().collect(Collectors.groupingBy(Person::getGender));
    }

    public Map<Integer, List<Person>> computeGroupByAge(List<Person> persons) {
        return persons.stream().collect(Collectors.groupingBy(Person::getAge));
    }

    public Map<Integer, Long> computeGroupCountByHeight(List<Person> persons) {
        return persons.stream().collect(Collectors.groupingBy(Person::getHeight, Collectors.counting()));
    }

    public Map<Integer, Long> computeGroupByCountWeight(List<Person> persons) {
        return persons.stream().collect(Collectors.groupingBy(Person::getWeight, Collectors.counting()));
    }

    public Map<String, Long> computeGroupByCountGender(List<Person> persons) {
        return persons.stream().collect(Collectors.groupingBy(Person::getGender, Collectors.counting()));
    }

    public Map<Integer, Long> computeGroupCountByAge(List<Person> persons) {
        return persons.stream().collect(Collectors.groupingBy(Person::getAge, Collectors.counting()));
    }

    public Map<Integer, Double> computeDistAgeByWeight(List<Person> persons) {
        return persons.stream()
                .collect(Collectors.groupingBy(
                        Person::getAge,
                        Collectors.collectingAndThen(
                                Collectors.averagingInt(Person::getWeight),
                                Double::valueOf
                        )
                ));
    }
}
