package com.liquidr.daynightterminator;

import com.nighthacks.fx.daynightterminator.DayNightTerminator;
import java.util.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class TestColor extends Application {
    @Override
    public void start(Stage primaryStage) {
        DayNightTerminator map = DayNightTerminator.colorful();
        map.addMapSelectionListener((lat,lon)->System.out.println(lat+","+lon));
        map.setSelectIndicatorCircle(5);
        long t0 = System.currentTimeMillis();
        long dt = 20*24*60*60*1000; // 20 days
        Slider slider = new Slider(t0-dt,t0+dt,t0);
        Label label = new Label("Hello");
        slider.valueProperty().addListener((v)->{
            long nt = (long)slider.getValue();
            label.setText(new Date(nt).toString());
            map.setTime(nt);
        });
        final VBox root = new VBox();
        root.getChildren().add(map);
        root.getChildren().add(label);
        root.getChildren().add(slider);
        VBox.setVgrow(map, Priority.ALWAYS);
        Scene scene = new Scene(root);
        primaryStage.setTitle("Color world");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
