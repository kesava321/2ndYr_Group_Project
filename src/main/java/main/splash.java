package main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

/**
 * Created by Matt on 24-Dec-16.
 */
public class splash {

    private Stage window = new Stage();

    public void Splash() throws IOException {

        window.setTitle("Building Control Systems");
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 300, 200);

        Text text1 = new Text(25, 25, "Mr. Robot Presents");
        text1.setFill(Color.CHOCOLATE);
        text1.setFont(Font.font(java.awt.Font.SERIF, 25));
        root.setCenter(text1);
        root = FXMLLoader.load(getClass().getClassLoader().getResource("MainMenu.fxml"));
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

