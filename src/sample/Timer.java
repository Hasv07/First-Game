package sample;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Timer extends Application {
    @Override
    public void start(Stage primaryStage)  {

        ClockPane circle=new ClockPane();
        Timeline animation=new Timeline(new KeyFrame(Duration.millis(1000),e->{
            circle.setcurrenttime(); // Set a new clock time

        }));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
        Scene scene = new Scene(circle, 400, 400);
        primaryStage.setTitle("ClockAnimation"); // Set the stage title
        primaryStage.setScene(scene);            // Put scene in stage
        primaryStage.show();
    }
}
class ClockPane extends Pane
{   int clockRadius=50;
    int centerX=200;
    int centerY=200;
    int second;
    int hour;
    int minute;

    public ClockPane( ) {
          }
        public void setcurrenttime()
        {
            second+=1;
            if(second==60)
            {
                minute+=1;
                second=0;
        }
             if(minute==60)
            {

                hour+=1;
                minute=0;
            }
            paintcircle();
    }
    public void  paintcircle()
{
    Circle   r=new Circle(200,200,50);

    Text t1 = new Text(200 - 5, 200 - 50 + 12, "12");
    Text t2 = new Text(200 - 50 + 3, 200 + 5, "9");
    Text t3 = new Text(200 + 50 - 10, 200 + 3, "3");
    Text t4 = new Text(200 - 3, 200 + 50 - 3, "6");
    double sLength = clockRadius * 0.8;
    double secondX = centerX + sLength *  Math.sin(second * (2 * Math.PI / 60));
    double secondY = centerY - sLength *       Math.cos(second * (2 * Math.PI / 60));
    Line sLine = new Line(centerX, centerY, secondX, secondY);

    double mLength = clockRadius * 0.65;
    double xMinute = centerX + mLength * Math.sin(minute * (2 * Math.PI / 60));
    double minuteY = centerY - mLength * Math.cos(minute * (2 * Math.PI / 60));
    Line mLine = new Line(centerX, centerY, xMinute, minuteY);
    double hLength = clockRadius * 0.5;
    double hourX = centerX + hLength *   Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
    double hourY = centerY - hLength *  Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
    Line hLine = new Line(centerX, centerY, hourX, hourY);

    sLine.setStroke(Color.RED);
    mLine.setStroke(Color.BLUE);



    r.setFill(null);
    r.setStroke(Color.BLACK);
    getChildren().clear();
    getChildren().addAll(r, t1, t2, t3, t4, sLine, mLine, hLine);

}
}