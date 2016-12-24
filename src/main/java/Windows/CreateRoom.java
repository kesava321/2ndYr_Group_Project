package Windows;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by daniel on 24/12/2016.
 */
public class CreateRoom
{
    private Stage window = new Stage();
    public /*static*/ TabPane tabPanel;

    private ToolBar toolbar = new ToolBar(
            new Button("Mouse"),
            new Button("Pen")
    );

    private BorderPane build()
    {
        BorderPane root = new BorderPane();
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
        borderPane.setTop(toolbar);
        Scene scene = new Scene(borderPane,800,600);
        window.setScene(scene);
        window.show();
    }



}
class Lights {

    public Pane getView() {
        Pane p = new Pane();
        Button button = new Button("LED Bulb");
        Button button1 = new Button("Incandescent"); //probs should change to image view at a later date
        VBox vBox = new VBox(5);
        vBox.getChildren().addAll(button,button1);
        p.getChildren().addAll(vBox);
        return p;
    }

}