package JavaFundamentalsMidExam29February2020;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> groceries =
                Arrays.stream(scanner.nextLine().split("!")).collect(Collectors.toList());

        String command = scanner.nextLine();

        while(!command.equals("Go Shopping!")) {
            String[] itemsArray = command.split(" ");
            String instruction = itemsArray[0];
            String item = itemsArray[1];

            switch (instruction) {
                case "Urgent":
                    if (!groceries.contains(item)) {
                        groceries.add(0, item);
                    }
                    break;
                case "Unnecessary":
                    groceries.remove(item);
                    break;
                case "Correct":
                    String newItem = itemsArray[2];
                    if(groceries.contains(item)) {
                        groceries.add(groceries.indexOf(item), newItem);
                        groceries.remove(item);
                    }
                    break;
                case "Rearrange":
                    if (groceries.contains(item)) {
                        int index = groceries.indexOf(item);
                        groceries.add(groceries.remove(index));
                    }
                    break;
                default:
                    break;

            }
            command = scanner.nextLine();
        }
        String output = "";
        output = String.join(", ", groceries);
        System.out.println(output);
    }
}
