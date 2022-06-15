package JavaFundamentalsMidExam29February2020;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HeartDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> houses =
                Arrays.stream(scanner.nextLine().split("@")).map(Integer::parseInt)
                        .collect(Collectors.toList());
        int index = 0;

        String command = scanner.nextLine();
        while (!command.equals("Love!")) {
            String[] cupidArray = command.split(" ");

            int jump = Integer.parseInt(cupidArray[1]);
            index += jump;
            if (index >= houses.size()) {
                index = 0;
            }
            if (houses.get(index) == 0) {
                System.out.printf("Place %d already had Valentine's day.%n", index);
            } else {
                houses.set(index, houses.get(index) - 2);
                if (houses.get(index) == 0) {
                    System.out.printf("Place %d has Valentine's day.%n", index);
                }
            }

            command = scanner.nextLine();
        }

        int count = 0;
        for (Integer house : houses) {
            if (house != 0) {
                count++;
            }
        }
        System.out.printf("Cupid's last position was %d.%n", index);
        if (count == 0) {
            System.out.println("Mission was successful.");
        } else {
            System.out.printf("Cupid has failed %d places.%n", count);
        }
    }
}
