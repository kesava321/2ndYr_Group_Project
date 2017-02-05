package Windows;
import energyConsumers.Light;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import org.apache.commons.lang3.BooleanUtils;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by daniel on 24/12/2016.
 */
public class CreateRoom
{

    private Stage window = new Stage();
    public ArrayList<Light> lights = new ArrayList<Light>();
    private ArrayList<Pane> prefs = new ArrayList<Pane>();
    BorderPane borderPane = new BorderPane();
    private Pane prefPane = new Pane();
    private Pane canvas = new Pane();
    private int count = 0;
    private int heatCount = 0;
    private int currentHeatingSelected =0;
    private int currentSelected =0;
    private Label infoLabel = new Label();
    private FlowPane infoPane = new FlowPane();
    LightPreferences lightPreferences = new LightPreferences();
    HeatPreferences heatPreferences = new HeatPreferences();
    double orgSceneX, orgSceneY;

    //Room coords
    LinkedList<Double> pointsX = new LinkedList<Double>();
    LinkedList<Double> pointsY = new LinkedList<Double>();
    LinkedList<Line> lines = new LinkedList<Line>();
    Circle currentClick = new Circle();

    private ToolBar toolbar = new ToolBar(
            new Button("Mouse"),
            new Button("Pen")
    );

    private void build()
    {
        Accordion accordion = new Accordion();
        Pane pane;
        TitledPane tiledPane;
        Lights light = new Lights();
        pane = light.getView();
        tiledPane = new TitledPane("Electric", pane);
        accordion.getPanes().add(tiledPane);
        accordion.setExpandedPane(tiledPane);
        borderPane.setLeft(accordion);
    }

    private ImageView drawLight()
    {
        int id = count;
        Image image = new Image("Images/bulb.png",50,50,false,false);
        ImageView imageView = new ImageView(image);
        imageView.setCursor(Cursor.HAND);
        imageView.setOnMousePressed(event ->
        {
            currentSelected = id;
            double powerRating = lights.get(id).getUsage();
            int lighState = BooleanUtils.toInteger(lights.get(id).getState());
            lightPreferences.powerRatingField.setText(String.valueOf(Double.parseDouble(String.valueOf(powerRating))));
            lightPreferences.stateCombo.getSelectionModel().select(lighState);
            orgSceneX = event.getSceneX();
            orgSceneY = event.getSceneY();
        });
        imageView.setOnMouseDragged(event ->
        {
            if((event.getX() >0 && event.getX() < canvas.getWidth()) && (event.getY() > 0 && event.getY() < canvas.getHeight()))
            {
                double offsetX = event.getSceneX() - orgSceneX;
                double offsetY = event.getSceneY() - orgSceneY;
                Object o = event.getSource();
                ImageView i = (ImageView) o;
                i.setX(i.getX() + offsetX);
                i.setY(i.getY() + offsetY);
                orgSceneX = event.getSceneX();
                orgSceneY = event.getSceneY();
            }
        });
        return imageView;
    }

    private ImageView drawHeater()
    {
        int id = heatCount;
        Image image = new Image("Images/heating.png",50,50,false,false);
        ImageView imageView = new ImageView(image);
        imageView.setCursor(Cursor.HAND);
        imageView.setOnMousePressed(event ->
        {
            orgSceneX = event.getSceneX();
            orgSceneY = event.getSceneY();
        });
        imageView.setOnMouseDragged(event ->
        {
            if((event.getX() >0 && event.getX() < canvas.getWidth()) && (event.getY() > 0 && event.getY() < canvas.getHeight()))
            {
                double offsetX = event.getSceneX() - orgSceneX;
                double offsetY = event.getSceneY() - orgSceneY;
                Object o = event.getSource();
                ImageView i = (ImageView) o;
                i.setX(i.getX() + offsetX);
                i.setY(i.getY() + offsetY);
                orgSceneX = event.getSceneX();
                orgSceneY = event.getSceneY();
            }
        });
        return imageView;

    }

