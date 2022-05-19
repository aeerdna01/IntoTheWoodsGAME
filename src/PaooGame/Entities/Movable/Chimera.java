package PaooGame.Entities.Movable;

import PaooGame.Graphics.Animation;
import PaooGame.Graphics.Assets;
import PaooGame.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Chimera extends Creature{

    private BufferedImage image;

    private long lastAttackTimer, attackCooldown=2000, attackTimer=attackCooldown;

    public Chimera(Handler handler, float x, float y) {
        super(handler, x, y, 80,80);

        image = Assets.chimera_left;

        bounds.x=22;
        bounds.y=44; //44
        bounds.width=19; //19
        bounds.height=19; //19


        speed = 0.5f;
        health = 5;
    }


    private void direction() {
        xMove = 0;
        yMove = 0;

        if (handler.getWorld().getEntityManager().getHero().isActive() == false)
            return;

        int xP = (int) handler.getWorld().getEntityManager().getHero().getX();
        int yP = (int) handler.getWorld().getEntityManager().getHero().getY();


        if (xP >= this.getX()) {
            if (yP >= this.getY())
                if ((int) (xP - this.getX()) / 64 > 3 || (int) (yP - this.getY()) / 64 > 3) {
                    return;
                }
            if (yP <= this.getY())
                if ((int) (xP - this.getX()) / 64 > 3 || (int) (this.getY() - yP) / 64 > 3) {
                    return;
                }
        }
        if (this.getX() >= xP) {
            if (yP >= this.getY())
                if ((int) (this.getX() - xP) / 64 > 3 || (int) (yP - this.getY()) / 64 > 3) {
                    return;
                }
            if (yP <= this.getY())
                if ((int) (this.getX() - xP) / 64 > 3 || (int) (this.getY() - yP) / 64 > 3) {
                    return;
                }
        }

        if(xP<this.getX())
            xMove= -speed;
        if(xP>this.getX())
            xMove= speed;
        if(yP<this.getY())
            yMove= -speed;
        if(yP>this.getY())
            yMove=speed;
    }

    private void checkAttacks()
    {
        attackTimer+= System.currentTimeMillis()-lastAttackTimer;
        lastAttackTimer=System.currentTimeMillis();
        if(attackTimer<attackCooldown)
            return;

        Rectangle ar=new Rectangle();
        ar.width=120;
        ar.height=120;
        ar.x=(int)this.getX()+this.width/2-ar.width/2;
        ar.y=(int)this.getY()+this.height/2-ar.height/2;


        attackTimer=0;
        if(handler.getWorld().getEntityManager().getHero().getCollisionBounds(0,0).intersects(ar) && handler.getWorld().getEntityManager().getHero().isActive()){
            handler.getWorld().getEntityManager().getHero().hurt(1);
            return;
        }
    }

    @Override
    public void update() {
        move();

       // animDown.update();
       // animUp.update();
       // animLeft.update();
       // animRight.update();
       // lastAnim.update();

        if(getxMove()>0)
        {
            image = Assets.chimera_right;
        }
        if(getxMove()<0)
        {
            image = Assets.chimera_left;
        }
        if(getyMove()>0 && getyMove()<0)
        {
            image = Assets.chimera_left;
        }

        direction();
        checkAttacks();

    }

    @Override
    public boolean isEnemy()
    {
        return true;
    }

    @Override
    public void draw(Graphics g) {

        g.setColor(Color.gray);
        g.fillRect((int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), 64, 10);

        g.setColor(Color.green);
        g.fillRect((int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), (64 * health) / 5, 10);

        g.setColor(Color.white);
        g.drawRect((int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), 64, 10);


        g.drawImage(image,(int)(x-handler.getGame().getGameCamera().getxOffset()),
                (int)(y-handler.getGame().getGameCamera().getyOffset()),width,height,null);

    }

    @Override
    public void die() {
        x=this.getX();
        y=this.getY();
        handler.getWorld().getEntityManager().getHero().score += 10;
    }
}
