package energyConsumers;

/** The water constructors either allow the user to set a WaterState and
 * WaterIntake or a WaterState and WaterIntake is set itself. setWaterState
 * ensures that WaterState cannot be less than 0 by resetting any
 * WaterState made false.
 * Created by Kesava on 12/12/2016.
 */
public class Water extends energyConsumers
{
    //water usage per min

    private final double waterEmmisions = 0.59; // gram per liter

    public Water(){
        setState(false);
        setUsage(50.0);
    }

    public Water(Boolean state, double intake){
        setState(state);
        setUsage(intake);
    }


    @Override
    public double getConsumption(int mins)
    {
        return getUsage()*mins;
    }

    @Override
    public double estimatedEmissions(int mins)
    {
        return getConsumption(mins)* waterEmmisions;
    }
}



