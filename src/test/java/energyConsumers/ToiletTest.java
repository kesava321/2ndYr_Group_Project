package energyConsumers;
import static org.junit.Assert.assertEquals;

import energyConsumers.Water;

/**
 * Created by Aleem on 24/02/2017.
 */


public class ToiletTest {

    @org.junit.Test
    public void setToiletState() throws Exception {
        Toilet toilets = new Toilet(true,17,4);
        toilets.setState(false);
        boolean x = toilets.getState();
        assertEquals(x,false);
    }//makes the state true does the actual value equal the expected value

    @org.junit.Test
    public void setUsage() throws Exception {
        Toilet toilets = new Toilet(true,17,4);
        toilets.setUsage(50);
        double x = toilets.getUsage();
        assertEquals(50,x,0.0);
    }//makes the state true does the actual value equal the expected value

    @org.junit.Test
    public void getToiletState__DEFAULTCONSTRUCTOR() throws Exception {
        Toilet toilets = new Toilet();
        boolean x = toilets.getState();
        assertEquals(x,true);
    }

    @org.junit.Test
    public void getToiletFlushPerHour__CONSTRUCTOR() throws Exception {
        Toilet toilets = new Toilet(true, 17, 10);
        double x = toilets.getUsePerHour();
        assertEquals(10, x, 0.0);
    }

    @org.junit.Test
    public void getToiletUsage__DEFAULTCONSTRUCTOR() throws Exception {
        Toilet toilets = new Toilet();
        double x = toilets.getUsage();
        assertEquals(17,x, 0.0);
    }
}