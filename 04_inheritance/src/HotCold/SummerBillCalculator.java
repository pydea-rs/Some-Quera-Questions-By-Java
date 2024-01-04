package HotCold;

public class SummerBillCalculator implements BillCalculator {
    private double water, energy;

    public SummerBillCalculator() {
        this.reset();
    }

    @Override
    public void addEnergy(double energyConsumed) {
        this.energy += energyConsumed;
    }

    @Override
    public void addWater(double waterConsumed) {
        this.water += waterConsumed;
    }

    @Override
    public double getBill() {
        return 10 * this.energy + (this.water <= 3000 ? (this.water * 20) : (3000 * 20 + (this.water - 3000) * 60));
    }

    @Override
    public void reset() {
        this.energy = 0;
        this.water = 0;
    }
}
