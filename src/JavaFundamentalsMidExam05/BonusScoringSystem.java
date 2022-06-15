package JavaFundamentalsMidExam05;

import java.util.Scanner;

public class BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        int numberOfLectures = Integer.parseInt(scanner.nextLine());
        int additionalBonus = Integer.parseInt(scanner.nextLine());
        double maxBonusPoints = 0.0;
        int bestStudentAttendances = 0;

        for (int i = 1; i <= numberOfStudents ; i++) {
            int attendances = Integer.parseInt(scanner.nextLine());
            double currentBonusPoints = ((attendances * 1.0) / numberOfLectures) * (5 + additionalBonus);

            if (currentBonusPoints > maxBonusPoints) {
                maxBonusPoints = currentBonusPoints;
                bestStudentAttendances = attendances;
            }
        }
        System.out.printf("Max Bonus: %.0f.%n", Math.ceil(maxBonusPoints));
        System.out.printf("The student has attended %d lectures.%n", bestStudentAttendances);
    }
}
