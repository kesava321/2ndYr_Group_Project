package energyConsumers;

/** The Gas constructors either allow the user to set a GasState and
 * GasUsage or a GasState and GasUsage is set itself. setGasState
 * ensures that GasState cannot be less than 0 by resetting any
 * GasState made below 0 to 0.
 * Created by Kesava on 13/12/2016.
 */
public class Gas extends energyConsumers {

    private Boolean GasState;
    private double gasUsage; //m3

    public Gas(){
        setGasState(false);
        setGasUsage(70.0);
    }

    public Gas(Boolean state, double powerRating) {
        setGasState(state);
        setGasUsage(powerRating);
    }

    public Boolean getGasState() {
        return GasState;
    }

    public void setGasState(boolean gasState) {
        this.GasState = gasState;
    }

    public double getGasUsage() {
        return gasUsage;
    }

    public void setGasUsage(double gasUsage) {
        if(gasUsage>0) {
            this.gasUsage = gasUsage;
        }else {
            this.gasUsage = 0;
        }
    }
}
