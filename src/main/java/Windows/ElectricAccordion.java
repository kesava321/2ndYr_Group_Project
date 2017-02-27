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
        Button button = new Button("LED Bulb"); //probs should change to image view at a later date
        Button heatingButton = new Button("Heating");
        heatingButton.setOnMouseClicked(event->
        {
            ImageView image = draw.drawHeater();
            canvas.getChildren().add(image);
            energyConsumers.add(new ElectricHeating(true,1000,25));
                /*ElectricHeating temp = electricHeatings.get(electricHeatings.size()-1);
                try {
                    temp.InsertElectricHeatingData(temp.getAllData());
                } catch (SQLException e) {
                    e.printStackTrace();
                }*/
            //System.out.println(electricHeatings.get(heatCount).getUsage());
            //insert the data into database
            ControlSqlite cs = new ControlSqlite();
            Object[] o = {-1, 1000};
            cs.InsertData("Rating", o);
            cs.DisplayTable();
            count++;
        });
        button.setOnMouseClicked(event ->{
            energyConsumers.add(new Light(true,100));
            ImageView image = draw.drawLight();
            canvas.getChildren().add(image);
            count++;
            update();
        });
        VBox vBox = new VBox(5);
        vBox.getChildren().addAll(button,heatingButton);
        p.getChildren().addAll(vBox);
        return p;
    }

}