package JavaFundamentalsFinalExamRetake10April2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        List<String> word = new ArrayList<>();
        List<String> wordReversed = new ArrayList<>();


        String regex = "([@#])(?<firstWord>[A-Za-z]{3,})\\1\\1(?<secondWord>[A-Za-z]{3,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        int count = 0;
        while(matcher.find()) {
            count++;
            String first = matcher.group("firstWord");
            String second = matcher.group("secondWord");

            StringBuilder sb = new StringBuilder();
            sb.append(second);
            String reversed = sb.reverse().toString();
            if (first.equals(reversed)) {
                word.add(first);
                wordReversed.add(second);
            }
        }

        if (count == 0) {
            System.out.println("No word pairs found!");
        } else {
            System.out.printf("%d word pairs found!%n", count);
        }

        if (word.size() == 0) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            for (int i = 0; i < word.size(); i++) {
                System.out.printf("%s <=> %s", word.get(i), wordReversed.get(i));
                if (i != word.size() - 1) {
                    System.out.print(", ");
                }
            }
        }
    }
}
