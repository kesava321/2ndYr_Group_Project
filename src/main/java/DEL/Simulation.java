package DEL;

import DEL.ScreenViewController;
import DEL.ScreensController;

/**
 * Created by daniel on 04/12/2016.
 */
public class Simulation implements ScreenViewController
{

    ScreensController controller;

    public void setScreenParent(ScreensController screenpage)
    {
        controller = screenpage;
    }
}