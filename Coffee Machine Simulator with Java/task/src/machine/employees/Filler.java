package machine.employees;

import machine.CoffeeMachine;

public class Filler {
    //FIELDS
    private int mlWaterOnHand;
    private int mlMilkOnHand;
    private int gCoffeeBeansOnHand;
    private int cupsOnHand;
    //CONSTRUCTOR
    public Filler() {
        this.mlWaterOnHand = 0;
        this.mlMilkOnHand = 0;
        this.gCoffeeBeansOnHand = 0;
        this.cupsOnHand = 0;
    }
    //SETTERS
    public void setWater(int water) {this.mlWaterOnHand = water;}
    public void setMilk(int milk) {this.mlMilkOnHand = milk;}
    public void setCoffeeBeans(int coffeeBeans) {this.gCoffeeBeansOnHand = coffeeBeans;}
    public void setCups(int cups) {this.cupsOnHand = cups;}
    //INSTANCE METHOD
    public void fill(CoffeeMachine coffeeMachine) {
        coffeeMachine.setWater(mlWaterOnHand += coffeeMachine.getWater());
        coffeeMachine.setMilk(mlMilkOnHand += coffeeMachine.getMilk());
        coffeeMachine.setCoffeeBeans(gCoffeeBeansOnHand += coffeeMachine.getCoffeeBeans());
        coffeeMachine.setCountCups(cupsOnHand += coffeeMachine.getCountCups());
    }
}
