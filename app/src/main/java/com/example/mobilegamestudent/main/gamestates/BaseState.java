package com.example.mobilegamestudent.main.gamestates;

import com.example.mobilegamestudent.main.main.Game;

public abstract class BaseState {
    protected Game game;

    public BaseState(Game game){
        this.game = game;
    }

    public Game getGame() {
        return game;
    }
}
