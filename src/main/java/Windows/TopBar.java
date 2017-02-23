package Windows;

import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.*;

import java.io.IOException;

import static Windows.CreateRoom.*;
/**
 * Created by daniel on 21/02/2017.
 */
public class TopBar extends CreateRoom
{
    private MenuBar menuBar = new MenuBar();

    private ToolBar toolbar = new ToolBar();
    private Button mouse = new Button("Mouse");
    private Button pen = new Button("Pen");

    public VBox build()
    {
        VBox topContainer = new VBox();
        mouse.setOnMouseClicked(e ->
        {
            penState = false;
            borderPane.getChildren().removeAll(mouseLine);
            distance.setVisible(false);
            infoLabel.setVisible(true);
        });
        pen.setOnMouseClicked(e ->{
            penState = true;
            borderPane.getChildren().add(mouseLine);
            distance.setVisible(true);
            infoLabel.setVisible(false);
        });
        Menu file = new Menu("File");
        Menu edit = new Menu("Edit");
        Menu help = new Menu("Help");

        MenuItem openFile = new MenuItem("Open File");
        MenuItem saveFile = new Menu("Save");
        MenuItem exitApp = new MenuItem("Exit");
        file.getItems().addAll(openFile,saveFile,exitApp);

        saveFile.setOnAction(event ->
        {
            try
            {
                save();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        });

        MenuItem deleteRoom = new MenuItem("Delete Room");
        deleteRoom.setOnAction(event ->
        {
            deleteRoomOutline();
        });


        MenuItem deleteItems = new MenuItem("Delete Items");
        deleteItems.setOnAction(event ->
        {
            deleteRoomContents();
        });

        MenuItem deleteAll = new MenuItem("Delete Room and Items");
        deleteAll.setOnAction(event ->
        {
            deleteRoomOutline();
            deleteRoomContents();
        });

        edit.getItems().addAll(deleteRoom, deleteItems, deleteAll);

        menuBar.getMenus().addAll(file, edit, help);
        toolbar.getItems().addAll(mouse,pen);
        topContainer.getChildren().addAll(menuBar,toolbar);
        return topContainer;
    }

     public void deleteRoomOutline(){
         System.out.print("Hit");
         borderPane.getChildren().removeAll(lines);
         borderPane.getChildren().remove(currentClick);
         while (!pointsX.isEmpty()) {
             pointsX.removeFirst();
             pointsY.removeFirst();
             lines.removeFirst();
         }
     }

     public void deleteRoomContents(){
         canvas.getChildren().clear();
         energyConsumers.clear();
         currentSelected = 0;
         count = 0;
     }

}
