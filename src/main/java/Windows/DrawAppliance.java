package Windows;

import energyConsumers.*;
import javafx.scene.Cursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.apache.commons.lang3.BooleanUtils;

/**
 * Created by daniel on 26/02/2017.
 */
public class DrawAppliance extends CreateRoom
{

    public ImageView drawTap() {
        int id = count;
        Image image = new Image("Images/sink.png", 50, 50, false, false);
        ImageView imageView = new ImageView(image);
        imageView.setCursor(Cursor.HAND);
        imageView.setOnMousePressed(event ->
        {
            currentSelected = id;
            waterPreferences.setVisible(true,WaterPreferences.SINK);
            heatPreferences.setVisible(false);
            lightPreferences.setVisible(false);
            Object temp = energyConsumers.get(id);
            if (temp instanceof Sink) {
                waterPreferences.stateCombo.getSelectionModel().select(BooleanUtils.toInteger(((Sink) temp).getState()));
                waterPreferences.usePerHourField.setText(Integer.toString(((Sink) temp).getUsePerHour()));
                waterPreferences.avgUseTimeField.setText(Double.toString(((Sink) temp).getAvgTimeUsed()));
                waterPreferences.literPerUseField.setText(Double.toString(((Sink) temp).getUsage()));
            } else
                System.out.println("I done a boo boo");
            orgSceneX = event.getSceneX();
            orgSceneY = event.getSceneY();
        });
        imageView.setOnMouseDragged(event ->
        {
            if ((event.getX() > 0 && event.getX() < canvas.getWidth()) && (event.getY() > 0 && event.getY() < canvas.getHeight())) {
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
        imageView.setOnMouseReleased(event ->
        {
            if(energyConsumers.get(id) instanceof Sink)
            {
                double offsetX = event.getSceneX() - orgSceneX;
                double offsetY = event.getSceneY() - orgSceneY;
                Object o = event.getSource();
                ImageView i = (ImageView) o;
                ((Sink) energyConsumers.get(id)).setX(i.getX() + offsetX);
                ((Sink) energyConsumers.get(id)).setY(i.getY() + offsetY);
            }
        });
        return imageView;
    }

    public ImageView drawToilet() {
        int id = count;
        Image image = new Image("Images/toilet.png", 50, 50, false, false);
        ImageView imageView = new ImageView(image);
        imageView.setCursor(Cursor.HAND);
        imageView.setOnMousePressed(event ->
        {
            currentSelected = id;
            heatPreferences.setVisible(false);
            lightPreferences.setVisible(false);
            waterPreferences.setVisible(true,waterPreferences.TOILET);
            Object temp = energyConsumers.get(id);
            if (temp instanceof Toilet)
            {
                waterPreferences.stateCombo.getSelectionModel().select(BooleanUtils.toInteger(((Toilet) temp).getState()));
                waterPreferences.usePerHourField.setText(Integer.toString(((Toilet) temp).getUsePerHour()));
                waterPreferences.literPerUseField.setText(Double.toString(((Toilet) temp).getUsage()));
            } else
                System.out.println("oh-oh");
            orgSceneX = event.getSceneX();
            orgSceneY = event.getSceneY();
        });

        imageView.setOnMouseDragged(event ->
        {
            if ((event.getX() > 0 && event.getX() < canvas.getWidth()) && (event.getY() > 0 && event.getY() < canvas.getHeight())) {
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
        imageView.setOnMouseReleased(event ->
        {
            if(energyConsumers.get(id) instanceof Toilet)
            {
                double offsetX = event.getSceneX() - orgSceneX;
                double offsetY = event.getSceneY() - orgSceneY;
                Object o = event.getSource();
                ImageView i = (ImageView) o;
                ((Toilet) energyConsumers.get(id)).setX(i.getX() + offsetX);
                ((Toilet) energyConsumers.get(id)).setY(i.getY() + offsetY);
            }
        });
        return imageView;
    }

    public ImageView drawGasHeater()
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
        imageView.setOnMouseReleased(event ->
        {
            if(energyConsumers.get(id) instanceof GasHeating)
            {
                double offsetX = event.getSceneX() - orgSceneX;
                double offsetY = event.getSceneY() - orgSceneY;
                Object o = event.getSource();
                ImageView i = (ImageView) o;
                ((GasHeating) energyConsumers.get(id)).setX(i.getX() + offsetX);
                ((GasHeating) energyConsumers.get(id)).setY(i.getY() + offsetY);
            }
        });
        return imageView;
    }

    public ImageView drawLight()
    {
        int id = count;
        Image image = new Image("Images/bulb.png",50,50,false,false);
        System.out.println(image);
        ImageView imageView = new ImageView(image);
        imageView.setCursor(Cursor.HAND);
        imageView.setOnMousePressed(event ->
        {
            heatPreferences.setVisible(false);
            lightPreferences.setVisible(true);
            waterPreferences.setVisible(false);
            currentSelected = id;
            System.out.println(id);
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
        imageView.setOnMouseReleased(event ->
        {
            if(energyConsumers.get(id) instanceof Light)
            {
                double offsetX = event.getSceneX() - orgSceneX;
                double offsetY = event.getSceneY() - orgSceneY;
                Object o = event.getSource();
                ImageView i = (ImageView) o;
                ((Light) energyConsumers.get(id)).setX(i.getX() + offsetX);
                ((Light) energyConsumers.get(id)).setY(i.getY() + offsetY);
            }
        });
        return imageView;
    }

    public ImageView drawHeater()
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
            waterPreferences.setVisible(false);
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
                System.out.println("insert profanity here " + id + " " + temp.getClass());
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
        imageView.setOnMouseReleased(event ->
        {
            if(energyConsumers.get(id) instanceof ElectricHeating)
            {
                double offsetX = event.getSceneX() - orgSceneX;
                double offsetY = event.getSceneY() - orgSceneY;
                Object o = event.getSource();
                ImageView i = (ImageView) o;
                ((ElectricHeating) energyConsumers.get(id)).setX(i.getX() + offsetX);
                ((ElectricHeating) energyConsumers.get(id)).setY(i.getY() + offsetY);
            }
        });
        return imageView;
    }
}