    public void update()
    {
        double power,emmisions;
        power = emmisions = 0;
        for(int x =0; x<lights.size();x++)
        {
            System.out.println(lights.size() + " " + lights.get(x).getConsumption(60)); //converts watts into KW
            power+= lights.get(x).getConsumption(60);
            emmisions+= lights.get(x).estimatedEmissions(60);
        }
        infoLabel.setText("Power: " + power/1000 + " KwH" + " Emmisions:" + emmisions/1000 + "Kg/co2");
    }

    public void start() throws Exception
    {
        ListView list = new ListView();
        BorderPane.setAlignment(list, Pos.TOP_LEFT);
        BorderPane.setMargin(list, new Insets(12,12,12,12));
        borderPane.setTop(toolbar);
        build();
        borderPane.setCenter(canvas);
        borderPane.setRight(prefPane);

        borderPane.getChildren().add(currentClick);
        canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                pointsX.add(event.getSceneX());
                pointsY.add(event.getSceneY());
                currentClick.setCenterX(event.getSceneX());
                currentClick.setCenterY(event.getSceneY());
                currentClick.setRadius(4.0f);

                drawLine();
            }
        });


        infoPane.getChildren().add(infoLabel);
        borderPane.setBottom(infoPane);
        Scene scene = new Scene(borderPane,800,600);
        scene.getStylesheets().add(getClass().getResource("/Room.css").toExternalForm());
        window.setScene(scene);
        window.show();
    }

    public void drawLine(){
        if (pointsX.size()<1){
            return;
        }
        else {
            for (int i = 0; i < pointsX.size() - 1; i++) {
                Line temp = new Line(pointsX.get(i), pointsY.get(i), pointsX.get(i + 1), pointsY.get(i + 1));
               // temp.draw();
                lines.add(temp);
                borderPane.getChildren().add(temp);
            }
        }
    }

    class LightPreferences
    {
        Pane pane = new Pane();
        Label state = new Label("Light State");
        ComboBox stateCombo = new ComboBox();
        Label powerRating = new Label("Power Rating");
        TextField powerRatingField = new TextField();
        GridPane grid = new GridPane();
        public Pane init()
        {
            stateCombo.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
            {
                boolean state = BooleanUtils.toBoolean(stateCombo.getSelectionModel().getSelectedIndex());
                lights.get(currentSelected).setState(state);

            });
            stateCombo.getItems().addAll("Off","On");
            grid.setConstraints(state,0,0);
            grid.setConstraints(stateCombo,1,0);
            grid.setConstraints(powerRating,0,1);
            grid.setConstraints(powerRatingField,1,1);
            grid.getChildren().addAll(state,stateCombo,powerRating,powerRatingField);
            pane.getChildren().add(grid);
            return pane;
        }
    }

    class HeatPreferences
    {
        Pane pane = new Pane();
        Label temp = new Label("Temperature");
        TextField tempField = new TextField();
        Label powerRating = new Label("Power Rating");
        TextField powerRatingField = new TextField();
        GridPane grid = new GridPane();
        public Pane init()
        {
            grid.setConstraints(temp,0,0);
            grid.setConstraints(tempField,1,0);
            grid.setConstraints(powerRating,0,1);
            grid.setConstraints(powerRatingField,1,1);
            grid.getChildren().addAll(temp,tempField,powerRating,powerRatingField);
            pane.getChildren().add(grid);
            return pane;
        }

    }
    class Lights
    {

        public Pane getView()
        {
            Pane p = new Pane();
            Button button = new Button("LED Bulb"); //probs should change to image view at a later date
            Button heatingButton = new Button("Heating");
            heatingButton.setOnMouseClicked(event->
            {
                heatCount++;
                ImageView image = drawHeater();
                canvas.getChildren().add(image);
                //add to array list
            });
            button.setOnMouseClicked(event ->{
                lights.add(new Light(true,100));
                ImageView image = drawLight();
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

    class drawRoom{

    }
}
