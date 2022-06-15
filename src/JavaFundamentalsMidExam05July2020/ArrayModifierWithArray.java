package JavaFundamentalsMidExam05July2020;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ArrayModifierWithArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split(" ");
        int[] elements = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            elements[i] = Integer.parseInt(array[i]);
        }

        String input = scanner.nextLine();
        while(!input.equals("end")) {
            String[] commandArray = input.split(" ");
            String command = commandArray[0];
            switch (command) {
                case "swap":
                    int firstIndex = Integer.parseInt(commandArray[1]);
                    int secondIndex = Integer.parseInt(commandArray[2]);

                    int firstValue = elements[firstIndex];
                    int secondValue = elements[secondIndex];

                    elements[firstIndex] = secondValue;
                    elements[secondIndex] = firstValue;

                    break;
                case "multiply":
                    int first = Integer.parseInt(commandArray[1]);
                    int second = Integer.parseInt(commandArray[2]);

                    int value = elements[first] * elements[second];
                    elements[first] = value;

                    break;
                case "decrease":
                    for (int i = 0; i < elements.length; i++) {
                        elements[i] = elements[i] - 1;
                    }
                    break;
                default:
                    break;
            }
            input = scanner.nextLine();
        }
        String output = Arrays.stream(elements).mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(output);
    }
}
