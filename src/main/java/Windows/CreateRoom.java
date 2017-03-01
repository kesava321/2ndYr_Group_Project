package Windows;
import energyConsumers.*;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import org.apache.commons.lang3.BooleanUtils;

import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;

import java.util.LinkedList;
import java.sql.*;

/**
 * Created by daniel on 24/12/2016.
 */
public class CreateRoom extends Room implements Serializable
{

    public Stage window = new Stage();
    public static Boolean penState = false;
    public BorderPane borderPane = new BorderPane();
    Scene scene = new Scene(borderPane,800,600);

    private Pane prefPane = new Pane();
    public static Pane canvas = new Pane();
    public static int count = 0;
    public static int currentSelected =0;
    public static Label infoLabel = new Label();
    public static Label distance = new Label();
    private Pane infoPane = new Pane();
    public static LightPreferences lightPreferences = new LightPreferences();
    public static HeatPreferences heatPreferences = new HeatPreferences();
    public static WaterPreferences waterPreferences = new WaterPreferences();
    public static double orgSceneX, orgSceneY;
    private static DecimalFormat df2 = new DecimalFormat("####0.##");
    public static DrawAppliance draw = new DrawAppliance();
    //Room coords
    public static LinkedList<Line> lines = new LinkedList<Line>();


    public static Circle currentClick = new Circle();
    public static Line mouseLine = new Line();

    private void build()
    {
        Accordion accordion = new Accordion();
        Pane electric,gas,water;
        TitledPane tiledPaneElectric,titledPaneGas,titledPaneWater;
        ElectricAccordion electricAccordion = new ElectricAccordion();
        electric = electricAccordion.getView();
        GasAccordion gasAccordion = new GasAccordion();
        gas = gasAccordion.getView();
        WaterAccordion waterAccordion = new WaterAccordion();
        water = waterAccordion.getView();
        tiledPaneElectric = new TitledPane("Electric", electric);
        titledPaneGas = new TitledPane("Gas",gas);
        titledPaneWater = new TitledPane("Water",water);
        accordion.getPanes().addAll(tiledPaneElectric,titledPaneGas,titledPaneWater);
        accordion.setExpandedPane(tiledPaneElectric);
        borderPane.setLeft(accordion);
    }

    public void update()
    {
        double power,emmisions;
        power = emmisions = 0;
        for(int x =0; x<energyConsumers.size();x++)
        {
            if(energyConsumers.get(x) != null)
            {
                Object temp = energyConsumers.get(x);
                if (temp instanceof Light)
                {
                    if (((Light) temp).getState())
                    {
                        power += ((Light) temp).getConsumption(60);
                        emmisions += ((Light) temp).estimatedEmissions(60);
                    }
                }
                else if (temp instanceof ElectricHeating)
                {
                    if (((ElectricHeating) temp).getState())
                    {
                        power += ((ElectricHeating) temp).getConsumption(60);
                        emmisions += ((ElectricHeating) temp).estimatedEmissions(60);
                    }
                }
                else if (temp instanceof GasHeating)
                {
                    if (((GasHeating) temp).getState())
                    {
                        power += ((GasHeating) temp).getConsumption(60);
                        emmisions = ((GasHeating) temp).estimatedEmissions(60);
                    }
                }
                else if(temp instanceof Toilet)
                {
                    if(((Toilet) temp).getState())
                    {
                        power += ((Toilet) temp).getConsumption(60);
                        emmisions = ((Toilet) temp).estimatedEmissions(60);
                    }
                }
                else if(temp instanceof Sink)
                {
                    if(((Sink) temp).getState())
                    {
                        power += ((Sink) temp).getConsumption(60);
                        emmisions = ((Sink) temp).estimatedEmissions(60);
                    }
                }
                else
                    System.out.println("WHY THO " + temp.getClass());
            }

        }
        infoLabel.setText("Power: " + df2.format(power) + " KwH" + " Emmisions:" + df2.format(emmisions) + "Kg/co2");
    }

