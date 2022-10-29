package com.example.wonderfooleditor;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextFormatter;

import java.util.concurrent.atomic.AtomicInteger;

public class EditorController {

    private static final String REPEATED_TEXT = "I am a fool. ";
    private static final AtomicInteger COUNTER = new AtomicInteger(0);

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

            if (change.getCaretPosition() != COUNTER.get()) {
                change.setCaretPosition(COUNTER.get());
                change.setAnchor(COUNTER.get());
            }

            return change;
        }));


    }
}