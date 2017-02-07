package energyConsumers;/*
package energyConsumers;

import org.junit.Test;

import static org.junit.Assert.*;

*/

import energyConsumers.Light;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Matt on 11-Dec-16.
 */

public class energyConsumersTest {
    @Test
    public void powerConsumption() throws Exception {
        Light lights = new Light(true, 400);
        double x = lights.getConsumption(90);
        assertEquals(0.6,x,0.0);
    }

    @Test
    public void calculateCost() throws Exception {
        Light lights = new Light(true, 400);
        double x = lights.getConsumption(90);
        double y = lights.calculateCost(x, 2);
        assertEquals(1.2,lights.calculateCost(x,2),0.0);
    }

    @Test
    public void estimatedEmissions() throws Exception {
        Light lights = new Light(true, 400);
        assertEquals(lights.getConsumption(90),0.6,0.0);
    }

}
