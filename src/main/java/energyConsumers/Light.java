package energyConsumers;

/**
 * Created by daniel on 29/11/2016.
 */
public class Light extends energyConsumers
{
    private Boolean lightState;

    public Light()
    {
        setLightState(false);
    }

    public Light(Boolean state)
    {
        setLightState(state);
    }

    public Boolean getLightState()
    {
        return lightState;
    }

    public void setLightState(Boolean lightState)
    {
        this.lightState = lightState;
    }
}
