package Windows;

import energyConsumers.ElectricHeating;
import energyConsumers.GasHeating;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Matt on 15-Mar-17.
 */
public class simulation extends Room implements Runnable {
    private int time;
    int timeIntervals = time/5;
    ArrayList<Double> gasUsage = new ArrayList<Double>();
    double totalGas = 0;
    double gasCost = 0.16;
    ArrayList<Double> electricityUsage = new ArrayList<Double>();
    double totalElectricity =0;
    double electricityCost = 0.13;
    double toiletsFlushed = 0;
    double co2Cons = 0;

    @Override
    public void run() {
        timeIntervals = time/5;
        for (int i = 0; i<timeIntervals; i++) {
            generateOccupants();
            System.out.println(roomAttributes.currentTemperature);
            simulateHeating();
            simulateWeatherInfluence();
            simulateLighting();
        }
        printUsage();
    }

    private void simulateLighting() {
        if (getCurrentRoomOccupancy()==0){
            //turn lights off
            
        }
    }

    public simulation(int time) {
        this.time = time;
    }

    public void generateOccupants() {

        int temp = roomAttributes.roomCapacity / roomAttributes.activityLevel;
        Random rand = new Random();
        setCurrentRoomOccupancy(rand.nextInt(temp) + 1);
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
                    else if(energyConsumers.get(x) instanceof GasHeating)
                    {
                        ((GasHeating) energyConsumers.get(x)).setState(false);
                    }
                }
            }
            roomAttributes.currentTemperature = roomAttributes.currentTemperature +1;
        } else if (roomAttributes.currentTemperature > roomAttributes.optimalTemperature - 2) {
            //Do Nothing - In a good range
            roomAttributes.currentTemperature = roomAttributes.currentTemperature -1;
        } else {
            //Temperature is too low
            //Access heating elements and set them to on/true
            for(int x = 0; x<energyConsumers.size();x++)
            {
                if (energyConsumers.get(x) != null)
                {
                    if (energyConsumers.get(x) instanceof ElectricHeating)
                    {
                        ((ElectricHeating) energyConsumers.get(x)).setState(true);
                        electricityUsage.add(((ElectricHeating) energyConsumers.get(x)).getConsumption(5));
                    } else if (energyConsumers.get(x) instanceof GasHeating)
                    {
                        ((GasHeating) energyConsumers.get(x)).setState(true);
                        gasUsage.add(((GasHeating) energyConsumers.get(x)).getConsumption(5));
                    }
                }
            }
        }
    }

    public void simulateWeatherInfluence() {
        double differenceInCurrentAndOutside = roomAttributes.currentTemperature - outsideTemperature;
        if (roomAttributes.currentTemperature < outsideTemperature) {
            roomAttributes.currentTemperature = roomAttributes.currentTemperature + roomAttributes.insulationLevel;
        } else {
            roomAttributes.currentTemperature = roomAttributes.currentTemperature - roomAttributes.insulationLevel;
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
        System.out.printf("Electricity Cost %f", totalElectricity*electricityCost);
        System.out.printf("Toilets flushed %f", toiletsFlushed);
        System.out.printf("Co2 Consumption %f", co2Cons);
    }
}
