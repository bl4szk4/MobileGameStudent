package com.example.mobilegamestudent.main;

import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

public class Game {
    private SurfaceHolder holder;
    private GameLoop gameLoop;
    private GameState gameState = GameState.MENU;

    public Game(SurfaceHolder holder){
        this.holder = holder;
        gameLoop = new GameLoop(this);
        initGameStates();
    }

    public void update(double delta) {
    }

    public void render() {
        Canvas c = holder.lockCanvas();
        c.drawColor(Color.YELLOW);


        holder.unlockCanvasAndPost(c);
    }

    public void initGameStates(){

    }

    public boolean touchEvent(MotionEvent event){
        return true;
    }

    public void startGameLoop(){
        gameLoop.startGameLoop();
    }

    public enum GameState {
        MENU, OPTIONS, PLAYING;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
}
