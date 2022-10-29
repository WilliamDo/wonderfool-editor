package com.example.wonderfooleditor;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextFormatter;

import java.util.concurrent.atomic.AtomicInteger;

public class HelloController {

    private static final String REPEATED_TEXT = "I am a fool. ";
    private static final AtomicInteger COUNTER = new AtomicInteger(0);

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    private TextArea editor;

    @FXML
    public void initialize() {
        editor.setTextFormatter(new TextFormatter<>(change -> {
            if (change.isContentChange()) {
                if (change.isDeleted()) {
                    COUNTER.decrementAndGet();
                } else {
                    change.setText(REPEATED_TEXT.charAt(COUNTER.getAndIncrement() % REPEATED_TEXT.length()) + "");
                }
            }

            System.out.println(change.getCaretPosition());
            if (change.getCaretPosition() != COUNTER.get()) {
                change.setCaretPosition(COUNTER.get());
                change.setAnchor(COUNTER.get());
            }
            System.out.println(COUNTER.get());
            return change;
        }));


    }
}