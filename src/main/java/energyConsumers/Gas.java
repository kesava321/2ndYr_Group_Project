package energyConsumers;

/**
 * Created by Kesava on 13/12/2016.
 */
public class Gas extends energyConsumers {

    private Boolean GasState;
    private double powerRating; //Watts
    //Number of boilers
    //Number of kitchens


    public Gas()
    {
        setGasState(false);
        setPowerRating(70.0);
    }

    public Gas(Boolean state, double powerRating)
    {
        setGasState(state);
        setPowerRating(powerRating);
    }

    public void setGasState(boolean gasState) {
        this.GasState = gasState;
    }

    public void setPowerRating(double powerRating) {
        this.powerRating = powerRating;
    }
}
