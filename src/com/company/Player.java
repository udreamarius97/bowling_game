package com.company;

import java.util.ArrayList;
import java.util.List;

public class Player implements PlayerInterface{

    private List<Observer> observers;
    private int idPlayer;
    private int score;
    private List<Integer> scoreList;

    public Player(int idPlayer){
        this.idPlayer=idPlayer;
        this.score=0;
        this.scoreList=new ArrayList<Integer>(3);
        this.observers = new ArrayList<Observer>();
    }

    @Override
    public int getIdPlayer() {
        return idPlayer;
    }

    @Override
    public List<Integer> getScoreList() {
        return scoreList;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public void updateScoreList(Integer score) {
        this.scoreList.add(score);
        this.score = getScore() + score;
        notifyAllObservers();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
