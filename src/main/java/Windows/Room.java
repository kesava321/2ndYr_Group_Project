package Windows;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;


/**
 * Created by daniel on 22/02/2017.
 */
public class Room implements Serializable
{
    public static int HIGH = 1;
    public static int MEDIUM = 2;
    public static int LOW = 3;

    private int roomCapacity = 100; //DEFAULT
    private int currentRoomOccupancy = 50; //DEFAULT
    private int activityLevel = MEDIUM; //DEFAULT

    public static int currentRoom = 0;
    public static int roomCount = 0;
    private static ArrayList<Object> rooms = new ArrayList<>();

    public static ArrayList<Object> energyConsumers = new ArrayList<>();

    private static ArrayList<LinkedList<Double>[]> points = new ArrayList<>();
    public static LinkedList<Double> pointsX = new LinkedList<>();
    public static LinkedList<Double> pointsY = new LinkedList<>();


    public void save()throws IOException
    {
        URL urlEnergyConsumer  = this.getClass().getResource("/energyConsumers.ser");
        URL urlPoints  = this.getClass().getResource("/points.ser");

        FileOutputStream fosEnergyConsumer = null;
        FileOutputStream fosPoints = null;
        try
        {
            fosEnergyConsumer = new FileOutputStream(urlEnergyConsumer.toURI().getPath());
            fosPoints = new FileOutputStream(urlPoints.toURI().getPath());
        } catch (URISyntaxException e)
        {
            e.printStackTrace();
        }

        ObjectOutput oosEnergyConsumer = new ObjectOutputStream(fosEnergyConsumer);
        ObjectOutput oosPoints = new ObjectOutputStream(fosPoints);

        //saves current room
        rooms.set(currentRoom,energyConsumers);
        savePoints();
        oosEnergyConsumer.writeObject(rooms);
        oosPoints.writeObject(points);

        oosEnergyConsumer.close();
        oosPoints.close();
    }

    public void load() throws IOException, URISyntaxException, ClassNotFoundException
    {
        URL urlEnergyConsumer  = this.getClass().getResource("/energyConsumers.ser");
        URL urlPoints  = this.getClass().getResource("/points.ser");

        FileInputStream finEnergyConsumer = new FileInputStream(urlEnergyConsumer.toURI().getPath());
        FileInputStream finPoints = new FileInputStream(urlPoints.toURI().getPath());

        ObjectInputStream oisEnergyConsumer = new ObjectInputStream(finEnergyConsumer);
        ObjectInputStream oisPoints = new ObjectInputStream(finPoints);

        energyConsumers.clear();
        rooms.clear();
        rooms = (ArrayList<Object>) oisEnergyConsumer.readObject();
        energyConsumers = (ArrayList<Object>)rooms.get(0);
        points.clear();
        points = (ArrayList<LinkedList<Double>[]>)oisPoints.readObject();
        pointsX = points.get(0)[0];
        pointsY = points.get(0)[1];



        oisEnergyConsumer.close();
        oisPoints.close();
    }

    public void setRoom(int room)
    {
        savePoints();
        pointsX = points.get(room)[0];
        pointsY = points.get(room)[1];
        rooms.set(currentRoom,energyConsumers);
        energyConsumers = (ArrayList<Object>)rooms.get(room);
        currentRoom = room;
    }

    public void addRoom()
    {
        points.add(new LinkedList[2]);
        rooms.add(new ArrayList<>());
        roomCount++;
        rooms.set(currentRoom,energyConsumers);
        savePoints();
        currentRoom = roomCount-1;
        energyConsumers = new ArrayList<>();
        pointsX = new LinkedList<>();
        pointsY = new LinkedList<>();
    }

    public void generateOccupants(){
        int temp = roomCapacity/activityLevel;
        Random rand = new Random();
        setCurrentRoomOccupancy(rand.nextInt(temp) + 1);
    }

    private void savePoints()
    {
        LinkedList<Double> temp[] = new LinkedList[2];
        temp[0] = pointsX;
        temp[1] = pointsY;
        points.set(currentRoom,temp);
    }

    public int getRoomCapacity(){
        return roomCapacity;
    }

    public int getCurrentRoomOccupancy(){
        return currentRoomOccupancy;
    }

    public void setCurrentRoomOccupancy(int x){
        currentRoomOccupancy = x;
    }

    public void setRoomCapacity(int x){
        roomCapacity = x;
    }

    public void setActivityLevel(int x){
        if (x>3|| x<0) {
            activityLevel = x;
        }
        else{
            activityLevel = MEDIUM;
        }
    }
}
