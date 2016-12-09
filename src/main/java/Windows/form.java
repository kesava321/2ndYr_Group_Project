package Windows;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.xml.soap.Text;

/**
 * Created by daniel on 09/12/2016.
 */
public class form
{

    Stage window = new Stage();
    GridPane grid = new GridPane();

    public void start() throws Exception
    {
        Label lightNum = new Label("Number of Lights");
        TextField lightNumField = new TextField();
        Label lightPowerRating = new Label("Lights Power Rating");
        TextField lightPowerRatingField = new TextField();
        Label heatingNum = new Label("Number of Lights");
        TextField heatingNumField = new TextField();
        Label heatingPowerRating = new Label("Lights Power Rating");
        TextField heatingPowerRatingField = new TextField();
        Label cost = new Label("Cost per KW/h");
        TextField costField = new TextField();
        Label time = new Label("Time Period");
        TextField timeField = new TextField();
        Button go = new Button("GO");


        grid.setConstraints(lightNum,0,0);
        grid.setConstraints(lightNumField,1,0);
        grid.setConstraints(lightPowerRating,0,1);
        grid.setConstraints(lightPowerRatingField,1,1);
        grid.setConstraints(heatingNum,0,2);
        grid.setConstraints(heatingNumField,1,2);
        grid.setConstraints(heatingPowerRating,0,3);
        grid.setConstraints(heatingPowerRatingField,1,3);
        grid.setConstraints(cost,0,4);
        grid.setConstraints(costField,1,4);
        grid.setConstraints(time,0,5);
        grid.setConstraints(timeField,1,5);
        grid.setConstraints(go,1,6);

        grid.getChildren().add(lightNum);
        grid.getChildren().add(lightNumField);
        grid.getChildren().add(lightPowerRating);
        grid.getChildren().add(lightPowerRatingField);
        grid.getChildren().add(heatingNum);
        grid.getChildren().add(heatingNumField);
        grid.getChildren().add(heatingPowerRating);
        grid.getChildren().add(heatingPowerRatingField);
        grid.getChildren().add(cost);
        grid.getChildren().add(costField);
        grid.getChildren().add(time);
        grid.getChildren().add(timeField);
        grid.getChildren().add(go);
        go.setOnMouseClicked(event ->
        {
            System.out.println("Total Power from lights" + Integer.parseInt(lightNumField.getText()) * Integer.parseInt(lightPowerRatingField.getText()));
            System.out.println("Total Power from Heating"+ Integer.parseInt(heatingNumField.getText())*Integer.parseInt(heatingPowerRatingField.getText()));
        });
        Scene scene = new Scene(grid);
        window.setScene(scene);
        window.show();
    }
}
