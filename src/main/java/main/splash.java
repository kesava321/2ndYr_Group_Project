package main;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Timer;

import static sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl.ThreadStateMap.Byte0.runnable;

/**
 * Created by Matt on 24-Dec-16.
 */
public class splash implements Runnable{

    //private Stage window = new Stage();

    public splash() throws IOException, InterruptedException {
        Stage window = new Stage();
        window.setTitle("Building Control Systems");
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600);
        // load the image
        Image image = new Image("splash.jpg");


        window.setScene(scene);
        window.show();

        window.hide();
    }


    @Override
    public void run() {
        try {
            new splash();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

