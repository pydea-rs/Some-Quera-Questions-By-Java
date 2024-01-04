package HotCold;

public class ThermTest {
    public static void main(String[] args) {
        BillCalculator summerBill = new SummerBillCalculator();
        Thermostat heater = new Heater(summerBill, 2.2, 30);
        heater.setWaterDegreeCelsius(30);
        heater.setDesiredDegreeCelsius(70);
        System.out.println(heater.getDesiredDegreeCelsius());
        heater.use(30);
        heater.use(20);
        System.out.println(summerBill.getBill());

        System.out.println();

        heater.setWaterDegreeCelsius(30);
        heater.setDesiredDegreeCelsius(90);
        System.out.println(heater.getDesiredDegreeCelsius());
        heater.use(15);
        System.out.println(summerBill.getBill());
        System.out.println();

        heater.setDesiredDegreeFahrenheit(153);
        System.out.println(heater.getDesiredDegreeCelsius());
        heater.use(10);
        System.out.println(summerBill.getBill());

        summerBill.reset();
        System.out.println();

        heater.setDesiredDegreeCelsius(30);
        System.out.println(heater.getDesiredDegreeCelsius());
        heater.use(10);
        System.out.println(summerBill.getBill());
        System.out.println();

    }
}
