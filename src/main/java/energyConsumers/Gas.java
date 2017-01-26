package energyConsumers;

public class Gas extends energyConsumers {

    private final double gasEmmisions = 0.5533827; //per KwH
    //Usage m3
    public Gas(){
        setUsage(70.0);
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

    @Override
    public double powerConsumption(int mins)
    {
        return (toKwH(getUsage())/60)*mins;
    }

    @Override
    public double estimatedEmissions(int mins)
    {
        return powerConsumption(mins)* gasEmmisions;
    }
}
