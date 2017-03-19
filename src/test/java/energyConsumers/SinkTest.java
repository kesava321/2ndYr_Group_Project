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
        assertEquals(false,x);
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
    public void getSinkUseperHour__DEFAULTCONSTRUCTOR() throws Exception {
        Sink Sinks = new Sink();
        double x = Sinks.getUsePerHour();
        assertEquals(4,x, 0.0);
    }

    @org.junit.Test
    public void getSinkAverageTimeUsed__DEFAULTCONSTRUCTOR() throws Exception {
        Sink Sinks = new Sink();
        double x = Sinks.getAvgTimeUsed();
        assertEquals(2,x, 0.0);
    }

    @org.junit.Test
    public void getSinkAverageTimeUsed__CONSTRUCTOR() throws Exception {
        Sink Sinks = new Sink(true, 17, 10,15);
        double x = Sinks.getAvgTimeUsed();
        assertEquals(15,x, 0.0);
    }

    @org.junit.Test
    public void getSinkEmissions() throws Exception {
        Sink Sinks = new Sink(true, 17, 10,2);
        double x = Sinks.estimatedEmissions(30);
        assertEquals(0.5015, x, 0.0);
    }

    @org.junit.Test
    public void getSinkFlushPerHour__CONSTRUCTOR() throws Exception {
        Sink Sinks = new Sink(true, 17, 10,2);
        double x = Sinks.getUsePerHour();
        assertEquals(10, x, 0.0);
    }


}

