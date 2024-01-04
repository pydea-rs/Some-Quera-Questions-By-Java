package CarFactory;

public class MJ {
    public static void main(String[] args) {
        Car[] cars = new Car[6];
        cars[0] = new Car(5000000L);
        cars[1] = new Car(20000);
        cars[2] = new Car(50L , "pride");
        cars[3] = new Car(999999L , "porshe");
        cars[4] = new Car(100000 , "peikan");
        cars[5] = new Car(0);
        for (Car car : cars) {
            Factory.getInstance().carPricePrinter().accept(car);
        }
        System.out.println("\n");
        Factory.getInstance().sortDescendingAndPrint(cars);
    }
}
