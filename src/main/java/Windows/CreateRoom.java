package Windows;
import energyConsumers.ElectricHeating;
import energyConsumers.Light;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import org.apache.commons.lang3.BooleanUtils;

import java.text.DecimalFormat;
import java.util.ArrayList;

import java.util.LinkedList;

/**
 * Created by daniel on 24/12/2016.
 */
public class CreateRoom
{

    private Stage window = new Stage();
    public static ArrayList<Light> lights = new ArrayList<Light>();
    public static ArrayList<ElectricHeating> electricHeatings = new ArrayList<>();
    Boolean penState = false;
    BorderPane borderPane = new BorderPane();
    private Pane prefPane = new Pane();
    private Pane canvas = new Pane();
    private int count = 0;
    private int heatCount = 0;
    public static int currentHeatingSelected =0;
    public static int currentSelected =0;
    private static Label infoLabel = new Label();
    private FlowPane infoPane = new FlowPane();
    LightPreferences lightPreferences = new LightPreferences();
    HeatPreferences heatPreferences = new HeatPreferences();
    double orgSceneX, orgSceneY;
    private static DecimalFormat df2 = new DecimalFormat("####0.##");

    //Room coords
    LinkedList<Double> pointsX = new LinkedList<Double>();
    LinkedList<Double> pointsY = new LinkedList<Double>();
    LinkedList<Line> lines = new LinkedList<Line>();
    Circle currentClick = new Circle();

    Button mouse = new Button("Mouse");
    Button pen = new Button("Pen");
    private ToolBar toolbar = new ToolBar();

    private void build()
    {
        Accordion accordion = new Accordion();
        Pane pane;
        TitledPane tiledPane;
        Lights light = new Lights();
        pane = light.getView();
        tiledPane = new TitledPane("Electric", pane);
        accordion.getPanes().add(tiledPane);
        accordion.setExpandedPane(tiledPane);
        borderPane.setLeft(accordion);
    }

    private ImageView drawLight()
    {
        int id = count;
        Image image = new Image("Images/bulb.png",50,50,false,false);
        ImageView imageView = new ImageView(image);
        imageView.setCursor(Cursor.HAND);
        imageView.setOnMousePressed(event ->
        {
            heatPreferences.setVisible(false);
            lightPreferences.setVisible(true);
            currentSelected = id;
            double powerRating = lights.get(id).getUsage();
            int lighState = BooleanUtils.toInteger(lights.get(id).getState());
            lightPreferences.powerRatingField.setText(String.valueOf(Double.parseDouble(String.valueOf(powerRating))));
            lightPreferences.stateCombo.getSelectionModel().select(lighState);
            orgSceneX = event.getSceneX();
            orgSceneY = event.getSceneY();
        });
        imageView.setOnMouseDragged(event ->
        {
            if((event.getX() >0 && event.getX() < canvas.getWidth()) && (event.getY() > 0 && event.getY() < canvas.getHeight()))
            {
                double offsetX = event.getSceneX() - orgSceneX;
                double offsetY = event.getSceneY() - orgSceneY;
                Object o = event.getSource();
                ImageView i = (ImageView) o;
                i.setX(i.getX() + offsetX);
                i.setY(i.getY() + offsetY);
                orgSceneX = event.getSceneX();
                orgSceneY = event.getSceneY();
            }
        });
        return imageView;
    }

