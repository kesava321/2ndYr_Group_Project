package energyConsumers;


/**
 * Created by Kesava on 15/02/2017.
 */
public class WaterTemp extends Water
{
    private double temperature;
    public WaterTemp()
    {
        super(false,70.0);
        setTemperature(0.0);
    }
    public WaterTemp(boolean state, double power, double temp)
    {
        super(state,power);
        setTemperature(temp);
    }

    /**
     * Returns the temperature of the electric heater
     * @return temperature
     */
    public double getTemperature()
    {
        return temperature;
    }

    /**
     * Sets the temperature of the electric heater
     * if temperature is > 40 the temp will be fixed at 40
     * @param temperature
     */
    public void setTemperature(double temperature)
    {
        if(temperature >40.0)
            this.temperature = 40;
        else if(temperature <0.0)
            this.temperature = 0;
        else
            this.temperature = temperature;
    }
}
