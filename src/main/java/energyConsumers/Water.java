package energyConsumers;

/** The water constructors either allow the user to set a WaterState and
 * WaterIntake or a WaterState and WaterIntake is set itself. setWaterState
 * ensures that WaterState cannot be less than 0 by resetting any
 * WaterState made false.
 * Created by Kesava on 12/12/2016.
 */
    public class Water extends energyConsumers
    {
        private Boolean WaterState; //Hot or Cold
        private double waterIntake; //Watts

        public Water(){
            setWaterState(false);
            setWaterIntake(50.0);
        }

        public Water(Boolean state, double intake){
            setWaterState(state);
            setWaterIntake(intake);
        }

        public Boolean getWaterState() {
            return WaterState;
        }

        public void setWaterState(boolean waterState) {
            this.WaterState = waterState;
        }

        public double getWaterIntake() {
            return waterIntake;
        }

        public void setWaterIntake(double intake) {
            this.waterIntake = intake;
            if (WaterState = false) {
                this.waterIntake = intake;
            } else {
                this.waterIntake = 35.0;
            }
        }
}



