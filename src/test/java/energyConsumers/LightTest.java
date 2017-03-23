package energyConsumers;/*
package energyConsumers;


import static org.junit.Assert.*;

*/

import energyConsumers.Light;

import static org.junit.Assert.assertEquals;

/**
 * Created by Matt on 11-Dec-16.
 */

public class LightTest {
    @org.junit.Test
    public void getLightState__DEFAULTCONSTRUCTOR() throws Exception {
        Light lights = new Light();
        boolean x = lights.getState();
        assertEquals(x,false);
    }

    @org.junit.Test
    public void getLightState__CONSTRUCTOR() throws Exception {
        Light lights = new Light(true, 500);
        boolean x = lights.getState();
        assertEquals(x,true);
    }

    @org.junit.Test
    public void setLightState() throws Exception {
        Light lights = new Light(false, 500);
        lights.setState(true);
        boolean x = lights.getState();
        assertEquals(x,true);
    }

    @org.junit.Test
    public void setPowerrating() throws Exception {
        Light lights = new Light(false, 500);
        lights.setMaxPower(400);
        double x = lights.getUsage();
        assertEquals(x,400,0.0);
    }

    @org.junit.Test
    public void getPowerRating__DEFAULTCONSTRUCTOR() throws Exception {
        Light lights = new Light();
        double x = lights.getUsage();
        assertEquals(x,60, 0.0);
    }

    @org.junit.Test
    public void getPowerRating__CONSTRUCTOR() throws Exception {
        Light lights = new Light(true, 500);
        double x = lights.getUsage();
        assertEquals(x,500, 0.0);
    }



}
