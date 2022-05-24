package PaooGame.Input;

import PaooGame.UI.UIManager;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/*! \class MouseInput implements MouseListener, MouseMotionListener
    \brief Gestioneaza miscarile mouse-ului.
 */

public class MouseManager implements MouseListener, MouseMotionListener {

    private boolean leftPressed, rightPressed;   /*!< flag ce se schimba in momentul in care se apasa click stanga/dreapta.*/
    private int mouseX, mouseY; /*!< Referinta catre coordonata mouse-ului de pe axa Ox si axa Oy.*/

    private UIManager uiManager;

    /*! \fn public KeyManager()
    \brief Constructorul clasei.
    */
    public MouseManager(){

    }
    public void setUiManager(UIManager uiManager){
        this.uiManager = uiManager;
    }

    /*! \fn public boolean isLeftPressed()
            \brief Returneaza daca a fost apasat button1 mouse/click stanga.
     */
    public boolean isLeftPressed(){
        return leftPressed;
    }

    /*! \fn public boolean isRightPressed()
         \brief Returneaza daca a fost apasat button3 mouse/click dreapta.
  */
    public boolean isRightPressed(){
        return rightPressed;
    }

    /*! \fn public int getMouseX()
        \brief Returneaza pozitina mouse pe axa Ox.
   */
    public int getMouseX() {
        return mouseX;
    }

    /*! \fn public int getMouseY()
        \brief Returneaza pozitina mouse pe axa Ox.
   */
    public int getMouseY() {
        return mouseY;
    }


    /*! \fn public void mouseClicked(MouseEvent e)
         \brief Eventul de mouseClicked
     */
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    /*! \fn public void mousePressed(MouseEvent e)
          \brief Eventul de apasare a unui click
      */
    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1)
            leftPressed = true;
        else if(e.getButton() == MouseEvent.BUTTON3)
            rightPressed = true;
    }

    /*! \fn public void mouseReleased(MouseEvent e)
        \brief Eventul de mouseReleased.
    */
    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1)
            leftPressed = false;
        else if(e.getButton() == MouseEvent.BUTTON3)
            rightPressed = false;

        if(uiManager != null)
            uiManager.onMouseRelease(e);

    }

    /*! \fn public void mouseEntered(MouseEvent e)
         \brief Eventul de mouseEntered.
    */
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    /*! \fn public void mouseExited(MouseEvent e)
        \brief Eventul de mouseExited.
   */
    @Override
    public void mouseExited(MouseEvent e) {

    }

    /*! \fn public void mouseDragged(MouseEvent e)
        \brief Eventul de mouseDragged.
    */
    @Override
    public void mouseDragged(MouseEvent e) {

    }

    /*! \fn public void mouseMoved(MouseEvent e)
            \brief Eventul de mouseMoved.
    */
    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();

        if(uiManager != null)
            uiManager.onMouseMove(e);
    }
}
