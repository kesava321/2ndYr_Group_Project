package Windows;

import energyConsumers.ElectricHeating;
import energyConsumers.Electricity;
import energyConsumers.GasHeating;
import energyConsumers.Light;
import graphs.XYLineChart_AWT;
import org.jfree.ui.RefineryUtilities;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * This class is designed to return information based on a simulation, where the
 * information given relates to each of the different types of energyConsumers
 * (Electric, Gas, Water). It is a subclass of the Room class that simulates
 * energy consumers within a room and represents the data as a graph (see XYLineChart_AWT class).
 * Created by Matt on 15-Mar-17.
 */
public class simulation extends Room implements Runnable {
    private int time;
    private int timeperiod =5;
    int timeIntervals = time/timeperiod;
    ArrayList<Double> gasUsage = new ArrayList<Double>();
    double totalGas = 0;
    double gasCost = 0.16;
    ArrayList<Double> electricityUsage = new ArrayList<Double>();
    ArrayList<Double> heating = new ArrayList<>();
    ArrayList<Double> lightUsage = new ArrayList<Double>();
    ArrayList<Double> heatingUsage = new ArrayList<Double>();
    double totalElectricity =0;
    double electricityCost = 0.13;
    double toiletsFlushed = 0;
    double co2Cons = 0;
    private int season;
    @Override
    public void run() {
        timeIntervals = time/5;
        for (int i = 0; i<timeIntervals; i++) {
             //System.out.println(roomAttributes.currentRoomOccupancy);
            generateOccupants();
            simulateHeating();
            simulateWeatherInfluence();
            simulateElectricity();
            //sumCons();
        }
        calcTotals();
        printUsage();
        for(int x =0;x<time/5;x++) {
            gasUsage.add(0.0);
            heatingUsage.add(0.0);
            lightUsage.add(0.0);
        }

        XYLineChart_AWT chart = new XYLineChart_AWT("Energy Usage Statistics", "Current Energy Consumption Within Building",electricityUsage, lightUsage,heatingUsage,gasUsage);
        chart.pack( );
        RefineryUtilities.centerFrameOnScreen( chart );
        chart.setVisible( true );
    }
/*
    private void sumCons() {
        double gas = 0;
        double elec =0;
        for (int i = 0; i<energyConsumers.size();i++){
            if (energyConsumers.get(i) != null) {
                if (energyConsumers.get(i) instanceof Light) {
                    elec += ((Light) energyConsumers.get(i)).getConsumption(timeperiod);
                } else if (energyConsumers.get(i) instanceof ElectricHeating) {
                    elec += ((ElectricHeating) energyConsumers.get(i)).getConsumption(timeperiod);
                } else if (energyConsumers.get(i) instanceof GasHeating) {
                    gas += ((GasHeating) energyConsumers.get(i)).getConsumption(timeperiod);
                }
            }
        }
        electricityUsage.add(elec);
        gasUsage.add(gas);
    }*/


    private void simulateElectricity() {
        double temp = 0;
        Random rn = new Random();
        int tempRandom;
        double tempPower;
        double temp2;
        double light = 0;
        double heating = 0;
        if (getCurrentRoomOccupancy()==0){
            //turn lights off
            //Access heating elements and set them to on/true
            for(int x = 0; x<energyConsumers.size();x++)
            {
                if (energyConsumers.get(x) != null) {
                    if (energyConsumers.get(x) instanceof Light) {
                        //((Light) energyConsumers.get(x)).setState(false);
                        tempRandom =rn.nextInt(4);
                        if(tempRandom==1)
                            ((Light) energyConsumers.get(x)).setState(false);
                            //temp += ((Light) energyConsumers.get(x)).getConsumption(timeperiod)*100;
                    }
                    else if(energyConsumers.get(x) instanceof ElectricHeating)
                    {
                        temp += ((ElectricHeating) energyConsumers.get(x)).getConsumption(timeperiod) * 10;
                    }

                }
            }
            electricityUsage.add(temp);
        }
        else
        {

            for(int x = 0; x<energyConsumers.size();x++)
            {
                if (energyConsumers.get(x) != null)
                {
                    if (energyConsumers.get(x) instanceof Light)
                    {
                        if(((Light) energyConsumers.get(x)).getState())
                        {
                            temp += ((Light) energyConsumers.get(x)).getConsumption(timeperiod) * 100;
                        }
                        ((Light) energyConsumers.get(x)).setState(true);
                    }
                    else if(energyConsumers.get(x) instanceof ElectricHeating)
                    {
                        ((ElectricHeating) energyConsumers.get(x)).setState(true);
                        tempPower =((ElectricHeating) energyConsumers.get(x)).getConsumption(timeperiod)*10;
                        temp2 = 0;
                        switch(season)
                        {
                            case 1: //summer
                                temp2 = ThreadLocalRandom.current().nextDouble(tempPower*0.2,tempPower*0.5);
                                break;
                            case 2://autumn
                                temp2 = ThreadLocalRandom.current().nextDouble(tempPower*0.3,tempPower*0.5);
                                break;
                            case 3://winter
                                temp2 = ThreadLocalRandom.current().nextDouble(tempPower*0.5,tempPower);
                                break;
                            case 4:
                                temp2 = ThreadLocalRandom.current().nextDouble(tempPower*0.3,tempPower*0.5);
                                break;

                        }
                       // temp2 = ThreadLocalRandom.current().nextDouble(tempPower*0.5,tempPower);
                        temp+= temp2;
                    }
                }
            }
            electricityUsage.add(temp);
        }
    }

