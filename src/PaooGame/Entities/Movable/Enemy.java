package PaooGame.Entities.Movable;

import PaooGame.Graphics.Animation;
import PaooGame.Graphics.Assets;
import PaooGame.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy extends Creature{

    protected Animation animDown, animUp, animLeft, animRight, lastAnim;
    protected Animation attackDown, attackUp, attackLeft, attackRight;
    protected boolean attacking=false;
    private int direction = 0;
    protected int damage=1;

    public Enemy(Handler handler, float x, float y, int width, int height, float speed, int life) {
        super(handler, x, y, width, height, speed, life);
    }

    @Override
    public void update() {
        animDown.update();
        animUp.update();
        animRight.update();
        animLeft.update();
    }
    public void update(Hero hero) {
        update();
    }
    protected void followPlayer(Hero hero) {
        if (!hero.Dead()) {
            xMove = 0;
            yMove = 0;
            if(Math.abs(hero.getX() - x) >= 32) {
                if (x < hero.getX()) {
                    xMove = speed;
                    attacking = false;
                }
                if (x > hero.getX()) {
                    xMove = -speed;
                    attacking = false;
                }
            }
            if (y < hero.getY() && Math.abs(hero.getY() - y) >= 44) {
                yMove = speed;
                attacking = false;
            }
            if (y > hero.getY() && Math.abs(hero.getY() - y) >= 18) {
                yMove = -speed;
                attacking = false;
            }
            move();
        }
    }

    protected void gettingHit(Hero hero) {
        if (!hero.Dead()) {
            if (getCollisionBounds(0,0).intersects(hero.getAttackBounds(0,0))) {
                if (handler.getKeyManager().attack && Assets.attackTimeElapsed()) {
                    actual_life = actual_life - 1;
                }
            }
        }
    }

    @Override
    public void draw(Graphics g) {

            if (attacking) {
                //g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
                if (direction == 1) {
                    g.drawImage(attackUp.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset() - 55), (int) (y - handler.getGameCamera().getyOffset() - 38), 180, 192, null);
                }
                if (direction == 2) {
                    g.drawImage(attackLeft.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset() - 55), (int) (y - handler.getGameCamera().getyOffset() - 50), 180, 192, null);
                }
                if (direction == 3) {
                    g.drawImage(attackRight.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset() - 55), (int) (y - handler.getGameCamera().getyOffset() - 77), 186, 192, null);
                }
                if (direction == 0) {
                    g.drawImage(attackDown.getCurrentFrame(), (int) (x - handler.getGameCamera().getxOffset() - 55), (int) (y - handler.getGameCamera().getyOffset() - 65), 186, 192, null);
                }
                if (Assets.attackTimeElapsed()) {
                    attacking = false;
                }

            } else {
                g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
            }
            // g.setColor(Color.red);
            //  g.fillRect((int)(x+bounds.x-handler.getGameCamera().getxOffset()),(int)(y+bounds.y-handler.getGameCamera().getyOffset()),bounds.width, bounds.height);

        }

    private BufferedImage getCurrentAnimationFrame() {


        if(xMove < 0){
            //left
            direction = 2;
            return animLeft.getCurrentFrame();
        }else if(xMove > 0){
            //right
            direction = 3;
            return animRight.getCurrentFrame();
        }else if(yMove < 0){
            //up
            direction = 1;
            return animUp.getCurrentFrame();
        }else{
            //down
            direction = 0;
            return animDown.getCurrentFrame();
        }
    }
    @Override
    public void die() {

    }
}
