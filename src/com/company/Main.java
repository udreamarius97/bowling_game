package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Add number of players:");
        Scanner scanner = new Scanner(System.in);
        int nrOfPlayers = scanner.nextInt();
        if(nrOfPlayers == 0){
            System.out.println("Invalid number of players");
        }
        else if(nrOfPlayers == 1){
            GameClass.playGame(nrOfPlayers, GameType.COMPUTER_GAME, scanner);
        }
        else if(nrOfPlayers > 1)
            GameClass.playGame(nrOfPlayers, GameType.PVP_GAME, scanner);

        System.out.println("Game over!");
    }
}
