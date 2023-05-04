package PaooGame.Graphics;

import java.awt.image.BufferedImage;

/*! \class Animation
    \brief Clasa gestioneaza ideea de animatie in joc.
 */

public class Animation {

    private int speed, index;
    private long lastTime, timer;

    private BufferedImage[] frames;

    /*! \fn  public Animation(int speed, BufferedImage[] frames)
      \brief Constructorul clasei.
       \param speed viteza de redare a imaginilor
      \param frames vectorul ce contine imaginile folosite pentru animatii
   */
    public Animation(int speed, BufferedImage[] frames){
        this.speed=speed;
        this.frames=frames;
        index=0;
        timer = 0;
        lastTime=System.currentTimeMillis();
    }

    /*! \fn public void update()
          \brief In functie de timp sunt generate animatiile propriu zise.
    */
    public void update(){
        ///calculeaza timpul trecut de la ultimul update
        timer += System.currentTimeMillis() - lastTime;
        ///cand a avut loc ultimul update
        lastTime = System.currentTimeMillis();

        ///atunci cand index-ul depaseste numarul de imaginii reincepe de la imaginea initiala
        if(timer > speed){
            index++;
            timer=0;
            if(index >= frames.length)
                index = 0;
        }
    }

    /*! \fn public BufferedImage getCurrentAnimation()
        \brief Returneaza animatia curenta a caracterului.
  */
    public BufferedImage getCurrentFrame(){
        return frames[index];
    }

    /*! \fn  public void resetIndex()
        \brief Reseteaza animatia.
  */
    public void resetIndex(){ index = 0; }

}
