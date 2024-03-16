package com.example.mobilegamestudent.main.helpers;

public class GameConstants {

    public static final class Sprite{
        public static final int DEFAULT_SIZE = 16;
        public static final int SCALE_MULTIPLIER = 6;
        public static final int SIZE = SCALE_MULTIPLIER * DEFAULT_SIZE;
        public static final int HITBOX_SIZE = 12 * SCALE_MULTIPLIER;

    }

    public static final class CharacterDirection{
        public static final int DOWN = 0;
        public static final int UP = 1;
        public static final int LEFT = 2;
        public static final int RIGHT = 3;
    }

    public static final class Animation{
        public static final int SPEED = 10;
        public static final int AMOUNT = 4;
    }
}
