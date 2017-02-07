package main;

import javafx.fxml.FXML;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import controlDB.*;
import javafx.stage.Stage;

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
        splash splashScreen = new splash();
        splashScreen.Splash();

        mainMenu room = new mainMenu();
        room.start();

    }

    public static void main(String[] args)
    {
        ControlSqlite cd = new ControlSqlite();//
        //cd.ControlDB();//
        launch(args);
    }
}