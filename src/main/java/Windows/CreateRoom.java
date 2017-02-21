package Windows;
import energyConsumers.*;
import javafx.event.EventHandler;
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
import java.text.DecimalFormat;
import java.util.ArrayList;

import java.util.LinkedList;
import java.sql.*;

/**
 * Created by daniel on 24/12/2016.
 */
public class CreateRoom
{

    private Stage window = new Stage();
    public static ArrayList<Object> energyConsumers = new ArrayList<>();
    public static Boolean penState = false;
    static BorderPane borderPane = new BorderPane();
    Scene scene = new Scene(borderPane,800,600);

    private Pane prefPane = new Pane();
    public static Pane canvas = new Pane();
    public static int count = 0;
    public static int currentSelected =0;
    public static Label infoLabel = new Label();
    public static Label distance = new Label();
    private Pane infoPane = new Pane();
    static LightPreferences lightPreferences = new LightPreferences();
    static HeatPreferences heatPreferences = new HeatPreferences();
    static WaterPreferences waterPreferences = new WaterPreferences();
    static double orgSceneX, orgSceneY;
    private static DecimalFormat df2 = new DecimalFormat("####0.##");

    //Room coords
    static LinkedList<Double> pointsX = new LinkedList<Double>();
    static LinkedList<Double> pointsY = new LinkedList<Double>();
    static LinkedList<Line> lines = new LinkedList<Line>();
    static Circle currentClick = new Circle();
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

    public static void update()
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

        borderPane.getChildren().add(currentClick);
        canvas.setOnMouseClicked(event ->
        {
            if(penState)
            {
                pointsX.add(event.getSceneX());
                pointsY.add(event.getSceneY());
                currentClick.setCenterX(event.getSceneX());
                currentClick.setCenterY(event.getSceneY());
                currentClick.setRadius(4.0f);
                drawLine();
            }
        });
        scene.getStylesheets().add(getClass().getResource("/Room.css").toExternalForm());

        scene.setOnMouseMoved(event -> {
            double coordx = event.getSceneX();
            double coordy = event.getSceneY();
            if(!pointsX.isEmpty())
            {
                System.out.println(pointsX.size());
                mouseLine.setStartX(pointsX.getLast());
                mouseLine.setStartY(pointsY.getLast());
                System.out.println(coordx + " " + coordy);
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
                borderPane.getChildren().add(temp);
            }
        }
    }

}
