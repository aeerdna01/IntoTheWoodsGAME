package PaooGame.States;

import PaooGame.Graphics.Assets;
import PaooGame.Handler;
import PaooGame.UI.ClickListener;
import PaooGame.UI.UIManager;
import PaooGame.Utils.UIImageButton;

import java.awt.*;
import java.sql.SQLException;
/*! \class public class WinState extends State
    \brief Implementeaza notiunea de joc castigat cu posibilitate de intoarcere in meniu.
 */
public class WinState extends State{

    private UIManager uiManager;

    /*! \fn public WinState(Handler handler)
        \brief Constructorul de initializare al clasei.
        \param handler O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
    */
    public WinState(Handler handler) {
        ///Apel al constructorului clasei de baza
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);

        uiManager.addObject(new UIImageButton(752, 40, 48, 48, Assets.btn_back, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(uiManager);
                State.setState(handler.getGame().introState);
            }
        }));

    }

    /*! \fn public void Update()
       \brief Actualizeaza starea curenta.
    */
    @Override
    public void update() {
         System.out.println(handler.getMouseManager().getMouseX() + " " +handler.getMouseManager().getMouseY());
         Assets.level3Music.stop();
        uiManager.update();
    }

    /*! \fn public void draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a meniului.
        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
    */
    @Override
    public void draw(Graphics g) {
        g.drawImage(Assets.win,0,0,handler.getWidth(), handler.getHeight(), null);
        g.setColor(Color.black);
        g.setFont(new Font("Serif", Font.PLAIN, 48));
        try {
            g.drawString("Score: ", 503, 285);
            g.drawString(Integer.toString(handler.getDataBase().getScore()), 640, 286);

        } catch (SQLException e) {
            System.err.println(e);
        }
        uiManager.draw(g);
        g.drawImage(Assets.sword,handler.getMouseManager().getMouseX(),handler.getMouseManager().getMouseY(),64,64,null);

    }
}
