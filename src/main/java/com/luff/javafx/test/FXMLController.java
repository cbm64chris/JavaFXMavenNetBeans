package com.luff.javafx.test;

import eu.hansolo.medusa.Clock;
import java.net.URL;
import java.time.ZonedDateTime;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class FXMLController implements Initializable {

    @FXML
    private Clock clock;
    
    private static final ScheduledExecutorService TICKING = Executors.newSingleThreadScheduledExecutor();;
    private final Runnable run = FXMLController.this::changeDisplay;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TICKING.scheduleAtFixedRate(run, 0, 1, TimeUnit.SECONDS);
    }
    
    private void changeDisplay() {
        Platform.runLater(() -> clock.setTime(ZonedDateTime.now()));
    }

}
