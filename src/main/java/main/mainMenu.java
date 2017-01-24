package main;
import Windows.CreateRoom;
import energyConsumers.Light;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
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

import java.util.ArrayList;

/**
 * Created by Matt on 24/1/2016.
 */
public class mainMenu
{

    private Stage window = new Stage();
    public ArrayList<Light> lights = new ArrayList<Light>();
    BorderPane borderPane = new BorderPane();

    public void start() throws Exception
    {
        CreateRoom room = new CreateRoom();
        room.start();
    }


}
