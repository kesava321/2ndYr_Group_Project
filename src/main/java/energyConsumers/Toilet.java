package energyConsumers;

/**
 * Created by daniel on 16/02/2017.
 */
public class Toilet extends Water
{

    public Toilet()
    {
        super(true,17,4);
    }

    public Toilet(boolean state, double usage, int flushPerHour)
    {
        super(state,usage,flushPerHour);
    }

}
