package main;

import Windows.ControlOptions;
import Windows.MainController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import java.io.InputStream;


public class CAB extends Application implements Initializable{


    private Stage stage;
    @FXML
    private Button ElectricityButton;

    public static Parent root;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        root = FXMLLoader.load(getClass().getClassLoader().getResource("MainMenu.fxml"));
        primaryStage.setTitle("Building Control Systems");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
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
                System.out.println("That was easy, wasn't it?");
                    ControlOptions control = new ControlOptions();
                    control.start();



            }
        });
    }
}

/*
Tasks to do:
-Kesava- Main menu (energy consumers)
-Sam- Sub menu (control/simulation)
-Aleem- Options menu (control/monitor/historical data)
-Create GUI for main menu
-Add buttons using scene builder
-Use a red coloured theme: dark red border, with light red background and red transparent button.
-Could add a image of a building as the background
 */
