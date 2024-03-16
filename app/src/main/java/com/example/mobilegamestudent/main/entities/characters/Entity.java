package com.example.mobilegamestudent.main.entities.characters;

import android.graphics.PointF;
import android.graphics.RectF;

public abstract class Entity implements Comparable<Entity>{
    protected RectF hitbox;
    protected boolean active = true;
    protected float lastCamValY = 0;

    public Entity(PointF pos, float width, float height){
        this.hitbox =new RectF(pos.x, pos.y, pos.x + width, pos.y + height);
    }

    public RectF getHitbox() {
        return hitbox;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public int compareTo(Entity o) {
        return Float.compare(hitbox.top - lastCamValY, o.hitbox.top - o.lastCamValY);
    }
}
