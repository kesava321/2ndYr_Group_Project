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
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(  "sample.fxml"));
<<<<<<< HEAD
        primaryStage.setTitle("Building Control Systems");
        primaryStage.setScene(new Scene(root, 600, 400));
=======
        primaryStage.setTitle("Hello World");
        Scene scene = new Scene(root, 600, 600);
        //scene.getStylesheets().add(getClass().getResource("MainMenu.css").toExternalForm());
        primaryStage.setScene(scene);
>>>>>>> f78bc1cf8438eeb3c81fdcffaaf9b7be0424e4e8
        primaryStage.show();

//        BorderPane root = new BorderPane();
//        Scene scene = new Scene(root,600,600);
//        primaryStage.setTitle("Hello World");
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
