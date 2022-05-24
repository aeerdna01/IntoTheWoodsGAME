package PaooGame.States;

import PaooGame.Game;
import PaooGame.Graphics.Assets;
import PaooGame.Handler;
import PaooGame.UI.ClickListener;
import PaooGame.UI.UIManager;
import PaooGame.Utils.UIImageButton;

import java.awt.*;


/*! \class MenuState extends State
    \brief Implementeaza notiunea de start menu pentru joc.
 */

public class MenuState extends State {

    private UIManager uiManager;   /*!< Referinta pentru gestiunorea obiectul de tip button.*/

    /*! \fn public MenuState(Handler handler)
        \brief Constructorul de initializare al clasei.
        \param handler O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */

    public MenuState(Handler handler){

        ///Apel al constructorului clasei de baza.
        super(handler);

        ///Gestionare element grafic
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);

        uiManager.addObject(new UIImageButton(780, 590, 48, 48, Assets.btn_start, new ClickListener() {
            @Override
            public void onClick() {
                ///la apasarea butonului se trece in next State
                handler.getMouseManager().setUiManager(uiManager);
                State.setState(handler.getGame().introState);
            }
        }));

    }
    @Override
    public void update() {
        ///linie folosita pentru a determina coordonatele unde se se doreste plasarea butonului.
        ///System.out.println(handler.getMouseManager().getMouseX() + " " +handler.getMouseManager().getMouseY());

        uiManager.update();

        //temporary to go directly to the game state
        /*handler.getMouseManager().setUiManager(null);
        State.setState(handler.getGame().gameState);*/
    }

    /*! \fn public void draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a meniului.
        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
    */
    @Override
    public void draw(Graphics g) {
        ///deseneaza background-ul starii
        g.drawImage(Assets.menu1,0,0,handler.getWidth(), handler.getHeight(), null);
        ///deseneaza obiectul de tip buton
        uiManager.draw(g);
        ///deseneaza cursorul pentru mouse
        g.drawImage(Assets.sword,handler.getMouseManager().getMouseX(),handler.getMouseManager().getMouseY(),64,64,null);
    }
}