    private ImageView drawHeater()
    {
        int id = heatCount;
        Image image = new Image("Images/heating.png",50,50,false,false);
        ImageView imageView = new ImageView(image);
        imageView.setCursor(Cursor.HAND);
        imageView.setOnMousePressed(event ->
        {
            currentHeatingSelected = id;
            heatPreferences.setVisible(true);
            lightPreferences.setVisible(false);
            heatPreferences.stateCombo.getSelectionModel().select(BooleanUtils.toInteger(electricHeatings.get(id).getState()));
            heatPreferences.powerRatingField.setText(Double.toString(electricHeatings.get(id).getUsage()));
            heatPreferences.tempField.setText(Double.toString(electricHeatings.get(id).getTemperature()));
            System.out.println(electricHeatings.get(id).getUsage());
            orgSceneX = event.getSceneX();
            orgSceneY = event.getSceneY();
        });
        imageView.setOnMouseDragged(event ->
        {
            if((event.getX() >0 && event.getX() < canvas.getWidth()) && (event.getY() > 0 && event.getY() < canvas.getHeight()))
            {
                double offsetX = event.getSceneX() - orgSceneX;
                double offsetY = event.getSceneY() - orgSceneY;
                Object o = event.getSource();
                ImageView i = (ImageView) o;
                i.setX(i.getX() + offsetX);
                i.setY(i.getY() + offsetY);
                orgSceneX = event.getSceneX();
                orgSceneY = event.getSceneY();
            }
        });
        return imageView;
    }

    public static void update()
    {
        double power,emmisions;
        power = emmisions = 0;
        for(int x =0; x<lights.size();x++)
        {
            System.out.println(lights.size() + " " + lights.get(x).getConsumption(60)); //converts watts into KW
            if(lights.get(x).getState())
            {
                power += lights.get(x).getConsumption(60);
                emmisions += lights.get(x).estimatedEmissions(60);
            }
        }
        for(int y = 0;y<electricHeatings.size();y++)
        {
            if(electricHeatings.get(y).getState())
            {
                power+= electricHeatings.get(y).getConsumption(60);
                emmisions+=electricHeatings.get(y).estimatedEmissions(60);
            }
        }
        infoLabel.setText("Power: " + df2.format(power) + " KwH" + " Emmisions:" + df2.format(emmisions) + "Kg/co2");
    }

    public void start() throws Exception
    {
        ListView list = new ListView();
        BorderPane.setAlignment(list, Pos.TOP_LEFT);
        BorderPane.setMargin(list, new Insets(12,12,12,12));
        mouse.setOnMouseClicked(e -> penState = false);
        pen.setOnMouseClicked(e -> penState = true);
        toolbar.getItems().addAll(mouse,pen);
        borderPane.setTop(toolbar);
        build();
        borderPane.setCenter(canvas);
        prefPane.getChildren().add(lightPreferences.init());
        prefPane.getChildren().add(heatPreferences.init());
        heatPreferences.setVisible(false);
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


        infoPane.getChildren().add(infoLabel);
        borderPane.setBottom(infoPane);
        Scene scene = new Scene(borderPane,800,600);
        scene.getStylesheets().add(getClass().getResource("/Room.css").toExternalForm());
        window.setScene(scene);
        window.show();
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

    class Lights
    {

        public Pane getView()
        {
            Pane p = new Pane();
            Button button = new Button("LED Bulb"); //probs should change to image view at a later date
            Button heatingButton = new Button("Heating");
            Button clearCanvas = new Button("Delete Room");
            heatingButton.setOnMouseClicked(event->
            {
                ImageView image = drawHeater();
                canvas.getChildren().add(image);
                electricHeatings.add(new ElectricHeating(true,1000,25));
                System.out.println(electricHeatings.get(heatCount).getUsage());
                heatCount++;
            });
            button.setOnMouseClicked(event ->{
                lights.add(new Light(true,100));
                ImageView image = drawLight();
                canvas.getChildren().add(image);
                count++;
                update();
            });
            clearCanvas.setOnMouseClicked(event ->{
                System.out.print("Hit");
                borderPane.getChildren().removeAll(lines);
                borderPane.getChildren().remove(currentClick);
                while (!pointsX.isEmpty()) {
                    pointsX.removeFirst();
                    pointsY.removeFirst();
                    lines.removeFirst();
                }
            });

            VBox vBox = new VBox(5);
            vBox.getChildren().addAll(button,heatingButton, clearCanvas);
            p.getChildren().addAll(vBox);
            return p;
        }

    }
    
}
