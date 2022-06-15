package JavaFundamentalsFinalExam04April2020;

import java.util.Scanner;

public class ActivationKeysWithStringBuilder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();

        String text = scanner.nextLine();
        sb.append(text);

        String command = scanner.nextLine();
        while(!command.equals("Generate")) {
            String[] input = command.split(">>>");
            String order = input[0];
            switch (order) {
                case "Contains":
                    String substring = input[1];
                    if(sb.toString().contains(substring)) {
                        System.out.printf("%s contains %s%n", sb, substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String type = input[1];
                    int startIndex = Integer.parseInt(input[2]);
                    int endIndex = Integer.parseInt(input[3]);

                    if (type.equals("Upper")) {
                        sb.replace(startIndex, endIndex, sb.substring(startIndex, endIndex).toUpperCase());
                        System.out.println(sb);

                    } else if(type.equals("Lower")) {
                        sb.replace(startIndex, endIndex, sb.substring(startIndex, endIndex).toLowerCase());
                        System.out.println(sb);
                    }
                    break;
                case "Slice":
                    int firstIndex = Integer.parseInt(input[1]);
                    int secondIndex = Integer.parseInt(input[2]);
                    sb.replace(firstIndex, secondIndex, "");
                    System.out.println(sb);
                    break;
                default:
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.printf("Your activation key is: %s%n", sb);
    }
}
