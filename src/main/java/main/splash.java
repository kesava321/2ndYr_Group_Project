package main;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Date;
import java.util.Timer;

import static sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl.ThreadStateMap.Byte0.runnable;
import static sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl.ThreadStateMap.Byte0.timedWaiting;

/**
 * Created by Matt on 24-Dec-16.
 */
public class splash implements Runnable{

    //private Stage window = new Stage();

    public splash() throws Exception{
        Stage window = new Stage();
        window.setTitle("Building Control Systems");
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600);
        // load the image
        Image image = new Image("splash_logo.jpg");

        GridPane gridpane = new GridPane();
        gridpane.setHgap(10);
        gridpane.setVgap(10);

        final ImageView imv = new ImageView();
        final Image image2 = new Image("splash_logo.jpg");
        imv.setImage(image2);

        final HBox pictureRegion = new HBox();

        pictureRegion.getChildren().add(imv);
        gridpane.add(pictureRegion, 16, 5);


        root.getChildren().add(gridpane);
        window.setScene(scene);

        window.show();
 //       window.showAndWait();
      //  window.wait(1000);
     //   wait(1000);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run(){
                long x = System.currentTimeMillis();

                while((System.currentTimeMillis()-x)<1000){

                }

                window.hide();
            }
        });

        thread1.start();

        while (thread1.isAlive()){

        }
        window.hide();
    }


    @Override
    public void run() {
        try {
            new splash();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}




