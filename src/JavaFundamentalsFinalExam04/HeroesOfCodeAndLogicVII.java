package JavaFundamentalsFinalExam04;

import java.util.*;

public class HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfHeroes = Integer.parseInt(scanner.nextLine());

        Map<String, List<Integer>> heroes = new LinkedHashMap<>();

        while(numberOfHeroes > 0) {
            String[] input = scanner.nextLine().split(" ");
            String nameOfHero = input[0];
            int HP = Integer.parseInt(input[1]);
            int MP = Integer.parseInt(input[2]);

            heroes.put(nameOfHero, new ArrayList<>());
            heroes.get(nameOfHero).add(HP);
            heroes.get(nameOfHero).add(MP);

            numberOfHeroes--;
        }

        String command = scanner.nextLine();
        while(!command.equals("End")) {
            String[] commandArray = command.split(" - ");
            String order = commandArray[0];
            String nameOfPlayer = commandArray[1];

            switch (order) {
                case "CastSpell":
                    int neededMP = Integer.parseInt(commandArray[2]);
                    String spellName = commandArray[3];

                    if (heroes.get(nameOfPlayer).get(1) >= neededMP) {
                        int manaPointsLeft = heroes.get(nameOfPlayer).get(1) - neededMP;
                        System.out.printf("%s has successfully cast %s and now has %s MP!%n",
                                nameOfPlayer, spellName, manaPointsLeft);
                        heroes.get(nameOfPlayer).set(1, manaPointsLeft);
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n",
                                nameOfPlayer, spellName);
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(commandArray[2]);
                    String attacker = commandArray[3];
                    if (heroes.get(nameOfPlayer).get(0) > damage) {
                        int leftHP = heroes.get(nameOfPlayer).get(0) - damage;
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n",
                                nameOfPlayer, damage, attacker, leftHP);
                        heroes.get(nameOfPlayer).set(0, leftHP);
                    } else {
                        heroes.remove(nameOfPlayer);
                        System.out.printf("%s has been killed by %s!%n", nameOfPlayer, attacker);
                    }
                    break;
                case "Recharge":
                    int amountOfMP = Integer.parseInt(commandArray[2]);

                    int mana = heroes.get(nameOfPlayer).get(1) + amountOfMP;
                    if (mana > 200) {
                        mana = 200;
                    }
                    System.out.printf("%s recharged for %d MP!%n",
                            nameOfPlayer, mana - heroes.get(nameOfPlayer).get(1));
                    heroes.get(nameOfPlayer).set(1, mana);
                    break;
                case "Heal":
                    int amountOfHP = Integer.parseInt(commandArray[2]);

                    int health = heroes.get(nameOfPlayer).get(0) + amountOfHP;
                    if (health > 100) {
                        health = 100;
                    }
                    System.out.printf("%s healed for %d HP!%n",
                            nameOfPlayer, health - heroes.get(nameOfPlayer).get(0));
                    heroes.get(nameOfPlayer).set(0, health);
                    break;
                default:
                    break;
            }
            command = scanner.nextLine();
        }
        for (String s : heroes.keySet()) {
            System.out.println(s);
            System.out.printf("  HP: %d%n", heroes.get(s).get(0));
            System.out.printf("  MP: %d%n", heroes.get(s).get(1));
        }
    }
}
