package energyConsumers;

/**
 * Created by daniel on 20/02/2017.
 */
public class Sink extends Water
{
    private double avgTimeUsed; //use is measured in mins
    //usage is average liters used per single use of sink
    public Sink()
    {
        super(true,17,4);
        setAvgTimeUsed(2);
    }

    public Sink(boolean state, double usage, int flushPerHour,double avgTimeUsed)
    {
        super(state,usage,flushPerHour);
        setAvgTimeUsed(avgTimeUsed);
    }

    public double getAvgTimeUsed()
    {
        return avgTimeUsed;
    }

    public void setAvgTimeUsed(double avgTimeUsed)
    {
        this.avgTimeUsed = avgTimeUsed;
    }
}
