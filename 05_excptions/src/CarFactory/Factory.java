package CarFactory;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

public class Factory {
    private static Factory factory;

    private Factory() {
    }

    public static Factory getInstance() {
        if(factory == null)
            factory = new Factory();
        return factory;
    }

    Comparator<Car> priceComparator() {
        return new Comparator<Car>() {
            @Override
            public int compare(Car c1, Car c2) {
                return Long.compare(c2.getPrice(), c1.getPrice()); // comparing is reversed to use for descending sorting
            }
        };
    }

    Predicate<Car> isExpensive() {
        return new Predicate<Car>() {
            @Override
            public boolean test(Car car) {
                return car.getPrice() >= 100000L;
            }
        };
    }

    Function<Car, String> price() {
        return new Function<Car, String>() {
            @Override
            public String apply(Car car) {
                return "$" + String.valueOf(car.getPrice());
            }
        };
    }

    BiFunction<Long, String, Car> namedCarCreator() {
        return new BiFunction<Long, String, Car>() {
            @Override
            public Car apply(Long price, String name) {
                return new Car(price, name);
            }
        };
    }
    Function<Long, Car> namelessCarCreator() {
        return new Function<Long, Car>() {
            @Override
            public Car apply(Long price) {
                return new Car(price);
            }
        };
    }

    Consumer<Car> carPricePrinter() {
        return new Consumer<Car>() {
            @Override
            public void accept(Car car) {
                System.out.println(car.getName() + "'s price is " + factory.price().apply(car));
            }
        };
    }

    BinaryOperator<Car> middlePriceCreator() {
        return new BinaryOperator<Car>() {
            @Override
            public Car apply(Car car, Car car2) {
                return factory.namelessCarCreator().apply((car.getPrice() + car2.getPrice()) / 2);
            }
        };
    }

    public Car[] collectCheapCars(Car[] cars) {
        List<Car> cheapCars =  Arrays.stream(cars).filter(Predicate.not(factory.isExpensive())).toList();
        Car[] result = new Car[cheapCars.size()];
        for(int i = 0; i < cheapCars.size(); i++) {
            result[i] = cheapCars.get(i);
        }
        return result;
    }

    public void sortDescendingAndPrint(Car[] cars) {
        List<Car> sorted = Arrays.stream(cars).sorted(factory.priceComparator()).toList();
        for (Car car : sorted) {
            factory.carPricePrinter().accept(car);
        }
    }

    public String compare(Car a , Car b){
       long comp = -factory.priceComparator().compare(a, b);

       if(comp > 0)
            return a.getName() + " is more expensive than " + b.getName();
        else if(comp < 0)
            return b.getName() + " is more expensive than " + a.getName();
        return a.getName() + " is equivalent to " + b.getName();
    }
}
