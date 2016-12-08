package energyConsumers;

/**
 * Created by daniel on 29/11/2016.
 */
public class Heating extends energyConsumers
{
    private double temperature;
    private double powerRating; //Watts

    public Heating()
    {
        setTemperature(0.0);
        setPowerRating(10000);
    }
    public Heating(double temp, double power)
    {

    }

    public double getTemperature()
    {
        return temperature;
    }

    public void setTemperature(double temperature)
    {
        if(temperature >40.0)
            this.temperature = 40;
        else if(temperature >0.0)
            this.temperature = temperature;
        else
            this.temperature = 0;
    }

    public double getPowerRating()
    {
        return powerRating;
    }

    public void setPowerRating(double powerRating)
    {
        if(powerRating<0)
            this.powerRating = 0;
        else
            this.powerRating = powerRating;
    }
}
