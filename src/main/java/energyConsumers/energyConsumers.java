package energyConsumers;

/**
 * The user will input a time in minutes which will equal the runtime
 * of an appliance. The powerConsumption method then works out watt hours
 * which is then converted into kilowatt hours in the calculateCost method.
 * This method multiplies kilowatt hours by cost per kilowatt hours to find
 * the cost of the appliance running.
 * The estimatedEmissions method calculates an estimation of emissions based
 * on a variable kilowatt hours.
 */

public abstract class energyConsumers
{
    private boolean state;
    private double usage;
    /**
     * @param mins runtime of an appliance
     * @return watt hours
     */
    abstract public double powerConsumption(int mins);

    /**
     * @param powerConsumption watt hours of an appliance
     * @return kilowatt hours
     */
    public double calculateCost(double powerConsumption, double costPerKwH){
        return (powerConsumption/1000)*costPerKwH;
    }

    abstract public double estimatedEmissions(double usage);

    /**
     * returns state of the energy consumer
     * @return state
     */
    public boolean getState()
    {
        return state;
    }

    /**
     * sets state of state
     * @param state
     */
    public void setState(boolean state)
    {
        this.state = state;
    }

    /**
     * gets Usage information
     * @return usage
     */
    public double getUsage()
    {
        return usage;
    }

    /**
     * sets usage information whilst validating it is larger than 0
     * @param usage
     */
    public void setUsage(double usage)
    {
        if(usage<0)
            this.usage = 0;
        else
            this.usage = usage;
    }
}



