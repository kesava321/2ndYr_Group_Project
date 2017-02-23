package Windows;

import energyConsumers.Light;
import javafx.scene.shape.Line;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
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
    public static LinkedList<Line> lines = new LinkedList<Line>(); //probs should move that back to CreateRoom


    public void save()throws IOException
    {
        URL url = this.getClass().getResource("/test.txt");
        System.out.println(url.getFile());
        FileOutputStream fos = null;
        try
        {
            fos = new FileOutputStream(url.toURI().getPath());
        } catch (URISyntaxException e)
        {
            e.printStackTrace();
        }
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(energyConsumers);
        oos.close();
    }

}
