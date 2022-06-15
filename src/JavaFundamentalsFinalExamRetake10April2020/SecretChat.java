package JavaFundamentalsFinalExamRetake10April2020;

import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();
        StringBuilder sb = new StringBuilder();
        sb.append(message);

        String command = scanner.nextLine();
        while(!command.equals("Reveal")) {
            String[] commandArray = command.split(":\\|:");
            String order = commandArray[0];
            switch (order) {
                case "InsertSpace":
                    int index = Integer.parseInt(commandArray[1]);
                    sb.insert(index, " ");
                    System.out.println(sb);
                    break;
                case "Reverse":
                    String substring = commandArray[1];

                    if (sb.indexOf(substring) != -1) {
                        int startIndex = sb.indexOf(substring);
                        StringBuilder reverse = new StringBuilder();
                        reverse.append(substring);
                        reverse.reverse();
                        sb.replace(startIndex, startIndex + substring.length(), "");
                        sb.append(reverse);

                    } else {
                        System.out.println("error");
                        break;
                    }
                    System.out.println(sb);
                    break;
                case "ChangeAll":
                    String textSubstring = commandArray[1];
                    String replacement = commandArray[2];

                    while(sb.indexOf(textSubstring)!= -1) {
                    sb.replace(sb.indexOf(textSubstring),
                            sb.indexOf(textSubstring) + textSubstring.length(), replacement);
                    }
                    System.out.println(sb);
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.printf("You have a new text message: %s%n", sb);
    }
}
