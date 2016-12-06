package main;

import Windows.ControlOptions;
import Windows.ScreensController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CAB extends Application implements Initializable{

    @FXML
    private Button ElectricityButton;

    public static Parent root;

    public static final String MAIN_SCREEN = "main";
    public static final String MAIN_FXML = "/MainMenu.fxml";
    public static final String CONTROL_OPTIONS_SCREEN = "controlOptions";
    public static final String CONTROL_OPTIONS_FXML = "/ControlOptions.fxml";


    @Override
    public void start(Stage primaryStage) throws Exception
    {

        ScreensController mainContainer = new ScreensController();
        mainContainer.loadFXML(CAB.MAIN_SCREEN,CAB.MAIN_FXML);
        mainContainer.loadFXML(CAB.CONTROL_OPTIONS_SCREEN,CAB.CONTROL_OPTIONS_FXML);
        mainContainer.setScreen(MAIN_SCREEN);
        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

        /*root = FXMLLoader.load(getClass().getClassLoader().getResource("MainMenu.fxml"));
        primaryStage.setTitle("Building Control Systems");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();*/
    }

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        assert ElectricityButton != null : "fx:id=\"ElectricityButton\" was not injected: check your FXML file 'simple.fxml'.";
        ElectricityButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                    ControlOptions control = new ControlOptions();
                    control.start();
            }
        });
    }
}