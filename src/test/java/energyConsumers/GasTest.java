package energyConsumers;/*
package energyConsumers;

import org.junit.Test;

import static org.junit.Assert.*;

*/

import energyConsumers.Gas;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Matt on 13-Dec-16.
 */

public class GasTest {
    @Test
    public void getGasState() throws Exception {
        Gas consumer = new Gas();
        boolean x = consumer.getState();
        assertEquals(x, false);
    }

    @Test
    public void setGasState() throws Exception {
        Gas consumer = new Gas();
        consumer.setState(true);
        boolean x = consumer.getState();
        assertEquals(x, true);
    }

    @Test
    public void getGasUsage() throws Exception {
        Gas consumer = new Gas();
        double x = consumer.getUsage();
        assertEquals(x, 70,0);
    }

    @Test
    public void setGasUsage() throws Exception {
        Gas consumer = new Gas();
        consumer.setUsage(110);
        double x = consumer.getUsage();
        assertEquals(x, 110, 0);
    }

    @Test
    public void setGasConsumption() throws Exception {
        Gas consumer = new Gas(false ,70);
        double x = consumer.getConsumption(45);
        assertEquals(587.3175,x, 0);
    }

    @Test
    public void setGasUsage__CONSTRUCTOR() throws Exception {
        Gas consumer = new Gas(false ,88);
        double x = consumer.getUsage();
        assertEquals(88,x, 0);
    }

    @Test
    public void setGasState__CONSTRUCTOR() throws Exception {
        Gas consumer = new Gas(true ,15);
        boolean x = consumer.getState();
        assertEquals(true,x);
    }

    @Test
    public void GetEmissions() throws Exception {
        Gas consumer = new Gas(true ,10);
        double x = consumer.estimatedEmissions(40);
        assertEquals(41.271281766,x,0.0);
    }
}
