package Windows;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by daniel on 04/12/2016.
 */
public class ScreensController extends StackPane
{
    private HashMap<String, Node> screens = new HashMap<>();

    public ScreensController()
    {
        super();
    }
    public void addScreens(String id, Node screen)
    {
        screens.put(id,screen);
    }
    public Node getScreen(String id)
    {
        return screens.get(id);
    }

    public void loadFXML(String id, String path)
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            Parent loadFXML = (Parent) loader.load();
            ScreenViewController screencontroller = ((ScreenViewController) loader.getController());
            screencontroller.setScreen(this);
            addScreens(id,loadFXML);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void setScreen(String id)
    {
        if(screens.get(id)!= null)
        {
            if(!getChildren().isEmpty()) //if there is more than one screen
            {

            }
            else
            {
                getChildren().add(screens.get(id));
            }
        }
        else
            System.out.println("NO FXML LOADED");
    }
    public void unloadScreen(String id)
    {
        if(screens.remove(id)==null)
            System.out.println("UNKNOWN SCREEN!");
    }
}
