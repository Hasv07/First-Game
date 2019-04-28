package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;

import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

import javafx.scene.layout.*;

import javafx.scene.media.AudioClip;
import javafx.scene.text.Font;

import javafx.scene.text.Text;

import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;


public class ProfessorBall extends Application {
    Timeline main1;
    Image img=new Image("cursor/wind-rose.png");
    Character[] Characters={Character.Boy,Character.Robot};



    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage)  {
        {
            menupane main=new menupane();

            Ballpane ball=new Ballpane();
            Text txt1=new Text();
            txt1.setFont(new Font(30));
            txt1.setText("Score :");





            Text txt2=new Text();
            txt2.setFont(new Font(30));

            ClockPane clock=new ClockPane();
            HBox H=new HBox();
            H.getChildren().addAll(clock,txt1,txt2);
            BorderPane p=new BorderPane();
            p.setTop(H);
            p.setCenter(ball);
            StackPane p2= new StackPane();
            Text txt3 =new Text();
            txt3.setFont(new Font(60));
            p2.getChildren().add(txt3);
  /*   Pane[] pane=new Pane[2];
            pane[0].getChildren().add(p);
            pane[1].getChildren().add(p2);*/


            Scene scene = new Scene(main);
            primaryStage.setMinWidth(800);
            primaryStage.setMinHeight(800);

            Timeline animation = new Timeline(new KeyFrame(Duration.millis(50), e1 -> {

                clock.setcurrenttime(); // Set a new clock time
                ball.increaseSpeed();
                txt2.setText(Ballpane.counter.toString());

            }

            ));


            Timeline animation2=new Timeline(new KeyFrame(Duration.millis(50), e2->{

                if (ball.cond) {

                    txt3.setText("Game Over" + "\n" + " Score:" + Ballpane.counter);


                    scene.setRoot(p2);


                    scene.setCursor(new ImageCursor(img));






                }}));
            main1 = new Timeline(new KeyFrame(Duration.millis(1), e -> {


                if (main.flag) {
                    main1.stop();
                    scene.setRoot(p);

                    scene.setCursor(Cursor.NONE);


                    animation.setCycleCount(Timeline.INDEFINITE);
                    animation.play();


                    animation2.setCycleCount(Timeline.INDEFINITE);
                    animation2.play();


                } else {

                        scene.setCursor(new ImageCursor(img));


                }
            }));

            main1.setCycleCount(-1);
            main1.play();







/*
 scene.setOnKeyPressed(e -> {
                if      (e.getCode() == KeyCode.RIGHT)   ball.MoveRight();
                else if (e.getCode() == KeyCode.LEFT) ball.MoveLeft();
            });

     ball.setOnMouseClicked(e ->{
               if (e.getButton()==MouseButton.PRIMARY)   ball.MoveRight();
               else if(e.getButton()==MouseButton.SECONDARY) ball.MoveLeft();
           });
*/




            ball.requestFocus();

            scene.setOnKeyPressed(e -> {
                if(!(ball.j>=Characters[menupane.charindex].dead)) {
                    if (e.getCode() == KeyCode.RIGHT) ball.MoveRight();
                    else if (e.getCode() == KeyCode.LEFT) ball.MoveLeft();
                }


            });



            URL url = this.getClass().getResource("/audio/Black_Clover_-_Opening_7_HDGrabvidtoMp3.mp3");

            AudioClip note=new AudioClip(url.toString());
            note.setVolume(100);
            note.setCycleCount(-1);

            note.play();



    primaryStage.setScene(scene);
    primaryStage.setFullScreen(true);
    primaryStage.setTitle("ProfessorBall");
    primaryStage.show();


        }

    }
}
