package PaooGame.Entities.Movable;

import PaooGame.Entities.Entity;
import PaooGame.Graphics.Animation;
import PaooGame.Graphics.Assets;
import PaooGame.Handler;

import java.awt.*;

public class Enemy extends Creature{

    private int width, height;
    public boolean attacking = false;

    protected Animation animDown, animUp, animLeft, animRight, lastAnim;
    protected Hero hero;
    protected int direction = 0;
    protected int difficulty;



    public Enemy(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        Creature.DEFAULT_CREATURE_HEIGHT = height;
        Creature.DEFAULT_CREATURE_WIDTH = width;

    }

    @Override
    public void update() {
        animDown.update();
        animUp.update();
        animLeft.update();
        animRight.update();
        lastAnim.update();
        move();

    }
    public void update(Hero hero){
        update();
        attacked(hero);
        move();
    }


    @Override
    public void draw(Graphics g) {

    }

    @Override
    public void die() {

    }

    protected void attacked(Hero hero){
        if(!hero.Dead()){
            if(getCollisionBounds(0,0).intersects(hero.getAttackBounds(0,0))){
                if(handler.getKeyManager().attack && Assets.attackTimeElapsed()){
                    current_health = current_health - Hero.getInstance(handler,0,0).getDamage();
                }
            }
        }
    }

    protected void monsterAttack(Hero hero) {
        if (!hero.Dead() && current_health > 0) {
            if (xMove == 0 && yMove == 0) {
                attacking = true;
                if (hero.getCollisionBounds(0, 0).intersects(this.getAttackBounds(0, 0)) || hero.getCollisionBounds(0,0).intersects(this.getCollisionBounds(0,0))) {
                    if (hero.getCurrent_health() >= 0 && Assets.monsterAttackTimeElapsed()) {
                        if(difficulty == 2)
                            hero.setCurrent_health(hero.getCurrent_health() - 10);
                        if(difficulty == 3)
                            hero.setCurrent_health(hero.getCurrent_health() - 30);
                        if(difficulty == 1)
                            hero.setCurrent_health(hero.getCurrent_health() - 5);
                        attacking = false;
                    }
                }
            }
        }
    }

}

