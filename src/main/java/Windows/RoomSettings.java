package Windows;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * The RoomSettings class is where the settings to be made (on simulating a room)
 * are written. Here the edit box is designed so that the user can easily understand
 * how they can the set the parameters for a room and where they can do so.
 * Created by daniel on 15/03/2017.
 */
public class RoomSettings extends Room
{
    private Stage window = new Stage();
    private GridPane gridPane = new GridPane();

    private Label roomCapacity = new Label("Room Capacity");
    private TextField roomCapacityField = new TextField();

    private Label season = new Label("Season");
    private ComboBox seasonCombo = new ComboBox();

    private Label activityLevel = new Label("Activity Level");
    private ComboBox activityLevelCombo = new ComboBox();

    private Label insulationLevel = new Label("Insulation Level");
    private ComboBox insulationLevelCombo = new ComboBox();

    private Label optimalTemp = new Label("Optimal Temp");
    private TextField optimalTempField = new TextField();

    private Button go = new Button("go");

    public void start()
    {
        activityLevelCombo.getItems().addAll("High","Medium","Low");
        insulationLevelCombo.getItems().addAll("High","Medium","Low");
        seasonCombo.getItems().addAll("Summer","Autumn","Winter","Spring");
        roomCapacityField.setText(Integer.toString(roomAttributes.roomCapacity));
        activityLevelCombo.getSelectionModel().select(roomAttributes.activityLevel-1);
        insulationLevelCombo.getSelectionModel().select(roomAttributes.insulationLevel-1);
        optimalTempField.setText(Double.toString(roomAttributes.optimalTemperature));
        seasonCombo.getSelectionModel().select(roomAttributes.activityLevel-1);
        go.setOnAction(event ->
        {
            System.out.println((Integer.parseInt(roomCapacityField.getText()))+"|||");
            setRoomCapacity((Integer.parseInt(roomCapacityField.getText())));
            roomAttributes.activityLevel = activityLevelCombo.getSelectionModel().getSelectedIndex() +1;
            roomAttributes.insulationLevel = insulationLevelCombo.getSelectionModel().getSelectedIndex()+1;
            roomAttributes.optimalTemperature = Double.parseDouble(optimalTempField.getText());
            System.out.println(activityLevelCombo.getSelectionModel().getSelectedIndex());
            simulate(600,seasonCombo.getSelectionModel().getSelectedIndex()+1);
            System.out.println(seasonCombo.getSelectionModel().getSelectedIndex()+1+"|||||||||");
            System.out.println("\n\n" + roomAttributes.roomCapacity + "\n\n");
        });

        GridPane.setConstraints(roomCapacity,0,0);
        GridPane.setConstraints(roomCapacityField,1,0);
        GridPane.setConstraints(activityLevel,0,1);
        GridPane.setConstraints(activityLevelCombo,1,1);
        GridPane.setConstraints(insulationLevel,0,2);
        GridPane.setConstraints(insulationLevelCombo,1,2);
        GridPane.setConstraints(optimalTemp,0,3);
        GridPane.setConstraints(optimalTempField,1,3);
        GridPane.setConstraints(season,0,4);
        GridPane.setConstraints(seasonCombo,1,4);
        GridPane.setConstraints(go,1,5);
        gridPane.getChildren().addAll(roomCapacity,roomCapacityField,activityLevel,activityLevelCombo,
                insulationLevel,insulationLevelCombo,optimalTemp,optimalTempField,go,season,seasonCombo);

        Scene scene = new Scene(gridPane);
        window.setScene(scene);
        window.show();

    }
}
