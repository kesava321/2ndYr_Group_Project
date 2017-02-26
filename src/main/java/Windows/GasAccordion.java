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

/**
 * Created by daniel on 12/02/2017.
 */
public class GasAccordion extends CreateRoom
{



    public Pane getView()
    {
        Pane p = new Pane();
        Button gasHeater = new Button("Heater");
        gasHeater.setOnMouseClicked(event ->
        {
            ImageView image = draw.drawGasHeater();
            canvas.getChildren().add(image);
            energyConsumers.add(new GasHeating(true,100,25));
            count++;
        });
        VBox vBox = new VBox(5);
        vBox.getChildren().addAll(gasHeater);
        p.getChildren().add(vBox);
        return p;
    }
}
