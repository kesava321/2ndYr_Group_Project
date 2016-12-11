package energyConsumers;

public class energyConsumers
{
    public double powerConsumption(int mins, double powerRating)
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

