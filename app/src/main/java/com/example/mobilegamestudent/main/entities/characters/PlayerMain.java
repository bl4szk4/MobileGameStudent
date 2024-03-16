package com.example.mobilegamestudent.main.entities.characters;

import android.graphics.PointF;

import com.example.mobilegamestudent.main.main.MainActivity;

public class PlayerMain extends Character{
    public PlayerMain() {
        super(new PointF(MainActivity.GAME_WIDTH/2, MainActivity.GAME_HEIGHT/2),
                GameCharacters.PLAYER);
    }

    public void update(double delta, boolean movePlayer){
        if(movePlayer)
            updateAnimation();
    }

    public void setLastCameValY(float lastCamValY){
        this.lastCamValY = lastCamValY;
    }
}
