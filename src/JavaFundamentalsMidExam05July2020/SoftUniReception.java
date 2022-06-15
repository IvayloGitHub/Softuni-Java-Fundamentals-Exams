package JavaFundamentalsMidExam05July2020;

import java.util.Scanner;

public class SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int first = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());
        int third = Integer.parseInt(scanner.nextLine());

        int allStudents = Integer.parseInt(scanner.nextLine());

        int employeesPerHour = first + second + third;
        int countOfHours = 0;

      while(allStudents > 0) {
          countOfHours++;
          if(countOfHours % 4 == 0) {
              continue;
          }
          allStudents -= employeesPerHour;
      }
        System.out.printf("Time needed: %dh.", countOfHours);
    }
}
