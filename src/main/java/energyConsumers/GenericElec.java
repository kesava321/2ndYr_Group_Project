package energyConsumers;

/**
 * Created by daniel on 03/04/2017.
 */
public class GenericElec extends Electricity
{
    private double currentPower;

    public GenericElec(double power)
    {
        super(true,power);
    }

    /**
     * Sets the maximum power a generic electrical appliance can use
     * @param maxPower the maximum power that the bulb can use.
     */
    public void setMaxPower(double maxPower)
    {
        setUsage(maxPower);
    }

    /**
     * returns the current power of a generic electrical appliance
     * @return currentPower
     */

    public double getCurrentPower()
    {
        return currentPower;
    }

    /**
     * sets the current power of a generic electrical appliance
     * @param currentPower sets the current power usage of a generic electrical appliance
     */

    public void setCurrentPower(double currentPower)
    {
        this.currentPower = currentPower;
    }
}
