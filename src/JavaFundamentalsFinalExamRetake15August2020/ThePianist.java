package JavaFundamentalsFinalExamRetake15August2020;

import java.util.*;

public class ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> pieces = new LinkedHashMap<>();

        int numberOfPieces = Integer.parseInt(scanner.nextLine());

        while(numberOfPieces > 0) {
            String[] items = scanner.nextLine().split("\\|");
            String piece = items[0];
            String composer = items[1];
            String key = items[2];
            pieces.put(piece, new ArrayList<>());
            pieces.get(piece).add(composer);
            pieces.get(piece).add(key);
            numberOfPieces--;
        }

        String command = scanner.nextLine();
        while(!command.equals("Stop")) {
            String[] commandArray = command.split("\\|");
            String order = commandArray[0];
            String nameOfPiece = commandArray[1];
            switch (order) {
                case "Add":
                    String nameOfComposer = commandArray[2];
                    String nameOfKey = commandArray[3];
                    if (!pieces.containsKey(nameOfPiece)) {
                        pieces.put(nameOfPiece, new ArrayList<>());
                        pieces.get(nameOfPiece).add(nameOfComposer);
                        pieces.get(nameOfPiece).add(nameOfKey);
                        System.out.printf("%s by %s in %s added to the collection!%n",
                                nameOfPiece, pieces.get(nameOfPiece).get(0), pieces.get(nameOfPiece).get(1));
                    } else {
                        System.out.printf("%s is already in the collection!%n", nameOfPiece);
                    }
                    break;
                case "Remove":
                    if (pieces.containsKey(nameOfPiece)) {
                        pieces.remove(nameOfPiece);
                        System.out.printf("Successfully removed %s!%n", nameOfPiece);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n",
                                nameOfPiece);
                    }
                    break;
                case "ChangeKey":
                    String newNameOfKey = commandArray[2];
                    if (pieces.containsKey(nameOfPiece)) {
                        System.out.printf("Changed the key of %s to %s!%n", nameOfPiece, newNameOfKey);
                        pieces.get(nameOfPiece).set(1, newNameOfKey);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", nameOfPiece);
                    }
                    break;
                default:
                    break;

            }
            command = scanner.nextLine();
        }
        for (String piece : pieces.keySet()) {
            System.out.printf("%s -> Composer: %s, Key: %s%n",
                    piece, pieces.get(piece).get(0), pieces.get(piece).get(1));
        }
    }
}
