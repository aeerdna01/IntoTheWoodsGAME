package PaooGame.Entities.Movable;

import PaooGame.Graphics.Animation;
import PaooGame.Graphics.Assets;
import PaooGame.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy extends Creature{

    protected Animation animDown, animUp, animLeft, animRight, lastAnim;
    private int width, height;
   // protected Animation attackDown, attackUp, attackLeft, attackRight;
    protected boolean attacking=false;
    protected Hero hero;
    protected int direction = 0;

    public Enemy(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        Creature.DEFAULT_CREATURE_HEIGHT = width;
        Creature.DEFAULT_CREATURE_HEIGHT = height;
    }


    @Override
    public void update() {
        animDown.update();
        animUp.update();
        animRight.update();
        animLeft.update();
        move();
    }


    public void update(Hero hero) {
        update();
        attacked(hero);
        move();
    }

    protected void attacked(Hero hero){
        if(!hero.Dead()){
            if(getCollisionBounds(0,0).intersects(hero.getAttackBounds(0,0))){
                if(handler.getKeyManager().attack && Assets.attackTimeElapsed()){
                    current_life = current_life - Hero.getInstance(handler,0,0).getDamage();
                }
            }
        }
    }

    protected void monsterAttack(Hero hero) {
        if (!hero.Dead() && current_life > 0) {
            if (xMove == 0 && yMove == 0) {
                attacking = true;
                if (hero.getCollisionBounds(0, 0).intersects(this.getAttackBounds(0, 0)) || hero.getCollisionBounds(0,0).intersects(this.getCollisionBounds(0,0))) {
                    if (hero.getCurrent_life() >= 0 && Assets.EnemyAttackTimeElapsed()) {

                            hero.setCurrent_life(hero.getCurrent_life() - 5);
                        attacking = false;
                    }
                }
            }
        }
    }

    @Override
    public void draw(Graphics g) {

        }


    @Override
    public void die() {

    }
}
