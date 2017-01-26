package energyConsumers;

/**
 * The light constructors either allow the user to set a LightState and
 * Powerrating or a LightState and Powerrating is set itself. setPowerrating
 * ensures that Powerrating cannot be less than 0 by resetting any
 * Powerrating made below 0 to 0.
 * Created by daniel on 29/11/2016.
 */
public class Light extends Electricity
{
    private double currentPower; //dimming bulb

    public Light()
    {
        super(false,60.0);
        setCurrentPower(60.0);
    }

    public Light(Boolean state, double powerrating)
    {
        super(state,powerrating);
        setCurrentPower(powerrating);
    }

    /**
     * returns the current power of the bulb accounting for if it is dimmed
     * @return currentPower
     */
    public double getCurrentPower()
    {
        return currentPower;
    }

    /**
     * sets the current power of the bulb allowing for dimming
     * does not allow for the bulb to have a large power than powerRating
     * @param currentPower
     */
    public void setCurrentPower(double currentPower)
    {
        if(currentPower<=getUsage())
            this.currentPower = currentPower;
    }
}
