package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ProfessorBall extends Application {
    @Override
    public void start(Stage primaryStage)  {
        {

            Ballpane ball=new Ballpane();
            Text txt1=new Text();
            txt1.setFont(new Font(30));
            txt1.setText("Score :");






            Text txt2=new Text();
            txt2.setFont(new Font(30));

            BorderPane p=new BorderPane();
            ClockPane clock=new ClockPane();
            Timeline animation=new Timeline(new KeyFrame(Duration.millis(1000), e->{
                clock.setcurrenttime(); // Set a new clock time
                ball.increaseSpeed();
                txt2.setText(Ballpane.counter.toString());

            }));

            animation.setCycleCount(Timeline.INDEFINITE);
            animation.play();
            // Increase and decrease animation with key presses


            ball.requestFocus();
           /* scene.setOnKeyPressed(e -> {
                if      (e.getCode() == KeyCode.RIGHT)   ball.MoveRight();
                else if (e.getCode() == KeyCode.LEFT) ball.MoveLeft();
            });*/
      /*     ball.setOnMouseClicked(e ->{
               if (e.getButton()==MouseButton.PRIMARY)   ball.MoveRight();
               else if(e.getButton()==MouseButton.SECONDARY) ball.MoveLeft();
           });
*/
            HBox H=new HBox();
            H.getChildren().addAll(clock,txt1,txt2);


            p.setTop(H);
            p.setCenter(ball);
            StackPane p2= new StackPane();
            Text txt3 =new Text();
            txt3.setFont(new Font(60));
            txt3.setText("Game Over");
            p2.getChildren().add(txt3);
       /*     Pane[] pane=new Pane[2];
            pane[0].getChildren().add(p);
            pane[1].getChildren().add(p2);*/

            Scene scene = new Scene(p);
           if(ball.moveball()) {
                scene.setRoot(p2);
            }
            scene.setOnKeyPressed(e -> {
                if      (e.getCode() == KeyCode.RIGHT)   ball.MoveRight();
                else if (e.getCode() == KeyCode.LEFT) ball.MoveLeft();



            });

            primaryStage.setScene(scene);
            primaryStage.setFullScreen(true);
            primaryStage.setTitle("ProfessorBall");
            primaryStage.show();


        }

    }
}
