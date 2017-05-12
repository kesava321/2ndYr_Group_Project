package energyConsumers;

/**
 * Electricity is a subclass of energyConsumers and inherits its methods, but it
 * also acts as a base class for electrical objects such as lights.
 * Created by daniel on 26/01/2017.
 */
public class Electricity extends energyConsumers
{
    private final double electricityEmmisions = 0.5; //perKwH
    public Electricity()
    {
        setState(false);
        setUsage(100);
    }

    public Electricity(boolean state,double powerRating)
    {
        setState(state);
        setUsage(powerRating);
    }

    /**
     * gets the power consumption of energy consumer for given time in liter per time period
     * @param mins runtime of an energy comsumer
     * @return power consumption in liter per time period
     */

    @Override
    public double getConsumption(int mins)
    {
        return ((getUsage()/60)*mins)/1000;
    }

    /**
     * estimates emissions of energy consumer using its power consumption and a estimate for electrical emmisions
     * @param mins int time for which you want the emmisions to be estimated
     * @return emmisions
     */

    @Override
    public double estimatedEmissions(int mins)
    {
        return getConsumption(mins)* electricityEmmisions;
    }
}
