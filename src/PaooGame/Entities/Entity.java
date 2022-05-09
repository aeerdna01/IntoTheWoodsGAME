package PaooGame.Entities;

import PaooGame.Handler;

import java.awt.*;

public abstract class Entity {

    protected Handler handler;

    protected float x, y;
    protected  int width, height;

    protected  int life;
    protected int current_life;
    public static final int DEFAULT_life = 10;
    protected  boolean active = true;

    protected final Rectangle attackBounds;
    protected Rectangle normalBounds;
    protected Rectangle attackbounds;
    protected Rectangle bounds;

    public Entity(Handler handler, float x, float y, int width, int height){
        this.handler=handler;
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        life=DEFAULT_life;


        normalBounds= new Rectangle(0,0,width, height);
        attackBounds = new Rectangle(0, 0, width, height);

        bounds = normalBounds;
        attackbounds = attackBounds;
    }

    public abstract void update();

    public abstract void draw(Graphics g);

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
    public Rectangle getAttackBounds(float xOffset, float yOffset){
        return new Rectangle((int) (x + attackbounds.x + xOffset), (int) (y + attackbounds.y + yOffset), attackbounds.width,attackbounds.height);
    }


    public abstract void die();

    public void hurt(int amt){
        current_life -= amt;
        if(current_life <= 0){
            active = false;
            die();
        }
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

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getCurrent_life() {
        return current_life;
    }

    public void setCurrent_life(int current_life) {
        this.current_life = current_life;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
