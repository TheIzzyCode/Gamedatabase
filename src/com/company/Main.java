package com.company;

import java.util.*;

public class Main {

    private static Scanner plotscanner = new Scanner(System.in);
    private static Playstation4 ps5 = new Playstation4();

    public static void main(String[] args) {


        boolean quit = false;
        int choice = 0;
        printinstructions();
        while(!quit){
            System.out.println("Enter your choice");

            try {choice = plotscanner.nextInt();
            }
            catch(Exception e) {
                System.out.println("Please enter a number!");
            }
            plotscanner.nextLine();

            switch(choice) {
                case 1:addgames();
                    break;
                case 2:modifygame();
                    break;
                case 3:ps5.printgames();
                    break;
                case 4:removegame();
                    break;
                case 5:querylist();
                    break;
                case 6:printinstructions();
                    break;
                case 7:
                    break;
                case 8:quit = true; System.out.println("You finished making your gamelist");
                    break;
            }

        }


    }

    public static void printinstructions() {
        System.out.println("Press 1 to add a game ");
        System.out.println("Press 2 to modify a game");
        System.out.println("Press 3 to show your gamelist");
        System.out.println("Press 4 to delete a game");
        System.out.println("Press 5 to find a game in your list");
        System.out.println("Press 6 to show the options menu");
        System.out.println("Press 7 to quit this application");
    }

    private static void addgames() {
        System.out.println("Please enter a gamename");
        String gamename = plotscanner.nextLine();
        System.out.println("Please enter a plot for your game");
        String gameplot = plotscanner.nextLine();
        Game newgame = new Game(gamename, gameplot);
        if (ps5.addgame(newgame)) {
            System.out.println(gamename + " its plot is " + gameplot);
        } else {
            System.out.println("Cannot add, " + gamename + " already on file");
        }
    }

    private static void querylist(){
        System.out.println("Type in the game you are trying to find");
        String findgame = plotscanner.nextLine();
        Game existingame = ps5.querygame(findgame);
        if(existingame == null){System.out.println("Game not found, please enter it in your database");
        return;}
        System.out.println("The game " + existingame.getGames()+ " Its plot is " +existingame.getPlot());

    }

    private static void removegame() {
        System.out.println("Please enter the name of the game you want to remove");
        String gameremove = plotscanner.nextLine();
        Game existinggame = ps5.querygame(gameremove);
        if (existinggame == null) {
            System.out.println("Game not found, please enter it in your database");
            return;
        }

        if (ps5.deletegame(existinggame)) {
        } else {
            System.out.println("Error deleting contact");
        }
    }

    private static void modifygame(){
        System.out.println("Please enter the name of the game you want to modify");
        String gamemodify = plotscanner.nextLine();
        Game existinggame = ps5.querygame(gamemodify);
        if(existinggame == null){
            System.out.println("Game not found, please add it by use option 1");
            return;
        }
        if(ps5.deletegame(existinggame)){
            System.out.println("Please now enter a new game");
            String gamename = plotscanner.nextLine();
            System.out.println("Please enter a plot for your game");
            String gameplot = plotscanner.nextLine();
            Game newgame = new Game(gamename, gameplot);
            if (ps5.addgame(newgame)) {
                System.out.println("The previous game has been succesfully modified");
                System.out.println(gamename + " its plot is " + gameplot);
            } else {
                System.out.println("Cannot add, " + gamename + " already on file");
            }

        }
    }


}