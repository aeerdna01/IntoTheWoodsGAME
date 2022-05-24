package PaooGame.Entities.Movable;

import PaooGame.Entities.Entity;
import PaooGame.Handler;
import PaooGame.Tiles.Tile;
/*! \class public abstract class Character extends Item
    \brief Defineste notiunea abstracta de caracter/individ/fiinta din joc.
    Notiunea este definita doar de viata, viteza de deplasare si distanta cu care trebuie sa se
    miste/deplaseze in urma calculelor.
 */
public abstract class Creature extends Entity {

    protected float speed;  /*!< Retine viteza de deplasare caracterului.*/
    protected  float xMove; /*!< Retine noua pozitie a caracterului pe axa X.*/
    protected  float yMove;  /*!< Retine noua pozitie a caracterului pe axa Y.*/

    public static final float DEFAULT_SPEED=2.0f; /*!< Viteza implicita a unu caracter.*/
    public static  final int DEFAULT_CREATURE_WIDTH=64; /*!< Latimea implicita a imaginii caracterului.*/
    public static final int DEFAULT_CREATURE_HEIGHT=64;  /*!< Inaltimea implicita a imaginii caracterului.*/


    /*! \fn public Creature(Handler handler, float x, float y, int width, int height)
           \brief Constructor de initializare al clasei Character
           \param handler Referinta catre obiectul shortcut (care retine alte referinte utile/necesare in joc).
           \param x Pozitia de start pa axa X a caracterului.
           \param y Pozitia de start pa axa Y a caracterului.
           \param width Latimea imaginii caracterului.
           \param height Inaltimea imaginii caracterului.
        */
    public Creature(Handler handler, float x, float y, int width, int height) {
        ///Apel constructor la clasei de baza
        super(handler,x, y, width, height);
        ///Seteaza pe valorile implicite pentru viteza si distantele de deplasare
        speed=DEFAULT_SPEED;
        xMove=0;
        yMove=0;
    }

    /*! \fn public void Move()
        \brief Modifica pozitia caracterului
    */
    public void move(){
        //Modifica pozitia caracterului pe axa X daca nu exista coliziuni
        if(!checkEntityCollision(xMove,0f))
            moveX();
        //Modifica pozitia caracterului pe axa Y daca nu exista coliziuni
        if(!checkEntityCollision(0f,yMove))
            moveY();
    }

    /*! \fn public void MoveX()
         \brief Modifica pozitia caracterului pe axa X.
     */
    public void moveX(){
        if(xMove>0){ ///moving right
            int tx=(int)(x+xMove+ bounds.x+ bounds.width)/ Tile.TILE_WIDTH;

            if(!collisionWithTile(tx,(int)(y+ bounds.y)/Tile.TILE_HEIGHT) && !collisionWithTile(tx,(int)(y+ bounds.y+ bounds.height)/Tile.TILE_HEIGHT)){
                x+=xMove;
            }else{
                x = tx*Tile.TILE_WIDTH - bounds.x- bounds.width-1;
            }

        }else if(xMove<0){ ///moving left
            int tx=(int)(x+xMove+ bounds.x)/ Tile.TILE_WIDTH;

            if(!collisionWithTile(tx,(int)(y+ bounds.y)/Tile.TILE_HEIGHT) && !collisionWithTile(tx,(int)(y+ bounds.y+ bounds.height)/Tile.TILE_HEIGHT)){
                x+=xMove;
            }else
            {
                x=tx*Tile.TILE_WIDTH+Tile.TILE_WIDTH- bounds.x;
            }
        }
        ///Aduna la pozitia curenta numarul de pixeli cu care trebuie sa se deplaseze pe axa X.
    }


    /*! \fn public void MoveY()
        \brief Modifica pozitia caracterului pe axa Y.
    */
    public void moveY(){
        if(yMove<0){ /// moving up
            int ty=(int)(y+yMove+ bounds.y)/Tile.TILE_HEIGHT;
            if(!collisionWithTile((int)(x+ bounds.x)/Tile.TILE_WIDTH,ty)&&!collisionWithTile((int)(x+ bounds.x+ bounds.width)/Tile.TILE_WIDTH,ty)){
                y+=yMove;
            }else
            {
                y=ty*Tile.TILE_HEIGHT +Tile.TILE_HEIGHT - bounds.y;
            }
        }else if (yMove>0){ /// moving down
            int ty=(int)(y+yMove+ bounds.y+ bounds.height)/Tile.TILE_HEIGHT;
            if(!collisionWithTile((int)(x+ bounds.x)/Tile.TILE_WIDTH,ty)&&!collisionWithTile((int)(x+ bounds.x+ bounds.width)/Tile.TILE_WIDTH,ty)){
                y+=yMove;
            }else
            {
                y=ty*Tile.TILE_HEIGHT- bounds.y- bounds.height-1;
            }
        }
        ///Aduna la pozitia curenta numarul de pixeli cu care trebuie sa se deplaseze pe axa Y.
    }

    /*! \fn   protected  boolean collisionWithTile(int x, int y)
       \brief Ia coordonatele x,y a unui tile si daca este solid returneaza true, daca nu false.
    */
    protected  boolean collisionWithTile(int x, int y)
    {
        return handler.getWorld().getTile(x,y).IsSolid();
    }


    ///Getters and setters

    /*! \fn public int getHealth()
        \brief Returneaza viata caracterului.
    */
    public int getHealth() {
        return health;
    }

    /*! \fn public int setHealth()
        \brief Seteaza viata caracterului.
   */
    public void setHealth(int health) {
        this.health = health;
    }

    /*! \fn public float GgetSpeed()
        \brief Returneaza viteza caracterului.
    */
    public float getSpeed() {
        return speed;
    }

    /*! \fn public void setSpeed(float speed)
        \brief Seteaza viteza caracterului.
    */
    public void setSpeed(float speed) {
        this.speed = speed;
    }

    /*! \fn public float getXMove()
       \brief Returneaza distanta in pixeli pe axa X cu care este actualizata pozitia caracterului.
    */
    public float getxMove() {
        return xMove;
    }

    /*! \fn public void setXMove(float xMove)
        \brief Seteaza distanta in pixeli pe axa X cu care va fi actualizata pozitia caracterului.
    */
    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    /*! \fn public float getYMove()
      \brief Returneaza distanta in pixeli pe axa Y cu care este actualizata pozitia caracterului.
   */
    public float getyMove() {
        return yMove;
    }

    /*! \fn public void setYMove(float yMove)
      \brief Seteaza distanta in pixeli pe axa Y cu care va fi actualizata pozitia caracterului.
    */
    public void setyMove(float yMove) {
        this.yMove = yMove;
    }
}
