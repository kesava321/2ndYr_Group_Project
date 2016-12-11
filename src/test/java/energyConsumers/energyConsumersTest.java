package energyConsumers;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by User on 11-Dec-16.
 */
public class energyConsumersTest {
    @Test
    public void powerConsumption() throws Exception {
        Light lights = new Light(true, 400);
        double x = lights.powerConsumption(90, lights.getPowerrating());
        assertEquals(600,x,0.0);
    }

    @Test
    public void calculateCost() throws Exception {
        Light lights = new Light(true, 400);
        double x = lights.powerConsumption(90, lights.getPowerrating());
        double y = lights.calculateCost(x, 2);
        assertEquals(1200,y,0.0);
    }

    @Test
    public void estimatedEmissions() throws Exception {
        Light lights = new Light(true, 400);
        double x = lights.powerConsumption(90, lights.getPowerrating());
        double y = lights.estimatedEmissions(x);
        assertEquals(1200,y,0.0);
    }

}