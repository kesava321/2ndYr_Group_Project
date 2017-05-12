package Windows;

import energyConsumers.ElectricHeating;
import energyConsumers.Gas;
import energyConsumers.GasHeating;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import org.apache.commons.lang3.BooleanUtils;

/**
 * This class draws the preferences for a particular object. In this case the object is a heater.
 * On the right hand side of the GUI, the preferences of an energyConsumer are laid out and can be
 * altered resulting in changes being made to the system. For example an energyConsumer can be switched
 * On or Off. These changes will have an effect on the Power, Emissions and Kg/cO2 ratings for a room.
 * HeatPreferences inherits CreateRoom.
 * Created by daniel on 06/02/2017.
 */
class HeatPreferences extends CreateRoom
{
    Label state = new Label("Heater State");
    ComboBox stateCombo = new ComboBox();
    Pane pane = new Pane();
    Label temp = new Label("Temperature");
    TextField tempField = new TextField();
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
            if(tempObject instanceof ElectricHeating)
            {
                ((ElectricHeating) tempObject).setState(BooleanUtils.toBoolean(stateCombo.getSelectionModel().getSelectedIndex()));
                update();
            }
            else if(tempObject instanceof GasHeating)
            {
                ((GasHeating) tempObject).setState(BooleanUtils.toBoolean(stateCombo.getSelectionModel().getSelectedIndex()));
                update();
            }
        });
        powerRatingField.textProperty().addListener((observable, oldValue, newValue) ->
        {
            Object tempObject = energyConsumers.get(currentSelected);
            if (!Validation.Validate.vDouble(newValue))
                powerRatingField.getStyleClass().add("error");
            else
            {
                powerRatingField.getStyleClass().remove("error");
                if(tempObject instanceof ElectricHeating)
                {
                    ((ElectricHeating) tempObject).setUsage(Double.parseDouble(newValue));
                    update();
                }
                else if(tempObject instanceof GasHeating)
                {
                    ((GasHeating) tempObject).setUsage(Double.parseDouble(newValue));
                    update();
                }
            }
        });
        tempField.textProperty().addListener((observable, oldValue, newValue) ->
        {
            Object tempObject = energyConsumers.get(currentSelected);
            if (!Validation.Validate.vDouble(newValue))
                tempField.getStyleClass().add("error");
            else
            {
                if(tempObject instanceof ElectricHeating)
                {
                    tempField.getStyleClass().remove("error");
                    ((ElectricHeating) tempObject).setTemperature(Double.parseDouble(newValue));
                    update();
                }
                else if(tempObject instanceof GasHeating)
                {
                    ((GasHeating) tempObject).setTemperature(Double.parseDouble(newValue));
                    update();
                }
            }
        });
        stateCombo.getItems().addAll("Off", "On");
        GridPane.setConstraints(state, 0, 0);
        GridPane.setConstraints(stateCombo, 1, 0);
        GridPane.setConstraints(temp, 0, 1);
        GridPane.setConstraints(tempField, 1, 1);
        GridPane.setConstraints(powerRating, 0, 2);
        GridPane.setConstraints(powerRatingField, 1, 2);
        grid.getChildren().addAll(state, stateCombo, temp, tempField, powerRating, powerRatingField);
        pane.getChildren().add(grid);
        return pane;
    }
}