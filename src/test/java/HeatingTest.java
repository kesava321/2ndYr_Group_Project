import energyConsumers.Heating;
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
    /** A test for the desfault constructor */
    public void getTemperatureDefaultConst() throws Exception {
        Heating heater = new Heating();
        double x = heater.getTemperature();
        assertEquals(0, x, 0.0);
    }

    @Test
    /** A test for checking the constructor with values passed of 20 and 10000 */
    public void getTemperatureTestingSetter__Temperature() throws Exception {
        Heating heater = new Heating(20, 10000);
        double x = heater.getTemperature();
        assertEquals(20, x, 0.0);
    }

    @Test
    /** A test for checking the constructor with values passed of 20 and 10000 - POWER RATING */
    public void getTemperatureTestingSetter__PowerRating() throws Exception {
        Heating heater = new Heating(20, 10000);
        double x = heater.getPowerRating();
        assertEquals(10000, x, 0.0);
    }

    @Test
    /** Testing a valid tempature entry */
    public void setTemperature__VALID() throws Exception {
        Heating heater = new Heating();
        heater.setTemperature(20);
        double x = heater.getTemperature();
        assertEquals(20, x, 0.0);
    }

    @Test
    /** Testing a invalid tempature entry -- Too high */
    public void setTemperature__INVALID_High() throws Exception {
        Heating heater = new Heating();
        heater.setTemperature(41);  //should reduce to 40
        double x = heater.getTemperature();
        assertEquals(40, x, 0.0);
    }

    @Test
    /** Testing a valid tempature entry -- Too low */
    public void setTemperature__INVALID_Low() throws Exception {
        Heating heater = new Heating();
        heater.setTemperature(-2);
        double x = heater.getTemperature();
        assertEquals(0, x, 0.0);
    }

    @Test
    public void getPowerRatingDefaultConstrutor() throws Exception {
        Heating heater = new Heating();
        double x = heater.getPowerRating();
        assertEquals(10000, x, 0.0);
    }

    @Test
    public void getPowerRatingDefaultConstrutor() throws Exception {
        Heating heater = new Heating();
        double x = heater.getPowerRating();
        assertEquals(10000, x, 0.0);
    }

    @Test
    public void setPowerRating() throws Exception {

    }

}