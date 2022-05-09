package PaooGame.Entities.Movable;

import PaooGame.Entities.Entity;
import PaooGame.Game;
import PaooGame.Graphics.Animation;
import PaooGame.Graphics.Assets;
import PaooGame.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Hero extends Creature {

    //Animations
    private Animation animDown;
    private Animation animUp;
    private Animation animRight;
    private Animation animLeft;

    private Animation attackDown;
    private Animation attackUp;
    private Animation attackRight;
    private Animation attackLeft;

    //Attack timer
    private long lastAttackTimer, attackCooldown = 800, attackTimer = attackCooldown;

    private int direction = 0;
    private boolean attacking;

    protected static int level;

    protected int damage;
    protected static int score;

    private BufferedImage image;

    private static Hero instance = null;

    public Hero(Handler handler, float x, float y) {
        super(handler, x, y,Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

        score = 0;


        normalBounds.x=22;
        normalBounds.y=44; //44
        normalBounds.width=19; //19
        normalBounds.height=19; //19


        attackBounds.x = 26;
        attackBounds.y = 20;
        attackBounds.width = 54;
        attackBounds.height = 32;

        //Animations
        animDown = new Animation(250,Assets.hero_walk_down);
        animUp = new Animation(250,Assets.hero_walk_up);
        animLeft = new Animation(250,Assets.hero_walk_left);
        animRight = new Animation(250,Assets.hero_walk_right);

        attackDown = new Animation(250,Assets.hero_attack_down);
        attackUp = new Animation(250,Assets.hero_attack_up);
        attackLeft = new Animation(250,Assets.hero_attack_left);
        attackRight = new Animation(250,Assets.hero_attack_right);
    }
    public static Hero getInstance(Handler handler, float x, float y)
    {
        if(instance==null)
        {
            instance = new Hero(handler,x,y);
        }
        return instance;
    }

    @Override
    public void update() {
        //Animations
        animDown.update();
        animUp.update();
        animLeft.update();
        animRight.update();

        attackDown.update();
        attackUp.update();
        attackLeft.update();
        attackRight.update();

        //Movement
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);

        //Attack
        checkAttacks();
    }

    private void checkAttacks() {

        attackTimer += System.currentTimeMillis() - lastAttackTimer;
        lastAttackTimer = System.currentTimeMillis();

        if(attackTimer < attackCooldown)
            return;

        Rectangle cb = getCollisionBounds(0, 0);
        Rectangle ar = new Rectangle();
        int arSize = 20;
        ar.width = arSize;
        ar.height = arSize;

        if(handler.getKeyManager().attack && direction == 1){
            ar.x = cb.x + cb.width / 2 - arSize / 2;
            ar.y = cb.y - arSize;
        }else if(handler.getKeyManager().attack && direction == 0){
            ar.x = cb.x + cb.width / 2 - arSize / 2;
            ar.y = cb.y + cb.height;
        }else if(handler.getKeyManager().attack && direction == 2){
            ar.x = cb.x - arSize;
            ar.y = cb.y + cb.height / 2 - arSize / 2;
        }else if(handler.getKeyManager().attack && direction == 3){
            ar.x = cb.x + cb.width;
            ar.y = cb.y + cb.height / 2 - arSize / 2;
        }else{
            return;
        }

        attackTimer = 0;

        for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
            if (e.equals(this))
                continue;
            if (e.getCollisionBounds(0, 0).intersects(ar)) {
                e.hurt(damage);
                return;
            }
        }
    }


    @Override
    public void die(){
        System.out.println("YOU LOSE!");
        Dead();
    }

    private void getInput()
    {
        xMove = 0;
        yMove = 0;

        if(!attacking) {
            if (handler.getKeyManager().up)
                yMove = -speed;
            if (handler.getKeyManager().down)
                yMove = speed;
            if (handler.getKeyManager().left)
                xMove = -speed;
            if (handler.getKeyManager().right)
                xMove = speed;
            if (handler.getKeyManager().attack) {
                xMove = 0;
                yMove = 0;
                attacking = true;
                attackUp.resetIndex();
                attackDown.resetIndex();
                attackLeft.resetIndex();
                attackRight.resetIndex();
            }
        }

    }
    @Override
    public void draw(Graphics g) {
        if(!this.Dead()){
            g.setColor(Color.gray);
            g.fillRect((int) x,(int)  y, 64, 10);

            g.setColor(Color.green);
            g.fillRect((int) x,(int)  y, (64*current_life)/life, 10);

            g.setColor(Color.white);
            g.drawRect((int) x,(int)  y, 64, 10);
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
             g.setColor(Color.red);
              g.fillRect((int)(x+bounds.x-handler.getGameCamera().getxOffset()),(int)(y+bounds.y-handler.getGameCamera().getyOffset()),bounds.width, bounds.height);

    }
}
    public long getAttackTimer() {
        return attackTimer;
    }

    public long getLastAttackTimer() {
        return lastAttackTimer;
    }

    public long getAttackCooldown() {
        return attackCooldown;
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

    public boolean Dead()
    {
        if(current_life <= 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static int getScore() {
        return score;
    }

    public static void setScore(int score) {
        Hero.score = score;
    }

    public static int getLevel() {
        return level;
    }

    public static void setLevel(int level) {
        Hero.level = level;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

}
