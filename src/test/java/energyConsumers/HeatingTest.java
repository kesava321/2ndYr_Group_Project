package energyConsumers;

import energyConsumers.Heating;
import org.junit.Test;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;
import static org.junit.Assert.*;

/**
 * Created by Matt on 09-Dec-16.
 */
public class HeatingTest {

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
    /** testing getting using default constructor */
    public void getPowerRatingDefaultConstrutor() throws Exception {
        Heating heater = new Heating();
        double x = heater.getPowerRating();
        assertEquals(10000, x, 0.0);
    }

    @Test
    /** testing getter using user defined constructor */
    public void getPowerRatingConstrutor() throws Exception {
        Heating heater = new Heating(20, 200);
        double x = heater.getPowerRating();
        assertEquals(200, x, 0.0);
    }

    @Test
    /** sets the power rating to a valid number */
    public void setPowerRating__VALID() throws Exception {
        Heating heater = new Heating();
        heater.setPowerRating(5000);  //should reduce to 40
        double x = heater.getPowerRating();
        assertEquals(5000, x, 0.0);
    }

    @Test
    /** sets the power rating to an invalid value (negative) */
    public void setPowerRating__INVALID() throws Exception {
        Heating heater = new Heating();
        heater.setPowerRating(-40);  //should reduce to 40
        double x = heater.getPowerRating();
        assertEquals(0, x, 0.0);
    }
}