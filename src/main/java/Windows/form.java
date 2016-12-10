package Windows;

import energyConsumers.Heating;
import energyConsumers.Light;
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
    int totalLightPower;
    int totalHeatingPower;
    double price;
    double pollution;
    public void start() throws Exception
    {
        Label lightNum = new Label("Number of Lights");
        TextField lightNumField = new TextField();
        Label lightPowerRating = new Label("Lights Power Rating");
        TextField lightPowerRatingField = new TextField();
        Label heatingNum = new Label("Number of Radiators");
        TextField heatingNumField = new TextField();
        Label heatingPowerRating = new Label("Heating Power Rating");
        TextField heatingPowerRatingField = new TextField();
        Label temp = new Label("Tempreature");
        TextField tempField = new TextField();
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
        grid.setConstraints(temp,0,4);
        grid.setConstraints(tempField,1,4);
        grid.setConstraints(cost,0,5);
        grid.setConstraints(costField,1,5);
        grid.setConstraints(time,0,6);
        grid.setConstraints(timeField,1,6);
        grid.setConstraints(go,1,7);

        grid.getChildren().add(lightNum);
        grid.getChildren().add(lightNumField);
        grid.getChildren().add(lightPowerRating);
        grid.getChildren().add(lightPowerRatingField);
        grid.getChildren().add(heatingNum);
        grid.getChildren().add(heatingNumField);
        grid.getChildren().add(heatingPowerRating);
        grid.getChildren().add(heatingPowerRatingField);
        grid.getChildren().add(temp);
        grid.getChildren().add(tempField);
        grid.getChildren().add(cost);
        grid.getChildren().add(costField);
        grid.getChildren().add(time);
        grid.getChildren().add(timeField);
        grid.getChildren().add(go);
        go.setOnMouseClicked((MouseEvent event) ->
        {
            Light[] lights = new Light[Integer.parseInt(lightNumField.getText())];
            for(int x = 0; x< Integer.parseInt(lightNumField.getText());x++)
            {
                lights[x] = new Light(false,Integer.parseInt(lightPowerRatingField.getText()));
                totalLightPower+=lights[x].getPowerrating();
            }
            System.out.println("Total Power from lights " + totalLightPower);
            Heating[] heatings = new Heating[Integer.parseInt(heatingNumField.getText())];
            for(int y = 0; y<Integer.parseInt(heatingNumField.getText());y++)
            {
                heatings[y] = new Heating(Integer.parseInt(tempField.getText()),Integer.parseInt(heatingPowerRatingField.getText()));
                totalHeatingPower+=Integer.parseInt(heatingPowerRatingField.getText());
            }
            System.out.println("Total Power from Heating "+ totalHeatingPower);
            price = lights[1].calculateCost(totalLightPower+totalHeatingPower,Double.parseDouble(costField.getText()));
            System.out.println("Cost per " + Integer.parseInt(timeField.getText()) + " minutes is " + price);
            System.out.println("Estimated elisions are " + lights[1].estimatedEmissions(totalHeatingPower+totalLightPower)+"g");
        });
        Scene scene = new Scene(grid);
        window.setScene(scene);
        window.show();
    }
}
