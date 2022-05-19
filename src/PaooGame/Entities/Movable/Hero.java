package PaooGame.Entities.Movable;

import PaooGame.Entities.Entity;
import PaooGame.Game;
import PaooGame.Graphics.Animation;
import PaooGame.Graphics.Assets;
import PaooGame.Handler;
import PaooGame.Inventory.Inventory;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Hero extends Creature {

    //Animations
    private Animation animDown;
    private Animation animUp;
    private Animation animRight;
    private Animation animLeft;
    private Animation lastAnim;

    private Animation attackDown;
    private Animation attackUp;
    private Animation attackRight;
    private Animation attackLeft;

    //Attack timer
    private long lastAttackTimer, attackCooldown = 800, attackTimer = attackCooldown;

    private int direction = 0;
    private boolean attacking;

    public  int score = 0;
    private boolean dead = false;

    private static Hero instance;

    //Inventory
    private Inventory inventory;

    public Hero(Handler handler, float x, float y) {
        super(handler, x, y,Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        bounds.x=22;
        bounds.y=44; //44
        bounds.width=19; //19
        bounds.height=19; //19

        this.setHealth(5);

/*
        attackBounds.x = 26;
        attackBounds.y = 20;
        attackBounds.width = 54;
        attackBounds.height = 32;
 */
        //Animations
        animDown = new Animation(250,Assets.hero_walk_down);
        animUp = new Animation(250,Assets.hero_walk_up);
        animLeft = new Animation(250,Assets.hero_walk_left);
        animRight = new Animation(250,Assets.hero_walk_right);
        lastAnim = new Animation(250, Assets.hero_walk_down);

        attackDown = new Animation(250,Assets.hero_attack_down);
        attackUp = new Animation(250,Assets.hero_attack_up);
        attackLeft = new Animation(250,Assets.hero_attack_left);
        attackRight = new Animation(250,Assets.hero_attack_right);

        inventory = new Inventory(handler);
    }

    //Singleton
    public static Hero getInstance(Handler handler, float x, float y){
        if(instance==null)
        {
            instance = new Hero(handler,x,y);
        }
        return instance;
    }



    @Override
    public void update() {
        if(!isDead()) {
            //Animations
            animDown.update();
            animUp.update();
            animLeft.update();
            animRight.update();
            lastAnim.update();
        }


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

        //inventory
        inventory.update();
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
                e.hurt(1);
                return;
            }
        }
    }


    @Override
    public void die(){
        System.out.println("YOU LOSE!");

    }

    @Override
    public void hurt(int amt) {
        health -= amt;
        if (health <= 0) {
            active = false;
            dead = true;
            die();
        }
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

        if (!isDead()) {
            g.setColor(Color.gray);
            g.fillRect((int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), 64, 10);

            g.setColor(Color.green);
            g.fillRect((int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), (64 * health) / DEFAULT_HEALTH, 10);

            g.setColor(Color.white);
            g.drawRect((int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), 64, 10);

            g.setColor(Color.black);
            g.fillRect( 20,25,250,100);
            g.setColor(Color.white);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString("Score: " + score, 80, 60);
            g.drawImage(Assets.blueDiamond,0,0,100,100,null);

            g.setColor(Color.white);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString("Health: " + health, 80, 110);
            g.drawImage(Assets.heart,5,50,90,90,null);

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
    }

    public void postRender(Graphics g){
        inventory.draw(g);
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

    public int getScore(){
        return  score;
    }
    public boolean isDead(){
        return  dead;
    }

    public void addHealth(int x){
        health = health + x;
    }
    public void addScore(int x){
     score = score + x;
    }
    @Override
    public boolean isEnemy(){
        return false;
    }
    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
