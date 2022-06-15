package JavaFundamentalsFinalExam09August2020;

import java.util.*;

public class PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Double>> plants = new LinkedHashMap<>();

        int numberOfTimes = Integer.parseInt(scanner.nextLine());

        while(numberOfTimes > 0) {
            String[] input = scanner.nextLine().split("<->");
            String plant = input[0];
            double rarity = Integer.parseInt(input[1]);

            if (plants.containsKey(plant)) {
                plants.get(plant).set(0, rarity);
            } else {
                plants.put(plant, new ArrayList<>());
                plants.get(plant).add(rarity);
            }
            numberOfTimes--;
        }

        String command = scanner.nextLine();
        while(!command.equals("Exhibition")) {
            String[] commandArray = command.split(": ");
            String order = commandArray[0];
            String[] items = commandArray[1].split(" - ");
            String nameOfPlant = items[0];
            if (!plants.containsKey(nameOfPlant)) {
                System.out.println("error");
                command = scanner.nextLine();
                continue;
            }
            switch (order) {
                case "Rate":
                double rating = Double.parseDouble(items[1]);
                plants.get(nameOfPlant).add(rating);
                    break;
                case "Update":
                    double newRarity = Double.parseDouble(items[1]);
                    plants.get(nameOfPlant).set(0, newRarity);
                    break;
                case "Reset":
                    plants.get(nameOfPlant).subList(1, plants.get(nameOfPlant).size()).clear();
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println("Plants for the exhibition:");
        for (String plant : plants.keySet()) {

            List<Double> current = plants.get(plant).subList(1, plants.get(plant).size());
            double averageRating;
            if (current.size() == 0) {
                averageRating = 0.0;
            } else {
                double sum = 0.0;
                for (Double rating : current) {
                    sum = sum + rating;
                }
                averageRating = sum / current.size();
            }
        System.out.printf("- %s; Rarity: %.0f; Rating: %.2f%n", plant, plants.get(plant).get(0), averageRating);
        }
    }
}
