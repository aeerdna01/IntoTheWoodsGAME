package PaooGame;

import PaooGame.Graphics.GameCamera;
import PaooGame.Input.KeyManager;
import PaooGame.Input.MouseManager;
import PaooGame.States.State;
import PaooGame.Worlds.World;
/*! \class  Handler
    \brief Clasa ce retine o serie de referinte ale unor elemente pentru a fi usor accesibile.
    Altfel ar trebui ca functiile respective sa aiba o serie intreaga de parametri si ar ingreuna programarea.
 */
public class Handler {

    private Game game;   /*!< Referinta catre obiectul Game.*/
    private World world;  /*!< Referinta catre harta curenta.*/
    private State state;  /*!< Referinta catre baza de date a jocului.*/

    /*! \fn public Handler(Game game)
      \brief Constructorul de initializare al clasei.
      \param game Referinta catre obiectul game.
  */
    public Handler(Game game){
        this.game=game;
    }

    public GameCamera getGameCamera(){
        return game.getGameCamera();
    }

    /*! \fn public KeyManager GetKeyManager()
        \brief Returneaza referinta catre managerul evenimentelor de tastatura.
     */
    public KeyManager getKeyManager(){
        return game.getKeyManager();
    }

    /*! \fn public KeyManager GetMouseManager()
        \brief Returneaza referinta catre managerul evenimentelor de mouse.
     */
    public MouseManager getMouseManager(){
        return game.getMouseManager();
    }

    /*! \fn public int GetWidth()
       \brief Returneaza latimea ferestrei jocului.
    */
    public int getWidth(){
        return game.getWidth();
    }


    /*! \fn public int GetHeight()
        \brief Returneaza inaltimea ferestrei jocului.
     */
    public int getHeight(){
        return game.getHeight();
    }


    /*! \fn public int GetHeight()
        \brief Returneaza inaltimea ferestrei jocului.
     */
    public Game getGame() {
        return game;
    }

    /*! \fn public void SetGame(Game game)
        \brief Seteaza referinta catre un obiect Game.
        \param game Referinta obiectului Game.
     */
    public void setGame(Game game) {
        this.game = game;
    }

    /*! \fn public Map GetWorld()
        \brief Intoarce referinta catre harta curenta.
     */
    public World getWorld() {
        return world;
    }

    /*! \fn public void Setworld(World world)
        \brief Seteaza referinta catre harta curenta.
        \param map Referinta catre harta curenta.
     */
    public void setWorld(World world) {
        this.world = world;
    }

    /*! \fn public State GetState()
        \brief Returneaza referinta catre state-ul jocului.
     */
    public State getState() {
        return state;
    }

    /*! \fn public void SetState(State state)
       \brief Seteaza referinta catre state-ul jocului.
        \param state Referinta catre state-ul curent.
    */
    public void setState(State state) {
        this.state = state;
    }

    /*! \fn public DataBase setDataBase()
        \brief Returneaza referinta catre baza de date a jocului.
     */
    public DataBase getDataBase() {
        return game.getDataBase();
    }
}
