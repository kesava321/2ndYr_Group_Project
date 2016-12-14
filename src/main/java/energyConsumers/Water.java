package energyConsumers;

/**
 * Created by Kesava on 12/12/2016.
 */
    public class Water extends energyConsumers
    {
        private Boolean WaterState; //on or off
        private double waterIntake; //liters

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
            if (WaterState = false) { //If water is hot apply powerrating of 50.0
                this.waterIntake = intake;
            } else {
                this.waterIntake = 35.0; //If water is cold apply powerrating of 35.0
            }
        }
}



