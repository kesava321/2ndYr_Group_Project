package energyConsumers;

/**
 * Created by daniel on 16/02/2017.
 */
public class Toilet extends Water
{

    public Toilet()
    {
        super(true,17,4);
    }

    public Toilet(boolean state, double usage, int flushPerHour)
    {
        super(state,usage,flushPerHour);
    }

    /**
     * gets the power consumption of energy consumer for given time in liter per time period
     * @param mins runtime of an energy comsumer
     * @return power consumption in liter per time period
     */
    @Override
    public double getConsumption(int mins)
    {
        return ((getUsage()*getUsePerHour())/60)*mins;
    }

}
