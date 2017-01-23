package Windows;

import energyConsumers.Light;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created by daniel on 24/12/2016.
 */
public class CreateRoom
{

    private Stage window = new Stage();
    public ArrayList<Light> lights = new ArrayList<Light>();
    BorderPane borderPane = new BorderPane();
    private Pane canvas = new Pane();

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
        tiledPane = new TitledPane("General1", pane);
        accordion.getPanes().add(tiledPane);
        accordion.setExpandedPane(tiledPane);
        borderPane.setLeft(accordion);
        //return root;
    }

    private void buildPreferences()
    {
        Accordion accordion = new Accordion();
        Pane pane;
        LightPreferences pref = new LightPreferences();
        pane = pref.getView();
        borderPane.setRight(pane);

    }

    private Circle createCircle(double x, double y, double r, Color color) {
        Circle circle = new Circle(x, y, r, color);
        circle.setCursor(Cursor.HAND);
        /*circle.setOnMousePressed((t) -> {
            System.out.println("PRESSED");
            orgSceneY = t.getSceneY();
            orgSceneX = t.getSceneX();

            Circle c = (Circle) (t.getSource());
            c.toFront();
        });*/
        circle.setOnMouseDragged((t) -> {
            System.out.println(t.getSceneX() + " " + t.getSceneY());
            Circle c = (Circle) (t.getSource());
            c.setCenterX(t.getSceneX());
            c.setCenterY(t.getSceneY());
        });
        return circle;
    }
    private ImageView drawLight()
    {
        Image image = new Image("Images/bulb.png",50,50,false,false);
        ImageView imageView = new ImageView(image);
        imageView.setCursor(Cursor.HAND);
        imageView.setOnMousePressed(event ->
        {
            orgSceneX = event.getSceneX();
            orgSceneY = event.getSceneY();
        });
        imageView.setOnMouseDragged(event ->
        {
                System.out.println(event.getX() + " " + event.getSceneY());
            if(event.getSceneX() >0 && event.getSceneX() < canvas.getMaxWidth() && event.getSceneY() > 0 && event.getSceneY() < canvas.getMaxHeight())
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
        buildPreferences();
        ImageView image = drawLight();
        canvas.getChildren().add(image);
        borderPane.setCenter(canvas);
        Scene scene = new Scene(borderPane,800,600);
        window.setScene(scene);
        window.show();
    }

    class LightPreferences
    {
        public Pane getView()
        {
            Pane pane = new Pane();
            Label state = new Label("Light State");
            ComboBox stateCombo = new ComboBox();
            stateCombo.getItems().addAll("On","Off");
            Label powerRating = new Label("Power Rating");
            TextField powerRatingField = new TextField();
            GridPane grid = new GridPane();
            grid.setConstraints(state,0,0);
            grid.setConstraints(stateCombo,1,0);
            grid.setConstraints(powerRating,0,1);
            grid.setConstraints(powerRatingField,1,1);
            grid.getChildren().addAll(state,stateCombo,powerRating,powerRatingField);
            pane.getChildren().add(grid);
            return null;
        }
    }

    class Lights
    {

        public Pane getView()
        {
            Pane p = new Pane();
            Button button = new Button("LED Bulb"); //probs should change to image view at a later date
        button.setOnMouseClicked(event ->
                lights.add(new Light(false,100)));
            VBox vBox = new VBox(5);
            vBox.getChildren().addAll(button);
            p.getChildren().addAll(vBox);
            return p;
        }

    }
}
