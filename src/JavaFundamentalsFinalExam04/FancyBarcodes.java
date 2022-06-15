package JavaFundamentalsFinalExam04;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfBarcodes = Integer.parseInt(scanner.nextLine());

        String regex = "(@#+)([A-Z][A-Za-z0-9]{4,}[A-Z])(@#+)";

        Pattern pattern = Pattern.compile(regex);

        while(numberOfBarcodes > 0) {
            String barcode = scanner.nextLine();
            Matcher matcher = pattern.matcher(barcode);

            if(matcher.find()) {
                String productGroup = findProductGroup(barcode);
                if(productGroup.equals("")) {
                    productGroup = "00";
                }
                System.out.printf("Product group: %s%n", productGroup);

            } else {
                System.out.println("Invalid barcode");
            }

            numberOfBarcodes--;
        }
    }

    private static String findProductGroup(String barcode) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < barcode.length(); i++) {
            if (Character.isDigit(barcode.charAt(i))) {
                sb.append(barcode.charAt(i));
            }
        }
        return sb.toString();
    }
}
