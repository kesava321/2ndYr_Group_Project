package Windows;

import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.*;
import static Windows.CreateRoom.*;
/**
 * Created by daniel on 21/02/2017.
 */
public class TopBar
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
        MenuItem exitApp = new MenuItem("Exit");
        file.getItems().addAll(openFile,exitApp);

        MenuItem deleteRoom = new MenuItem("Delete Room");
        deleteRoom.setOnAction(event ->
        {
            System.out.print("Hit");
            borderPane.getChildren().removeAll(lines);
            borderPane.getChildren().remove(currentClick);
            while (!pointsX.isEmpty()) {
                pointsX.removeFirst();
                pointsY.removeFirst();
                lines.removeFirst();
            }
        });


        MenuItem deleteItems = new MenuItem("Delete Items");
        deleteItems.setOnAction(event ->
        {
            int j = energyConsumers.size();
            System.out.print(j);
            int i = 0;
            for (;i<j;i++) {
                Object remove = energyConsumers.get(i);
                energyConsumers.remove(remove);
            }
        });

        edit.getItems().addAll(deleteRoom, deleteItems);

        menuBar.getMenus().addAll(file, edit, help);
        toolbar.getItems().addAll(mouse,pen);
        topContainer.getChildren().addAll(menuBar,toolbar);
        return topContainer;
    }
}
