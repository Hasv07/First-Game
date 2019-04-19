package sample;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;

import javafx.scene.shape.Circle;

import javafx.stage.Stage;


public class Controller extends Application {
    Circle1 circle=new Circle1();
    @Override
    public void start(Stage primaryStage) {
        Pane vbox = new Pane();
       /* Button btn1=new Button("Hello Bitch");
        txt=new Text();

        btn1.setAlignment(Pos.TOP_CENTER);


        txt.setTextAlignment(TextAlignment.CENTER);

        vbox.getChildren().addAll(btn1,txt);

*/
/*
         r = new Circle(200, 200, 50);
*/



        Button bt1 = new Button("enlarge");
        bt1.setLayoutX(100);
        bt1.setLayoutY(300);

        Button bt2 = new Button("shrink");

        bt2.setLayoutX(250);
        bt2.setLayoutY(300);
        circle.setOnMouseDragged(e->{
            circle.setLayoutX(e.getX());
            circle.setLayoutY(e.getY());

        });
        vbox.setOnKeyPressed(e->
        {
            if(e.getCode()== KeyCode.U)
            {
                circle.enlarge();


            }
        });
        circle.setOnMouseClicked(e->
        {
            if(e.getButton()== MouseButton.PRIMARY)
            {
                circle.enlarge();


            }
        });
        bt1.setOnAction(e ->
                  {
                circle.enlarge();
            });

            bt2.setOnAction(e->{
                circle.shrink();

                });
        vbox.getChildren().addAll(circle,bt1, bt2);
        primaryStage.setWidth(400);
        primaryStage.setHeight(400);

        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.setTitle("wow");

        primaryStage.show();
    }



}

class Circle1 extends Pane
{ Circle      r=new Circle(200,200,50);


    public  Circle1() {
        getChildren().add(r);

    }

    public void enlarge()
    {
        r.setRadius(r.getRadius()+10);

    }

    public void shrink()
    {

        r.setRadius(r.getRadius()>10? r.getRadius()-10:r.getRadius());

    }



}
