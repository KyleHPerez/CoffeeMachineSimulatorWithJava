package machine.employees;

import machine.CoffeeMachine;

public class Cleaner {

    public void clean(CoffeeMachine coffeeMachine) {
        coffeeMachine.setClean();
        coffeeMachine.resetCoffeesMade();
    }
}
