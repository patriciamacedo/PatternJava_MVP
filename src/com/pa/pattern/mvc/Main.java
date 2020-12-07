/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pa.pattern.mvc;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @author brunomnsilva
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane window = new BorderPane();
        window.setCenter(FactoryMVCGroup.create());
        Scene scene = new Scene(window, 400, 250);
        primaryStage.setTitle("Group Programming");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {

        launch(args);
    }

}
