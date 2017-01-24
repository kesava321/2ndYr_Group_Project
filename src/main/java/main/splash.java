package main;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Matt on 24-Dec-16.
 */
public class splash {

    private Stage window = new Stage();

    public void Splash() throws IOException {

        window.setTitle("Building Control Systems");
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 800, 600);
        root.setStyle("-fx-background-image: url(menu_bgr.jpg);-fx-background-size: 800, 600;-fx-background-repeat: no-repeat;");
        window.setScene(scene);
        window.show();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        window.hide();
    }
}

