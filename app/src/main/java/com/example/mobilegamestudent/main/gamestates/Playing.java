package com.example.mobilegamestudent.main.gamestates;

import android.graphics.Canvas;
import android.view.MotionEvent;

import com.example.mobilegamestudent.main.helpers.interfaces.GameStateInterface;
import com.example.mobilegamestudent.main.main.Game;

public class Playing extends BaseState implements GameStateInterface {

    public Playing(Game game) {
        super(game);
    }

    @Override
    public void update(double delta) {

    }

    @Override
    public void render(Canvas c) {

    }

    @Override
    public void touchEvents(MotionEvent event) {

    }
}
