package Graphs;

/**
 * Created by Kesava on 30/01/2017.
 */


public class energyData {


    private String energyConsumer;
    private int quantity;
    private float energyRating;

    public energyData(String energyConsumer, int quantity, float energyRating) {
        this.energyConsumer = energyConsumer;
        this.quantity = quantity;
        this.energyRating = energyRating;
    }

    public float getTotal() {
        return quantity * energyRating;
    }

    public String toString() {
        return "Energy Consumer: " + energyConsumer + "\n" + "Quantity: " + quantity + "\n"
                + "Energy Rating: " + energyRating;
    }
}
