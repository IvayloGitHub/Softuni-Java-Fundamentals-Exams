package JavaFundamentalsMidExamRetake12August2020;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> elements =
                Arrays.stream(scanner.nextLine().split(" "))
                        .collect(Collectors.toList());
        int moves = 0;

        String command = scanner.nextLine();
        while(!command.equals("end")) {
            String[] indexes = command.split(" ");
            int firstIndex = Integer.parseInt(indexes[0]);
            int secondIndex = Integer.parseInt(indexes[1]);

            moves++;
            if (firstIndex < 0 || firstIndex >= elements.size() || secondIndex < 0 || secondIndex >= elements.size()
            || firstIndex == secondIndex) {
                int index = elements.size() / 2;
                String element = "-" + moves + "a";
                elements.add(index, element);
                elements.add(index, element);
                command = scanner.nextLine();
                System.out.println("Invalid input! Adding additional elements to the board");
                continue;
            }
            String firstElement = elements.get(firstIndex);
            String secondElement = elements.get(secondIndex);
            if(firstElement.equals(secondElement)) {
                System.out.printf("Congrats! You have found matching elements - %s!%n", firstElement);
                elements.remove(firstElement);
                elements.remove(secondElement);
                if (elements.size() == 0) {
                    break;
                }
            } else {
                System.out.println("Try again!");
            }

            command = scanner.nextLine();
        }
        if (command.equals("end")) {
            System.out.printf("Sorry you lose :(%n");
            System.out.println(String.join(" ", elements));
        } else {
            System.out.printf("You have won in %d turns!%n", moves);
        }
    }
}