    public void start() throws Exception
    {
        addRoom();
        ListView list = new ListView();
        BorderPane.setAlignment(list, Pos.TOP_LEFT);
        BorderPane.setMargin(list, new Insets(12,12,12,12));
        infoPane.getChildren().addAll(distance,infoLabel);

        TopBar topBar = new TopBar();
        borderPane.setTop(topBar.build());

        build();
        borderPane.setCenter(canvas);
        prefPane.getChildren().add(lightPreferences.init());
        prefPane.getChildren().add(heatPreferences.init());
        prefPane.getChildren().add(waterPreferences.init()); //k
        lightPreferences.setVisible(false);
        heatPreferences.setVisible(false);
        waterPreferences.setVisible(false); //k
        borderPane.setRight(prefPane);

        canvas.getChildren().add(currentClick);
        canvas.setOnMouseClicked(event ->
        {
            if(penState)
            {
                Bounds boundsInScene = canvas.localToScene(canvas.getBoundsInLocal());
                pointsX.add(event.getSceneX() - boundsInScene.getMinX());
                pointsY.add(event.getSceneY() - boundsInScene.getMinY());
                currentClick.setCenterX(event.getSceneX() - boundsInScene.getMinX());
                currentClick.setCenterY(event.getSceneY() - boundsInScene.getMinY());
                currentClick.setRadius(4.0f);
                drawLine();
            }
        });
        scene.getStylesheets().add(getClass().getResource("/Room.css").toExternalForm());

        scene.setOnMouseMoved(event -> {
            Bounds boundsInScene = canvas.localToScene(canvas.getBoundsInLocal());
            double coordx = event.getSceneX() -boundsInScene.getMinX();
            double coordy = event.getSceneY()- boundsInScene.getMinY();
            if(!pointsX.isEmpty())
            {
                mouseLine.setStartX(pointsX.getLast());
                mouseLine.setStartY(pointsY.getLast());
                mouseLine.setEndX(coordx-1);
                mouseLine.setEndY(coordy-1);
                distance.setText(df2.format(trackLength(coordx, coordy)/10) + "m");
            }

        });
        scene.setOnKeyPressed(event ->
        {
            if(event.getCode() == KeyCode.BACK_SPACE && !penState)
            {
                System.out.println(currentSelected);
                if(energyConsumers.get(currentSelected) != null)
                    canvas.getChildren().remove(currentSelected);
                energyConsumers.set(currentSelected,null);
            }
        });
        borderPane.setBottom(infoPane);
        mouseLine.setStyle("-fx-stroke: red;");
        //prefPane.getStyleClass().add("left-line");
        window.setScene(scene);
        window.show();
    }

    private double trackLength(double coordx, double coordy) {
        double currentX = coordx;
        double currentY = coordy;
        double lastLocX = 0, lastLocY = 0;
        if (pointsX.size()>0){
            lastLocX = pointsX.getLast();
            lastLocY = pointsY.getLast();
        }
        double distance = Math.sqrt((currentX-lastLocX)*(currentX-lastLocX) + (currentY-lastLocY)*(currentY-lastLocY));
        return distance;
    }

    private double trackArea(){
        double area = 0;
        double RS = 0; // refers to right side of multiplication e.g. (x0*y1)+(x1*y2)+(x2*y3)...
        double LS = 0; // refers to left side of multiplication e.g. (y0*x1)+(y1*x2)+(y2*x3)...
        for (int i = 0; i < pointsX.size()-2; i++) { // ignores last set of coordinates assumes last point is equal to first
            RS = RS + (pointsX.get(i) * pointsY.get(i+1));
            LS = LS + (pointsY.get(i) * pointsX.get(i+1));
        }
        RS = RS + (pointsX.get(pointsX.size()-2)) * pointsY.getFirst();
        LS = LS + (pointsY.get(pointsY.size()-2)) * pointsX.getFirst();
        area = (RS - LS)/2;
        System.out.println("area = " + area);
        return area;
    }


    public void drawLine(){
        System.out.println(penState);
        if (pointsX.size()<1){
            return;
        }
        else {
            for (int i = 0; i < pointsX.size() - 1; i++) {
                Line temp = new Line(pointsX.get(i), pointsY.get(i), pointsX.get(i + 1), pointsY.get(i + 1));
                // temp.draw();
                lines.add(temp);
                //borderPane.getChildren().add(temp);
                canvas.getChildren().add(temp);
            }
        }
    }

    public void reload()
    {
        count = 0;
        canvas.getChildren().clear();
        canvas.getChildren().removeAll(lines);
        lines.clear();
        lightPreferences.setVisible(false);
        heatPreferences.setVisible(false);
        waterPreferences.setVisible(false);
        for(int x  =0; x<energyConsumers.size();x++)
        {
            Object temp = energyConsumers.get(x);
            ImageView image;
            if(temp instanceof Light)
            {
                image = draw.drawLight();
                image.setX(((Light) temp).getX());
                image.setY(((Light) temp).getY());
                canvas.getChildren().add(image);
            }
            else if(temp instanceof ElectricHeating)
            {
                image = draw.drawHeater();
                image.setX(((ElectricHeating) temp).getX());
                image.setY(((ElectricHeating) temp).getY());
                canvas.getChildren().add(image);
            }
            else if(temp instanceof GasHeating)
            {
                image = draw.drawGasHeater();
                image.setX(((GasHeating) temp).getX());
                image.setY(((GasHeating) temp).getY());
                canvas.getChildren().add(image);
            }
            else if(temp instanceof Sink)
            {
                image = draw.drawTap();
                image.setX(((Sink) temp).getX());
                image.setY(((Sink) temp).getY());
                canvas.getChildren().add(image);
            }
            else if(temp instanceof Toilet)
            {
                image = draw.drawToilet();
                image.setX(((Toilet) temp).getX());
                image.setY(((Toilet) temp).getY());
                canvas.getChildren().add(image);
            }
            else
                System.out.println("Probs worth implementing that" +temp.getClass());
            count++;
        }
        drawLine();
        /*for(int y =0;y<pointsX.size()-1;y++)
        {
            Line temp = new Line(pointsX.get(y), pointsY.get(y), pointsX.get(y + 1), pointsY.get(y + 1));
            lines.add(temp);
            borderPane.getChildren().add(temp);
        }*/
    }

}
