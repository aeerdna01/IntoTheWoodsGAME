package PaooGame.Entities;

import PaooGame.Handler;

import java.awt.*;

/*! \class Entity
    \brief. Implementeaza notiunea abstracta de entitate activa din joc, "element cu care se poate interactiona: monstru, turn etc.".
 */
public abstract class Entity {

    protected Handler handler;  /*!< O referinte catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.*/
    protected float x;   /*!< Pozitia pe axa X a "tablei" de joc a imaginii entitatii.*/
    protected float y;  /*!< Pozitia pe axa Y a "tablei" de joc a imaginii entitatii.*/
    protected  int width;  /*!< Latimea imaginii entitatii.*/
    protected int height;    /*!< Inaltimea imaginii entitatii.*/
    protected  int health;    /*!< Viata entitatii.*/
    public static final int DEFAULT_HEALTH=5;    /*!< Viata initiala a entitatii.*/
    public boolean active = true;    /*!< Flag pentru a verifica ca entitiatea inca exista in joc.*/
    protected Rectangle bounds;         /*!< Dreptunghiul curent de coliziune.*/


    /*! \fn public Entity(Handler handler, float x, float y, int width, int height)
     \brief Constructor de initializare al clasei
     \param  handler Referinte "shortcut" catre alte referinte
     \param  x   Pozitia pe axa X a "tablei" de joc a imaginii entitatii.
     \param  y   Pozitia pe axa Y a "tablei" de joc a imaginii entitatii.
     \param  width   Latimea imaginii entitatii.
     \param  height  Inaltimea imaginii entitatii.
  */
    public Entity(Handler handler, float x, float y, int width, int height){
        this.handler=handler;  /*!< Retine "shortcut".*/
        this.x=x;  /*!< Retine coordonata pe axa X.*/
        this.y=y;  /*!< Retine coordonata pe axa Y.*/
        this.width=width;  /*!< Retine latimea imaginii.*/
        this.height=height; /*!< Retine inaltimea imaginii.*/
        health=DEFAULT_HEALTH;  /*!<Seteaza viata pentru entitate.*/
        bounds = new Rectangle(0,0,width, height); /*!<Creeaza dreptunghiul de coliziune.*/
    }

    ///Metoda abstracta destinata actualizarii starii curente
    public abstract void update();

    ///Metoda abstracta destinata desenarii starii curente
    public abstract void draw(Graphics g);

    //Metoda abstracta prin care o entitate moare
    public abstract void die();

    ///Metoda folosita pentru a gestiona ideea de atac
    public void hurt(int amt){
        health -= amt;      //Scade din viata valoarea data ca parametru
        if(health <= 0){
            active = false; //Seteaza active cu false pentru a elimina de pe harta entitatea respectiva
            die(); //apeleaza metoda die()
        }
    }


    ///Testeaza coliziuea cu fiecare entitate din joc
    public boolean checkEntityCollision(float xOffset, float yOffsett){
        for(Entity e: handler.getWorld().getEntityManager().getEntities()){
            if(e.equals(this)) //se verifica sa nu se faca coliziunea in entitatea insasi
                continue;
            if(e.getCollisionBounds(0f,0f).intersects(getCollisionBounds(xOffset,yOffsett)))
                return true;
        }
        return false;
    }

    ///Returneaza dreptunghiul de coliziune
    public Rectangle getCollisionBounds(float xOffset, float yOffset){
        return new Rectangle((int) (x + bounds.x + xOffset),(int) (y + bounds.y + yOffset), bounds.width,bounds.height);
    }



    /*! \fn public float getY()
     \brief Returneaza coordonata pe axa X.
    */
    public float getY() {
        return y;
    }

    /*! \fn public float setY()
        \brief Seteaza coordonata pe axa X.
     */
    public void setY(float y) {
        this.y = y;
    }

    /*! \fn public float getX()
     \brief Returneaza coordonata pe axa X.
    */
    public float getX() {
        return x;
    }

    /*! \fn public float setX()
    \brief Seteaza coordonata pe axa X.
    */
    public void setX(float x) {
        this.x = x;
    }

    /*! \fn public float getWidth()
      \brief Returneaza latimea entitatii.
   */
    public int getWidth() {
        return width;
    }

    /*! \fn public float setWidth()
      \brief Seteaza latimea entitatii.
   */
    public void setWidth(int width) {
        this.width = width;
    }

    /*! \fn public float getHeight()
      \brief Returneaza latimea entitatii.
   */
    public int getHeight() {
        return height;
    }

    /*! \fn public float setHeight()
      \brief Seteaza latimea entitatii.
   */
    public void setHeight(int height) {
        this.height = height;
    }

    /*! \fn public float getHealth()
      \brief Returneaza viata entitatii.
   */
    public int getHealth() {
        return health;
    }

    /*! \fn public float setHeight()
      \brief Seteaza viata entitatii.
   */
    public void setHealth(int health) {
        this.health = health;
    }

    /*! \fn  public boolean isActive()
      \brief Verifica daca entitatea exista in joc.
   */
    public boolean isActive() {
        return active;
    }

    /*! \fn  public boolean isEnemy()
        \brief Verifica daca entitatea din joc este inamic.
    */

    public boolean isEnemy()
    {
        return false;
    }

    public void setNormalBounds(Rectangle normalBounds) {
        bounds = normalBounds;
    }
}
