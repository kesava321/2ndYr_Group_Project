package energyConsumers;

/**
 * Created by daniel on 16/02/2017.
 */
public abstract class Toilet extends Water
{
    private int flushPerHour;

    public Toilet()
    {
        setUsage(17);
        setState(true);
        setFlushPerHour(4);
    }

    public Toilet(boolean state, double usage, int flushPerHour)
    {
        setState(state);
        setUsage(usage);
        setFlushPerHour(flushPerHour);
    }

    /**
     * gets the power consumption of energy consumer for given time in liter per time period
     * @param mins runtime of an energy comsumer
     * @return power consumption in liter per time period
     */
    @Override
    public double getConsumption(int mins)
    {
        return ((getUsage()*getFlushPerHour())/60)*mins;
    }

    public double getFlushPerHour()
    {
        return flushPerHour;
    }

    public void setFlushPerHour(int flushPerHour)
    {
        this.flushPerHour = flushPerHour;
    }
}
