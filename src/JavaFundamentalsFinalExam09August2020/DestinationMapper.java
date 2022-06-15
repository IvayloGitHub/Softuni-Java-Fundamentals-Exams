package JavaFundamentalsFinalExam09August2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        List<String> destinations = new ArrayList<>();

        String regex = "([=/])(?<destination>[A-Z][A-Za-z]{2,})\\1";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        int travelPoints = 0;
        while(matcher.find()) {
            String destination = matcher.group("destination");
            travelPoints += destination.length();
            destinations.add(destination);
        }

        System.out.printf("Destinations: %s%n", String.join(", ", destinations));
        System.out.printf("Travel Points: %d", travelPoints);
    }
}
