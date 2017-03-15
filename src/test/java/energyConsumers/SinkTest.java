package energyConsumers;


import static org.junit.Assert.assertEquals;

import energyConsumers.Water;

/**
 * Created by Aleem on 24/02/2017.
 */


public class SinkTest {

    @org.junit.Test
    public void setSinkState() throws Exception {
        Sink Sinks = new Sink(true,17,4,2);
        Sinks.setState(false);
        boolean x = Sinks.getState();
        assertEquals(x,false);
    }

    @org.junit.Test
    public void setUsage() throws Exception {
        Sink Sinks = new Sink(true,17,4,2);
        Sinks.setUsage(40);
        double x = Sinks.getUsage();
        assertEquals(40,x,0.0);
    }

    @org.junit.Test
    public void setAvgTimeUsed() throws Exception {
        Sink Sinks = new Sink(true,17,4,2);
        Sinks.setAvgTimeUsed(25);
        double x = Sinks.getAvgTimeUsed();
        assertEquals(25,x,0.0);
    }

    @org.junit.Test
    public void getSinkState__DEFAULTCONSTRUCTOR() throws Exception {
        Sink Sinks = new Sink();
        boolean x = Sinks.getState();
        assertEquals(true,x);
    }

    @org.junit.Test
    public void getSinkUsage__DEFAULTCONSTRUCTOR() throws Exception {
        Sink Sinks = new Sink();
        double x = Sinks.getUsage();
        assertEquals(17,x, 0.0);
    }

    @org.junit.Test
    public void getSinkFlushPerHour__CONSTRUCTOR() throws Exception {
        Sink Sinks = new Sink(true, 17, 10,2);
        double x = Sinks.getUsePerHour();
        assertEquals(x, 10, 0.0);
    }
}

