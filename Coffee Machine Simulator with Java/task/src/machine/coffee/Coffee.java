package machine.coffee;

public class Coffee {
    //FIELDS
    private int waterRq;
    private int milkRq;
    private int coffeeBeansRq;
    private int price;
    //CONSTRUCTOR
    Coffee(int waterRq, int milkRq, int coffeeBeansRq, int price) {
        this.waterRq = waterRq;
        this.milkRq = milkRq;
        this.coffeeBeansRq = coffeeBeansRq;
        this.price = price;
    }
    //GETTERS
    public int getWaterRq() {return waterRq;}
    public int getMilkRq() {return milkRq;}
    public int getCoffeeBeansRq() {return coffeeBeansRq;}
    public int getPrice() {return price;}
}
