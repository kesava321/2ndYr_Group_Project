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

public class energyConsumers
{
    public double powerComsumption(int mins, double powerRating)
    {
        return (powerRating/60) * mins;
    }

    public double calculateCost(double powerConsumption, double costPerKwH){
        return (powerConsumption/1000)*costPerKwH;
    }

    public double estimatedEmissions(double kwh){
        double emissions = 0.527;
        return kwh * emissions;
    }
}



