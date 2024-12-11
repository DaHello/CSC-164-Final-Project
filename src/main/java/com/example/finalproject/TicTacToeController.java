package com.example.finalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class TicTacToeController {

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private Button btn4;

    @FXML
    private Button btn5;

    @FXML
    private Button btn6;

    @FXML
    private Button btn7;

    @FXML
    private Button btn8;

    @FXML
    private Button btn9;

    @FXML
    private Text player1ScoreTxt;

    @FXML
    private Button resetBtn; //button used to reset the game

    @FXML
    private Button optionsBtn; //loads the save scores window

    @FXML
    private Text Txt1; //Display text

    @FXML
    private Text Txt2;

    @FXML
    public Text player1Txt; //Player 1 name

    @FXML
    private TextField player1TxtField;

    @FXML
    private Button player1UpdateNameBtn; //Updates player 1's name

    @FXML
    private Text player2ScoreTxt;

    @FXML
    public Text player2Txt; //Player 2 or computer name

    @FXML
    private TextField player2TxtField;

    @FXML
    private Button player2UpdateNameBtn; //used to update player 2's name

    @FXML
    public Button playAloneBtn;

    @FXML
    private Text whosTurnTxt;

    @FXML
    private Text winnerTxt;

    @FXML
    private boolean playerTurn = true; // PlayerOne (X) goes first

    private static ArrayList<Button> buttons;

    static ArrayList<PlayerOne> players; // Create a new array list of type: superclass PlayerOne

    //accessible from players static ArrayList
    protected PlayerOne player1 = new PlayerOne("player1");;
    protected PlayerOne player2 = new PlayerTwo("player2");;
    protected PlayerOne computer = new Computer("Computer");

    public void initialize() {
        buttons = new ArrayList<>(Arrays.asList(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9));
        players = new ArrayList<>(Arrays.asList(player1, player2, computer));

        //rids the program of blue highlight on each button selected; however, causes a nullPointerException for value
//        for (Button value : buttons) {
//            value.setFocusTraversable(false);
//        }

    }

    @FXML
    void playAloneBtnPressed(ActionEvent event) {

        player2Txt.setText(computer.getName());
        Txt2.setText("Computer Mode Enabled");

        //if playAloneCheckbox is checked, it is disabled until the program closes, along with other options for player 2
        playAloneBtn.setDisable(true);
        player2TxtField.setDisable(true);
        player2UpdateNameBtn.setDisable(true);
    }

    @FXML
    void loadSaveScoresWindow(ActionEvent event) {
        System.out.println(players);
        Stage saveStage = (Stage)((Node) event.getSource()).getScene().getWindow();

        try {
            FXMLLoader fxmlWelcomeLoader = new FXMLLoader(getClass().getResource("options-view.fxml"));
            Scene welcomeScene = new Scene(fxmlWelcomeLoader.load(), 300, 200);
            saveStage.setTitle("Save Scores");
            saveStage.setScene(welcomeScene);
            saveStage.show();
        } catch (IOException e) {
            System.out.println("Couldn't load the fxml.");
            e.printStackTrace();
        }

    }

    @FXML
    void onBtn1Pressed(MouseEvent event) {
        setupButton(btn1);
    }

    @FXML
    void onBtn2Pressed(MouseEvent event) {
        setupButton(btn2);
    }

    @FXML
    void onBtn3Pressed(MouseEvent event) {
        setupButton(btn3);
    }

    @FXML
    void onBtn4Pressed(MouseEvent event) {
        setupButton(btn4);
    }

    @FXML
    void onBtn5Pressed(MouseEvent event) {
        setupButton(btn5);
    }

    @FXML
    void onBtn6Pressed(MouseEvent event) {
        setupButton(btn6);
    }

    @FXML
    void onBtn7Pressed(MouseEvent event) {
        setupButton(btn7);
    }

    @FXML
    void onBtn8Pressed(MouseEvent event) {
        setupButton(btn8);
    }

    @FXML
    void onBtn9Pressed(MouseEvent event) {
        setupButton(btn9);
    }

    @FXML
    void updatePlayer1TxtField(ActionEvent event) { // Change player1 name

        if (player1TxtField.getText().isEmpty()) { // if no name entered
            System.out.println("Invalid name entered: player1.");
        } else {

            players.get(0).setName(player1TxtField.getText());
            player1Txt.setText(players.get(0).getName());

            //update the fileName
            players.get(0).setFileName();

            //can only change name once per run
            player1UpdateNameBtn.setDisable(true);
            player1TxtField.setDisable(true);
        }

    }

    @FXML
    void updatePlayer2TxtField(ActionEvent event) { // change player2 name WOULD MAKE SENSE TO COMBINE THIS INTO ONE METHOD AND TAKE PLAYER AS PARAMETER

        if(player2TxtField.getText().equals("")) {
            System.out.println("Invalid name entered: player2.");
        } else {

            players.get(1).setName(player2TxtField.getText());
            player2Txt.setText(players.get(1).getName());

            players.get(1).setFileName();


            player2UpdateNameBtn.setDisable(true);
            player2TxtField.setDisable(true);
            //player2 is active
            playAloneBtn.setDisable(true);

        }

    }

    @FXML
    void onResetBtnPressed(ActionEvent event) { //reset buttons
        buttons.forEach(this :: resetButton); // each button is reset, using the resetButton method call
        winnerTxt.setText("Tic-Tac-Toe"); // reset game title
        playerTurn = true; // set player turn back to X
    }

    void setupButton(Button button) {
        setPlayerSymbol(button);
        button.setDisable(true);
    }

    public void setPlayerSymbol(Button button) {

        if (playerTurn) { // if PlayerOne's turn (X)
            whosTurnTxt.setText("It is O's turn!"); // set up the button that is pushed
            button.setText("X");
            playerTurn = false; // changes the turn to PlayerTwo or Computer (O)

        } else {

            whosTurnTxt.setText("It is X's turn!");
            button.setText("O");
            playerTurn = true; // set back to X's turn

        }

        checkIfWin(); //will check to see if there is a win, after each time a btn is pressed
    }

    public void resetButton(Button button) { //resets the game board
        button.setText(" ");
        button.setDisable(false); //turns off the disabling of the button
        whosTurnTxt.setText("It is X's turn!");
    }

    private int xWins = 0, xLosses = 0, oWins = 0, oLosses = 0;

    private void checkIfWin() {

        for (int a = 0; a < 8; a++) { //a for loop that iterates through each case of possible winning matches
            String line = switch (a) {
                case 0 -> btn1.getText() + btn2.getText() + btn3.getText();
                case 1 -> btn4.getText() + btn5.getText() + btn6.getText();
                case 2 -> btn7.getText() + btn8.getText() + btn9.getText();
                case 3 -> btn1.getText() + btn5.getText() + btn9.getText();
                case 4 -> btn3.getText() + btn5.getText() + btn7.getText();
                case 5 -> btn1.getText() + btn4.getText() + btn7.getText();
                case 6 -> btn2.getText() + btn5.getText() + btn8.getText();
                case 7 -> btn3.getText() + btn6.getText() + btn9.getText();
                default -> null; // null if no matches
            };

            //X winner
            if (line.equals("XXX")) {

                winnerTxt.setText("X won!");

                for (Button button : buttons) { //disables remainder of buttons
                    disableButton(button);
                }

                xWins ++;
                oLosses ++;

                players.get(0).setWins(xWins); //updates player1's wins

                updatePlayerScore(players.get(0), player1ScoreTxt);
                if (!player2Txt.getText().equals(players.get(2).getName())) {
                    //if Computer is not playing, updates player2's losses
                    players.get(1).setLosses(oLosses);
                    updatePlayerScore(players.get(1), player2ScoreTxt);
                } else {
                    //Computer takes place of player2
                    players.get(2).setLosses(oLosses);
                    updatePlayerScore(players.get(2), player2ScoreTxt);
                }

            }

            //O winner
            else if (line.equals("OOO")) {

                winnerTxt.setText("O won!");

                for (Button button : buttons) {
                    disableButton(button);
                }

                oWins ++;
                xLosses ++;

                players.get(0).setLosses(xLosses); //updates player1's losses

                updatePlayerScore(players.get(0), player1ScoreTxt);

                if (!player2Txt.getText().equals(players.get(2).getName())) {
                    players.get(1).setWins(oWins);
                    updatePlayerScore(players.get(1), player2ScoreTxt);
                } else {
                    players.get(2).setWins(oWins);
                    updatePlayerScore(players.get(2), player2ScoreTxt);
                }

            }
        }
    }

    public void updatePlayerScore(PlayerOne player, Text scoreTxt) {
        scoreTxt.setText(player.getPlayerScore());
    }

    public void disableButton(Button button) {
        button.setDisable(true);
    }

}
