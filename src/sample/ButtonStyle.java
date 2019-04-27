package sample;


import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ButtonStyle extends Button {


    public ButtonStyle(String text)
    {
        getStylesheets().add("sample/Style.css");
        setText(text);
        setButtonFont();
        setPrefWidth(190);
        setPrefHeight(49);
        getStyleClass().add("record-sales");
        initializeBtnListeners();

    }

    private void setButtonFont()
    {

            setFont(Font.font("verdana", FontWeight.EXTRA_BOLD, 23));

    }


    private void initializeBtnListeners()
    {

        setOnMouseEntered(e -> {


        });
        setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                setEffect(null);
            }
        });


    }
}
