package Windows;

import energyConsumers.*;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import org.apache.commons.lang3.BooleanUtils;

import static Windows.CreateRoom.currentSelected;
import static Windows.CreateRoom.update;


/**
 * Created by Kesava on 15/02/2017.
 */
class WaterPreferences
{

    public static final int TOILET = 1;
    public static final int SINK = 2;


    Label state = new Label("Water State");
    ComboBox stateCombo = new ComboBox();
    Pane pane = new Pane();
    Label usePerHour = new Label();
    TextField usePerHourField = new TextField();
    Label literPerUse = new Label("Liter Per Use");
    TextField literPerUseField = new TextField();
    Label avgUseTime = new Label("Avg. use time"); //only for sink
    TextField avgUseTimeField = new TextField();
    GridPane grid = new GridPane();

    public void setVisible(boolean visible)
    {
        pane.setVisible(visible);
    }

    public void setVisible(boolean visible, double consumer)
    {
        pane.setVisible(visible);
        if(consumer == TOILET)
        {
            usePerHour.setText("Flush Per Hour");
            avgUseTime.setVisible(false);
            avgUseTimeField.setVisible(false);
        }
        else if(consumer == SINK)
        {
            usePerHour.setText("Uses Per Hour");
            avgUseTime.setVisible(true);
            avgUseTimeField.setVisible(true);
        }
        else
            System.out.println("DARN");
    }

    public Pane init()
    {
        stateCombo.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
        {
            Object tempObject = CreateRoom.energyConsumers.get(currentSelected);
            if(tempObject instanceof Toilet)
            {
                ((Toilet) tempObject).setState(BooleanUtils.toBoolean(stateCombo.getSelectionModel().getSelectedIndex()));
                update();
            }
            else if(tempObject instanceof Sink)
            {
                ((Sink) tempObject).setState(BooleanUtils.toBoolean(stateCombo.getSelectionModel().getSelectedIndex()));
                update();
            }
        });
        usePerHourField.textProperty().addListener((observable, oldValue, newValue) ->
        {
            Object tempObject = CreateRoom.energyConsumers.get(currentSelected);
            if (!Validation.Validate.vDouble(newValue))
                usePerHourField.getStyleClass().add("error");
            else
            {
                usePerHourField.getStyleClass().remove("error");
                if(tempObject instanceof Toilet)
                {
                    ((Toilet) tempObject).setUsePerHour(Integer.parseInt(newValue));
                    update();
                }
                else if(tempObject instanceof Sink)
                {
                    ((Sink) tempObject).setUsePerHour(Integer.parseInt(newValue));
                    update();
                }
            }
        });
        literPerUseField.textProperty().addListener((observable, oldValue, newValue) ->
        {
            Object tempObject = CreateRoom.energyConsumers.get(currentSelected);
            if (!Validation.Validate.vDouble(newValue))
                literPerUseField.getStyleClass().add("error");
            else
            {
                literPerUseField.getStyleClass().remove("error");
                if(tempObject instanceof Toilet)
                {
                    ((Toilet) tempObject).setUsage(Double.parseDouble(newValue));
                    update();
                }
                else if(tempObject instanceof Sink)
                {
                    ((Sink) tempObject).setUsage(Double.parseDouble(newValue));
                    update();
                }
            }
        });
        avgUseTimeField.textProperty().addListener((observable, oldValue, newValue) ->
        {
            Object tempObject = CreateRoom.energyConsumers.get(currentSelected);
            if (!Validation.Validate.vDouble(newValue))
                avgUseTimeField.getStyleClass().add("error");
            else
            {
                avgUseTimeField.getStyleClass().remove("error");
                if(tempObject instanceof Sink)
                {
                    ((Sink) tempObject).setAvgTimeUsed(Double.parseDouble(newValue));
                    update();
                }
            }
        });

        stateCombo.getItems().addAll("Off", "On");
        grid.setConstraints(state, 0, 0);
        grid.setConstraints(stateCombo, 1, 0);
        grid.setConstraints(usePerHour,0,1);
        grid.setConstraints(usePerHourField,1,1);
        grid.setConstraints(literPerUse,0,2);
        grid.setConstraints(literPerUseField,1,2);
        grid.setConstraints(avgUseTime,0,3);
        grid.setConstraints(avgUseTimeField,1,3);
        grid.getChildren().addAll(state, stateCombo,usePerHour,usePerHourField,literPerUse,literPerUseField,avgUseTime,avgUseTimeField);
        pane.getChildren().add(grid);
        return pane;
    }
}