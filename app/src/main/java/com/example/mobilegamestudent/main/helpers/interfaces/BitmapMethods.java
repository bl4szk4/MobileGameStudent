package com.example.mobilegamestudent.main.helpers.interfaces;

import static com.example.mobilegamestudent.main.helpers.GameConstants.Sprite.SCALE_MULTIPLIER;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public interface BitmapMethods {

    BitmapFactory.Options options = new BitmapFactory.Options();

    default Bitmap getScaledBitmap(Bitmap bitmap){
        return Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() * SCALE_MULTIPLIER,
                                bitmap.getHeight() * SCALE_MULTIPLIER, false);
    }
}
