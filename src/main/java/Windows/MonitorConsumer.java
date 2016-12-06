package Windows;

/**
 * Created by daniel on 04/12/2016.
 */
public class MonitorConsumer implements ScreenViewController
{
    ScreensController myController;

    public void setScreenParent(ScreensController screenpage)
    {
        myController = screenpage;
    }
}
