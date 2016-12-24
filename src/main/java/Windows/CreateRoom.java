package Windows;

import energyConsumers.Light;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by daniel on 24/12/2016.
 */
public class CreateRoom
{
    private Stage window = new Stage();
    public TabPane tabPanel;
    StackPane canvas = new StackPane();
    public ArrayList<Light> lights = new ArrayList<Light>();
    private ToolBar toolbar = new ToolBar(
            new Button("Mouse"),
            new Button("Pen")
    );

        BorderPane root = new BorderPane();
    private BorderPane build()
    {
        tabPanel = new TabPane();
        root.setCenter(tabPanel);
        Accordion accordion = new Accordion();
        Pane pane = null;
        TitledPane tiledPane;
        Lights light = new Lights();
        pane = light.getView();
        tiledPane = new TitledPane("General1", pane);
        accordion.getPanes().add(tiledPane);
        accordion.setExpandedPane(tiledPane);
        root.setLeft(accordion);
        return root;
    }

    public void start() throws Exception
    {
        BorderPane borderPane = new BorderPane(build());
        ListView list = new ListView();
        BorderPane.setAlignment(list, Pos.TOP_LEFT);
        BorderPane.setMargin(list, new Insets(12,12,12,12));
        borderPane.setTop(toolbar);
        //borderPane.setCenter(canvas);
        //drawLight();
        Scene scene = new Scene(borderPane,800,600);
        window.setScene(scene);
        window.show();
    }

    private void drawLight()
    {
        File file = new File("Images/bulb.png");
        Image image = new Image(file.toURI().toString());
        ImageView imageView = new ImageView(image);
        //canvas.getChildren().add(imageView);
        root.setCenter(imageView);
    }

    class Lights
    {

        public Pane getView() {
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
