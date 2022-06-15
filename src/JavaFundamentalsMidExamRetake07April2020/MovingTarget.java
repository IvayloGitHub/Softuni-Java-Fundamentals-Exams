package JavaFundamentalsMidExamRetake07April2020;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List <Integer> targets =
                Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
                        .collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] commandArray = input.split(" ");
            String command = commandArray[0];
            int index = Integer.parseInt(commandArray[1]);

            switch (command) {
                case "Shoot":
                    int power = Integer.parseInt(commandArray[2]);
                    if (index >= 0 && index < targets.size()) {
                        targets.set(index, targets.get(index) - power);
                        if(targets.get(index) <= 0) {
                            targets.remove(index);
                        }
                    }
                    break;
                case "Add":
                    int value = Integer.parseInt(commandArray[2]);
                    if (index >= 0 && index < targets.size()) {
                        targets.add(index, value);
                    } else {
                        System.out.println("Invalid placement!");
                    }
                    break;
                case "Strike":
                    int radius = Integer.parseInt(commandArray[2]);
                    if (index >= 0 && index < targets.size() && (index + radius) >= 0 && (index + radius) < targets.size()
                       && (index - radius) >= 0 && (index - radius) < targets.size()) {

                        int startIndex = index - radius;
                        int end = 2 * radius + 1;
                      while(end > 0) {
                          targets.remove(startIndex);
                          end--;
                      }
                    } else {
                        System.out.println("Strike missed!");
                    }
                    break;
                default:
                    break;
            }
            input = scanner.nextLine();
        }
        String output = targets.stream().map(String::valueOf).collect(Collectors.joining("|"));
        System.out.println(output);
    }
}
