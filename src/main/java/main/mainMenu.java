package main;
import Windows.CreateRoom;
import energyConsumers.Light;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
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
    private Stage window  = new Stage();

    public void start() throws Exception
    {
        root = FXMLLoader.load(getClass().getClassLoader().getResource("MainMenu.fxml"));
        
        window.setTitle("Building Control Systems");
        Scene scene = new Scene(root, 550, 330);
        scene.getStylesheets().add("MainMenu.css");
        window.setScene(scene);
        window.setResizable(false);
        window.show();
    }

    public static void settingsClicked(){
        System.out.print("Load Settings");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        assert ControlSimulate != null;
        ControlSimulate.setOnAction(event ->
        {
            System.out.print("Load Controller");
            CreateRoom room = new CreateRoom();
            try {
                room.start();
                ((Node)(event.getSource())).getScene().getWindow().hide();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        });

        assert Settings != null;
        Settings.setOnAction(event -> settingsClicked());
    }
}
