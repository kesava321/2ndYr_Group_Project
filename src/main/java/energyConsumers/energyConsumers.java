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
    /**
     * @param mins runtime of an appliance
     * @param powerRating watts of an applliance
     * @return watt hours
     */
    abstract public double powerConsumption(int mins, double powerRating);

    /**
     * @param powerConsumption watt hours of an appliance
     * @return kilowatt hours
     */
    public double calculateCost(double powerConsumption, double costPerKwH){
        return (powerConsumption/1000)*costPerKwH;
    }

    abstract public double estimatedEmissions(double kwh);
}



