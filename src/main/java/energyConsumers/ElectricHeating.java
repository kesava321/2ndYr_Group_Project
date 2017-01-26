package energyConsumers;

/**
 * Created by daniel on 26/01/2017.
 */
public class ElectricHeating extends Electricity
{
    private double temperature;

    public ElectricHeating()
    {
        super(false,1000);
        setTemperature(0.0);
    }

    public ElectricHeating(boolean state, double powerRating, double temp)
    {
        super(state,powerRating);
        setTemperature(temp);
    }

    public double getTemperature()
    {
        return temperature;
    }

    public void setTemperature(double temperature)
    {
        this.temperature = temperature;
    }
}
