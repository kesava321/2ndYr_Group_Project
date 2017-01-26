package Windows;
import energyConsumers.Light;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.apache.commons.lang3.BooleanUtils;

import java.util.ArrayList;

/**
 * Created by daniel on 24/12/2016.
 */
public class CreateRoom
{

    private Stage window = new Stage();
    public ArrayList<Light> lights = new ArrayList<Light>();
    BorderPane borderPane = new BorderPane();
    private StackPane prefPane = new StackPane();
    private Pane canvas = new Pane();
    private int count = 0;
    private int heatCount = 0;
    private int currentHeatingSelected =0;
    private int currentSelected =0;
    LightPreferences lightPreferences = new LightPreferences();
    HeatPreferences heatPreferences = new HeatPreferences();
    double orgSceneX, orgSceneY;

    private ToolBar toolbar = new ToolBar(
            new Button("Mouse"),
            new Button("Pen")
    );

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


    private void controlPref(int controller)
    {
        switch(controller)
        {
            case 1:
            {

            }
        }
    }

    private ImageView drawLight()
    {
        int id = count;
        Image image = new Image("Images/bulb.png",50,50,false,false);
        ImageView imageView = new ImageView(image);
        imageView.setCursor(Cursor.HAND);
        imageView.setOnMousePressed(event ->
        {
            prefPane.toFront();
            currentSelected = id;
            double powerRating = lights.get(id).getUsage();
            int lighState = BooleanUtils.toInteger(lights.get(id).getState());
            System.out.println(String.valueOf(Double.parseDouble(String.valueOf(powerRating))));
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

    public void start() throws Exception
    {
        ListView list = new ListView();
        BorderPane.setAlignment(list, Pos.TOP_LEFT);
        BorderPane.setMargin(list, new Insets(12,12,12,12));
        borderPane.setTop(toolbar);
        build();
        prefPane.getChildren().add(lightPreferences.init());
        lights.add(new Light(true,100));
        borderPane.setCenter(canvas);
        borderPane.setRight(prefPane);
        Scene scene = new Scene(borderPane,800,600);
        window.setScene(scene);
        window.show();
    }

    class LightPreferences
    {
        Pane pane = new Pane();
        Label state = new Label("Light State");
        ComboBox stateCombo = new ComboBox();
        Label powerRating = new Label("Power Rating");
        TextField powerRatingField = new TextField();
        GridPane grid = new GridPane();
        public Pane init()
        {
            stateCombo.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
            {
                boolean state = BooleanUtils.toBoolean(stateCombo.getSelectionModel().getSelectedIndex());
                System.out.println(currentSelected + " " + state);
                lights.get(currentSelected).setState(state);
                System.out.println(lights.get(currentSelected).getState());
            });
            powerRatingField.textProperty().addListener((observable, oldValue, newValue) -> {
                lights.get(currentSelected).setUsage(Double.parseDouble(newValue));
            });
            stateCombo.getItems().addAll("Off","On");
            grid.setConstraints(state,0,0);
            grid.setConstraints(stateCombo,1,0);
            grid.setConstraints(powerRating,0,1);
            grid.setConstraints(powerRatingField,1,1);
            grid.getChildren().addAll(state,stateCombo,powerRating,powerRatingField);
            pane.getChildren().add(grid);
            return pane;
        }
    }

    class HeatPreferences
    {
        Pane pane = new Pane();
        Label temp = new Label("Temperature");
        TextField tempField = new TextField();
        Label powerRating = new Label("Power Rating");
        TextField powerRatingField = new TextField();
        GridPane grid = new GridPane();
        public Pane init()
        {
            grid.setConstraints(temp,0,0);
            grid.setConstraints(tempField,1,0);
            grid.setConstraints(powerRating,0,1);
            grid.setConstraints(powerRatingField,1,1);
            grid.getChildren().addAll(temp,tempField,powerRating,powerRatingField);
            pane.getChildren().add(grid);
            return pane;
        }

    }
    class Lights
    {

        public Pane getView()
        {
            Pane p = new Pane();
            Button button = new Button("LED Bulb"); //probs should change to image view at a later date
            Button heatingButton = new Button("Heating");
            heatingButton.setOnMouseClicked(event->
            {
                heatCount++;
                ImageView image = drawHeater();
                canvas.getChildren().add(image);
                //add to array list
            });
            button.setOnMouseClicked(event ->{
                count++;
                ImageView image = drawLight();
                canvas.getChildren().add(image);
                lights.add(new Light(true,100));
            });
            VBox vBox = new VBox(5);
            vBox.getChildren().addAll(button,heatingButton);
            p.getChildren().addAll(vBox);
            return p;
        }

    }
}
