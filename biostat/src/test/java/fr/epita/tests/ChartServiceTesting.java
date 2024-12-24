package fr.epita.tests;

import fr.epita.biostat.datamodel.Person;
import fr.epita.biostat.services.ChartService;
import fr.epita.biostat.services.PersonService;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ChartServiceTesting {

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

        Map<Integer, Double> mapAgeByHeight = personService.computeMapAgeByWeight(persons);
        chartService.drawScatterChart(
                mapAgeByHeight,
                "Relationship of Age and Weight",
                "Age",
                "Weight",
                "Age x Weight"
        );

        Map<Integer, Double> mapHeightByWeight = personService.computeMapHeightByWeight(persons);
        chartService.drawScatterChart(
                mapHeightByWeight,
                "Relationship of Height and Weight",
                "Height",
                "Weight",
                "Height x Weight"
        );

        Map<String, Long> countsByAgeGroup = personService.computeGroupByCountAgeGroup(persons);
        chartService.drawPieChart(countsByAgeGroup, "Counts by Age groups");
    }
}