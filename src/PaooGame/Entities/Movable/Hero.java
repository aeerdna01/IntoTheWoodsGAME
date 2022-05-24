package PaooGame.Entities.Movable;

import PaooGame.Entities.Entity;
import PaooGame.Game;
import PaooGame.Graphics.Animation;
import PaooGame.Graphics.Assets;
import PaooGame.Handler;


import java.awt.*;
import java.awt.image.BufferedImage;
/*! \class public class Hero extends Character
    \brief Implementeaza notiunea de erou/player (caracterul controlat de jucator).
 */

public class Hero extends Creature {

    ///Referinte catre animatiile pentru mers
    private Animation animDown;
    private Animation animUp;
    private Animation animRight;
    private Animation animLeft;
    private Animation lastAnim;

    //Referinte catre animatiile pentru atac
    private Animation attackDown;
    private Animation attackUp;
    private Animation attackRight;
    private Animation attackLeft;

    ///Attack timer
    private long lastAttackTimer, attackCooldown = 800, attackTimer = attackCooldown;

    ///Referinta pentru a gestiona directia animatiilor
    private int direction = 0;
    ///Flag pentru a verifica daca eroul ataca inamicul
    private boolean attacking;
    ///Referinta pentru score
    public  int score = 0;
    ///Flag pentru a seta daca eroul a fost ucis
    private boolean dead = false;

    ///Referinta pentru nivelul in care se afla eroul
    protected static int level;

    ///Singleton
    private static Hero instance = null;

     /*! \fn public Hero(Handler handler, float x, float y)
        \brief Constructorul de initializare al clasei Hero.
        \param handler Referinta catre obiectul shortcut (obiect ce retine o serie de referinte din program).
        \param x Pozitia initiala pe axa X a eroului.
        \param y Pozitia initiala pe axa Y a eroului.
     */
    public Hero(Handler handler, float x, float y) {
        ///Apel al constructorului clasei de baza
        super(handler, x, y,Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

        ///Stabilieste pozitia relativa si dimensiunea dreptunghiului de coliziune, starea implicita
        bounds.x=22;
        bounds.y=44;
        bounds.width=19;
        bounds.height=19;

        ///seteaza viata eroului implicit cu 5
        this.setHealth(5);

        ///initilizeaza animatiile
        animDown = new Animation(250,Assets.hero_walk_down);
        animUp = new Animation(250,Assets.hero_walk_up);
        animLeft = new Animation(250,Assets.hero_walk_left);
        animRight = new Animation(250,Assets.hero_walk_right);
        lastAnim = new Animation(250, Assets.hero_walk_down);

        attackDown = new Animation(250,Assets.hero_attack_down);
        attackUp = new Animation(250,Assets.hero_attack_up);
        attackLeft = new Animation(250,Assets.hero_attack_left);
        attackRight = new Animation(250,Assets.hero_attack_right);

    }

    /*! \fn public static Hero getInstance(Handler handler, float x, float y)
       \brief Metoda de creare a unui obiect de tip Hero.
       \param handler Referinta catre obiectul shortcut (obiect ce retine o serie de referinte din program).
       \param x Pozitia initiala pe axa X a eroului.
       \param y Pozitia initiala pe axa Y a eroului.
    */

    public static Hero getInstance(Handler handler, float x, float y){
        if(instance==null)
        {
            instance = new Hero(handler,x,y);
        }
        else {
            System.out.println("Hero este singleton si este deja creat!");
        }

        return instance;
    }


    /*! \fn public void update()
           \brief Actualizeaza pozitia si imaginea eroului.
    */
    @Override
    public void update() {
        ///daca eroul nu a fost ucis se actualizeaza animatiile
        if(!isDead()) {
            ///Animatiile pentru mers
            animDown.update();
            animUp.update();
            animLeft.update();
            animRight.update();
            lastAnim.update();
        }
        ///animatiile pentru atac
        attackDown.update();
        attackUp.update();
        attackLeft.update();
        attackRight.update();

        ///verifica daca a fost apasata o tasta
        getInput();

        ///actualizeaza pozitia
        move();

        ///centreaza camera implementata in joc pe erou
        handler.getGameCamera().centerOnEntity(this);

        ///verifica daca a avut loc notiunea de atac
        checkAttacks();

    }

    /*! \fn     private void checkAttacks()
          \brief Verifica daca eroul a initiat un atac asupra inamicului.
   */
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
        System.out.println("YOU DIED!");
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

    /*! \fn private void getInput()
            \brief Verifica daca a fost apasata o tasta din cele stabilite pentru controlul eroului.
    */
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

    /*! \fn public void draw(Graphics g)
        \brief Randeaza/deseneaza eroul in noua pozitie.
        \brief g Contextul grafi in care trebuie efectuata desenarea eroului.
     */
    @Override
    public void draw(Graphics g) {

        if (!isDead()) {
            g.setColor(Color.red);
            g.fillRect((int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), 64, 10);

            g.setColor(Color.green);
            g.fillRect((int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), (64 * health) / DEFAULT_HEALTH, 10);

            g.setColor(Color.black);
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
            // g.fillRect((int)(x+bounds.x-handler.getGameCamera().getxOffset()),(int)(y+bounds.y-handler.getGameCamera().getyOffset()),bounds.width, bounds.height);

        }
    }

    /*! \fn  private BufferedImage getCurrentAnimationFrame()
         \brief Returneaza animatia curenta in functie de directia in care se deplaseaza eroul.
    */
    private BufferedImage getCurrentAnimationFrame() {


        if(xMove < 0){
            ///left
            direction = 2;
            return animLeft.getCurrentFrame();
        }else if(xMove > 0){
            ///right
            direction = 3;
            return animRight.getCurrentFrame();
        }else if(yMove < 0){
            ///up
            direction = 1;
            return animUp.getCurrentFrame();
        }else{
            ///down
            direction = 0;
            return animDown.getCurrentFrame();
        }
    }

    public int getScore(){
        return  score;
    }

    public void setScore(int score) {
        this.score = score;
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

    public static int getLevel() {
        return level;
    }

    public static void setLevel(int level) {
        Hero.level = level;
    }


}