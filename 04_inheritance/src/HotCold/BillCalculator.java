package HotCold;
public interface BillCalculator {
    public void addEnergy(double energyConsumed);
    public void addWater(double waterConsumed);
    public double getBill();
    public void reset();
}
