package PaooGame.States;

import PaooGame.Graphics.Assets;
import PaooGame.Handler;
import PaooGame.UI.ClickListener;
import PaooGame.UI.UIManager;
import PaooGame.Utils.UIImageButton;

import java.awt.*;

/*! \class public class HelpState extends State
    \brief Ofera informatii despre actiunea si mecanica jocului.
 */
public class HelpState extends State{

    private UIManager uiManager;

    /*! \fn public HelpState(Handler handler)
      \brief Constructorul de initializare al clasei.
      \param handler O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
  */
    public HelpState(Handler handler) {
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
        uiManager.update();
    }

    /*! \fn public void draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a meniului.
        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
   */
    @Override
    public void draw(Graphics g) {

        g.drawImage(Assets.help,0,0,handler.getWidth(), handler.getHeight(), null);
        uiManager.draw(g);
        g.drawImage(Assets.sword,handler.getMouseManager().getMouseX(),handler.getMouseManager().getMouseY(),64,64,null);

    }
}
