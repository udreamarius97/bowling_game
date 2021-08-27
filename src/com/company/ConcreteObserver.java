package com.company;

import java.util.List;

public class ConcreteObserver extends Observer{

    public ConcreteObserver(Player player){
        this.player=player;
        this.player.attach(this);
    }

    @Override
    public void update() {
        List<Integer> playerScoreList = player.getScoreList();
        System.out.println("You struke " + playerScoreList.get(playerScoreList.size() - 1) + " points");
        System.out.println("You score is: " + player.getScore());
        System.out.println("-----------");
    }
}
