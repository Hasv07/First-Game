package sample;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
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
    int i=0;
    boolean cond;
    static Integer counter = 0;
    final static double redius = 50;
    double x = redius, y = redius, dy = 1, dx = 1,q=600,w=600,dq=1.5,dw=1;
    Circle circle = new Circle(x, y, redius);
    Circle circle2 = new Circle(q, w, redius);

    Timeline animation,animation2;
    ImageView person;
      Image [] image={new Image("images/Walk (1).png") ,new Image("images/Walk (2).png"),
              new Image("images/Walk (3).png"),new Image("images/Walk (4).png"),
              new Image("images/Walk (5).png"),new Image("images/Walk (6).png"),
              new Image("images/Walk (7).png"),new Image("images/Walk (8).png"),
              new Image("images/Walk (9).png"),new Image("images/Walk (10).png"),
              new Image("images/Walk (11).png"),new Image("images/Walk (12).png"),
              new Image("images/Walk (13).png"),new Image("images/Walk (14).png"),
              new Image("images/Walk (15).png")
   ,new Image("images/Dead (1).png") ,new Image("images/Dead (2).png"),
            new Image("images/Dead (5).png"),new Image("images/Dead (6).png"),
            new Image("images/Dead (7).png"),new Image("images/Dead (8).png"),
            new Image("images/Dead (9).png"),new Image("images/Dead (10).png"),
            new Image("images/Dead (11).png"),new Image("images/Dead (12).png"),
            new Image("images/Dead (13).png"),new Image("images/Dead (14).png"),
            new Image("images/Dead (15).png")};


    public Ballpane() {










        person=new ImageView(image[0]);


        person.layoutYProperty().bind(heightProperty().subtract(100));
        person.setLayoutX(0);
        person.setFitHeight(100);
        person.setFitWidth(100);

        circle.setFill(Color.BLUE);
        circle2.setFill(Color.YELLOW);

        getChildren().addAll(circle,circle2,person);
        animation = new Timeline(new KeyFrame(Duration.millis(50), e -> moveball()));
        animation2 = new Timeline(new KeyFrame(Duration.millis(1000), e -> counter++));

        Timeline animation3=new Timeline(new KeyFrame(Duration.millis(50), e->{

            if (moveball()) {

                animation.stop();
                animation2.stop();



            }}));


        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
        animation2.setCycleCount(Timeline.INDEFINITE);
        animation2.play();
        animation3.setCycleCount(Timeline.INDEFINITE);
        animation3.play();
    }

    public void play() {
        animation.play();



    }


    public void pause() {
        animation.pause();

    }

    public void increaseSpeed() {
        animation.setRate(animation.getRate() + 0.05);


    }

    public void decreaseSpeed() {
        animation.setRate(animation.getRate() > 0 ? animation.getRate() - 0.1 : 0);
    }

    public DoubleProperty rateProperty() {
        return animation.rateProperty();
    }

    public void MoveRight() {

        person.setX(person.getX() < getWidth() - 70 ? person.getX() + 10 : person.getX());


        person.setScaleY(1);

        person.setRotate(360);


            person.setImage(image[i]);
            i++;



        if(i>14)
        {
            i=0;

        }


    }

    public void MoveLeft() {
        person.setX(person.getX() > 0 ? person.getX() - 10 : 0);




        person.setScaleY(-1);
        person.setRotate(180);




        person.setImage(image[i]);
        i++;



        if(i>14)
        {
            i=0;

        }










    }

    protected boolean moveball() {

        if (x < redius || x > getWidth() - redius) {
            dx *= -1;

        }

        if (y < redius || y > getHeight() - redius) {
            dy *= -1;

        }
        if (q < redius || q > getWidth() - redius) {
            dq *= -1;
        }

        if (w < redius || w > getHeight() - redius) {
            dw *= -1;

        }


        x += dx;
        y += dy;
        q += dq;
        w += dw;
        circle.setCenterX(x);
        circle.setCenterY(y);
        circle2.setCenterX(q);
        circle2.setCenterY(w);

      /*  if(counter>0) {

            Shape shape = Shape.intersect(person, circle);

            Shape shape2 = Shape.intersect(person, circle2);


            boolean intersects = shape.getBoundsInLocal().getWidth() != -1;
            boolean intersects2 = shape2.getBoundsInLocal().getWidth() != -1;

            if (intersects||intersects2) {
                System.out.println("Collision" + counter);
                return true;

            }
        }*/
        if(counter>0) {
/*
            System.out.println(Math.sqrt(Math.pow(circle.getCenterX()-person.getX(),2)+Math.pow(circle.getCenterY()-person.getY(),2)));
*/
            if(circle.intersects(person.getBoundsInParent()))
            {
                i=0;

                Timeline deadanimation=new Timeline(new KeyFrame(Duration.millis(50),e->{
                    person.setImage(image[i+15]);
                    i++;



                    if(i>29)
                    {
                        i=15;

                    }

                }
                        ));
                deadanimation.setCycleCount(1);
                deadanimation.play();
                System.out.println("Collision" + counter);

                Timeline deadanimation2=new Timeline();
                deadanimation2.setOnFinished(e-> {
                    cond = true;
                });
                if(cond)
                {
                    return true;
                }
            }
            if(circle2.intersects(person.getBoundsInParent()))
            {
                i=0;

                Timeline deadanimation=new Timeline(new KeyFrame(Duration.millis(100),e->{

                    person.setImage(image[i+15]);
                    i++;



                    if(i>29)
                    {
                        i=15;

                    }

                }
                ));
                deadanimation.setCycleCount(1);
                deadanimation.play();
                System.out.println("Collision" + counter);
                Timeline deadanimation2=new Timeline();
                deadanimation2.setOnFinished(e->{
                     cond=true;
                });
                if(cond)
                {
                    return true;
                }
            }
        }

        return false;

    }
}
