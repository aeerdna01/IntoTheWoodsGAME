package PaooGame.Entities;

import PaooGame.Handler;

import java.awt.*;

public abstract class Entity {

    protected Handler handler;
    protected float x, y;
    protected  int width, height;
    protected Rectangle bounds;
    protected  int health;
    public static final int DEFAULT_HEALTH=5;
    protected  boolean active = true;
    protected final Rectangle attackBounds;

    public Entity(Handler handler, float x, float y, int width, int height){
        this.handler=handler;
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        health=DEFAULT_HEALTH;

        bounds= new Rectangle(0,0,width, height);
        attackBounds = new Rectangle(0, 0, width, height);
    }

    public abstract void update();

    public abstract void draw(Graphics g);

    public abstract void die();

    public void hurt(int amt){
        health -= amt;
        if(health <= 0){
            active = false;
            die();
        }
    }

    public boolean checkEntityCollision(float xOffset, float yOffsett){
        for(Entity e: handler.getWorld().getEntityManager().getEntities()){
            if(e.equals(this))
                continue;
            if(e.getCollisionBounds(0f,0f).intersects(getCollisionBounds(xOffset,yOffsett)))
                return true;
        }
        return false;
    }

    public Rectangle getCollisionBounds(float xOffset, float yOffset){
        return new Rectangle((int) (x + bounds.x + xOffset),(int) (y + bounds.y + yOffset), bounds.width,bounds.height);
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
