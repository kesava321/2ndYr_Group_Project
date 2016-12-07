package Windows;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import main.CAB;

import java.awt.event.MouseEvent;



/**
 * Created by daniel on 04/12/2016.
 */
public class MainController
{

    private CAB application;

    public void setApp(CAB Application)
    {
        this.application = application;
    }


    ElectrictyButton.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent e) {
        label.setText("Electricity");
    }
}
    //A button with the specified text caption and icon.
    Image imageEletricity = new Image(getClass().getResourceAsStream("electricity.png"));
    Button ElectrictyButton = new Button("Electricity", new ImageView(imageEletricity));


    DropShadow shadow = new DropShadow();
//Adding the shadow when the mouse cursor is on
ElectrictyButton.addEventHandler(MouseEvent.MOUSE_ENTERED,
        new EventHandler<MouseEvent>() {
    public void handle(MouseEvent e) {
        ElectrictyButton.setEffect(shadow);
    }
}
//Removing the shadow when the mouse cursor is off
ElectrictyButton.addEventHandler(MouseEvent.MOUSE_EXITED,
        new EventHandler<MouseEvent>() {
    public void handle(MouseEvent e) {
        ElectrictyButton.setEffect(null);
    }
}
}
