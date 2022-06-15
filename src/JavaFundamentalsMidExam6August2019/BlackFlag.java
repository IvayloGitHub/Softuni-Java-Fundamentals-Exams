package JavaFundamentalsMidExam6August2019;

import java.util.Scanner;

public class BlackFlag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int daysOfPlunder = Integer.parseInt(scanner.nextLine());
        int dailyPlunder = Integer.parseInt(scanner.nextLine());
        double expectedPlunder = Double.parseDouble(scanner.nextLine());



        double totalPlunder = 0.0;
        for (int i = 1; i <= daysOfPlunder; i++) {
            totalPlunder = totalPlunder + dailyPlunder;
            if (i % 3 == 0) {
                totalPlunder = totalPlunder + dailyPlunder * 0.5;
            }
            if (i % 5 == 0) {
                totalPlunder = totalPlunder * 0.7;
            }
        }
        if (totalPlunder >= expectedPlunder) {
            System.out.printf("Ahoy! %.2f plunder gained.",totalPlunder);
        } else {
            double percentageOfExpectedPlunder = (totalPlunder / expectedPlunder) * 100;
            System.out.printf("Collected only %.2f%% of the plunder.",percentageOfExpectedPlunder);
        }
    }
}
