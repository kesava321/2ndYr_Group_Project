package energyConsumers;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Matt on 15-Dec-16.
 */
public class WaterTest {
    @Test
    public void getWaterState() throws Exception {
        Water source = new Water();
        boolean x = source.getWaterState();
        assertEquals(x,false);
    }

    @Test
    public void setWaterState() throws Exception {
        Water source = new Water();
        source.setWaterState(true);
        boolean x = source.getWaterState();
        assertEquals(x,true);
    }

    @Test
    public void getWaterIntake() throws Exception {
        Water source = new Water();
        double x = source.getWaterIntake();
        assertEquals(x,50.0,0);
    }

    @Test
    public void setWaterIntake() throws Exception {
        Water source = new Water();
        source.setWaterIntake(75);
        double x = source.getWaterIntake();
        assertEquals(x,75,0);
    }

}