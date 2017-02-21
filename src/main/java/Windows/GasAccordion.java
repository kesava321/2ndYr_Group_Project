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

import static Windows.CreateRoom.*;
/**
 * Created by daniel on 12/02/2017.
 */
public class GasAccordion
{

    private ImageView drawHeater()
    {
        int id = count;
        Image image = new Image("Images/gasHeating.png",50,50,false,false);
        ImageView imageView = new ImageView(image);
        imageView.setCursor(Cursor.HAND);
        imageView.setOnMousePressed(event ->
        {
            currentSelected = id;
            heatPreferences.setVisible(true);
            lightPreferences.setVisible(false);
            waterPreferences.setVisible(false);
            Object temp = energyConsumers.get(id);
            if(temp instanceof GasHeating)
            {
                heatPreferences.stateCombo.getSelectionModel().select(BooleanUtils.toInteger(((GasHeating) temp).getState()));
                heatPreferences.powerRatingField.setText(Double.toString(((GasHeating) temp).getUsage()));
                heatPreferences.tempField.setText(Double.toString(((GasHeating) temp).getTemperature()));
            }
            else
                System.out.println("oh-oh");
            orgSceneX = event.getSceneX();
            orgSceneY = event.getSceneY();
        });
        imageView.setOnMouseDragged(event ->
        {
            if((event.getX() >0 && event.getX() < canvas.getWidth()) && (event.getY() > 0 && event.getY() < canvas.getHeight()))
            {
                double offsetX = event.getSceneX() - orgSceneX;
                double offsetY = event.getSceneY() - orgSceneY;
                Object o = event.getSource();
                ImageView i = (ImageView) o;
                i.setX(i.getX() + offsetX);
                i.setY(i.getY() + offsetY);
                orgSceneX = event.getSceneX();
                orgSceneY = event.getSceneY();
            }
        });
        return imageView;
    }

    public Pane getView()
    {
        Pane p = new Pane();
        Button gasHeater = new Button("Heater");
        gasHeater.setOnMouseClicked(event ->
        {
            ImageView image = drawHeater();
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
