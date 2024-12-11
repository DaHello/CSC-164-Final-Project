/*
Author : Robert Kane
Class : csc 164
Class Section : 4C1
Date : 5/05/2022
Assignment : Final Project
Notes: Used the code from this video, and made some modifications to it
https://www.youtube.com/watch?v=fO4KUCtbmq8
 */

// Add a cancel button to option window and clean up code

package com.example.finalproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TicTacToeApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                TicTacToeApplication.class.getResource("tic-tac-toe-view.fxml")
        );
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Tic Tac Toe");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
