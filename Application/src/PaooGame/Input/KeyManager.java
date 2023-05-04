package PaooGame.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/*! \class KeyManager implements KeyListener
    \brief Gestioneaza intrarea (input-ul) de tastatura.
    Clasa citeste daca a fost apasata o tasta, stabiliteste ce tasta a fost actionata si seteaza corespunzator un flag.
    In program trebuie sa se tina cont de flagul aferent tastei de interes. Daca flagul respectiv este true inseamna
    ca tasta respectiva a fost apasata si false nu a fost apasata.
 */

public class KeyManager implements KeyListener {

    private boolean[] keys;  /*!< Vector de flaguri pentru toate tastele. Tastele vor fi regasite dupa cod [0 - 255]*/
    public boolean up, down, left, right; /*!< Flag pentru tasta "sus"/"jos"/"stanga"/"dreapta"  apasata.*/
    public boolean attack; /*!< Flag pentru tasta "atack" apasata.*/
    public boolean restart; /*!< Flag pentru tasta "restart" apasata.*/
    public boolean quit; /*!< Flag pentru tasta "quit" apasata.*/
    public boolean escape; /*!< Flag pentru tasta "escape" apasata.*/
    public boolean play; /*!< Flag pentru tasta "play" apasata.*/

    private boolean[] justPressed, cantPress;

    public void update(){
        for(int i = 0; i< keys.length;i++)
        {
            if(cantPress[i] && !keys[i]){
                cantPress[i] = false;
            }else if(justPressed[i]){
                cantPress[i] = true;
                justPressed[i] = false;
            }
            if(!cantPress[i] && keys[i]){
                justPressed[i] = true;
            }
        }

        up = keys[KeyEvent.VK_W];
        down = keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_D];
        attack = keys[KeyEvent.VK_SPACE];

        quit = keys[KeyEvent.VK_Q];
        restart = keys[KeyEvent.VK_R];
        escape = keys[KeyEvent.VK_ESCAPE];
        play = keys[KeyEvent.VK_ENTER];

    }

    /*! \fn public KeyManager()
      \brief Constructorul clasei.
   */
    public KeyManager(){
        ///Constructie vector de flaguri aferente tastelor.
        keys = new boolean[256];
        justPressed = new boolean[keys.length];
        cantPress = new boolean[keys.length];

    }

    /*! \fn public void keyPressed(KeyEvent e)
     \brief Functie ce va fi apelata atunci cand un un eveniment de tasta apasata este generat.
      \param e obiectul eveniment de tastatura.
  */
    public boolean keyJustPressed(int keyCode){
        if(keyCode < 0 || keyCode >= keys.length)
            return false;
        return justPressed[keyCode];
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
            return;
        keys[e.getKeyCode()]=true;
        //System.out.println("Pressed!");
    }

    /*! \fn public void keyReleased(KeyEvent e)
       \brief Functie ce va fi apelata atunci cand un un eveniment de tasta eliberata este generat.
        \param e obiectul eveniment de tastatura.
    */
    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
            return;
        keys[e.getKeyCode()]=false;
    }

    /*! \fn public void keyTyped(KeyEvent e)
     \brief Functie ce va fi apelata atunci cand o tasta a fost apasata si eliberata.
  */
    @Override
    public void keyTyped(KeyEvent e) {

    }

}
