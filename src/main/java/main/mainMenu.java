package main;
import Windows.CreateRoom;
import energyConsumers.Light;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.apache.commons.lang3.BooleanUtils;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by Matt on 24/1/2016.
 */
public class mainMenu implements Initializable
{
    public static Parent root;

    @FXML
    private Button ControlSimulate;
    @FXML
    private Button Settings;


    public void start() throws Exception
    {
        Stage window  = new Stage();
        root = FXMLLoader.load(getClass().getClassLoader().getResource("MainMenu.fxml"));
        Scene scene = new Scene(root, 800, 600);
        window.setTitle("Building Control Systems");
        window.setScene(scene);
        window.show();
    }

    public static void controlClick(){
        System.out.print("Load Controller");
        CreateRoom room = new CreateRoom();
        try {
            room.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void settingsClicked(){
        System.out.print("Load Settings");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        assert ControlSimulate != null;
        ControlSimulate.setOnAction(event -> controlClick());

        assert Settings != null;
        Settings.setOnAction(event -> settingsClicked());
    }
}
