package PaooGame.Entities.Movable;

import PaooGame.Graphics.Animation;
import PaooGame.Graphics.Assets;
import PaooGame.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.sql.SQLException;

public class Achlys extends Creature{

    private Animation animDown;
    private Animation animUp;
    private Animation animRight;
    private Animation animLeft;



    private long lastAttackTimer, attackCooldown=2000, attackTimer=attackCooldown;



    public Achlys(Handler handler, float x, float y) {
        super(handler, x, y, 80,80);

        animDown = new Animation(250,Assets.achlys_walk_down);
        animUp = new Animation(250,Assets.achlys_walk_up);
        animLeft = new Animation(250,Assets.achlys_walk_left);
        animRight = new Animation(250,Assets.achlys_walk_right);


        bounds.x=22;
        bounds.y=44; //44
        bounds.width=19; //19
        bounds.height=19; //19


        speed = 0.5f;
        this.setHealth(30);
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
            try {
                if (handler.getGame().getDataBase().getDifficulty() == 1) {
                    health -= 10;
                    handler.getWorld().getEntityManager().getHero().hurt(1);
                }
                if (handler.getGame().getDataBase().getDifficulty() == 2) {
                    health -= 5;
                    handler.getWorld().getEntityManager().getHero().hurt(1);
                }
                if (handler.getGame().getDataBase().getDifficulty() == 3) {
                    health -= 3;
                    handler.getWorld().getEntityManager().getHero().hurt(1);
                }
                return;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update() {
        move();

        if(getxMove()>0)
        {
            //image = Assets.chimera_walk_right[0];
            animRight.update();
        }
        if(getxMove()<0)
        {
            //image = Assets.chimera_walk_left[0];
            animLeft.update();
        }

        if(getyMove()>0)
        {
            //image = Assets.chimera_walk_down[0];
            animDown.update();
        }
        if(getyMove()<0)
        {
            //image = Assets.chimera_walk_up[0];
            animUp.update();
        }

        direction();
        checkAttacks();

    }

    @Override
    public boolean isEnemy()
    {
        return true;
    }


    private BufferedImage getCurrentAnimationFrame() {


        if(xMove < 0){
            //left
            return animLeft.getCurrentFrame();
        }else if(xMove > 0){
            //right
            return animRight.getCurrentFrame();
        }else if(yMove < 0){
            //up
            return animUp.getCurrentFrame();
        }else{
            //down
            return animDown.getCurrentFrame();
        }
    }

    @Override
    public void draw(Graphics g) {

        g.setColor(Color.red);
        g.fillRect((int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), 64, 10);

        g.setColor(Color.green);
        g.fillRect((int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), (64 * health) / 30, 10);

        g.setColor(Color.black);
        g.drawRect((int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), 64, 10);


        g.drawImage(getCurrentAnimationFrame(),(int)(x-handler.getGame().getGameCamera().getxOffset()),
                (int)(y-handler.getGame().getGameCamera().getyOffset()),width,height,null);
    }

    @Override
    public void die() {
        if(health <= 0)
        {
            try {
                handler.getDataBase().updateEnemyKilled(15);
                Thread.sleep(100);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        x=this.getX();
        y=this.getY();
        //handler.getWorld().getEntityManager().getHero().score += 90;

        handler.getWorld().getEntityManager().getHero().addScore(90);
        int x = handler.getWorld().getEntityManager().getHero().getScore();
        try{
            handler.getDataBase().updateScore(x);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
