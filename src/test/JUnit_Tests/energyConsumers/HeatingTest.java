package energyConsumers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Matt on 09-Dec-16.
 */
public class HeatingTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getTemperatureDefaultConst() throws Exception {
        Heating heater = new Heating();
        double x = heater.getTemperature();
        assertEquals(0, x, 0.0);
    }

    @Test
    public void setTemperature() throws Exception {

    }

    @Test
    public void getPowerRating() throws Exception {

    }

    @Test
    public void setPowerRating() throws Exception {

    }

}