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

    public Boolean getGasState() {return GasState;}

    public void setGasState(boolean gasState) {
        this.GasState = gasState;
    }
    public double getPowerRating() {return powerRating;}

    public void setPowerRating(double powerRating) {
        this.powerRating = powerRating;

        if(powerRating>0)
            this.powerRating = powerRating;
        else
            this.powerRating = 0;
    }

    public double getPowerrating() {
        return powerRating;
    }
}
