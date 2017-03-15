package Windows;

import java.util.Random;

/**
 * Created by Matt on 15-Mar-17.
 */
public class simulation extends Room implements Runnable {
    @Override
    public void run() {

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
                Thread.sleep(1000);
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
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

}
