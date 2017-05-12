package energyConsumers;

public abstract class energyConsumers implements java.io.Serializable
{
    private boolean state;
    private double usage;
    private double y;
    private double x;
    /**
     * @param mins runtime of an energy consumer
     * @return KWh
     */
    abstract public double getConsumption(int mins);

    /**
     * @param powerConsumption watt hours of an appliance
     * @param costPerUnit cost per unit for energy consumer
     * @return cost
     */
    public static double calculateCost(double powerConsumption, double costPerUnit){
        return (powerConsumption)*costPerUnit;
    }

    abstract public double estimatedEmissions(int mins);

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
     * @param state boolean variable representing if the object is on of off
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
     * @param usage double representing energy usage of the object.
     *              Can be any unit (KW,m/3
     */
    public void setUsage(double usage)
    {
        if(usage<0)
            this.usage = 0;
        else
            this.usage = usage;
    }

    public double getX()
    {
        return x;
    }

    public void setY(double y)
    {
        this.y = y;
    }

    public void setX(double x)
    {
        this.x = x;
    }

    public double getY()
    {
        return y;
    }
}



