package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }



    public static void main(String[] args) {
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
