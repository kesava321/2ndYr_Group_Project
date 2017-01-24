package DEL;

import DEL.ScreenViewController;
import DEL.ScreensController;

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
