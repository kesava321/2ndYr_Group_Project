package Windows;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by daniel on 04/12/2016.
 */
public class ControlOptions implements ScreenViewController
{
    Stage window = new Stage();
    //GridPane grid = new GridPane();
    private static Parent root;
    @Override
    public void setScreenParent(ScreensController screenPage)
    {

    }
    public void start()
    {
        try
        {
            root = FXMLLoader.load(getClass().getResource("/ControlOptions.fxml"));
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        Button test = new Button("TEST");
        //grid.setPadding(new Insets(0,0,0,0));
        //grid.setVgap(0);
        //grid.setHgap(0);
        //grid.setConstraints(test,0,0);
        Scene scene = new Scene(root,600,400);
        window.setScene(scene);
        window.show();

    }


}
