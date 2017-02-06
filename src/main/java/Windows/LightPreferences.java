package Windows;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import org.apache.commons.lang3.BooleanUtils;

import static Windows.CreateRoom.currentSelected;
import static Windows.CreateRoom.lights;

/**
 * Created by daniel on 06/02/2017.
 */
class LightPreferences
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
            boolean state = BooleanUtils.toBoolean(stateCombo.getSelectionModel().getSelectedIndex());
            lights.get(currentSelected).setState(state);
            CreateRoom.update();

        });
        powerRatingField.textProperty().addListener((observable, oldValue, newValue) ->
        {
            if(!Validation.Validate.vDouble(newValue))
                powerRatingField.getStyleClass().add("error");
            else
            {
                powerRatingField.getStyleClass().remove("error");
                lights.get(currentSelected).setUsage(Double.parseDouble(newValue));
                System.out.println("|"+ currentSelected + " " +  lights.get(currentSelected).getUsage());
                CreateRoom.update();
            }
        });
        stateCombo.getItems().addAll("Off","On");
        grid.setConstraints(state,0,0);
        grid.setConstraints(stateCombo,1,0);
        grid.setConstraints(powerRating,0,1);
        grid.setConstraints(powerRatingField,1,1);
        grid.getChildren().addAll(state,stateCombo,powerRating,powerRatingField);
        pane.getChildren().add(grid);
        return pane;
    }
}