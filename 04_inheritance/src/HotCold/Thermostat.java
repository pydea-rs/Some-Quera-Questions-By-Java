package HotCold;

public abstract class Thermostat {
    protected double desiredDegree, waterDegree, coefficient; // in C
    protected BillCalculator billCalculator;

    public Thermostat(BillCalculator billCalculator, double coefficient) {
        this.coefficient = coefficient;
        this.billCalculator = billCalculator;
    }

    public abstract void setDesiredDegreeCelsius(double degreeCelsius);
    public void setDesiredDegreeFahrenheit(double degreeFahrenheit){
        this.desiredDegree = (degreeFahrenheit - 32.0) * 5.0 / 9.0;
    }

    public double getDesiredDegreeCelsius() {
        return this.desiredDegree;
    }

    public double getDesiredDegreeFahrenheit(double degreeFahrenheit){
        return this.desiredDegree * 1.8 + 32.0;
    }

    public void setWaterDegreeCelsius(double degreeCelsius) {
        this.waterDegree = degreeCelsius;
    }

    public abstract void use(double liter);
}
