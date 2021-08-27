package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class GameClass {

    public static void playGame(int nrPlayers, GameType gameType, Scanner scanner) throws InterruptedException {
        if(gameType == GameType.COMPUTER_GAME){
            playComputerGame(scanner);
        }
        if(gameType == GameType.PVP_GAME){
            playPvPGame(nrPlayers, scanner);
        }
    }

    public static void playComputerGame(Scanner scanner) throws InterruptedException {
        Player computerPlayer = PlayerFactory.getPlayer(0);
        new ConcreteObserver(computerPlayer);
        Player humanPlayer = PlayerFactory.getPlayer(1);
        new ConcreteObserver(humanPlayer);

        for(int i=0; i<3; i++){
            playAsHuman(humanPlayer, scanner);
            sleep(300);
            playAsComputer(computerPlayer, scanner);
            sleep(300);
        }

        System.out.println("Player total score is: " + humanPlayer.getScore());
        System.out.println("Computer total score is: " + computerPlayer.getScore());
    }

    public static void playPvPGame(int nrPlayers,Scanner scanner) throws InterruptedException {
        List<Player> playerList = initializeListOfPlayers(nrPlayers);

        for(int i=0; i<3; i++){
            for(int j=0; j<nrPlayers; j++){
                playAsHuman(playerList.get(j), scanner);
                sleep(300);
            }
        }

        for(int i=0; i<nrPlayers; i++){
            Player player = playerList.get(i);
            System.out.println("Player " +player.getIdPlayer()+ " total score is: " + player.getScore());
        }

    }

    public static void playAsHuman(Player humanPlayer, Scanner scanner){
        System.out.println("Player " + humanPlayer.getIdPlayer() +" write strike to play:");
        String strike = scanner.next();
        if(strike.equals("strike")){
            Random r = new Random();
            int score = r.nextInt(11);
            humanPlayer.updateScoreList(score);
        }
        else{
            System.out.println("Sorry you missed");
            humanPlayer.updateScoreList(0);
        }
    }

    public static void playAsComputer(Player computerPlayer, Scanner scanner){
        Random r = new Random();
        int score = r.nextInt(11);
        System.out.println("Computer plays");
        computerPlayer.updateScoreList(score);
    }

    public static List<Player>initializeListOfPlayers(int nrPlayers){
        List<Player> playerList = new ArrayList<>();
        for(int i=0; i<nrPlayers; i++){
            Player player = new HumanPlayer(i+1);
            new ConcreteObserver(player);
            playerList.add(player);
        }

        return playerList;
    }
}
