package com.example.mobilegamestudent.main.main;

import android.content.Context;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

public class GamaPanel extends SurfaceView implements SurfaceHolder.Callback {

    private SurfaceHolder holder;
    private Game game;

    public GamaPanel(Context context) {
        super(context);
        holder = getHolder();
        holder.addCallback(this);
        game = new Game(holder);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return game.touchEvent(event);
    }
    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        game.startGameLoop();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

    }
}
