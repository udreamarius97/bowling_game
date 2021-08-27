package com.company;

import java.util.List;

public interface PlayerInterface {

    void updateScoreList(Integer score);
    int getIdPlayer();
    List<Integer> getScoreList();
    int getScore();
}
