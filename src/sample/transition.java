package sample;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class transition extends Application {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        launch();
    }

    @Override
    public void start(Stage window) throws Exception {
        // TODO Auto-generated method stub
        //--------------Entity----------
        Circle c1 = new Circle(50, 50, 25);
        c1.setFill(null);
        c1.setStroke(Color.BLACK);
        Rectangle r1 = new Rectangle(300, 300, 100, 100);


        //------ path---------
        PathTransition path = new PathTransition(Duration.millis(1000), r1, c1);
        path.setCycleCount(Timeline.INDEFINITE);


        //------------------BUttons-----------
        Button Stop = new Button("Stop");
        Stop.setOnAction(e -> path.pause());
        Button Play = new Button("Play");
        Play.setOnAction(e -> path.play());

        //---------ButtonsLayout-----------
        BorderPane y = new BorderPane();
        y.setAlignment(c1, Pos.CENTER);
        y.setAlignment(Play, Pos.CENTER);
        y.setAlignment(Stop, Pos.CENTER);
        y.setLeft(Play);
        y.setRight(Stop);
        y.setCenter(c1);

        //------Scene-------
        Scene s1 = new Scene(y, 500, 500);
        window.setTitle("Animation");
        window.setScene(s1);
        window.setFullScreen(true);
        window.show();

    }
}
