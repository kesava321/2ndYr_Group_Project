package energyConsumers;

public class energyConsumers
{
    public double powerComsumption(int mins, double powerRating)
    {
        return (powerRating/60) * mins;
    }

    public double calculateCost(double powerConsumption, double costPerKwH){

        return (powerConsumption/1000)*costPerKwH;
    }
}

