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
    private ImageView drawTap() {
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

    private ImageView drawToilet() {
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

    public Pane getView() {
        Pane p = new Pane();
        Button waterTap = new Button("Tap");
        Button waterToilet = new Button("Toilet");
        //Button waterKitchen = new Button("Kitchen");
        waterTap.setOnMouseClicked(event ->
        {
            ImageView image = drawTap();
            canvas.getChildren().add(image);
            energyConsumers.add(new Sink(true, 30, 2,2));
            count++;
        });
        waterToilet.setOnMouseClicked(event ->{

            ImageView image = drawToilet();
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


