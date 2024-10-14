package machine;

import machine.coffee.*;
import machine.employees.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        Filler filler = new Filler();
        Harvester harvester = new Harvester();
        Cleaner cleaner = new Cleaner();

        do {
            System.out.println("Write action (buy, fill, take, clean, remaining, exit):");
            String action = scanner.nextLine();
            switch (action) {
                case "buy" : {
                    if (coffeeMachine.isClean()) {
                        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                        String drinkChoice = scanner.nextLine();
                        switch (drinkChoice) {
                            case "1": {coffeeMachine.buy(new Espresso()); break;}
                            case "2": {coffeeMachine.buy(new Latte()); break;}
                            case "3": {coffeeMachine.buy(new Cappuccino()); break;}
                        }
                    } else {
                        System.out.println("I need cleaning!");
                    }
                } break;
                case "fill" : {
                    System.out.println("Write how many ml of water you want to add:");
                    filler.setWater(Integer.parseInt(scanner.nextLine()));
                    System.out.println("Write how many ml of milk you want to add:");
                    filler.setMilk(Integer.parseInt(scanner.nextLine()));
                    System.out.println("Write how many grams of coffee beans you want to add:");
                    filler.setCoffeeBeans(Integer.parseInt(scanner.nextLine()));
                    System.out.println("Write how many disposable cups you want to add:");
                    filler.setCups(Integer.parseInt(scanner.nextLine()));
                    filler.fill(coffeeMachine);
                } break;
                case "take" : {
                    harvester.take(coffeeMachine);
                } break;
                case "clean" : {
                    cleaner.clean(coffeeMachine);
                    System.out.println("I have been cleaned!");
                } break;
                case "remaining" : {
                    coffeeMachine.remaining();
                } break;
                case "exit" : {
                    coffeeMachine.exit();
                } break;
            }
        } while (!coffeeMachine.isDone()) ;
    }
}