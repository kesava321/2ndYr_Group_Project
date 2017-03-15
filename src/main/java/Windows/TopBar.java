package Windows;

import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

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

    private Menu rooms = new Menu("Rooms");
    private ArrayList<MenuItem> roomItems = new ArrayList<>();

    public VBox build()
    {
        VBox topContainer = new VBox();
        mouse.setOnMouseClicked(e ->
        {
            penState = false;
            canvas.getChildren().removeAll(mouseLine);
            distance.setVisible(false);
            infoLabel.setVisible(true);
        });
        pen.setOnMouseClicked(e ->{
            penState = true;
            canvas.getChildren().add(mouseLine);
            distance.setVisible(true);
            infoLabel.setVisible(false);
        });
        Menu file = new Menu("File");
        Menu edit = new Menu("Edit");

        MenuItem openFile = new MenuItem("Open File");
        MenuItem saveFile = new MenuItem("Save");
        MenuItem exitApp = new MenuItem("Exit");
        MenuItem addRoom = new MenuItem("Add Room");


        for(int x =0 ;x<roomCount;x++)
        {
            MenuItem temp = new MenuItem("Room " + (x+1));
            int finalX = x;
            temp.setOnAction(event ->{
                setRoom(finalX);
                reload();
                update();
            });
            roomItems.add(temp);
            rooms.getItems().add(roomItems.get(x));
        }

        file.getItems().addAll(openFile,saveFile,exitApp,addRoom);

        addRoom.setOnAction(event ->
        {
            resetmouseline();
            addRoom();
            reload();
            updateRooms();
        });


        openFile.setOnAction(event ->
        {
            try
            {
                load();
                reload();
            } catch (IOException e)
            {
                e.printStackTrace();
            } catch (URISyntaxException e)
            {
                e.printStackTrace();
            } catch (ClassNotFoundException e)
            {
                e.printStackTrace();
            }
        });

        saveFile.setOnAction(event ->
        {
            try
            {
                save();
                System.out.println("SAVED YEY");
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        });

        MenuItem deleteRoom = new MenuItem("Delete Room");
        deleteRoom.setOnAction(event ->
        {
            System.out.println("PLS WORK");
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


        MenuItem attributes = new MenuItem("Room Attributes");
        attributes.setOnAction(event ->
        {
            RoomSettings settings = new RoomSettings();
            settings.start();
        });


        edit.getItems().addAll(deleteRoom, deleteItems, deleteAll,attributes);

        menuBar.getMenus().addAll(file, edit, rooms);
        toolbar.getItems().addAll(mouse,pen);
        topContainer.getChildren().addAll(menuBar,toolbar);
        return topContainer;
    }

    private void updateRooms()
    {
        MenuItem temp = new MenuItem("Room " + roomCount);
        temp.setOnAction(event ->{
            setRoom(roomCount-1);
            reload();
            update();
        });
        roomItems.add(temp);
        rooms.getItems().add(roomItems.get(roomCount-1));
    }

    public void deleteRoomOutline(){
        if(!pointsX.isEmpty())
        {
            canvas.getChildren().removeAll(lines);
            canvas.getChildren().remove(currentClick);
            pointsX.clear();
            pointsX.clear();
            lines.clear();
        }
         System.out.println("FINISHED");
     }

     public void deleteRoomContents(){
         canvas.getChildren().clear();
         energyConsumers.clear();
         currentSelected = 0;
         count = 0;
     }

}
