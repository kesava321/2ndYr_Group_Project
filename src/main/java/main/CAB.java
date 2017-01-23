package main;

import Windows.ControlOptions;
import Windows.*;
import energyConsumers.Heating;
import energyConsumers.Light;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import controlDB.*;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

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
        splash spashScreen = new splash();
        spashScreen.Splash();

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
            CreateRoom f = new CreateRoom();
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
            FormWater water = new FormWater();
            try
            {
                water.start();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        });

    }
}