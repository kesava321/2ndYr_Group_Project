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

import static Windows.CreateRoom.*;
/**
 * Created by daniel on 12/02/2017.
 */

class ElectricAccordion
{

    private ImageView drawLight()
    {
        int id = count;
        Image image = new Image("Images/bulb.png",50,50,false,false);
        ImageView imageView = new ImageView(image);
        imageView.setCursor(Cursor.HAND);
        imageView.setOnMousePressed(event ->
        {
            heatPreferences.setVisible(false);
            lightPreferences.setVisible(true);
            currentSelected = id;
            Object temp = energyConsumers.get(id);
            if(temp instanceof Light)
            {
                double powerRating = ((Light) temp).getUsage();
                int lighState = BooleanUtils.toInteger(((Light) temp).getState());
                lightPreferences.powerRatingField.setText(String.valueOf(Double.parseDouble(String.valueOf(powerRating))));
                lightPreferences.stateCombo.getSelectionModel().select(lighState);
                orgSceneX = event.getSceneX();
                orgSceneY = event.getSceneY();
            }
            else
                System.out.println("insert profanity here");
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

    private ImageView drawHeater()
    {
        int id = count;
        Image image = new Image("Images/heating.png",50,50,false,false);
        ImageView imageView = new ImageView(image);
        imageView.setCursor(Cursor.HAND);
        imageView.setOnMousePressed(event ->
        {
            currentSelected = id;
            heatPreferences.setVisible(true);
            lightPreferences.setVisible(false);
            Object temp = energyConsumers.get(id);
            if(temp instanceof ElectricHeating)
            {
                heatPreferences.stateCombo.getSelectionModel().select(BooleanUtils.toInteger(((ElectricHeating) temp).getState()));
                heatPreferences.powerRatingField.setText(Double.toString(((ElectricHeating) temp).getUsage()));
                heatPreferences.tempField.setText(Double.toString(((ElectricHeating) temp).getTemperature()));
                System.out.println(((ElectricHeating) temp).getUsage());
                orgSceneX = event.getSceneX();
                orgSceneY = event.getSceneY();
            }
            else
                System.out.println("insert profanity here");
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
        Button button = new Button("LED Bulb"); //probs should change to image view at a later date
        Button heatingButton = new Button("Heating");
        Button clearCanvas = new Button("Delete Room");
        heatingButton.setOnMouseClicked(event->
        {
            ImageView image = drawHeater();
            canvas.getChildren().add(image);
            energyConsumers.add(new ElectricHeating(true,1000,25));
                /*ElectricHeating temp = electricHeatings.get(electricHeatings.size()-1);
                try {
                    temp.InsertElectricHeatingData(temp.getAllData());
                } catch (SQLException e) {
                    e.printStackTrace();
                }*/
            //System.out.println(electricHeatings.get(heatCount).getUsage());
            count++;
        });
        button.setOnMouseClicked(event ->{
            energyConsumers.add(new Light(true,100));
            ImageView image = drawLight();
            canvas.getChildren().add(image);
            count++;
            update();
        });
        clearCanvas.setOnMouseClicked(event ->{
            System.out.print("Hit");
            borderPane.getChildren().removeAll(lines);
            borderPane.getChildren().remove(currentClick);
            while (!pointsX.isEmpty()) {
                pointsX.removeFirst();
                pointsY.removeFirst();
                lines.removeFirst();
            }

        });

        VBox vBox = new VBox(5);
        vBox.getChildren().addAll(button,heatingButton, clearCanvas);
        p.getChildren().addAll(vBox);
        return p;
    }

}