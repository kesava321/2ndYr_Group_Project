package main;

import DEL.FormWater;
import DEL.form;
import Windows.*;
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

public class CAB extends Application{

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

        CreateRoom room = new CreateRoom();
        room.start();

    }

    public static void main(String[] args)
    {
        ControlDB cd = new ControlDB();//
        //cd.ControlDB();//
        launch(args);
    }
}