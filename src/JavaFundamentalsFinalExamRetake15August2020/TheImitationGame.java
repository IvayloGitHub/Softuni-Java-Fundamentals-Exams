package JavaFundamentalsFinalExamRetake15August2020;

import java.util.Scanner;

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String encryptedMessage = scanner.nextLine();
        StringBuilder sb = new StringBuilder();
        sb.append(encryptedMessage);

        String command = scanner.nextLine();

        while(!command.equals("Decode")) {
            String[] commandArray = command.split("\\|");
            String order = commandArray[0];

            switch (order) {
                case "Move":
                    int numberOfLetters = Integer.parseInt(commandArray[1]);
                    String toBeAddedAtTheEnd = sb.substring(0, numberOfLetters);
                    sb.replace(0, numberOfLetters, "").append(toBeAddedAtTheEnd);
                    break;
                case "Insert":
                    int index = Integer.parseInt(commandArray[1]);
                    String value = commandArray[2];

                    sb.insert(index, value);
                    break;
                case "ChangeAll":
                    String substring = commandArray[1];
                    String replacement = commandArray[2];
                    while(sb.indexOf(substring) != -1) {
                        sb.replace(sb.indexOf(substring), sb.indexOf(substring) + substring.length(), replacement);
                    }
                    break;
                default:
                    break;

            }
            command = scanner.nextLine();
        }
        System.out.printf("The decrypted message is: %s%n", sb);
    }
}
