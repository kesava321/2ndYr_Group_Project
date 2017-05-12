package energyConsumers;

/**
 * Electric heating is a subclass of electricity.
 * Created by daniel on 26/01/2017.
 */
import controlDB.ControlSqlite;

import java.sql.SQLException;

public class ElectricHeating extends Electricity
{
    private double temperature;
    private double maxPower;
    public ElectricHeating()
    {
        super(false,1000);
        setTemperature(0.0);
    }

    public ElectricHeating(boolean state, double powerRating, double temp)
    {
        super(state,powerRating);
        setTemperature(temp);
        this.maxPower=powerRating;
    }

    /**
     * Returns the temperature of the electric heater
     * @return temperature
     */
    public double getTemperature()
    {
        return temperature;
    }

    /**
     * Sets the temperature of the electric heater
     * if temperature is greater than 40 the temp will be fixed at 40
     * if temperature is less than 0 the temp will be fixed at 0
     * otherwise the temperature will just be returned.
     * @param temperature double temperature in celsius
     */
    public void setTemperature(double temperature)
    {
        if(temperature >40.0)
            this.temperature = 40;
        else if(temperature <0.0)
            this.temperature = 0;
        else
            this.temperature = temperature;
    }

    /**
     * get all the data about the electric heating
     * @return
     */
    public Object[] getAllData(){
       Object[] o = {"ElectricHeating", 60, getUsage(), " ", getConsumption(60),estimatedEmissions(60),getTemperature() };
        return o;
    }

    /**
     * Insert all the data about electric heating into database using a object[]
     * @param o
     * @throws SQLException
     *
     */
    public void InsertElectricHeatingData( Object[] o) throws SQLException {
        ControlSqlite cs = new ControlSqlite();
        cs.InsertData("ENERGYDATA", o);
        cs.DisplayTable();
        System.out.println("Insert successflly");
    }
}
