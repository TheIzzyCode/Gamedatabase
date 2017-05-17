package com.company;

import java.util.Collections;
import java.util.Scanner;

import java.util.ArrayList;
public class Playstation4 {
    private ArrayList<Game> mygamelist;

    public Playstation4() {
        this.mygamelist = new ArrayList<Game>();
    }
    Scanner plotscanner = new Scanner(System.in);

    public boolean addgame(Game game){
        if(findgameplot(game.getGames())>= 0){ System.out.println("This game already exists");
        return false;}
        mygamelist.add(game);
        return true;
    }
    private int findgameplot(Game game){
        return this.mygamelist.indexOf(game);
    }

    private int findgameplot(String findnewgame) {
        for (int i = 0; i < this.mygamelist.size(); i++) {
            Game game = this.mygamelist.get(i);
            if (game.getGames().equals(findnewgame)) {
                return i;}
            }
            return -1;
    }
    public String querygame(Game game){
        if(findgameplot(game)<= 0){ return game.getGames();}
        return null;

    }
    public Game querygame(String name) {
        int position = findgameplot(name);
        if(position >=0) {
            return this.mygamelist.get(position);
        }

        return null;
    }

    public void printgames() {
        System.out.println("Game List");
        for (int i = 0; i < this.mygamelist.size(); i++) {
            System.out.println((i + 1) + "." +
                    this.mygamelist.get(i).getGames() + " its plot is " +
                    this.mygamelist.get(i).getPlot());
        }
    }

    public boolean deletegame(Game game){
        int foundposition = findgameplot(game);
        if(foundposition < 0){System.out.println(game.getGames()+ "Was not found");
            return false;}
        this.mygamelist.remove(foundposition);
        System.out.println(game.getGames()+ " has been removed from your list");
        return true;

    }
}


