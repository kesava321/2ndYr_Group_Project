package energyConsumers;

/**
 * The heating constructors allow the user to set a temperature and powerRating
 * or it sets them as predefined values. setTemperature ensures that if the
 * temperature is set as above 40 it is automatically reset to 40 and if it is
 * above 0 but below 40, it remains as is.
 * setPower rating ensures that powerRating cannot be less than 0.
 * Gas heating is a subclass of Gas.
 *
 * Created by daniel on 29/11/2016.
 */
public class GasHeating extends Gas
{
    private double temperature;
    public GasHeating()
    {
        super(false,70.0);
        setTemperature(0.0);
    }
    public GasHeating(boolean state, double power, double temp)
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
     * if temperature is greater than 40 the temp will be fixed at 40
     * if temperature is less than 0 the temp will be fixed at 0
     * otherwise the temperature will just be returned.
     * @param temperature double temperature in celsius
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
