package Windows;

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
            simulateHeating();
            simulateWeatherInfluence();
        }
        printUsage();
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
        while (simulate = true) {
            if (roomAttributes.currentTemperature > roomAttributes.optimalTemperature + 2) {
                //Getting too high/hot
                //Access heating elements and set them to off/false
                roomAttributes.currentTemperature = roomAttributes.currentTemperature +1;
                break;
            } else if (roomAttributes.currentTemperature > roomAttributes.optimalTemperature - 2) {
                //Do Nothing - In a good range
                roomAttributes.currentTemperature = roomAttributes.currentTemperature -1;
            } else {
                //Temperature is too low
                //Access heating elements and set them to on/true
            }

            try {
            //    Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void simulateWeatherInfluence() {
        double differenceInCurrentAndOutside = roomAttributes.currentTemperature - outsideTemperature;

        while (simulate) {
            if (roomAttributes.currentTemperature < outsideTemperature) {
                roomAttributes.currentTemperature = roomAttributes.currentTemperature + roomAttributes.insulationLevel;
            } else {
                roomAttributes.currentTemperature = roomAttributes.currentTemperature - roomAttributes.insulationLevel;
            }

            try {
            //    Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
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
        System.out.printf("Electricity Cost %f", totalElectricity*electricityCost);
        System.out.printf("Toilets flushed %f", toiletsFlushed);
        System.out.printf("Co2 Consumption %f", co2Cons);
    }
}
