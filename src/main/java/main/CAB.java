package main;

import controlSensors.control;
import controlSensors.sensor;
import energyConsumers.Heating;
import energyConsumers.Light;
import simulation.*;

class CAB{
    public static void main(String[] args)
    {
        control.test();
        sensor.test();
        energyConsumers.energyConsumers.test();
        Heating.test();
        Light.test();
        building.test();
        environment.test();
        person.test();
        room.test();
        simulation.test();
    }
}