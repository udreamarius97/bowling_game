package com.company;

public class PlayerFactory {

    public static Player getPlayer(int playerId){
        switch(playerId){
            case 0:
                return new ComputerPlayer();
            default:
                return new HumanPlayer(playerId);
        }
    }
}
