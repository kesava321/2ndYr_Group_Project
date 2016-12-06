package main;

import Windows.ControlOptions;
import DEL.ScreensController;
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
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        assert ElectricityButton != null : "fx:id=\"ElectricityButton\" was not injected: check your FXML file 'simple.fxml'.";
        ElectricityButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
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