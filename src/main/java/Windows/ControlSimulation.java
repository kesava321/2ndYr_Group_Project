package Windows;

import javafx.stage.Screen;

/**
 * Created by daniel on 04/12/2016.
 */
public class ControlSimulation implements ScreenViewController
{

    ScreensController myController;

    public void setScreenParent(ScreensController screenpage)
    {
        myController = screenpage;
    }
}
