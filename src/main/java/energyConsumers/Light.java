package energyConsumers;

/**
 * The light constructors either allow the user to set a LightState and
 * Powerrating or a LightState and Powerrating is set itself. setPowerrating
 * ensures that Powerrating cannot be less than 0 by resetting any
 * Powerrating made below 0 to 0.
 * Created by daniel on 29/11/2016.
 */
public class Light extends energyConsumers
{
    private Boolean lightState;
    private double powerrating;

    public Light()
    {
        setLightState(false);
        setPowerrating(60.0);
    }

    public Light(Boolean state, double powerrating)
    {
        setLightState(state);
        setPowerrating(powerrating);
    }

    public Boolean getLightState()
    {
        return lightState;
    }

    public void setLightState(Boolean lightState)
    {
        this.lightState = lightState;
    }

    public void setPowerrating(double powerrating) {
        if(powerrating>0)
            this.powerrating = powerrating;
        else
            this.powerrating =0;
    }

    public double getPowerrating() {
        return powerrating;
    }
}
