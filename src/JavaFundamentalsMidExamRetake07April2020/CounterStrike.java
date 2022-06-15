package JavaFundamentalsMidExamRetake07April2020;

import java.util.Scanner;

public class CounterStrike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();
        int wins = 0;

        while(!command.equals("End of battle")) {
            int distance = Integer.parseInt(command);

            if (energy < distance) {
                break;
            } else {
                energy -= distance;
                wins++;
                if (wins % 3 == 0) {
                    energy += wins;
                }
            }
            command = scanner.nextLine();
        }
        if (command.equals("End of battle")) {
            System.out.printf("Won battles: %d. Energy left: %d", wins, energy);
        } else {
            System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", wins, energy);
        }

    }
}
