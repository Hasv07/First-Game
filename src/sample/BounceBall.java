package sample;


import com.sun.javafx.tk.Toolkit;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.geometry.Dimension2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;




public class BounceBall extends Application {
    public void start(Stage primaryStage)
    {
        Ballpane ballPane = new Ballpane(); // Create a ball pane

        // Note: The ball animates itself using a Timeline; we don’t have to do
        // things like move it around here; all we do here is start / stop and
        // speed up / slow down.  See the BallPane class for the other details

        // Pause and resume animation
        ballPane.setOnMousePressed (e -> ballPane.pause()); // mouse down  pause
        ballPane.setOnMouseReleased(e -> ballPane.play());  // mouse  up   resume

        // Increase and decrease animation with key presses
        ballPane.setOnKeyPressed(e -> {          // respond to only UP and DOWN
            if      (e.getCode() == KeyCode.UP)   ballPane.increaseSpeed();
            else if (e.getCode() == KeyCode.DOWN) ballPane.decreaseSpeed();
        });
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

        // Create a scene and place it in the stage
        Scene scene = new Scene(ballPane, primaryScreenBounds.getWidth(), primaryScreenBounds.getHeight());
        primaryStage.setTitle("BounceBallControl"); // Set the stage title
        primaryStage.setScene(scene);               // Put scene in stage
        primaryStage.show();                        // Display the stage

        // Must request focus after the primary stage is displayed
        ballPane.requestFocus();
    }

}
class Ballpane extends Pane {

    static Integer counter = 0;
    final static double redius = 50;
    double x = redius, y = redius, dy = 1, dx = 1;
    Circle circle = new Circle(x, y, redius);
    Timeline animation;
    Rectangle person = new Rectangle(0, 0, 70, 70);


    public Ballpane() {
        person.layoutYProperty().bind(heightProperty().subtract(70));
        circle.setFill(Color.BLUE);
        getChildren().addAll(circle, person);
        animation = new Timeline(new KeyFrame(Duration.millis(50), e -> moveball()));

        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
    }

    public void play() {
        animation.play();



    }


    public void pause() {
        animation.pause();

    }

    public void increaseSpeed() {
        animation.setRate(animation.getRate() + 1);
        counter++;


    }

    public void decreaseSpeed() {
        animation.setRate(animation.getRate() > 0 ? animation.getRate() - 0.1 : 0);
    }

    public DoubleProperty rateProperty() {
        return animation.rateProperty();
    }

    public void MoveRight() {

        person.setX(person.getX() < getWidth() - 70 ? person.getX() + 10 : person.getX());


    }

    public void MoveLeft() {
        person.setX(person.getX() > 0 ? person.getX() - 10 : 0);
    }

    protected boolean moveball() {

        if (x < redius || x > getWidth() - redius) {
            dx *= -1;
        }

        if (y < redius || y > getHeight() - redius) {
            dy *= -1;
        }


        x += dx;
        y += dy;
        circle.setCenterX(x);
        circle.setCenterY(y);
        if(counter>0) {

            Shape shape = Shape.intersect(person, circle);
            boolean intersects = shape.getBoundsInLocal().getWidth() != -1;
            if (intersects) {
                System.out.println("Collision" + counter);
                return true;

            }
        }
        return false;

    }
}
