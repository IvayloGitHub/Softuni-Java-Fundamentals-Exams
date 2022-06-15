package JavaFundamentalsFinalExam04;

import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        StringBuilder sb = new StringBuilder();

        sb.append(text);

        String command = scanner.nextLine();
        while(!command.equals("Done")) {
            String[] commandArray = command.split(" ");
            String order = commandArray[0];
            switch (order) {
                case "TakeOdd":
                    StringBuilder oddLetters = new StringBuilder();
                    for (int i = 0; i < sb.length(); i++) {
                        if (i % 2 != 0) {
                            oddLetters.append(sb.charAt(i));
                        }
                    }
                    sb.replace(0, sb.length(), oddLetters.toString());
                    System.out.println(sb);
                    break;
                case "Cut":
                    int startIndex = Integer.parseInt(commandArray[1]);
                    int length = Integer.parseInt(commandArray[2]);
                    int endIndex = startIndex + length;

                    sb.replace(startIndex, endIndex, "");
                    System.out.println(sb);
                    break;
                case "Substitute":
                    String substring = commandArray[1];
                    String substitute = commandArray[2];
                    if (sb.indexOf(substring) == -1) {
                        System.out.println("Nothing to replace!");
                        break;
                    }
                    while (sb.indexOf(substring) != -1) {
                        sb.replace(sb.indexOf(substring), sb.indexOf(substring) + substring.length(), substitute);
                    }
                    System.out.println(sb);
                    break;
                default:
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.printf("Your password is: %s%n", sb);
    }
}
