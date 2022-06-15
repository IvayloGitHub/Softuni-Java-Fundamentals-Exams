package JavaFundamentalsMidExam05;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initialHealth = 100;
        int initialBitcoins = 0;
        int countOfRooms = 0;

        List<String> roomsList =
                Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());

        for (String current : roomsList) {
            String[] items = current.split(" ");
            String command = items[0];
            int number = Integer.parseInt(items[1]);

            switch (command) {
                case "potion":
                    countOfRooms++;
                    int health = initialHealth;
                    initialHealth = initialHealth + number;
                    if (initialHealth >= 100) {
                        initialHealth = 100;
                        System.out.printf("You healed for %d hp.%n", 100 - health);
                        System.out.printf("Current health: %d hp.%n", initialHealth);
                    } else {
                        System.out.printf("You healed for %d hp.%n", number);
                        System.out.printf("Current health: %d hp.%n", initialHealth);
                    }
                    break;
                case "chest":
                    countOfRooms++;
                    initialBitcoins += number;
                    System.out.printf("You found %d bitcoins.%n", number);
                    break;
                default:
                    countOfRooms++;
                    initialHealth -= number;
                    if(initialHealth > 0) {
                        System.out.printf("You slayed %s.%n", command);
                    } else {
                        System.out.printf("You died! Killed by %s.%n", command);
                        System.out.printf("Best room: %d%n", countOfRooms);
                        return;
                    }
                    break;
            }
        }
        System.out.println("You've made it!");
        System.out.printf("Bitcoins: %d%n", initialBitcoins);
        System.out.printf("Health: %d%n", initialHealth);
    }
}
