package Windows;

import energyConsumers.Light;
import javafx.scene.shape.Line;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by daniel on 22/02/2017.
 */
public class Room
{
    public static ArrayList<Object> energyConsumers = new ArrayList<>();

    public static LinkedList<Double> pointsX = new LinkedList<Double>();
    public static LinkedList<Double> pointsY = new LinkedList<Double>();

    public void save()throws IOException
    {
        URL urlEnergyConsumer  = this.getClass().getResource("/energyConsumers.ser");
        URL urlPointsX  = this.getClass().getResource("/pointsX.ser");
        URL urlPointsY  = this.getClass().getResource("/pointsY.ser");

        FileOutputStream fosEnergyConsumer = null;
        FileOutputStream fosPointsX = null;
        FileOutputStream fosPointsY = null;
        try
        {
            fosEnergyConsumer = new FileOutputStream(urlEnergyConsumer.toURI().getPath());
            fosPointsX = new FileOutputStream(urlPointsX.toURI().getPath());
            fosPointsY = new FileOutputStream(urlPointsY.toURI().getPath());
        } catch (URISyntaxException e)
        {
            e.printStackTrace();
        }

        ObjectOutput oosEnergyConsumer = new ObjectOutputStream(fosEnergyConsumer);
        ObjectOutput oosPointsX = new ObjectOutputStream(fosPointsX);
        ObjectOutput oopPointsY = new ObjectOutputStream(fosPointsY);

        oosEnergyConsumer.writeObject(energyConsumers);
        oosPointsX.writeObject(pointsX);
        oopPointsY.writeObject(pointsY);

        oosEnergyConsumer.close();
        oosPointsX.close();
        oopPointsY.close();
    }

    public void load() throws IOException, URISyntaxException, ClassNotFoundException
    {
        URL urlEnergyConsumer  = this.getClass().getResource("/energyConsumers.ser");
        URL urlPointsX  = this.getClass().getResource("/pointsX.ser");
        URL urlPointsY  = this.getClass().getResource("/pointsY.ser");

        FileInputStream finEnergyConsumer = new FileInputStream(urlEnergyConsumer.toURI().getPath());
        /*FileInputStream finPointsX = new FileInputStream(urlPointsX.toURI().getPath());
        FileInputStream finPointsY = new FileInputStream(urlPointsY.toURI().getPath());*/

        ObjectInputStream oisEnergyConsumer = new ObjectInputStream(finEnergyConsumer);
        /*ObjectInputStream oisPointsX = new ObjectInputStream(finPointsX);
        ObjectInputStream oisPointsY = new ObjectInputStream(finPointsY);*/


        energyConsumers.clear();
        energyConsumers = (ArrayList<Object>) oisEnergyConsumer.readObject();

       /* pointsX.clear();
        pointsX = (LinkedList<Double>) oisPointsX.readObject();

        pointsY.clear();
        pointsY = (LinkedList<Double>) oisPointsY.readObject();*/

        oisEnergyConsumer.close();
       /* oisPointsX.close();
        oisPointsY.close();*/
    }

}
