package energyConsumers;

/**
 * The heating constructors allow the user to set a temperature and powerRating
 * or it sets them as predefined values. setTemperature ensures that if the
 * temperature is set as above 40 it is automatically reset to 40 and if it is
 * above 0 but below 40, it remains as is.
 * setPower rating ensures that powerRating cannot be less than 0.
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
    public GasHeating(double temp, double power,Boolean state)
    {
        super(state,power);
        setTemperature(temp);
    }

    public double getTemperature()
    {
        return temperature;
    }

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
