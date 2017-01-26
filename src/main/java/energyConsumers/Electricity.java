package energyConsumers;

/**
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

    @Override
    public double getConsumption(int mins)
    {
        return (getUsage()/60)*mins;
    }

    @Override
    public double estimatedEmissions(int mins)
    {
        return getConsumption(mins)* electricityEmmisions;
    }
}
