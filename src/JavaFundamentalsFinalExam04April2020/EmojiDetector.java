package JavaFundamentalsFinalExam04April2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String numberRegex = "\\d";

        String text = scanner.nextLine();

        String regex = "(?<name>([:]{2}|[*]{2})([A-Z][a-z]{2,})\\2)";

        List<String> validEmojis = new ArrayList<>();

        Pattern pattern = Pattern.compile(numberRegex);
        Matcher matcher = pattern.matcher(text);

        Pattern pattern2 = Pattern.compile(regex);
        Matcher matcher2 = pattern2.matcher(text);

        long countThreshold = 1;

        while(matcher.find()) {
            int digit = Integer.parseInt(matcher.group(0));
            countThreshold *= digit;
        }

        int countOfEmojis = 0;
        while(matcher2.find()) {
            countOfEmojis++;
            String name = matcher2.group("name");
            int coolness = 0;
            for (int i = 2; i < name.length() - 2; i++) {
                coolness += name.charAt(i);
            }

            if (coolness > countThreshold) {
                validEmojis.add(name);
            }
        }
        System.out.printf("Cool threshold: %d%n", countThreshold);
        System.out.printf("%d emojis found in the text. The cool ones are:%n", countOfEmojis);
        for (String validEmoji : validEmojis) {
            System.out.println(validEmoji);
        }
    }
}
