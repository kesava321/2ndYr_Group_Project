package Windows;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;


/**
 * The Room class manages all instances that relate to a created room. The class maintains and manages
 * an array of features which include: saving a room, loading a room, setting a room or simulating
 * a room. When saving, loading or setting a room, a room's attributes and energyConsumers are stored
 * so that they can later be retrieved. When simulating a room, a room is initially given a set of
 * default parameters such as it's capacity, that can be changed.
 * Created by daniel on 22/02/2017.
 */
public class Room implements Serializable {
    public static int HIGH = 1;
    public static int MEDIUM = 2;
    public static int LOW = 3;

    public static boolean simulate = false;

    public static double outsideTemperature = 25.0;

    static class RoomAttributes implements Serializable {
        int roomCapacity = 20; //DEFAULT
        int currentRoomOccupancy = 50; //DEFAULT
        int activityLevel = MEDIUM; //DEFAULT
        int insulationLevel = MEDIUM;

        double currentTemperature = 25.0; //default
        double optimalTemperature = 30.0; //default
    }

    RoomAttributes roomAttributes = new RoomAttributes();
    public static int currentRoom = 0;
    public static int roomCount = 0;
    private static ArrayList<Object[]> rooms = new ArrayList<>();

    public static ArrayList<Object> energyConsumers = new ArrayList<>();

    private static ArrayList<LinkedList<Double>[]> points = new ArrayList<>();
    public static LinkedList<Double> pointsX = new LinkedList<>();
    public static LinkedList<Double> pointsY = new LinkedList<>();


    public void save() throws IOException {
        URL urlEnergyConsumer = this.getClass().getResource("/energyConsumers.ser");
        URL urlPoints = this.getClass().getResource("/points.ser");

        FileOutputStream fosEnergyConsumer = null;
        FileOutputStream fosPoints = null;
        try {
            fosEnergyConsumer = new FileOutputStream(urlEnergyConsumer.toURI().getPath());
            fosPoints = new FileOutputStream(urlPoints.toURI().getPath());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        ObjectOutput oosEnergyConsumer = new ObjectOutputStream(fosEnergyConsumer);
        ObjectOutput oosPoints = new ObjectOutputStream(fosPoints);

        //saves current room
        saveRoom();
        savePoints();
        oosEnergyConsumer.writeObject(rooms);
        oosPoints.writeObject(points);

        oosEnergyConsumer.close();
        oosPoints.close();
    }

    public void load() throws IOException, URISyntaxException, ClassNotFoundException {
        URL urlEnergyConsumer = this.getClass().getResource("/energyConsumers.ser");
        URL urlPoints = this.getClass().getResource("/points.ser");

        FileInputStream finEnergyConsumer = new FileInputStream(urlEnergyConsumer.toURI().getPath());
        FileInputStream finPoints = new FileInputStream(urlPoints.toURI().getPath());

        ObjectInputStream oisEnergyConsumer = new ObjectInputStream(finEnergyConsumer);
        ObjectInputStream oisPoints = new ObjectInputStream(finPoints);

        energyConsumers.clear();
        rooms.clear();
        rooms = (ArrayList<Object[]>) oisEnergyConsumer.readObject();
        energyConsumers = (ArrayList<Object>) rooms.get(0)[0];
        roomAttributes = (RoomAttributes) rooms.get(0)[1];
        points.clear();
        points = (ArrayList<LinkedList<Double>[]>) oisPoints.readObject();
        pointsX = points.get(0)[0];
        pointsY = points.get(0)[1];

        oisEnergyConsumer.close();
        oisPoints.close();
    }

    public void setRoom(int room) {
        savePoints();
        pointsX = points.get(room)[0];
        pointsY = points.get(room)[1];
        saveRoom();
        energyConsumers = (ArrayList<Object>) rooms.get(room)[0];
        roomAttributes = (RoomAttributes) rooms.get(room)[1];
        currentRoom = room;
    }

    public void addRoom() {
        points.add(new LinkedList[2]);
        rooms.add(new ArrayList[2]);
        roomCount++;
        saveRoom();
        savePoints();
        currentRoom = roomCount - 1;
        energyConsumers = new ArrayList<>();
        pointsX = new LinkedList<>();
        pointsY = new LinkedList<>();
        roomAttributes = new RoomAttributes();
    }

    private void saveRoom() {
        Object[] temp = new Object[2];
        temp[0] = energyConsumers;
        temp[1] = roomAttributes;
        rooms.set(currentRoom, temp);
    }

    private void savePoints() {
        LinkedList<Double> temp[] = new LinkedList[2];
        temp[0] = pointsX;
        temp[1] = pointsY;
        points.set(currentRoom, temp);
    }

    public void simulate(int time,int season){
        simulation sim = new simulation(time);
        Thread t = new Thread(sim);
        t.start();
    }


    public int getRoomCapacity() {
        return roomAttributes.roomCapacity;
    }

    public int getCurrentRoomOccupancy() {
        return roomAttributes.currentRoomOccupancy;
    }

    public void setCurrentRoomOccupancy(int x) {
        roomAttributes.currentRoomOccupancy = x;
    }

    public void setRoomCapacity(int x) {
        roomAttributes.roomCapacity = x;
    }

    public void setActivityLevel(int x) {
        if (x <= 3 || x > 0) {
            roomAttributes.activityLevel = x;
        } else {
            roomAttributes.activityLevel = MEDIUM;
        }
    }
}