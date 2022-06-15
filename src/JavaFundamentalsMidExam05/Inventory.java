package JavaFundamentalsMidExam05;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> items =
                Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        String command = scanner.nextLine();
        while(!command.equals("Craft!")) {
            String[] itemsToCraft = command.split(" - ");
            String instruction = itemsToCraft[0];

            switch (instruction) {
                case "Collect":
                    String item = itemsToCraft[1];
                    if (items.contains(item)) {
                        break;
                    } else {
                        items.add(item);
                    }
                    break;
                case "Drop":
                    String itemToDrop = itemsToCraft[1];
                    items.remove(itemToDrop);
                    break;
                case "Combine Items":
                    String[] itemsToSplit = itemsToCraft[1].split(":");
                    String oldItem = itemsToSplit[0];
                    String newItem = itemsToSplit[1];
                    if (items.contains(oldItem)) {
                        items.add(items.indexOf(oldItem) + 1, newItem);
                    }
                    break;
                case "Renew":
                    String itemToMove = itemsToCraft[1];
                    if (items.contains(itemToMove)) {
                        int index = items.indexOf(itemToMove);
                        items.add(items.remove(index));
                    }
                    break;
                default:
                    break;

            }
            command = scanner.nextLine();
        }
        String output = String.join(", ", items);
        System.out.println(output);
    }
}
