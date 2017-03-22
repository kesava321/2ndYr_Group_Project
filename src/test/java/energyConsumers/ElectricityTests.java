package energyConsumers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Aleem on 14/03/2017.
 */
public class ElectricityTests {

    @Test
    public void GetElectricityState() throws Exception {
        Electricity Electric = new Electricity(false,100);
        boolean x = Electric.getState();
        assertEquals(false,x);
    }

    @Test
    public void GetElectricityUsage() throws Exception {
        Electricity Electric = new Electricity();
        double x = Electric.getUsage();
        assertEquals(100,x,0.0);
    }

    @Test
    public void SetElectricityUsage() throws Exception {
        Electricity Electric = new Electricity(true, 150);
        Electric.setUsage(300);
        double x = Electric.getUsage();
        assertEquals(300,x,0.0);
    }

    @Test
    public void SetElectricityState() throws Exception {
        Electricity Electric = new Electricity(true, 150);
        Electric.setState(false);
        boolean x = Electric.getState();
        assertEquals(false,x);
    }

    @Test
    public void GetConsumption() throws Exception {
        Electricity Electric = new Electricity(true, 150);
        double x = Electric.getConsumption(45);
        assertEquals(Electric.getConsumption(45), x, 0.0);
    }
    
    @Test
    public void GetEmissions() throws Exception {
        Electricity Electric = new Electricity(true, 150);
        double x = Electric.estimatedEmissions(30);
        assertEquals(Electric.estimatedEmissions(30), x, 0.0);
    }


}
