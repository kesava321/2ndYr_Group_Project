package energyConsumers;

/**
 * Created by daniel on 29/11/2016.
 */
public class Heating extends energyConsumers
{
    private double temperature;


    public Heating()
    {
        setTemperature(0.0);
    }
    public Heating(double temp)
    {
        if(temp >40.0)
            setTemperature(40);
        else if(temp >0.0)
            setTemperature(temp);
        else
            setTemperature(0);
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
