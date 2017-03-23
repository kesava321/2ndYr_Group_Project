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

    @Test
    public void setUsage_INVALID() throws Exception {
        Light lights = new Light(true, 400);
        lights.setUsage(-5);
        double x = lights.getUsage();
        assertEquals(0, x, 0.0);
    }

    @Test
    public void setUsage_VALID() throws Exception {
        Light lights = new Light(true, 400);
        lights.setUsage(55);
        double x = lights.getUsage();
        assertEquals(55, x, 0.0);
    }

    @Test
    public void setUsage_Constructor() throws Exception {
        Light lights = new Light(true, 300);
        double x = lights.getUsage();
        assertEquals(300, x, 0.0);
    }

}
