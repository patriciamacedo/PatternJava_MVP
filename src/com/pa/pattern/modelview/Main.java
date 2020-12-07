/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pa.pattern.modelview;

import com.pa.pattern.modelview.model.Group;
import com.pa.pattern.modelview.view.GroupUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author brunomnsilva
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
                
       Group model = new Group("PA-12132");
       GroupUI view = new GroupUI(model);
       model.addObservers(view);
        BorderPane window = new BorderPane();
        window.setCenter(view);
        Scene scene = new Scene(window, 500, 250);
        primaryStage.setTitle("Programming Group ");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
