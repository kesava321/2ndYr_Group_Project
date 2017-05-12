package energyConsumers;

/**
 * The light class manages all features that relate to a light
 * object (such as it's current power). Light is a subclass of Electricity.
 * Created by daniel on 29/11/2016.
 */
public class Light extends Electricity
{
    private double currentPower; //dimming bulb

    public Light()
    {
        super(false,60.0);
        //setCurrentPower(60.0);
    }

    public Light(Boolean state, double powerrating)
    {
        super(state,powerrating);
       // setCurrentPower(powerrating);
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
     * @param currentPower set the current power usage of the bulb in Watts
     */
    public void setCurrentPower(double currentPower)
    {
        this.currentPower = currentPower;
    }

    /**
     * Sets the maximum power the bulb can use
     * @param maxPower set the maximum power that the bulb can use in Watts.
     *                This allows for dimming bulbs.
     */
    public void setMaxPower(double maxPower)
    {
        setUsage(maxPower);
    }
}
