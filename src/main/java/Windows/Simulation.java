package Windows;

/**
 * Created by daniel on 04/12/2016.
 */
public class Simulation implements ScreenViewController
{

    ScreensController controller;

    public void setScreen(ScreensController screenpage)
    {
        controller = screenpage;
    }
}
