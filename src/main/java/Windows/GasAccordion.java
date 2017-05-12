package Windows;

import energyConsumers.ElectricHeating;
import energyConsumers.GasHeating;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.apache.commons.lang3.BooleanUtils;
import controlDB.*;

/**
 * This class is for the drop down list on the left hand side of the GUI where the objects
 * are stored. this class in particular is for the Gas energyConsumers and inherits
 * the CreateRoom class. The class draws out the drop down list and handles what is down
 * when it is pressed.
 * Created by daniel on 12/02/2017.
 */
public class GasAccordion extends CreateRoom
{
    public Pane getView()
    {
        Pane p = new Pane();
        p.setStyle("-fx-background-color: #7093ff;");
        Button gasHeater = new Button("Heater");
        gasHeater.setStyle("-fx-background-color: #9dc8ff;");
        gasHeater.setOnMouseClicked(event ->
        {
            ImageView image = draw.drawGasHeater();
            canvas.getChildren().add(image);
            energyConsumers.add(new GasHeating(true,100,25));
            count++;

            //insert the data into database
            ControlSqlite cs = new ControlSqlite();
            Object[] objectOfTypesTables = {-1, "Gas"};
            Object[] objectOfRating = {-1, 100};
            Object[] objectOfAppliance = {"GasHeating", "src/main/resources/Images/gasHeating.png"};
            cs.InsertData("Types_Table", objectOfTypesTables);
            cs.InsertData("Rating", objectOfRating);
            cs.InsertData("Appliance", objectOfAppliance);
            cs.DisplayTable();
            count++;
        });
        VBox vBox = new VBox(5);
        vBox.getChildren().addAll(gasHeater);
        p.getChildren().add(vBox);
        return p;
    }
}
