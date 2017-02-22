package Windows;

import javafx.scene.shape.Line;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
    public static LinkedList<Line> lines = new LinkedList<Line>();

    

    public void save()
    {

    }
}
