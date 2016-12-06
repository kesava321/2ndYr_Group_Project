package Windows;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

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
    public void addScreen(String id, Node screen)
    {
        screens.put(id,screen);
    }
    public Node getScreen(String id)
    {
        return screens.get(id);
    }

    public boolean loadFXML(String name, String resource) {
        try {
            System.out.println("R " +getClass().getClassLoader().getResource(resource));
            FXMLLoader myLoader = new FXMLLoader(getClass().getClassLoader().getResource("MainMenu.fxml"));
            Parent loadScreen = myLoader.load();
            ScreenViewController myScreenControler = myLoader.getController();
            myScreenControler.setScreenParent(this);
            addScreen(name, loadScreen);
            System.out.println("WORKED");
            return true;
        }catch(Exception e) {
            System.out.println("opps "+e.getMessage());
            return false;
        }
    }
    public void setScreen(String id)
    {
        if(screens.get(id)!= null)
        {
            if(!getChildren().isEmpty()) //if there is more than one screen
            {
                getChildren().remove(0);
                getChildren().add(0, screens.get(id));
            }
            else
            {
                getChildren().add(0,screens.get(id));
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
