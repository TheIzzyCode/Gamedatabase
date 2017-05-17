package com.company;

public class Game {

    private String games;
    private String plot;

    public Game(String games, String plot) {
        this.games = games;
        this.plot = plot;
    }

    public String getGames() {
        return games;
    }

    public String getPlot() {
        return plot;
    }

    public static Game addgameback(String game, String plot){
        return new Game(game, plot);

    }



}
