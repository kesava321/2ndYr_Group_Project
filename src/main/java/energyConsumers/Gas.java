package energyConsumers;

public class Gas extends energyConsumers {

    private final double gasEmmisions = 0.5533827; //per KwH
    //Usage m3/h
    public Gas(){
        setUsage(1.0);
        setState(false);
    }

    public Gas(Boolean state, double usage) {
        setState(state);
        setUsage(usage);
    }

    public double toKwH(double usage)
    {
        return usage*11.187;
    }

    /**
     * gets the power consumption of energy consumer for given time in KWh
     * @param mins runtime of an energy comsumer
     * @return power consumption in KWh
     */
    @Override
    public double getConsumption(int mins)
    {
        return (toKwH(getUsage())/60)*mins;
    }

    /**
     * estimates emissions of energy consumer using its power consumption and a estimate for gas emmisions
     * @param mins int time for which you want the emmisions to be estimated
     * @return emmisions
     */
    @Override
    public double estimatedEmissions(int mins)
    {
        return getConsumption(mins)* gasEmmisions;
    }
}
