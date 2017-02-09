package Windows;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import org.apache.commons.lang3.BooleanUtils;

import static Windows.CreateRoom.electricHeatings;
import static Windows.CreateRoom.update;

/**
 * Created by daniel on 06/02/2017.
 */
class HeatPreferences
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
            electricHeatings.get(CreateRoom.currentHeatingSelected).setState(BooleanUtils.toBoolean(stateCombo.getSelectionModel().getSelectedIndex()));
            update();
        });
        powerRatingField.textProperty().addListener((observable, oldValue, newValue) ->
        {
            if (!Validation.Validate.vDouble(newValue))
                powerRatingField.getStyleClass().add("error");
            else
            {
                powerRatingField.getStyleClass().remove("error");
                electricHeatings.get(CreateRoom.currentHeatingSelected).setUsage(Double.parseDouble(newValue));
                update();
            }
        });
        tempField.textProperty().addListener((observable, oldValue, newValue) ->
        {
            if (!Validation.Validate.vDouble(newValue))
                tempField.getStyleClass().add("error");
            else
            {
                tempField.getStyleClass().remove("error");
                electricHeatings.get(CreateRoom.currentHeatingSelected).setTemperature(Double.parseDouble(newValue));
                update();
            }
        });
        stateCombo.getItems().addAll("Off", "On");
        grid.setConstraints(state, 0, 0);
        grid.setConstraints(stateCombo, 1, 0);
        grid.setConstraints(temp, 0, 1);
        grid.setConstraints(tempField, 1, 1);
        grid.setConstraints(powerRating, 0, 2);
        grid.setConstraints(powerRatingField, 1, 2);
        grid.getChildren().addAll(state, stateCombo, temp, tempField, powerRating, powerRatingField);
        pane.getChildren().add(grid);
        return pane;
    }
}