    public simulation(int time,int season) {
        this.time = time;
        this.season=season;
    }

    public void generateOccupants() {

        int temp = roomAttributes.roomCapacity / roomAttributes.activityLevel;
        Random rand = new Random();
        setCurrentRoomOccupancy(rand.nextInt(temp));
    }

    public void simulateHeating() {
        if (roomAttributes.currentTemperature > roomAttributes.optimalTemperature + 2) {
            //Getting too high/hot
            //Access heating elements and set them to off/false
            for(int x = 0; x<energyConsumers.size();x++)
            {
                if(energyConsumers.get(x)  != null)
                {
                    if (energyConsumers.get(x) instanceof ElectricHeating)
                    {
                        ((ElectricHeating) energyConsumers.get(x)).setState(false);
                    }
                }
                heating.add(0.0);
            }
            //roomAttributes.currentTemperature++;
        } else if (roomAttributes.currentTemperature > roomAttributes.optimalTemperature - 2) {
            //Do Nothing - In a good range
            heating.add(0.0);
            //roomAttributes.currentTemperature = roomAttributes.currentTemperature -1;
        } else {
            //Temperature is too low
            //Access heating elements and set them to on/true
            for(int x = 0; x<energyConsumers.size();x++)
            {
                double temp = 0;
                if (energyConsumers.get(x) != null)
                {
                    if (energyConsumers.get(x) instanceof ElectricHeating)
                    {
                        ((ElectricHeating) energyConsumers.get(x)).setState(true);
                        //electricityUsage.add(((ElectricHeating) energyConsumers.get(x)).getConsumption(5));
                        roomAttributes.currentTemperature+=2;
                        temp+=((ElectricHeating) energyConsumers.get(x)).getConsumption(timeperiod);
                    }
                }
                heating.add(temp);
            }
        }
    }

    public void simulateWeatherInfluence() {
        double differenceInCurrentAndOutside = roomAttributes.currentTemperature - outsideTemperature;
        if(differenceInCurrentAndOutside>10)
        {
            if (roomAttributes.currentTemperature < outsideTemperature)
            {
                roomAttributes.currentTemperature = roomAttributes.currentTemperature + 2;
            } else
            {
                roomAttributes.currentTemperature = roomAttributes.currentTemperature - 2;
            }
        }
        else
        {
            if (roomAttributes.currentTemperature < outsideTemperature)
            {
                roomAttributes.currentTemperature = roomAttributes.currentTemperature + (roomAttributes.insulationLevel / 4);
            } else
            {
                roomAttributes.currentTemperature = roomAttributes.currentTemperature - (roomAttributes.insulationLevel / 4);
            }
        }
    }

    private void calcTotals(){
        for (int i =0; i < gasUsage.size(); i++) {
            totalGas = totalGas + gasUsage.get(i);
            totalElectricity = totalElectricity + electricityUsage.get(i);
        }
    }

    private void printUsage(){
        System.out.printf("Gas used %f", totalGas);
        System.out.printf("Gas cost %f", totalGas*gasCost);
        System.out.printf("Electricity used %f", totalElectricity);
        System.out.printf("Electricity Cost %f", Electricity.calculateCost(totalElectricity,electricityCost));
        System.out.printf("Toilets flushed %f", toiletsFlushed);
        System.out.printf("Co2 Consumption %f", co2Cons);
    }
}
