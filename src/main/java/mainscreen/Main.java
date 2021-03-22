package mainscreen;

import entities.Item;
import statistics.Statistics;
import utils.FileReader;
import utils.HousesStatistics;
import utils.StreetSet;

import java.io.File;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;

abstract public class Main {

    public static void showResult(String fileName) {
        FileReader fileReader = new FileReader(fileName);
        File file = fileReader.read();
        StreetSet streetSet = new StreetSet(file);
        Set<Item> itemSet = streetSet.getData();
        Statistics streetStatistics = new HousesStatistics(itemSet);
        Map<String, Map<Integer, Integer>> streets = streetStatistics.getStatistics();

        streetSet.getRepeatingItems().forEach((item, integer) ->
                System.out.println("Item " + item + "Repeating " + integer));
        streets.forEach((s, integerIntegerMap) ->
                System.out.println("City: " + s + " Houses: " + integerIntegerMap));
    }

    public static String getFileNameFromScanner() {
        Scanner scanner = new Scanner(System.in);
        return lineHandler(scanner);
    }

    private static String lineHandler(Scanner scanner) {
        try {
            System.out.println("Enter the path to the file");
            return scanner.nextLine();
        } catch (NoSuchElementException | IllegalArgumentException exception) {
            System.out.println(exception.getLocalizedMessage());
            return exception.getLocalizedMessage();
        }
    }
}
