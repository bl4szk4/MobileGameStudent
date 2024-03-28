package com.example.mobilegamestudent.main.gamestates;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.view.MotionEvent;

import com.example.mobilegamestudent.main.entities.characters.PlayerMain;
import com.example.mobilegamestudent.main.helpers.GameConstants;
import com.example.mobilegamestudent.main.helpers.interfaces.GameStateInterface;
import com.example.mobilegamestudent.main.main.Game;
import com.example.mobilegamestudent.main.ui.PlayingUI;

public class Playing extends BaseState implements GameStateInterface {

    private PlayerMain playerMain;
    private boolean movePlayer;     //moving player by the joystick
    private final Paint redPaint;
    private PointF lastTouchDiff;
    private PlayingUI playingUI;

    public Playing(Game game) {

        super(game);
        playerMain = new PlayerMain();
        redPaint = new Paint();
        redPaint.setStyle(Paint.Style.STROKE);
        redPaint.setColor(Color.RED);

        playingUI = new PlayingUI(this);
    }

    @Override
    public void update(double delta) {
        playerMain.update(delta, movePlayer);
    }

    @Override
    public void render(Canvas c) {
        drawPlayer(c);
        playingUI.draw(c);
    }

    @Override
    public void touchEvents(MotionEvent event) {
        playingUI.touchEvents(event);
    }

    private void drawPlayer(Canvas c){
        c.drawBitmap(
                playerMain.getGameCharType().getSprite(getAniIndex(), playerMain.getCharacterDirection()),
                playerMain.getHitbox().left - GameConstants.Sprite.X_DRAW_OFFSET,
                playerMain.getHitbox().top - GameConstants.Sprite.Y_DRAW_OFFSET,
                null
        );

    }

    private int getAniIndex(){
        return playerMain.getAniIndex();
    }

    public void setPlayerMoveTrue(PointF lastTouchDiff) {
        movePlayer = true;
        this.lastTouchDiff = lastTouchDiff;
    }

    public void setPlayerMoveFalse() {
        movePlayer = false;
        playerMain.resetAnimation();
    }
}
