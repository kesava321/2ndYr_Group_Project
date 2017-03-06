package energyConsumers;

import energyConsumers.GasHeating;
import org.junit.Test;

//import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;
import static org.junit.Assert.*;

/**
 * Created by Matt on 09-Dec-16.
 */
public class GasHeatingTest {

    @Test
    //** A test for the default constructor *//*
    public void getTemperatureDefaultConst() throws Exception {
        GasHeating heater = new GasHeating();
        double x = heater.getTemperature();
        assertEquals(0, x, 0.0);
    }

    @Test
    //** A test for checking the constructor with values passed of 20 and 10000 *//*
    public void getTemperatureTestingSetter__Temperature() throws Exception {
        GasHeating heater = new GasHeating(true,20, 10000);
        double x = heater.getTemperature();
        assertEquals(40, x, 0.0);
    }

    @Test
    //** A test for checking the constructor with values passed of 20 and 10000 - POWER RATING *//*
    public void getTemperatureTestingSetter__PowerRating() throws Exception {
        GasHeating heater = new GasHeating(true,20, 10000);
        double x = heater.getUsage();
        assertEquals(20, x, 0.0);
    }

    @Test
    //** Testing a valid tempature entry *//*
    public void setTemperature__VALID() throws Exception {
        GasHeating heater = new GasHeating();
        heater.setTemperature(20);
        double x = heater.getTemperature();
        assertEquals(20, x, 0.0);
    }

    @Test
    //** Testing a invalid tempature entry -- Too high *//*
    public void setTemperature__INVALID_High() throws Exception {
        GasHeating heater = new GasHeating();
        heater.setTemperature(41);  //should reduce to 40
        double x = heater.getTemperature();
        assertEquals(40, x, 0.0);
    }

    @Test
    //** Testing a valid tempature entry -- Too low *//*
    public void setTemperature__INVALID_Low() throws Exception {
        GasHeating heater = new GasHeating();
        heater.setTemperature(-2);
        double x = heater.getTemperature();
        assertEquals(0, x, 0.0);
    }

    @Test
    //** testing getting using default constructor *//*
    public void getPowerRatingDefaultConstrutor() throws Exception {
        GasHeating heater = new GasHeating();
        double x = heater.getUsage();
        assertEquals(70, x, 0.0);
    }
    @Test
    //** testing getter using user defined constructor *//*
    public void getPowerRatingConstrutor() throws Exception {
        GasHeating heater = new GasHeating(true,20, 200);
        double x = heater.getUsage();
        assertEquals(20, x, 0.0);
    }

    @Test
    //** sets the power rating to a valid number *//*
    public void setPowerRating__VALID() throws Exception {
        GasHeating heater = new GasHeating();
        heater.setUsage(5000);  //should reduce to 40
        double x = heater.getUsage();
        assertEquals(5000, x, 0.0);
    }

    @Test
    //** sets the power rating to an invalid value (negative) *//*
    public void setPowerRating__INVALID() throws Exception {
        GasHeating heater = new GasHeating();
        heater.setUsage(-40);  //should reduce to 40
        double x = heater.getUsage();
        assertEquals(0, x, 0.0);
    }
}