package JavaFundamentalsMidExam6August2019;

import java.util.*;
import java.util.stream.Collectors;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> chestContentList = Arrays.stream(scanner.nextLine()
                .split("\\|")).collect(Collectors.toList());

        String command = scanner.nextLine();

        while(!command.equals("Yohoho!")) {
            String[] commandArray = command.split(" ");
            String currentCommand = commandArray[0];
            switch (currentCommand) {
                case "Loot":
                    for (int i = 1; i < commandArray.length; i++) {
                        if (!chestContentList.contains(commandArray[i])) {
                            chestContentList.add(0, commandArray[i]);
                        }
                    }
                    break;
                case "Drop":
                    int dropIndex = Integer.parseInt(commandArray[1]);
                    if (dropIndex < 0 || dropIndex >= chestContentList.size()) {
                        break;
                    }
                    chestContentList.add(chestContentList.remove(dropIndex));
                    break;
                case "Steal":
                    int stealAmount = Integer.parseInt(commandArray[1]);
                    List<String> stolen = new ArrayList<>();
                    String output = "";
                    if (stealAmount >= chestContentList.size()) {
                        output = String.join(", ", chestContentList);
                        chestContentList.clear();
                        System.out.println(output);
                        break;
                    }
                    for (int i = 0; i < stealAmount; i++) {
                        int lastIndex = chestContentList.size() - 1;
                        stolen.add(chestContentList.remove(lastIndex));

                    }
                    Collections.reverse(stolen);
                    output = String.join(", ", stolen);
                    System.out.println(output);
                    break;
                default:
                    break;
            }
            command = scanner.nextLine();
        }
        int totalSizeOfItems = 0;
        for (String currentItem : chestContentList) {
            totalSizeOfItems += currentItem.length();
        }

        if (totalSizeOfItems == 0) {
            System.out.println("Failed treasure hunt.");
        } else {
            System.out.printf("Average treasure gain: %.2f pirate credits.%n",
                    (totalSizeOfItems * 1.0) / chestContentList.size());
        }
    }
}
