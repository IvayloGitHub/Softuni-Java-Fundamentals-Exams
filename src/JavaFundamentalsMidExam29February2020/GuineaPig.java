package JavaFundamentalsMidExam29February2020;

import java.util.Scanner;

public class GuineaPig {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double foodInKg = Double.parseDouble(scanner.nextLine());
        double hayInKg = Double.parseDouble(scanner.nextLine());
        double coverInKg = Double.parseDouble(scanner.nextLine());
        double guineaPigKg = Double.parseDouble(scanner.nextLine());

        for (int i = 1; i <= 30; i++) {
            foodInKg -= 0.3;
            if (i % 2 == 0) {
                hayInKg -= foodInKg * 0.05;
            }
            if (i % 3 == 0) {
                coverInKg -= guineaPigKg / 3;
            }
        }
        if(Math.round(foodInKg * 100.0) / 100.0 > 0 && Math.round(hayInKg * 100.0) / 100.0 > 0 && Math.round(coverInKg * 100.0) / 100.0 > 0) {
        System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.",
                foodInKg, hayInKg, coverInKg);
        } else {
            System.out.println("Merry must go to the pet store!");
        }
    }
}
