package Windows;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by daniel on 04/12/2016.
 */
public class ControlConsumer implements ScreenViewController
{

    ScreensController myController;

    public void setScreenParent(ScreensController x)
    {
        myController = x;
    }

}
