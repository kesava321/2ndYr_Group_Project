package Windows;

import energyConsumers.Light;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import org.apache.commons.lang3.BooleanUtils;


/**
 * This class draws the preferences for a particular object. In this case the object is a light.
 * On the right hand side of the GUI, the preferences of an energyConsumer are laid out and can be
 * altered resulting in changes being made to the system. For example an energyConsumer can be switched
 * On or Off. These changes will have an effect on the Power, Emissions and Kg/cO2 ratings for a room.
 * LightPreferences inherits CreateRoom.
 * Created by daniel on 06/02/2017.
 */
class LightPreferences extends CreateRoom
{
    Pane pane = new Pane();
    Label state = new Label("Light State");
    ComboBox stateCombo = new ComboBox();
    Label powerRating = new Label("Power Rating");
    TextField powerRatingField = new TextField();
    GridPane grid = new GridPane();
    public void setVisible(boolean visible)
    {
        pane.setVisible(visible);
    }
    public Pane init()
    {
        stateCombo.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
        {
            Object tempObject = energyConsumers.get(currentSelected);
            boolean state = BooleanUtils.toBoolean(stateCombo.getSelectionModel().getSelectedIndex());
            if(tempObject instanceof Light)
            {
                ((Light) tempObject).setState(state);
                update();
            }
        });
        powerRatingField.textProperty().addListener((observable, oldValue, newValue) ->
        {
            Object tempObject = energyConsumers.get(currentSelected);
            if(!Validation.Validate.vDouble(newValue))
                powerRatingField.getStyleClass().add("error");
            else
            {
                powerRatingField.getStyleClass().remove("error");
                if(tempObject instanceof Light)
                {
                    ((Light) tempObject).setUsage(Double.parseDouble(newValue));
                    //System.out.println("|" + currentSelected + " " + lights.get(currentSelected).getUsage());
                    update();
                }
            }
        });
        stateCombo.getItems().addAll("Off","On");
        GridPane.setConstraints(state,0,0);
        GridPane.setConstraints(stateCombo,1,0);
        GridPane.setConstraints(powerRating,0,1);
        GridPane.setConstraints(powerRatingField,1,1);
        grid.getChildren().addAll(state,stateCombo,powerRating,powerRatingField);
        pane.getChildren().add(grid);
        return pane;
    }
}