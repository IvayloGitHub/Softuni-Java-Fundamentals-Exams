package JavaFundamentalsFinalExamRetake15August2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String regex = "([|#])(?<itemName>[A-Za-z ]+)\\1(?<date>(\\d{2}/\\d{2}/\\d{2}))\\1(?<calories>\\d{1,5})\\1";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        List<String> items = new ArrayList<>();
        List<String> dates = new ArrayList<>();
        List<Integer> calories = new ArrayList<>();

        int totalCalories = 0;

        while(matcher.find()) {
            String itemName = matcher.group("itemName");
            String date = matcher.group("date");
            int currentCalories = Integer.parseInt(matcher.group("calories"));

            items.add(itemName);
            dates.add(date);
            calories.add(currentCalories);
            totalCalories += currentCalories;
        }

        System.out.printf("You have food to last you for: %d days!%n", totalCalories / 2000);
        for (int i = 0; i < items.size(); i++) {
            System.out.printf("Item: %s, Best before: %s, Nutrition: %d%n",
                    items.get(i), dates.get(i), calories.get(i));
        }
    }
}
