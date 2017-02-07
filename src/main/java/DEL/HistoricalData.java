package DEL;

import DEL.ScreenViewController;
import DEL.ScreensController;

/**
 * Created by daniel on 04/12/2016.
 */
public class HistoricalData implements ScreenViewController
{

    ScreensController myController;

    public void setScreenParent(ScreensController screenpage)
    {
        myController = screenpage;
    }
}
