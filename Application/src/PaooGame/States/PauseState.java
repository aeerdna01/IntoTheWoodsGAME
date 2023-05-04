package PaooGame.States;

import PaooGame.Entities.Movable.Hero;
import PaooGame.Graphics.Assets;
import PaooGame.Graphics.AudioLoader;
import PaooGame.Handler;
import PaooGame.Entities.EntityManager;
import java.awt.*;
import java.sql.SQLException;

/*! \class public class PauseState extends State
    \brief Implementeaza notiunea de pauza in joc cu urmatoarele optiuni: resume, save, quit.
 */
public class PauseState extends State {

    /*! \fn public PauseState(Handler handler)
         \brief Constructorul de initializare al clasei.
         \param handler O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
    */
    public PauseState(Handler handler) {
        ///Apel al constructorului clasei de baza
        super(handler);
        AudioLoader.setVolume(Assets.menuMusic,100);
        if (!Assets.menuMusic.isRunning()) { // daca Clipul audio nu este deja pornit
            Assets.menuMusic.setFramePosition(0);  // il setam sa inceapa de la frameul 0 ( folositor cand revenim in meniu din playState )
            Assets.menuMusic.start(); // pornim clipul audio
        }
    }

    /*! \fn public void Update()
        \brief Actualizeaza starea curenta.
    */
    @Override
    public void update() {

        ///implementare pentru notiunea de Resume
        if(handler.getMouseManager().getMouseX() >= 335  && handler.getMouseManager().getMouseX() <= 530){
            if(handler.getMouseManager().getMouseY() >= 167 && handler.getMouseManager().getMouseY() <= 236) {
                if(handler.getMouseManager().isLeftPressed())
                {
                    Assets.menuMusic.stop();
                    State.setState(State.GetPreviousState());
                }
            }
        }

        ///implementare pentru notiunea de Save
        if(handler.getMouseManager().getMouseX() >= 342  && handler.getMouseManager().getMouseX() <= 524){
            if(handler.getMouseManager().getMouseY() >= 269 && handler.getMouseManager().getMouseY() <= 320) {
                if(handler.getMouseManager().isLeftPressed())
                {
                    try {
                        handler.getGame().getDataBase().updateAll((int)handler.getWorld().getEntityManager().getHero().getX(),
                                (int)handler.getWorld().getEntityManager().getHero().getY(),
                                handler.getWorld().getEntityManager().getHero().getHealth(),
                                Hero.getInstance(handler,0,0).getLevel(),
                                handler.getWorld().getEntityManager().getHero().getScore());
                        System.out.println("OKKKK");
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        System.out.println("Eroare");
                    }
                }
            }
        }

        ///implementare pentru notiunea de Quit
        if(handler.getMouseManager().getMouseX() >= 344  && handler.getMouseManager().getMouseX() <= 526){
            if(handler.getMouseManager().getMouseY() >= 357 && handler.getMouseManager().getMouseY() <= 407) {
                if(handler.getMouseManager().isLeftPressed())
                {
                    System.exit(0);
                }
            }
        }

    }


    /*! \fn public void draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a meniului.
        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
    */
    @Override
    public void draw(Graphics g) {
        g.drawImage(Assets.pause, 0, 0, handler.getWidth(), handler.getHeight(), null);
        g.drawImage(Assets.sword,handler.getMouseManager().getMouseX(),handler.getMouseManager().getMouseY(),64,64,null);
    }

}
