package fr.epita.tests;

import fr.epita.biostat.datamodel.Person;
import fr.epita.biostat.services.ChartService;
import fr.epita.biostat.services.PersonService;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ChartTesting {

    public static void main(String[] args) throws IOException {
        PersonService personService = new PersonService();
        List<Person> persons = personService.readPersons();
        ChartService chartService = new ChartService(1000, 800);

        Map<String, Long> countsByGender = personService.computeGroupByCountGender(persons);
        chartService.drawBarChart(
                countsByGender,
                "Counts by Gender",
                "Gender",
                "Count",
                "Counts by Gender"
        );

        Map<Integer, Double> distAgeByHeight = personService.computeDistAgeByWeight(persons);
        chartService.drawScatterChart(
                distAgeByHeight,
                "Distribution of Age and Weight",
                "Age",
                "Height",
                "Age x Weight"
        );
    }
}