package PaooGame.Entities.Movable;

import PaooGame.Graphics.Animation;
import PaooGame.Graphics.Assets;
import PaooGame.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Chimera extends Enemy{
    protected int width, height;

    public Chimera(Handler handler, float x, float y) {
        super(handler, x, y);

        width = 64;
        height = 64;
        speed = 2.0f;
        life = 10;
        current_life = life;

        animDown = new Animation(150, Assets.chimera_walk_down);
        animUp = new Animation(150, Assets.chimera_walk_up);
        animLeft = new Animation(150, Assets.chimera_walk_left);
        animRight = new Animation(150, Assets.chimera_walk_right);

        //Bounds
        normalBounds.x = 15;
        normalBounds.y = 18;
        normalBounds.width = 35;
        normalBounds.height = 40;




    }

    @Override
    public void update(Hero hero){
        super.update(hero);
        monsterAttack(hero);
        //if(hero.getX()>0 && hero.getX()<850 && hero.getY()>0 && hero.getY()<650)
            tracking(hero);
    }

    protected void tracking(Hero hero)
    {
        float diffX = Math.abs(hero.getX()-x);
        float diffy = Math.abs(hero.getY()-y);

        if(!hero.Dead())
        {
            xMove = 0;
            yMove = 0;
            if(y>hero.getY())
            {
                if(diffy>=64)
                {
                    yMove = -speed;
                    attacking = false;
                }
            }

            if(y<hero.getY())
            {
                if(diffy>=34)
                {
                    yMove = speed;
                    attacking = false;
                }
            }

            if(diffX>=34)
            {
                if(x>hero.getX())
                {
                    xMove = -speed;
                    attacking = false;
                }
                if(x<hero.getX())
                {
                    xMove = speed;
                    attacking = false;
                }
            }
            move();
        }
    }
    @Override
    public void die() {

    }

    @Override
    public void draw(Graphics g)
    {
        g.setColor(Color.gray);
        g.fillRect((int) x,(int)  y, 64, 10);

        g.setColor(Color.red);
        g.fillRect((int) x,(int)  y, (64*current_life)/life, 10);

        g.setColor(Color.white);
        g.drawRect((int) x,(int)  y, 64, 10);
        g.drawImage(getCurrentAnimationFrame(), (int) x, (int) y, width, height, null);

        ///doar pentru debug daca se doreste vizualizarea dreptunghiului de coliziune altfel se vor comenta urmatoarele doua linii
        g.setColor(Color.blue);
        g.fillRect((int)(x + bounds.x), (int)(y + bounds.y), bounds.width, bounds.height);
        g.setColor(Color.red);
        g.drawRect((int)(x+attackbounds.x), (int)(y+attackbounds.y), attackbounds.width, attackbounds.height);
    }


    private BufferedImage getCurrentAnimationFrame(){
        if (xMove < 0) {
            lastAnim = new Animation(100, Assets.chimera_walk_left);
            direction = 2;          //Left
            attackbounds.x = -5;
            attackbounds.y = 0;
            attackbounds.width = 38;
            attackbounds.height = 80;
            return animLeft.getCurrentFrame();
        } else if (xMove > 0) {
            lastAnim = new Animation(100,Assets.chimera_walk_right);
            direction = 3;          //Right
            attackbounds.x = 40;
            attackbounds.y = 0;
            attackbounds.width = 35;
            attackbounds.height = 80;
            return animRight.getCurrentFrame();
        } else if (yMove < 0) {
            lastAnim = new Animation(100,Assets.chimera_walk_up);
            direction = 1;          //Up
            attackbounds.x = 0;
            attackbounds.y = 0;
            attackbounds.width = 64;
            attackbounds.height = 38;
            return animUp.getCurrentFrame();
        } else  {
            lastAnim = new Animation(100, Assets.chimera_walk_down);
            direction = 0;          //Down
            attackbounds.x = 0;
            attackbounds.y = 26;
            attackbounds.width = 60;
            attackbounds.height = 60;
            return animDown.getCurrentFrame();
        }
    }
}
