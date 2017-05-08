package energyConsumers;

/** The water constructors either allow the user to set a WaterState and
 * WaterIntake or a WaterState and WaterIntake is set itself. setWaterState
 * ensures that WaterState cannot be less than 0 by resetting any
 * WaterState made false.
 */
public class Water extends energyConsumers
{
    //water usage in L

    private final double waterEmmisions = 0.0059; // gram per liter
    private int usePerHour;

    public Water(){
        setState(false);
        setUsage(50.0);
        setUsePerHour(1);
    }

    public Water(Boolean state, double intake, int usePerHour){
        setState(state);
        setUsage(intake);
        setUsePerHour(usePerHour);
    }

    @Override
    public double getConsumption(int mins)
    {
        return 0;
    }

    /**
     * estimates emissions of energy consumer using its power consumption and a estimate for water emmisions
     * @param mins time for which you want the emmisions to be simulated over.
     * @return emmisions
     */
    @Override
    public double estimatedEmissions(int mins)
    {
        return ((getUsage()*getUsePerHour())/60)*mins* waterEmmisions;
    }

    public int getUsePerHour()
    {
        return usePerHour;
    }

    public void setUsePerHour(int usePerHour)
    {
        this.usePerHour = usePerHour;
    }

}



