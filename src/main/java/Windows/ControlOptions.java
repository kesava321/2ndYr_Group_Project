package Windows;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by daniel on 04/12/2016.
 */
public class ControlOptions implements ScreenViewController
{
    Stage window = new Stage();
    GridPane grid = new GridPane();

    @Override
    public void setScreenParent(ScreensController screenPage)
    {

    }
    public void start()
    {
        Button test = new Button("TEST");
        grid.setPadding(new Insets(0,0,0,0));
        grid.setVgap(0);
        grid.setHgap(0);
        grid.setConstraints(test,0,0);
        Scene scene = new Scene(grid);
        window.setScene(scene);
        window.show();

    }


}
