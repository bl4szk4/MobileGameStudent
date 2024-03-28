package com.example.mobilegamestudent.main.ui;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.view.MotionEvent;

import com.example.mobilegamestudent.main.gamestates.Playing;
import com.example.mobilegamestudent.main.main.MainActivity;

public class PlayingUI {
    private final Playing playing;
    private final PointF joystickCenterPos = new PointF((float)0.2 * MainActivity.GAME_WIDTH, (float)0.8 * MainActivity.GAME_HEIGHT);
    private final float radius = 150;
    private final Paint circlePaint;
    private boolean touchDown;
    private int joystickPointerId = -1;

    public PlayingUI(Playing playing) {
        this.playing = playing;
        circlePaint = new Paint();
        circlePaint.setColor(Color.RED);
        circlePaint.setStrokeWidth(5);
        circlePaint.setStyle(Paint.Style.STROKE);
    }

    private void drawUI(Canvas c){
        c.drawCircle(joystickCenterPos.x, joystickCenterPos.y, radius, circlePaint);
    }

    public void draw(Canvas c){
        drawUI(c);
    }

    private boolean checkInsideJoystick(PointF eventPos, int pointerId){
        if(isInsideRadius(eventPos, joystickCenterPos)){
            touchDown = true;
            joystickPointerId = pointerId;
            return true;
        }
        return false;
    }

    private boolean isInsideRadius(PointF eventPos, PointF circle) {
        float a = Math.abs(eventPos.x - circle.x);
        float b = Math.abs(eventPos.y - circle.y);
        float c = (float)Math.hypot(a, b);

        return c <= radius;
    }

    public void touchEvents(MotionEvent e){
        final int action = e.getActionMasked();
        final  int actionIdx = e.getActionIndex();
        final int pointerId = e.getPointerId(actionIdx);
        final PointF eventPos = new PointF(e.getX(actionIdx), e.getY(actionIdx));

        switch  (action){
            case MotionEvent.ACTION_DOWN, MotionEvent.ACTION_POINTER_DOWN ->{
                if(checkInsideJoystick(eventPos, pointerId)){
                    touchDown = true;
                }
            }

            case MotionEvent.ACTION_MOVE -> {
                if(touchDown){
                    for (int i = 1; i < e.getPointerCount(); i++){
                        if(e.getPointerId(i) == joystickPointerId){
                            float xDiff = e.getX(i) - joystickCenterPos.x;
                            float yDiff = e.getY(i) - joystickCenterPos.y;
                            playing.setPlayerMoveTrue(new PointF(xDiff, yDiff));
                        }
                    }
                }
            }

            case MotionEvent.ACTION_UP, MotionEvent.ACTION_POINTER_UP ->{
                if(pointerId == joystickPointerId){
                    resetJoystickButton();
                }
            }
        }
    }

    private void resetJoystickButton() {
        touchDown = false;
        playing.setPlayerMoveFalse();
        joystickPointerId = -1;
    }
}
