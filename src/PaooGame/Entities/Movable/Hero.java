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
    private Animation lastAnim;

    private Animation attackDown;
    private Animation attackUp;
    private Animation attackRight;
    private Animation attackLeft;
    private Animation animDie;

    //Attack timer
    private long lastAttackTimer, attackCooldown = 800, attackTimer = attackCooldown;

    private int direction = 0;
    protected static int level;
    private boolean attacking;

    protected int damage;
    protected static int score;

    private static Hero instance;


    public Hero(Handler handler, float x, float y) {
        super(handler, x, y,Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        bounds.x=22;
        bounds.y=44; //44
        bounds.width=19; //19
        bounds.height=19; //19

        score = 0;

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

        animDie = new Animation(100, Assets.hero_die);
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
        if(!Dead()) {
            //Animations
            animDown.update();
            animUp.update();
            animLeft.update();
            animRight.update();
            lastAnim.update();
        }
        if(Dead())
            animDie.update();


        if(Assets.secondElapsed())
            attacking = false;

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
/*
        attackTimer += System.currentTimeMillis() - lastAttackTimer;
        lastAttackTimer = System.currentTimeMillis();

        if(attackTimer < attackCooldown)
            return;


 */
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

       // attackTimer = 0;

        for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
            if (e.equals(this))
                continue;
            if (e.getCollisionBounds(0, 0).intersects(ar) && Assets.attackTimeElapsed()) {
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

    public boolean Dead(){
        if(current_health<=0)
        {
            return true;
        }
        else
            return false;
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
        if (!this.Dead()) {
            g.setColor(Color.gray);
            g.fillRect((int) (x - handler.getGameCamera().getxOffset()),(int) (y - handler.getGameCamera().getyOffset()), 64, 10);

            g.setColor(Color.green);
            g.fillRect((int) (x - handler.getGameCamera().getxOffset()),(int)  (y - handler.getGameCamera().getyOffset()), (64*current_health)/health, 10);

            g.setColor(Color.white);
            g.drawRect((int) (x - handler.getGameCamera().getxOffset()),(int)  (y - handler.getGameCamera().getyOffset()), 64, 10);

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
            lastAnim = new Animation(250, Assets.hero_walk_left);
            return animLeft.getCurrentFrame();
        }else if(xMove > 0){
            //right
            lastAnim = new Animation(250, Assets.hero_walk_right);
            direction = 3;
            return animRight.getCurrentFrame();
        }else if(yMove < 0){
            //up
            lastAnim = new Animation(250,Assets.hero_walk_up);
            direction = 1;
            return animUp.getCurrentFrame();
        }else if(yMove > 0){
            //down
            lastAnim = new Animation(250,Assets.hero_walk_down);
            direction = 0;
            return animDown.getCurrentFrame();
        }
        else
        {
            return lastAnim.getFirstFrame();
        }
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void AddtoScore(int val)
    {
        score += val;
    }
    public void AddtoLife(int val){
        current_health += val;
    }
    public int getDamage()
    {
        return damage;
    }
    public void SetLevel(int val)
    {
        level = val;
    }

    public int GetLevel(){
        return level;
    }



}
