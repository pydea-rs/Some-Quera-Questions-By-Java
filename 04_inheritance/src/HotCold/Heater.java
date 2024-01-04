package HotCold;

public class Heater extends Thermostat {
    private final double minimum;
    public static final double MAXIMUM_DESIRED_DEGREE = 80.0;
    public Heater(BillCalculator billCalculator, double coefficient, double minimum) {
        super(billCalculator, coefficient);
        this.minimum = minimum;
    }

    @Override
    public void setDesiredDegreeCelsius(double degreeCelsius) {
        this.desiredDegree = Math.min(degreeCelsius, Heater.MAXIMUM_DESIRED_DEGREE);
    }

    @Override
    public void use(double liter) {
        this.billCalculator.addWater(liter);
        final double en = liter * (this.desiredDegree - this.waterDegree) * this.coefficient;
        this.billCalculator.addEnergy(liter * (en <= this.minimum ? this.minimum : (this.desiredDegree - this.waterDegree) * this.coefficient));
        // if desired < waterDegree => en < 0 => en < minimum => energy = minimum
    }
}
