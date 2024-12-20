package com.example.finalproject;

public class Player { //super class
    // the default name of the player, also the name of the file that will be stored, after choosing to save

    private String name;
    private int wins = 0, losses = 0;
    private String fileName;

    public Player() {
        // no parameters, create overloaded constructor for name (player 1)
        this.name = "Player";
        this.fileName = name + "-score.txt";
    }

    public Player(String name) {
        this.name = name;
        this.fileName = name + "-score.txt";
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public String getName() {
        return name;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName() {
        this.fileName = this.getName() + "score.txt";
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlayerScore() { //returns the score of the player in FXML format
        return this.getName() + "'s score: Wins: " + this.getWins() + ", Losses: " + this.getLosses();
    }

    @Override
    public String toString() { //returns the score of the player in file format,
        return "name='" + this.name + '\'' +
                ", wins=" + this.wins +
                ", losses=" + this.losses;
    }
}
