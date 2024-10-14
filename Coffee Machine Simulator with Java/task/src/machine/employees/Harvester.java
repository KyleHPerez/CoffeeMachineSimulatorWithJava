package machine.employees;

import machine.CoffeeMachine;

public class Harvester {
    //FIELDS
    private int moneyOnHand;
    //CONSTRUCTOR
    public Harvester() {
        moneyOnHand = 0;
    }
    //INSTANCE METHOD
    public void take(CoffeeMachine coffeeMachine) {
        this.moneyOnHand += coffeeMachine.getMoney();
        coffeeMachine.setMoney(0);
    }
}
