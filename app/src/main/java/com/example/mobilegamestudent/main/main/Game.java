package com.example.mobilegamestudent.main.main;

import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

import com.example.mobilegamestudent.main.gamestates.Menu;
import com.example.mobilegamestudent.main.gamestates.Options;
import com.example.mobilegamestudent.main.gamestates.Playing;

public class Game {
    private SurfaceHolder holder;
    private GameLoop gameLoop;
    private GameState gameState = GameState.PLAYING;
    private Playing playing;
    private Menu menu;
    private Options options;

    public Game(SurfaceHolder holder){
        this.holder = holder;
        gameLoop = new GameLoop(this);
        initGameStates();
    }

    public void update(double delta) {
        switch (gameState){
            case MENU:
                menu.update(delta);
                break;
            case PLAYING:
                playing.update(delta);
                break;
            case OPTIONS:
                options.update(delta);
                break;
        }

    }

    public void render() {
        Canvas c = holder.lockCanvas();
        c.drawColor(Color.BLACK);


        switch (gameState){
            case MENU:
                menu.render(c);
                break;
            case PLAYING:
                playing.render(c);
                break;
            case OPTIONS:
                options.render(c);
                break;
        }
        holder.unlockCanvasAndPost(c);
    }

    public void initGameStates(){
        menu = new Menu(this);
        playing = new Playing(this);
        options = new Options(this);

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
