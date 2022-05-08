package PaooGame.Entities.Movable;

import PaooGame.Graphics.Animation;
import PaooGame.Graphics.Assets;
import PaooGame.Handler;

public class Chimera extends Enemy{

    private boolean attacking =false;
    private int direction = 0;
    private int tick=0;

    public Chimera(Handler handler, float x, float y, int width, int height, float speed, int life) {
        super(handler, x, y, width, height, speed, life);


        bounds.x = 24;
        bounds.y = 28;
        bounds.width = 16;
        bounds.height = 30;

        attackBounds.x = 0;
        attackBounds.y = 0;
        attackBounds.width = 54;
        attackBounds.height = 58;

        animDown = new Animation(15, Assets.chimera_walk_down);
        animUp = new Animation(15, Assets.chimera_walk_up);
        animLeft = new Animation(15, Assets.chimera_walk_left);
        animRight = new Animation(15, Assets.chimera_attack_right);
       // lastAnim = new Animation(15, Assets.caretakerRight);

        attackDown = new Animation(15, Assets.chimera_attack_down);
        attackUp = new Animation(15, Assets.chimera_attack_up);
        attackLeft = new Animation(15, Assets.chimera_attack_left);
        attackRight = new Animation(15, Assets.chimera_attack_right);
    }

    @Override
    public void update(Hero hero){

        tick++;
        attackDown.update();
        attackUp.update();
        attackRight.update();
        attackLeft.update();

        if(!attacking) {
            gettingHit(hero);
        }
        if(tick>=180) {
            if(!attacking) {
                speed = 5 * speed;
                attacking=true;
            }
            attackHero(hero);
        }
        if(tick>=300 && attacking) {
            tick = 0;
            speed= (float) (0.2*speed);
            attacking=false;
        }
        super.update(hero);

        if(attacking) {
            followPlayer(hero);
        }
        else {
            xMove=0;
            yMove=0;
        }

        if(direction == 3)
        {
            attackBounds.x = 32;
            attackBounds.y = 10;
            attackBounds.width = 48;
            attackBounds.height = 42;
        }
        if(direction == 2)
        {
            attackBounds.x = -26;
            attackBounds.y = 10;
            attackBounds.width = 48;
            attackBounds.height = 42;
        }
        if(direction == 1)
        {
            attackBounds.x = 5;
            attackBounds.y = -12;
            attackBounds.width = 60;
            attackBounds.height = 24;
        }
        if(direction == 0)
        {
            attackBounds.x = 5;
            attackBounds.y = 30;
            attackBounds.width = 60;
            attackBounds.height = 40;
        }
    }

    private void attackHero(Hero hero) {
        if(attacking) {
            if (hero.getCollisionBounds(0, 0).intersects(getAttackBounds(0, 0))) {
                if (Assets.EnemyAttackTimeElapsed() && hero.getActual_life() > 0) {
                    hero.setActual_life(hero.getActual_life() - damage);
                    hero.setScore(hero.getScore()-5);
                }
            }
        }
    }
}
