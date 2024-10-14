package machine;

import machine.coffee.Coffee;

public class CoffeeMachine {
    //FIELDS
    private int coffeesMade = 0;
    private int money = 550;

    private int mlWater = 400;
    private int mlMilk = 540;
    private int gCoffeeBeans = 120;
    private int countCups = 9;

    private boolean isClean = true;
    private boolean isDone = false;

    //GETTERS AND SETTERS
    public int getMoney() {return money;}
    public void setMoney(int money) {this.money = money;}

    public int getWater() {return mlWater;}
    public void setWater(int mlWater) {this.mlWater = mlWater;}

    public int getMilk() {return mlMilk;}
    public void setMilk(int mlMilk) {this.mlMilk = mlMilk;}

    public int getCoffeeBeans() {return gCoffeeBeans;}
    public void setCoffeeBeans(int gCoffeeBeans) {this.gCoffeeBeans = gCoffeeBeans;}

    public int getCountCups() {return countCups;}
    public void setCountCups(int countCups) {this.countCups = countCups;}

    public boolean isClean() {return isClean;}
    public void setClean() {isClean = true;}

    public int getCoffeesMade() {return coffeesMade;}
    public void resetCoffeesMade() {coffeesMade = 0;}

    public boolean isDone() {return isDone;}

    //INSTANCE METHODS
    public void buy(Coffee coffee) {
        int waterRatio = this.mlWater / coffee.getWaterRq();
        int milkRatio = 0 < coffee.getMilkRq() ? (this.mlMilk / coffee.getMilkRq()) : 1;
        int coffeeBeansRatio = this.gCoffeeBeans / coffee.getCoffeeBeansRq();
        boolean sufficientWater = (1 <= waterRatio);
        boolean sufficientMilk = 0 >= coffee.getMilkRq() || (1 <= milkRatio);
        boolean sufficientCoffeeBeans = (1 <= coffeeBeansRatio);
        boolean sufficientCups = (1 <= this.countCups);

        if (sufficientWater && sufficientMilk && sufficientCoffeeBeans && sufficientCups) {
            System.out.println("I have enough resources, making you a coffee!");
            this.mlWater -= coffee.getWaterRq();
            this.mlMilk -= coffee.getMilkRq();
            this.gCoffeeBeans -= coffee.getCoffeeBeansRq();
            this.countCups--;
            this.money += coffee.getPrice();
            this.coffeesMade++;
            isClean = 10 <= coffeesMade ? false : true;
        } else {
            String lowestIngredient;
             if (!sufficientWater) {
                 lowestIngredient = "water";
             } else if (!sufficientMilk) {
                 lowestIngredient = "milk";
             } else if (!sufficientCoffeeBeans) {
                 lowestIngredient = "coffee beans";
             } else {
                 lowestIngredient = "cups";
             }
             System.out.printf("Sorry, not enough %s!\n", lowestIngredient);
        }
    }

    void remaining() {
        System.out.printf("""
                The coffee machine has:
                %d ml of water
                %d ml of milk
                %d g of coffee beans
                %d disposable cups
                $%d of money
                """, this.mlWater, this.mlMilk, this.gCoffeeBeans, this.countCups, this.money);
    }
    void exit() {
        this.isDone = true;
    }
}