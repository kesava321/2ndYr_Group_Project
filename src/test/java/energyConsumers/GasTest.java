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
}
