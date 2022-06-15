package JavaFundamentalsMidExamRetake12August2020;

import java.util.Scanner;

public class ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        double totalPrice = 0.0;
        double vat = 0.0;
        while(!command.equals("special") && !command.equals("regular")) {
            double priceWithoutVat = Double.parseDouble(command);
            if (priceWithoutVat < 0) {
                System.out.println("Invalid price!");
                command = scanner.nextLine();
                continue;
            }
            totalPrice = totalPrice + priceWithoutVat;
            command = scanner.nextLine();
        }
        if (totalPrice == 0) {
            System.out.println("Invalid order!");
            return;
        }
        if (command.equals("special")) {
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n", totalPrice);
            vat = totalPrice * 0.2;
            System.out.printf("Taxes: %.2f$%n", vat);
            System.out.println("-----------");
            totalPrice = (totalPrice + vat) * 0.9;
            System.out.printf("Total price: %.2f$", totalPrice);
        }
        if (command.equals("regular")) {
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n", totalPrice);
            vat = totalPrice * 0.2;
            System.out.printf("Taxes: %.2f$%n", vat);
            System.out.println("-----------");
            totalPrice = totalPrice + vat;
            System.out.printf("Total price: %.2f$", totalPrice);
        }
    }
}
