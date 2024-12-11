package com.example.finalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class optionsController {

    File player1Score;
    File player2Score;

    @FXML
    private Button saveBtn; //saves the scores of both players

    @FXML
    private Text saveTxt; //will change to show if save was successful or not

    @FXML
    void onSaveBtnPressed(ActionEvent event) { //create a save file for player(s)
        System.out.println(TicTacToeController.players);

        createPlayerFile(TicTacToeController.players.get(0), player1Score);
        createPlayerFile(TicTacToeController.players.get(1), player2Score);
        createPlayerFile(TicTacToeController.players.get(2), player2Score);

    }

    public void createPlayerFile(PlayerOne player, File file ) { //creates a file based off of a name

        //create the files in Java: test version
        file = new File("C:\\Users\\rober\\Documents\\CSC164-4C1-All Assignments\\FinalProject\\" + player.getFileName());

        try {
            if (file.createNewFile()) { //if creating a player file is successful
                try { //try to write to that file, if it doesn't already exist
                    FileWriter scoreWriter = new FileWriter(file); //the file you are writing to?
                    scoreWriter.write(player.toString());
                    scoreWriter.close();
                } catch (IOException e) { //displays why the file cannot be written to
                    e.printStackTrace();
                }

            } else {
                System.out.println("Cannot create player's file, file already exists.");

            }

        } catch (IOException e) { //display error message (if any)
            e.printStackTrace();

        }


    }

}
