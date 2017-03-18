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
            ImageView image = draw.drawTap();
            canvas.getChildren().add(image);
            energyConsumers.add(new Sink(true, 30, 2,2));
            count++;
        });
        waterToilet.setOnMouseClicked(event ->{

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


