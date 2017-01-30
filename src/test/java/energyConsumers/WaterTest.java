package energyConsumers;/*
package energyConsumers;

import org.junit.Test;

import static org.junit.Assert.*;

*/

import energyConsumers.Water;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Matt on 15-Dec-16.
 */

public class WaterTest {
    @Test
    public void getWaterState() throws Exception {
        Water source = new Water();
        boolean x = source.getState();
        assertEquals(x,false);
    }

    @Test
    public void setWaterState() throws Exception {
        Water source = new Water();
        source.setState(true);
        boolean x = source.getState();
        assertEquals(x,true);
    }

    @Test
    public void getWaterIntake() throws Exception {
        Water source = new Water();
        double x = source.getUsage();
        assertEquals(x,50.0,0);
    }

    @Test
    public void setWaterIntake() throws Exception {
        Water source = new Water();
        source.setUsage(75);
        double x = source.getUsage();
        assertEquals(x,75,0);
    }

}
