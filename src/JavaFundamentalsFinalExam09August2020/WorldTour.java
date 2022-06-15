package JavaFundamentalsFinalExam09August2020;

import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        String text = scanner.nextLine();
        sb.append(text);


        String command = scanner.nextLine();
        while(!command.equals("Travel")) {
            String[] commandArray = command.split(":");
            String order = commandArray[0];
            switch (order) {
                case "Add Stop":
                    int index = Integer.parseInt(commandArray[1]);
                    String stringPart = commandArray[2];
                    if (index >= 0 && index < sb.length()) {
                        sb.insert(index, stringPart);
                    }
                        System.out.println(sb);
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(commandArray[1]);
                    int endIndex = Integer.parseInt(commandArray[2]);
                    if (startIndex >= 0 && startIndex < sb.length() && endIndex >= 0 && endIndex < sb.length()) {
                        sb.replace(startIndex, endIndex + 1, "");
                    }
                        System.out.println(sb);
                    break;
                case "Switch":
                    String oldString = commandArray[1];
                    String newString = commandArray[2];

                    if(sb.indexOf(oldString) != -1) {
                        sb.replace(sb.indexOf(oldString), sb.indexOf(oldString) + oldString.length(), newString);
                    }
                    System.out.println(sb);
                    break;

            }

            command = scanner.nextLine();
        }
        System.out.printf("Ready for world tour! Planned stops: %s%n", sb);
    }
}
