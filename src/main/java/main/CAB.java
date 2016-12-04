package main;

import controlSensors.control;
import controlSensors.sensor;
import energyConsumers.Heating;
import energyConsumers.Light;
import simulation.*;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class CAB extends Application{

    public static final String ControlConsumerID = "ControlConsumer";
    public static final String ControlConsumerPath = "ControlConsumer.fxml";
    public static final String ControlOptionsID = "ControlOptions";
    public static final String ControlOptionsPath = "ControlOptions.fxml";
    public static final String ControlSimulationID = "ControlSimulation";
    public static final String ControlSimulationPath = "ControlSimulation.fxml";
    public static final String ControlWindowID = "ControlWindow";
    public static final String ControlWindowPath = "ControlWindow.fxml";
    public static final String HistoricalDataID = "HistoricalData";
    public static final String HistoricalDataPath = "HistoricalData.fxml";
    public static final String HistoricalDataWindowID = "HistoricalDataWindow";
    public static final String HistoricalDataWindowPath = "HistoricalDataWindow.fxml";
    public static final String MainMenuID = "MainMenu";
    public static final String MainMenuPath = "MainMenu.fxml";
    public static final String MonitorConsumerID = "MonitorConsumer";
    public static final String MonitorConsumerPath = "MonitorConsumer.fxml";
    public static final String MonitorWindowID = "MonitorWindow";
    public static final String MonitorWindowPath = "MonitorWindow.fxml";
    public static final String SimulationID = "Simulation";
    public static final String SimulationPath = "Simulation.fxml";

    @Override
    public void start(Stage primaryStage) throws Exception{

        /*Stage optionsStage = new Stage();
        Stage simulationStage = new Stage();*/



        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(  "MainMenu.fxml"));
        primaryStage.setTitle("Building Control Systems");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();

        /*Parent sroot = FXMLLoader.load(getClass().getClassLoader().getResource(  "ControlSimulation.fxml"));
        optionsStage.setTitle("Building Control Systems");
        optionsStage.setScene(new Scene(sroot, 600, 400));
        optionsStage.show();

        Parent troot = FXMLLoader.load(getClass().getClassLoader().getResource(  "Simulation.fxml"));
        simulationStage.setTitle("Simulation Page");
        simulationStage.setScene(new Scene(troot, 600, 400));
        simulationStage.show();

        Parent oroot = FXMLLoader.load(getClass().getClassLoader().getResource(  "ControlOptions.fxml"));
        simulationStage.setTitle("Control Options Page");
        simulationStage.setScene(new Scene(oroot, 600, 400));
        simulationStage.show();*/

//        BorderPane root = new BorderPane();
//        Scene scene = new Scene(root,600,600);
//        primaryStage.setTitle("Building Control System");
//        primaryStage.setScene(scene);
//        primaryStage.show();
    }

    public static void main(String[] args)
    {
        control.test();
        sensor.test();
        energyConsumers.energyConsumers.test();
        Heating.test();
        Light.test();
        building.test();
        environment.test();
        person.test();
        room.test();
        simulation.test();

        launch(args);
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
