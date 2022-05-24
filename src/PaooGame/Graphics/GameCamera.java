package PaooGame.Graphics;

import PaooGame.Entities.Entity;
import PaooGame.Game;
import PaooGame.Handler;
import PaooGame.Tiles.Tile;


/*! \class GameCamera
    \brief Clasa cu rolul de a centra GameWindows-ul pe caracter atunci cand acesta isi schimba pozitia.
 */
public class GameCamera {

    private float xOffset;     /*!< Referinta catre coordonata x.*/
    private float yOffset;     /*!< Referinta catre coordonata y.*/
    private Handler handler;   /*!< Referinta catre un obiect a carui sarcina este doar de a retine diverse referinte pentru a fi usor accesibile.*/


    /*! \fn public GameCamera(Handler handler,float xOffset, float yOffset)
      \brief Pozitioneaza camera cu eroul in mijloc
      \param xOffset pozitia initiala a camerei pe axa Ox.
      \param yOffset pozitia initiala a camerei pe axa Oy.
      \param handler incarca referintele.
   */
    public GameCamera(Handler handler,float xOffset, float yOffset){
        this.handler=handler;
        this.xOffset=xOffset;
        this.yOffset=yOffset;
    }

    
    /*! \fn public void checkBlankSpace()
      \brief Verifica sa nu arate colturile albe cand caracterul se afla intr-o pozitie in care acesta nu se poate afla in mijlocul ecranului.
  */
    public void checkBlankSpace(){
        if(xOffset < 0){
            xOffset=0;
        }else if(xOffset>handler.getWorld().getWidth()* Tile.TILE_WIDTH- handler.getWidth()){
            xOffset=handler.getWorld().getWidth()* Tile.TILE_WIDTH- handler.getWidth();
        }

        if(yOffset < 0){
            yOffset=0;
        }else if(yOffset>handler.getWorld().getHeight()*Tile.TILE_HEIGHT-handler.getHeight()){
            yOffset=handler.getWorld().getHeight()*Tile.TILE_HEIGHT-handler.getHeight();
        }

    }


    /*! \fn public void centerOnEntity(Entity e)
      \brief Actualizeaza camera cand caracterul isi schimba pozitia
      \param e caracterul pe care se va centra camera.
  */
    public void centerOnEntity(Entity e){
        xOffset=e.getX()-handler.getWidth()/2 + e.getWidth()/2;
        yOffset=e.getY()-handler.getHeight()/2+ e.getHeight()/2;
        checkBlankSpace();
    }
    public  void move(float xAmt, float yAmt){
        xOffset+=xAmt;
        yOffset+=yAmt;
        checkBlankSpace();
    }

    ///Getters

    /*! \fn public float getxOffset()
     \brief Returneaza pozitia camerei pe axa Ox.
  */
    public float getxOffset() {
        return xOffset;
    }

    /*! \fn public float getyOffset()
       \brief Returneaza pozitia camerei pe axa Oy.
    */
    public float getyOffset() {
        return yOffset;
    }


}
