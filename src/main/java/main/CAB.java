package main;

import Windows.ControlOptions;
import Windows.form;
import energyConsumers.Heating;
import energyConsumers.Light;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import controlDB.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

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
        ControlDB cd = new ControlDB();//
        //cd.ControlDB();//
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
        int time= 60; //mins
        double totalPower =0;
        for(int z = 0; z<lightsNum; z++)
            totalPower+=lights[z].powerConsumption(time,lights[z].getPowerrating());
        for(int a = 0; a<heatingNum; a++)
            totalPower+=heatings[a].powerConsumption(time,heatings[a].getPowerRating());
        System.out.println(totalPower/1000);
        System.out.println(lights[1].calculateCost(totalPower, 0.13));
        System.out.println(lights[1].estimatedEmissions(totalPower/1000));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        assert ElectricityButton != null : "fx:id=\"ElectricityButton\" was not injected: check your FXML file 'simple.fxml'.";
        ElectricityButton.setOnAction(event ->
        {
            form f = new form();
            try
            {
                f.start();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        });
        assert HeatingButton != null : "fx:id=\"HeatingButton\" was not injected: check your FXML file 'simple.fxml'.";
        HeatingButton.setOnAction(event ->
        {
            form f = new form();
            try
            {
                f.start();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        });
        assert GasButton != null : "fx:id=\"GasButton\" was not injected: check your FXML file 'simple.fxml'.";
        GasButton.setOnAction(event ->
        {
            form f = new form();
            try
            {
                f.start();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        });
        assert WaterButton != null : "fx:id=\"WaterButton\" was not injected: check your FXML file 'simple.fxml'.";
        WaterButton.setOnAction(event ->
        {
            form f = new form();
            try
            {
                f.start();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        });

    }


}