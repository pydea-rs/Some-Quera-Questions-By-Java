package HotCold;

public class Cooler extends Thermostat {
    private final double coolingRange;
    public static final double MINIMUM_DESIRED_DEGREE = 10.0;

    public Cooler(BillCalculator billCalculator, double coefficient, double coolingRange) {
        super(billCalculator, coefficient);
        this.coolingRange = coolingRange;
    }

    @Override
    public void setDesiredDegreeCelsius(double degreeCelsius) {
        this.desiredDegree = Math.max(degreeCelsius, Cooler.MINIMUM_DESIRED_DEGREE);

    }

    @Override
    public void use(double liter) {
        this.billCalculator.addWater(liter);
        final double finalTemp = Math.max(this.desiredDegree, this.waterDegree - this.coolingRange),
            epl = (finalTemp - this.waterDegree) * (finalTemp - this.waterDegree) * this.coefficient;
        if(this.desiredDegree <= this.waterDegree && epl > 0) {
            this.billCalculator.addEnergy(liter * epl);
        }
    }
}
