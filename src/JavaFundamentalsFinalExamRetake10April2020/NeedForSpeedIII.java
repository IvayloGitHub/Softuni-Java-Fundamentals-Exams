package JavaFundamentalsFinalExamRetake10April2020;

import java.util.*;

public class NeedForSpeedIII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Integer>> cars = new LinkedHashMap<>();

        int numberOfCars = Integer.parseInt(scanner.nextLine());

        while(numberOfCars > 0) {
            String[] input = scanner.nextLine().split("\\|");
            String car = input[0];
            int mileage = Integer.parseInt(input[1]);
            int fuel = Integer.parseInt(input[2]);
            cars.put(car, new ArrayList<>());
            cars.get(car).add(mileage);
            cars.get(car).add(fuel);
            numberOfCars--;
        }

        String command = scanner.nextLine();
        while(!command.equals("Stop")) {
            String[] commandArray = command.split(" : ");
            String order = commandArray[0];
            String carName = commandArray[1];

            switch (order) {
                case "Drive":
                    int distance = Integer.parseInt(commandArray[2]);
                    int neededFuel = Integer.parseInt(commandArray[3]);
                    if (cars.get(carName).get(1) < neededFuel) {
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        int mileageOfCar = cars.get(carName).get(0) + distance;
                        int carFuel = cars.get(carName).get(1) - neededFuel;
                        cars.get(carName).set(0, mileageOfCar);
                        cars.get(carName).set(1, carFuel);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n",
                                carName, distance, neededFuel);
                        if (mileageOfCar >= 100000) {
                            System.out.printf("Time to sell the %s!%n", carName);
                            cars.remove(carName);
                        }
                    }
                    break;
                case "Refuel":
                    int refuel = Integer.parseInt(commandArray[2]);
                    int tank = cars.get(carName).get(1) + refuel;
                    if (tank > 75) {
                        tank = 75;
                    }
                    System.out.printf("%s refueled with %d liters%n", carName, tank - cars.get(carName).get(1));
                    cars.get(carName).set(1, tank);
                    break;
                case "Revert":
                    int kilometers = Integer.parseInt(commandArray[2]);
                    int realMileage = cars.get(carName).get(0) - kilometers;
                    if (realMileage < 10000) {
                        realMileage = 10000;
                    } else {
                        System.out.printf("%s mileage decreased by %d kilometers%n", carName, kilometers);
                    }
                    cars.get(carName).set(0, realMileage);
                    break;
            }
            command = scanner.nextLine();
        }
        for (String car : cars.keySet()) {
            System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n",
                    car, cars.get(car).get(0), cars.get(car).get(1));
        }
    }
}
