package JavaFundamentalsFinalExam04April2020;

import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String key = text;

        String command = scanner.nextLine();
        while(!command.equals("Generate")) {
            String[] input = command.split(">>>");
            String order = input[0];
            switch (order) {
                case "Contains":
                    String substring = input[1];
                    if(key.contains(substring)) {
                        System.out.printf("%s contains %s%n", key, substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String type = input[1];
                    int startIndex = Integer.parseInt(input[2]);
                    int endIndex = Integer.parseInt(input[3]);
                    String editedString = "";
                    if (type.equals("Upper")) {
                        editedString = key.substring(0, startIndex) + key.substring(startIndex, endIndex).toUpperCase()
                                + key.substring(endIndex);;
                        System.out.println(editedString);
                        key = editedString;
                    } else if(type.equals("Lower")) {
                        editedString = key.substring(0, startIndex) + key.substring(startIndex, endIndex).toLowerCase()
                                + key.substring(endIndex);;
                        System.out.println(editedString);
                        key = editedString;
                    }
                    break;
                case "Slice":
                    int firstIndex = Integer.parseInt(input[1]);
                    int secondIndex = Integer.parseInt(input[2]);
                    String partToDelete = key.replace(key.substring(firstIndex, secondIndex), "");
                    System.out.println(partToDelete);
                    key = partToDelete;
                    break;
                default:
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.printf("Your activation key is: %s%n", key);
    }
}
