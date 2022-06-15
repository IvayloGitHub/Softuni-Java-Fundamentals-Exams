package JavaFundamentalsFinalExam04April2020;

import java.util.*;

public class Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Integer>> cities = new LinkedHashMap<>();
        String command = scanner.nextLine();

        while (!command.equals("Sail")) {
            String[] commandArray = command.split("\\|\\|");
            String city = commandArray[0];
            int population = Integer.parseInt(commandArray[1]);
            int gold = Integer.parseInt(commandArray[2]);

            if (cities.containsKey(city)) {
                population = population + cities.get(city).get(0);
                gold = gold + cities.get(city).get(1);
            }
            cities.put(city, new ArrayList<>());
            cities.get(city).add(population);
            cities.get(city).add(gold);
            command = scanner.nextLine();
        }

        String input = scanner.nextLine();
        while(!input.equals("End")) {
            String[] inputArray = input.split("=>");
            String order = inputArray[0];
            String town = inputArray[1];
            switch (order) {
                case "Plunder":
                    int people = Integer.parseInt(inputArray[2]);
                    int treasure = Integer.parseInt(inputArray[3]);
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n",
                            town, treasure, people);
                    people = cities.get(town).get(0) - people;
                    treasure = cities.get(town).get(1) - treasure;
                    if (people <= 0 || treasure <= 0) {
                        cities.remove(town);
                        System.out.printf("%s has been wiped off the map!%n", town);
                    } else {
                        cities.get(town).set(0, people);
                        cities.get(town).set(1, treasure);
                    }
                    break;
                case "Prosper":
                    int additionalGold = Integer.parseInt(inputArray[2]);
                    if (additionalGold < 0) {
                        System.out.println("Gold added cannot be a negative number!");
                    } else {
                        int totalGold = additionalGold + cities.get(town).get(1);
                        cities.get(town).set(1, totalGold);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n",
                                additionalGold, town, totalGold);
                    }
                    break;
                default:
                    break;
            }
            input = scanner.nextLine();
        }
        if (cities.size() == 0) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", cities.size());
            for (String s : cities.keySet()) {
                System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n",
                        s, cities.get(s).get(0), cities.get(s).get(1));
            }
        }
    }
}
