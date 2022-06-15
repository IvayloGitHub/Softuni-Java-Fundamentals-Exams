package JavaFundamentalsMidExamRetake12August2020;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPeople = Integer.parseInt(scanner.nextLine());

        List<Integer> lift =
                Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
                        .collect(Collectors.toList());

        for (int i = 0; i < lift.size(); i++) {
            if (lift.get(i) < 4) {

                if(numberOfPeople >= 4 - lift.get(i)) {
                    numberOfPeople -= 4 - lift.get(i);
                    lift.set(i, 4);
                } else  {
                    lift.set(i, numberOfPeople + lift.get(i));
                    numberOfPeople = 0;
                }
            }

        }
        boolean isNotFull = false;

        for (Integer wagon : lift) {
            if(wagon < 4) {
                isNotFull = true;
                break;
            }
        }

        if (numberOfPeople == 0 && isNotFull) {
            System.out.println("The lift has empty spots!");
        } else if(numberOfPeople > 0 && !isNotFull) {
            System.out.printf("There isn't enough space! %d people in a queue!%n", numberOfPeople);
        }
        String output = lift.stream().map(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(String.join(" ", output));

    }
}
