package energyConsumers;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by User on 11-Dec-16.
 */
public class energyConsumersTest {
    @Test
    public void powerConsumption() throws Exception {
        Light lights = new Light(true, 4000);
        double x = lights.powerConsumption(90, lights.getPowerrating());
        assertEquals(6000,x,0.0);
    }

    @Test
    public void calculateCost() throws Exception {

    }

    @Test
    public void estimatedEmissions() throws Exception {

    }

}