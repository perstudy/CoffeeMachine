package machine;

import java.util.*;

public class CoffeeMachine {
    private static Scanner sc = new Scanner(System.in);
    private static int water = 400;
    private static int milk = 540;
    private static int coffeeBeans = 120;
    private static int cups = 9;
    private static int money = 550;
    private static final String[] ingredients =
            {"water!", "milk!", "coffee beans!", "cups!"};

    public static void writeAction() {
        System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
        String str = sc.next();
        switch (str.toLowerCase()) {
            case ("buy"):
                buy();
                break;
            case ("fill"):
                fill();
                break;
            case ("take"):
                take();
                break;
            case ("remaining"):
                machineHas();
                break;
            case ("exit"):
                System.exit(1);
                break;
            default:
                writeAction();
        }
    }

    public static void buy() {
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino," +
                "back - to main menu: ");
        String temp = sc.next();
        switch (temp) {
            case "1":
                espresso();
                break;
            case "2":
                latte();
                break;
            case "3":
                cappuccino();
                break;
            case "back":
                writeAction();
            default:
                buy();
        }
    }

    public static void fill() {
        System.out.println("\nWrite how many ml of water you want to add: ");
        int waterAdd = sc.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        int milkAdd = sc.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        int beansAdd = sc.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add: ");
        int cupsAdd = sc.nextInt();
        water += waterAdd;
        milk += milkAdd;
        coffeeBeans += beansAdd;
        cups += cupsAdd;
        writeAction();
    }

    public static void take() {
        System.out.println("\nI gave you $" + money);
        money = 0;
        writeAction();
    }

    public static void machineHas() {
        System.out.println("\nThe coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffeeBeans + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money");
        writeAction();
    }

    public static int diff(int... x) {
        int result = 0;
        while (true) {
            if (water < x[0]) {
                break;
            } else if (milk < x[1]) {
                result = 1;
                break;
            } else if (coffeeBeans < x[2]) {
                result = 2;
                break;
            } else if (cups < x[3]) {
                result = 3;
                break;
            }
        }
        return result;
    }

    public static void espresso() {
        if (water >= 250 && coffeeBeans >= 16 && cups >= 1) {
            System.out.println("I have enough resources, making you a coffee!");
            water -= 250;
            coffeeBeans -= 16;
            cups--;
            money += 4;
            writeAction();
        } else {
            System.out.println("Sorry, not enough " + ingredients[diff(250, 16,
                    Integer.MAX_VALUE, 1)] + "\n");
            writeAction();
        }
    }

    public static void latte() {
        if (water >= 350 && milk >= 75 && coffeeBeans >= 20 && cups >= 1) {
            System.out.println("I have enough resources, making you a coffee!");
            water -= 350;
            milk -= 75;
            coffeeBeans -= 20;
            cups--;
            money += 7;
            writeAction();
        } else {
            System.out.println("Sorry, not enough " + ingredients[diff(350, 75, 20, 1)]);
            writeAction();
        }
    }

    public static void cappuccino() {
        if (water >= 200 && milk >= 100 && coffeeBeans >= 12 && cups >= 1) {
            System.out.println("I have enough resources, making you a coffee!");
            water -= 200;
            milk -= 100;
            coffeeBeans -= 12;
            cups--;
            money += 6;
            writeAction();
        } else {
            System.out.println("Sorry, not enough " + ingredients[diff(200, 100, 12, 1)]);
            writeAction();
        }
    }

    public static void main(String[] args) {
        writeAction();
    }
}


