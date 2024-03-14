package com.example.mobilegamestudent.main;

public class GameLoop implements Runnable{

    private Game game;
    private Thread gameThread;

    public GameLoop(Game game) {
        this.game = game;
        gameThread = new Thread(this);
    }

    @Override
    public void run() {
        long lastDelta = System.nanoTime();
        final long nanoSec = 1_000_000_000;
        long now_delta, timeSinceLastDelta;
        double delta;
        while(true){
            now_delta = System.nanoTime();
            timeSinceLastDelta = now_delta - lastDelta;
            delta = timeSinceLastDelta / nanoSec;

            game.update(delta);
            game.render();

        }

    }


    public void startGameLoop(){
        gameThread.start();
    }
}
