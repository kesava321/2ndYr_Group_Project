package DEL;

import energyConsumers.Water;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.text.DecimalFormat;

/**
 * Created by daniel on 15/12/2016.
 */
public class FormWater
{
    Stage window = new Stage();
    GridPane grid = new GridPane();
    private double waterIntake;
    private static DecimalFormat df3 = new DecimalFormat(".##");

    public void start() throws Exception
    {
        Label waterNum = new Label("Number of water Consumers");
        TextField waterNumField = new TextField();
        Label waterConsumption = new Label("Water consumption");
        TextField waterConsumptionField = new TextField();
        Label time = new Label("Time period");
        Label cost = new Label("Cost per m\u00b3");
        TextField costField =  new TextField();
        TextField timeField = new TextField();
        Button go = new Button("go");

        grid.setConstraints(waterNum,0,0);
        grid.setConstraints(waterNumField,1,0);
        grid.setConstraints(waterConsumption,0,1);
        grid.setConstraints(waterConsumptionField,1,1);
        grid.setConstraints(cost,0,2);
        grid.setConstraints(costField,1,2);
        grid.setConstraints(time,0,3);
        grid.setConstraints(timeField,1,3);
        grid.setConstraints(go,1,4);

        grid.getChildren().add(waterNum);
        grid.getChildren().add(waterNumField);
        grid.getChildren().add(waterConsumption);
        grid.getChildren().add(waterConsumptionField);
        grid.getChildren().add(cost);
        grid.getChildren().add(costField);
        grid.getChildren().add(time);
        grid.getChildren().add(timeField);
        grid.getChildren().add(go);

        go.setOnMouseClicked(event ->
        {
            Water[] waters = new Water[Integer.parseInt(waterNumField.getText())];
            for(int x = 0; x<Integer.parseInt(waterNumField.getText());x++)
            {
                waters[x] = new Water(false, (Double.parseDouble(waterConsumptionField.getText())* Integer.parseInt(timeField.getText())));
            }
            for(int y = 0; y<Integer.parseInt(waterNumField.getText());y++)
            {
                waterIntake+= waters[y].getWaterIntake();
            }
            System.out.println("Total water intake is " + waterIntake + " for " + Integer.parseInt(timeField.getText()) + " minutes");
//            System.out.println("Cost per " + Integer.parseInt(timeField.getText()) + " is " + df3.format(waters[0].calculateCost(Double.parseDouble(waterConsumptionField.getText()),Double.parseDouble(costField.getText()))));
        });


        Scene scene = new Scene(grid);
        window.setScene(scene);
        window.show();
    }
}
