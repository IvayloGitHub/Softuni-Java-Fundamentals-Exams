package JavaFundamentalsMidExam05July2020;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> elements =
                Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
                        .collect(Collectors.toList());

        String input = scanner.nextLine();
        while(!input.equals("end")) {
            String[] commandArray = input.split(" ");
            String command = commandArray[0];
            switch (command) {
                case "swap":
                    int firstIndex = Integer.parseInt(commandArray[1]);
                    int secondIndex = Integer.parseInt(commandArray[2]);

                    int firstValue = elements.get(secondIndex);
                    int secondValue = elements.get(firstIndex);

                    elements.set(firstIndex, firstValue);
                    elements.set(secondIndex, secondValue);
                    break;
                case "multiply":
                    int first = Integer.parseInt(commandArray[1]);
                    int second = Integer.parseInt(commandArray[2]);

                    int value = elements.get(first) * elements.get(second);
                    elements.set(first, value);

                    break;
                case "decrease":
                    for (int i = 0; i < elements.size(); i++) {
                        elements.set(i, elements.get(i) - 1);
                    }
                    break;
                default:
                    break;
            }
            input = scanner.nextLine();
        }
        String output = elements.stream().map(String::valueOf).collect(Collectors.joining(", "));
        System.out.println(output);
    }
}
