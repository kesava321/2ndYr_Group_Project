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

    public void setMaxPower(double maxPower)
    {
        setUsage(maxPower);
    }

    public double getCurrentPower()
    {
        return currentPower;
    }

    public void setCurrentPower(double currentPower)
    {
        this.currentPower = currentPower;
    }
}
