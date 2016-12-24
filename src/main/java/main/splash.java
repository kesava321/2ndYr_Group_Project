package main;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.io.IOException;

/**
 * Created by Matt on 24-Dec-16.
 */
public class splash {

    public static void Splash() throws IOException {
        Stage Splash = new Stage();
        //Splash.initStyle(StageStyle.UNDECORATED);
        Splash.setTitle("Building Control Systems");

        Group rootGroup = new Group();
        Scene scene =
                new Scene(rootGroup, 300, 200, Color.BLACK);

        Text text1 = new Text(25, 25, "Mr. Robot Presents");
        text1.setFill(Color.CHOCOLATE);
        text1.setFont(Font.font(java.awt.Font.SERIF, 25));
        rootGroup.getChildren().add(text1);

        Splash.setScene(scene);
        Splash.show();
        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Splash.hide();

    }
}

