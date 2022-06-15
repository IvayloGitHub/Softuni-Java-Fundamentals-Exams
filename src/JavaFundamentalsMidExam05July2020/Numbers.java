package JavaFundamentalsMidExam05July2020;

import java.util.*;
import java.util.stream.Collectors;

public class Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers =
                Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
                        .collect(Collectors.toList());
        List<Integer> maxNumbers = new ArrayList<>();

        double sum = 0.0;


        for (Integer number : numbers) {
            sum += number;
        }
        double averageValue = sum / numbers.size();
        int count = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if(numbers.get(i) > averageValue) {
                maxNumbers.add(numbers.get(i));
                count++;
            }
        }
        if(count == 0) {
            System.out.println("No");
            return;
        }

        maxNumbers.sort(Collections.reverseOrder());

        String output = "";
        if (maxNumbers.size() > 5) {
            List<Integer> maxNumbers2 = maxNumbers.subList(0, 5);
            output = maxNumbers2.stream().map(String::valueOf).collect(Collectors.joining(" "));
            System.out.println(output);
        } else {
            output = maxNumbers.stream().map(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(output);
        }

    }
}
