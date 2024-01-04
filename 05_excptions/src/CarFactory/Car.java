package CarFactory;

public class Car {
    private String name;
    private long price;
    public Car(long price) {
        this.price = price;
        this.name = "nameless car";
    }
    public Car(long price, String name) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public long getPrice() {
        return this.price;
    }
}
