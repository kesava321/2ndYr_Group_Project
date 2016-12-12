package energyConsumers;

/**
 * Created by Kesava on 12/12/2016.
 */
    public class Water extends energyConsumers
    {
        private Boolean WaterState; //Hot/Cold
        private double PowerRating; //Watts



    public Water()
    {
        setWaterState(false);
        setPowerRating(50.0);
    }

    public Water(Boolean state, double PowerRating)
    {
        setWaterState(state);
        setPowerRating(PowerRating);
    }


    public void setWaterState(boolean waterState) {
        this.WaterState = waterState;
    }

    public void setPowerRating(double PowerRating) {
        this.PowerRating = PowerRating;
    }
}
 