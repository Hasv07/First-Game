package sample;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;


class menupane extends Pane {
    ArrayList<Image> background = new ArrayList<>();
    int index,idleIndex;
    Rectangle pane;
    static boolean flag=false;
    static ButtonStyle bt1=new ButtonStyle("Start");
     Image arrow=new Image("images/Arrow/icons8-chevron-right-100.png");
    public menupane() {
        ImageView arrowView=new ImageView(arrow);
        ImageView arrowView2=new ImageView(arrow);
         bt1.setLayoutY(860);
         bt1.setLayoutX(850);
        ImageView character=new ImageView(new Image("images/boyidleanimation/Idle (1).png"));
        character.fitHeightProperty().bind(heightProperty().multiply(0.3));
        character.fitWidthProperty().bind(widthProperty().multiply(0.22));



        pane=new Rectangle();
        pane.widthProperty().bind(widthProperty());
        pane.heightProperty().bind(heightProperty());
         bt1.layoutXProperty().bind(pane.widthProperty().multiply(0.46));
        bt1.layoutYProperty().bind((pane.heightProperty().multiply(0.786)));

        arrowView.layoutXProperty().bind(pane.widthProperty().multiply(0.7));
        arrowView.layoutYProperty().bind((pane.heightProperty().multiply(0.5)));
        arrowView2.layoutXProperty().bind(pane.widthProperty().multiply(0.23));
        arrowView2.layoutYProperty().bind((pane.heightProperty().multiply(0.5)));
        character.layoutXProperty().bind(pane.widthProperty().multiply(0.45));
        character.layoutYProperty().bind((pane.heightProperty().multiply(0.39)));
        arrowView2.setScaleX(-1);
        getChildren().addAll(pane,bt1,arrowView,arrowView2,character);

        Timeline animation=new Timeline(new KeyFrame(Duration.millis(75),e->
        {
                character.setImage(new Image("images/boyidleanimation/Idle ("+(idleIndex+1)+").png"));
                idleIndex++;
                if (idleIndex >= 15) {
                idleIndex = 0;
                }

                if(index<9) {

                    pane.setFill(new ImagePattern(new Image("images/background/y2mate.com - studiopolis_background_animation_dZLR5MuBeuk_1080p 00" + (index + 1) + ".jpg")));
                    index++;
                    if (index >= 499) {
                        index = 0;
                    }
                }
                else if(index<99)
                {
                    pane.setFill(new ImagePattern(new Image("images/background/y2mate.com - studiopolis_background_animation_dZLR5MuBeuk_1080p 0" + (index + 1) + ".jpg")));
                    index++;
                    if (index >= 499) {
                        index = 0;
                    }
                }
                else
            {
                pane.setFill(new ImagePattern(new Image("images/background/y2mate.com - studiopolis_background_animation_dZLR5MuBeuk_1080p " + (index + 1) + ".jpg")));
                index++;
                if (index >= 499) {
                    index = 0;
                }
            }



        }));

        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
        bt1.setOnMouseClicked(e->
        {
            System.out.println("clicked");
            animation.stop();
            flag=true;

        });
    }
}
public class TestMain extends Application {
    @Override
    public void start(Stage primaryStage)  {
        menupane menu=new menupane();
        Scene scene=new Scene(menu);
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.setTitle("ProfessorBall");

        primaryStage.show();


    }
    public static void main(String[] args) {
        launch(args);
    }
}
