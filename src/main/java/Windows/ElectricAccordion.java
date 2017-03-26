package Windows;

import energyConsumers.ElectricHeating;
import energyConsumers.Light;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.apache.commons.lang3.BooleanUtils;
import controlDB.*;//added by Rui

/**
 * Created by daniel on 12/02/2017.
 */

class ElectricAccordion extends CreateRoom
{


    public Pane getView()
    {
        Pane p = new Pane();
        p.setStyle("-fx-background-color: #7093ff;");
        Button button = new Button("LED Bulb"); //probs should change to image view at a later date
        button.setStyle("-fx-background-color: #9dc8ff;");
        Button heatingButton = new Button("Heating");
        heatingButton.setStyle("-fx-background-color: #9dc8ff;");
        heatingButton.setOnMouseClicked(event->
        {
            ImageView image = draw.drawHeater();
            canvas.getChildren().add(image);
            energyConsumers.add(new ElectricHeating(true,1000,25));

            //insert the data into database
            ControlSqlite cs = new ControlSqlite();
            Object[] objectOfTypesTables = {-1, "Electricity"};
            Object[] objectOfRating = {-1, 1000};
            Object[] objectOfAppliance = {"ElectricHeating", "src/main/resources/Images/heating.png"};
            cs.InsertData("Types_Table", objectOfTypesTables);
            cs.InsertData("Rating", objectOfRating);
            cs.InsertData("Appliance", objectOfAppliance);
            cs.DisplayTable();
            count++;
        });
        button.setOnMouseClicked(event ->{
            energyConsumers.add(new Light(true,100));
            ImageView image = draw.drawLight();
            canvas.getChildren().add(image);
            count++;

            //insert the data into database
            ControlSqlite cs = new ControlSqlite();
            Object[] objectOfTypesTables = {-1, "Electricity"};
            Object[] objectOfRating = {-1, 100};
            Object[] objectOfAppliance = {"Light", "src/main/resources/Images/bulb.png"};
            cs.InsertData("Types_Table", objectOfTypesTables);
            cs.InsertData("Rating", objectOfRating);
            cs.InsertData("Appliance", objectOfAppliance);
            cs.DisplayTable();
            update();
        });
        VBox vBox = new VBox(5);
        vBox.getChildren().addAll(button,heatingButton);
        p.getChildren().addAll(vBox);
        return p;
    }

}