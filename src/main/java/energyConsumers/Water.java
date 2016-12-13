package energyConsumers;

/**
 * Created by Kesava on 12/12/2016.
 */
    public class Water extends energyConsumers
    {
        private Boolean WaterState; //Hot or Cold
        private double powerRating; //Watts

        public Water(){
            setWaterState(false);
            setPowerRating(50.0);
        }

        public Water(Boolean state, double powerRating){
            setWaterState(state);
            setPowerRating(powerRating);
        }

        public Boolean getWaterState() {
            return WaterState;
        }

        public void setWaterState(boolean waterState) {
            this.WaterState = waterState;
        }

        public double getPowerRating() {
            return powerRating;
        }

        public void setPowerRating(double powerRating) {
            this.powerRating = powerRating;
            if (WaterState = false) { //If water is hot apply powerrating of 50.0
                this.powerRating = powerRating;
            } else {
                this.powerRating = 35.0; //If water is cold apply powerrating of 35.0
            }
        }
}



