package main;

import Windows.ControlOptions;
import DEL.ScreensController;
import energyConsumers.Heating;
import energyConsumers.Light;
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
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class CAB extends Application implements Initializable{

    @FXML
    private Button ElectricityButton;
    @FXML
    private Button HeatingButton;
    @FXML
    private Button GasButton;
    @FXML
    private Button WaterButton;


    public static int ELECTRICITY = 1;
    public static int HEATING = 2;
    public static int GAS = 3;
    public static int WATER = 4;

    public static Parent root;
    Stage window;
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        window = primaryStage;
        root = FXMLLoader.load(getClass().getClassLoader().getResource("MainMenu.fxml"));
        window.setTitle("Building Control Systems");
        window.setScene(new Scene(root, 600, 400));
        window.show();
    }

    public static void main(String[] args)
    {
        launch(args);
        int lightsNum = 6;
        int lightPowerRating = 100;
        Light[] lights = new Light[lightsNum];
        for(int x = 0; x<lightsNum; x++)
        {
            lights[x] = new Light(false,lightPowerRating);
        }
        int heatingNum = 2;
        int heatingPowerRating = 1000;
        Heating[] heatings = new Heating[heatingNum];
        for(int y = 0; y<heatingNum; y++)
        {
            heatings[y] = new Heating(25,heatingPowerRating);
        }
        int time= 40; //mins
        int totalPower =0;
        for(int z = 0; z<lightsNum; z++)
            totalPower+=lights[z].powerComsumption(time,lights[z].getPowerrating());
        for(int a = 0; a<heatingNum; a++)
            totalPower+=heatings[a].powerComsumption(time,heatings[a].getPowerRating());
        System.out.println(totalPower);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        assert ElectricityButton != null : "fx:id=\"ElectricityButton\" was not injected: check your FXML file 'simple.fxml'.";
        ElectricityButton.setOnAction(new EventHandler<ActionEvent>()
        {

            @Override
            public void handle(ActionEvent event)
            {
                ControlOptions control = new ControlOptions(ELECTRICITY);
                control.start();
                Stage stage = (Stage) ElectricityButton.getScene().getWindow();
                stage.close();
            }
        });
        assert HeatingButton != null : "fx:id=\"HeatingButton\" was not injected: check your FXML file 'simple.fxml'.";
        HeatingButton.setOnAction(event ->
        {
            ControlOptions control = new ControlOptions(HEATING);
            control.start();
            Stage stage = (Stage) HeatingButton.getScene().getWindow();
            stage.close();
        });
        assert GasButton != null : "fx:id=\"GasButton\" was not injected: check your FXML file 'simple.fxml'.";
        GasButton.setOnAction(event ->
        {
            ControlOptions control = new ControlOptions(GAS);
            control.start();
            Stage stage = (Stage) GasButton.getScene().getWindow();
            stage.close();
        });
        assert WaterButton != null : "fx:id=\"WaterButton\" was not injected: check your FXML file 'simple.fxml'.";
        WaterButton.setOnAction(event ->
        {
            ControlOptions control = new ControlOptions(WATER);
            control.start();
            Stage stage = (Stage) WaterButton.getScene().getWindow();
            stage.close();
        });

    }


}