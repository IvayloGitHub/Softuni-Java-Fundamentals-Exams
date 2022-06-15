package JavaFundamentalsMidExamRetake07April2020;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShootForWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> targets =
                Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt)
                        .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("End")) {
            int index = Integer.parseInt(command);

            if (index < 0 || index >= targets.size()) {
                command = scanner.nextLine();
                continue;
            } else {
                int currentValue = targets.get(index);
                if (currentValue == -1) {
                    command = scanner.nextLine();
                    continue;
                }
                for (int i = 0; i < targets.size(); i++) {
                    if (targets.get(i) == -1 || index == i) {
                        continue;
                    }
                    if (currentValue < targets.get(i)) {
                        targets.set(i, targets.get(i) - currentValue);
                    } else {
                        targets.set(i, targets.get(i) + currentValue);
                    }
                }
                targets.set(index, -1);
            }
            command = scanner.nextLine();
        }
        int count = 0;
        for (Integer target : targets) {
            if (target == -1) {
                count++;
            }
        }
        String output = targets.stream().map(String::valueOf).collect(Collectors.joining(" "));
        System.out.printf("Shot targets: %d -> %s", count, output);
    }
}
