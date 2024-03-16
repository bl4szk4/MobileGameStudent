package com.example.mobilegamestudent.main.entities.characters;

import static com.example.mobilegamestudent.main.helpers.GameConstants.CharacterDirection.DOWN;
import static com.example.mobilegamestudent.main.helpers.GameConstants.Sprite.HITBOX_SIZE;

import android.graphics.PointF;

import com.example.mobilegamestudent.main.helpers.GameConstants;

public class Character extends Entity{

    protected int aniTick, aniIndex;
    protected int characterDirection = DOWN;
    protected final GameCharacters gameCharType;
    public Character(PointF pos, GameCharacters gameCharType) {
        super(pos, HITBOX_SIZE, HITBOX_SIZE);
        this.gameCharType = gameCharType;
    }

    protected void updateAnimation(){
        aniTick++;
        if(aniTick >= GameConstants.Animation.SPEED){
            aniTick = 0;
            aniIndex++;
            if(aniIndex >= GameConstants.Animation.AMOUNT)
                aniIndex = 0;
        }
    }

    public int getAniIndex() {
        return aniIndex;
    }


    public int getCharacterDirection() {
        return characterDirection;
    }

    public void setCharacterDirection(int characterDirection) {
        this.characterDirection = characterDirection;
    }

    public GameCharacters getGameCharType() {
        return gameCharType;
    }

    public void resetAnimation(){
        aniIndex = 0;
        aniTick = 0;
    }
}
