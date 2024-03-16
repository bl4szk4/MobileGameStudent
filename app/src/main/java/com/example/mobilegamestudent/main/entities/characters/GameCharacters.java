package com.example.mobilegamestudent.main.entities.characters;


import static com.example.mobilegamestudent.main.helpers.GameConstants.Sprite.DEFAULT_SIZE;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.mobilegamestudent.R;
import com.example.mobilegamestudent.main.helpers.interfaces.BitmapMethods;
import com.example.mobilegamestudent.main.main.MainActivity;

public enum GameCharacters implements BitmapMethods {
    PLAYER(R.drawable.main_character_spritesheet);

    private Bitmap spriteSheet;
    private Bitmap[][] sprites = new Bitmap[7][4];

    GameCharacters(int resId) {
        options.inScaled = false;
        spriteSheet = BitmapFactory.decodeResource(MainActivity.getGameContext().getResources(), resId, options);

        for(int j = 0; j<sprites.length; j++){
            for(int i = 0; i<sprites[0].length; i++){
                sprites[j][i] = getScaledBitmap(Bitmap.createBitmap(spriteSheet,
                                                                DEFAULT_SIZE * i,
                                                                DEFAULT_SIZE * j,
                                                                    DEFAULT_SIZE,
                                                                    DEFAULT_SIZE));
            }
        }
    }

    public Bitmap getSpriteSheet() {
        return spriteSheet;
    }

    public Bitmap getSprite(int row, int charDirection) {
        return sprites[row][charDirection];
    }
}
