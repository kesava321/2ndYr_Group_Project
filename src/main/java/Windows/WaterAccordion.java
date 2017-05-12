package Windows;

import energyConsumers.Sink;
import energyConsumers.Toilet;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.apache.commons.lang3.BooleanUtils;
import controlDB.*;

/**
 * This class is for the drop down list on the left hand side of the GUI where the objects
 * are stored. this class in particular is for the Water energyConsumers and inherits
 * the CreateRoom class. The class draws out the drop down list and handles what is down
 * when it is pressed.
 */

public class WaterAccordion extends CreateRoom
{


    public Pane getView() {
        Pane p = new Pane();
        p.setStyle("-fx-background-color: #7093ff;");
        Button waterTap = new Button("Tap");
        waterTap.setStyle("-fx-background-color: #9dc8ff;");
        Button waterToilet = new Button("Toilet");
        waterToilet.setStyle("-fx-background-color: #9dc8ff;");
        waterTap.setOnMouseClicked(event ->
        {
            //insert the data into database
            ControlSqlite cs = new ControlSqlite();
            Object[] objectOfTypesTables = {-1, "Water"};
            Object[] objectOfRating = {-1, 30};
            Object[] objectOfAppliance = {"Sink", "src/main/resources/Images/sink.png"};
            cs.InsertData("Types_Table", objectOfTypesTables);
            cs.InsertData("Rating", objectOfRating);
            cs.InsertData("Appliance", objectOfAppliance);
            cs.DisplayTable();

            ImageView image = draw.drawTap();
            canvas.getChildren().add(image);
            energyConsumers.add(new Sink(true, 30, 2,2));
            count++;
        });
        waterToilet.setOnMouseClicked(event ->{
            //insert the data into database
            ControlSqlite cs = new ControlSqlite();
            Object[] objectOfTypesTables = {-1, "Water"};
            Object[] objectOfRating = {-1, 18};
            Object[] objectOfAppliance = {"Toilet", "src/main/resources/Images/toilet.png"};
            cs.InsertData("Types_Table", objectOfTypesTables);
            cs.InsertData("Rating", objectOfRating);
            cs.InsertData("Appliance", objectOfAppliance);
            cs.DisplayTable();

            ImageView image = draw.drawToilet();
            energyConsumers.add(new Toilet(true, 18, 4));
            canvas.getChildren().add(image);
            count++;
        });
        VBox vBox = new VBox(5);
        vBox.getChildren().addAll(waterTap,waterToilet/*,waterKitchen*/);
        p.getChildren().add(vBox);
        return p;
    }

}


