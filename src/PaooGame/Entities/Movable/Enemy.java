package PaooGame.Entities.Movable;

import PaooGame.Entities.Entity;
import PaooGame.Graphics.Animation;
import PaooGame.Graphics.Assets;
import PaooGame.Handler;

import java.awt.*;

public class Enemy extends Creature{
    protected int direction;
    private Animation animDown;
    private Animation animUp;
    private Animation animRight;
    private Animation animLeft;
    private boolean attacking;

    public Enemy(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        direction = 0;

        bounds.x=22;
        bounds.y=44; //44
        bounds.width=19; //19
        bounds.height=19; //19


        attackBounds.x = 26;
        attackBounds.y = 20;
        attackBounds.width = 54;
        attackBounds.height = 32;

        //Animations
        animDown = new Animation(250, Assets.hero_walk_down);
        animUp = new Animation(250,Assets.hero_walk_up);
        animLeft = new Animation(250,Assets.hero_walk_left);
        animRight = new Animation(250,Assets.hero_walk_right);
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics g) {

    }

    @Override
    public void die() {

    }
}

