package PaooGame;

import PaooGame.GameWindow.GameWindow;
import PaooGame.Graphics.Assets;
import PaooGame.Graphics.GameCamera;
import PaooGame.Input.KeyManager;
import PaooGame.Input.MouseManager;
import PaooGame.States.*;
import PaooGame.Tiles.Tile;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.IOException;

/*! \class Game
    \brief Clasa principala a intregului proiect. Implementeaza Game - Loop (Update -> Draw)

                ------------
                |           |
                |     ------------
    60 times/s  |     |  Update  |  -->{ actualizeaza variabile, stari, pozitii ale elementelor grafice etc.
        =       |     ------------
     16.7 ms    |           |
                |     ------------
                |     |   Draw   |  -->{ deseneaza totul pe ecran
                |     ------------
                |           |
                -------------
    Implementeaza interfata Runnable:

        public interface Runnable {
            public void run();
        }

    Interfata este utilizata pentru a crea un nou fir de executie avand ca argument clasa Game.
    Clasa Game trebuie sa aiba definita metoda "public void run()", metoda ce va fi apelata
    in noul thread(fir de executie). Mai multe explicatii veti primi la curs.

    In mod obisnuit aceasta clasa trebuie sa contina urmatoarele:
        - public Game();            //constructor
        - private void init();      //metoda privata de initializare
        - private void update();    //metoda privata de actualizare a elementelor jocului
        - private void draw();      //metoda privata de desenare a tablei de joc
        - public run();             //metoda publica ce va fi apelata de noul fir de executie
        - public synchronized void start(); //metoda publica de pornire a jocului
        - public synchronized void stop()   //metoda publica de oprire a jocului
 */
public class Game implements Runnable
{
    private GameWindow      wnd;        /*!< Fereastra in care se va desena tabla jocului*/

    private int width, height; /*!< Referinta catre latimea si inaltimea ferestrei jocului. */
    public String title; /*!< Referinta catre titlul jocului. */

    private boolean         runState;   /*!< Flag ce starea firului de executie.*/
    private Thread          gameThread; /*!< Referinta catre thread-ul de update si draw al ferestrei*/
    private BufferStrategy  bs;         /*!< Referinta catre un mecanism cu care se organizeaza memoria complexa pentru un canvas.*/

    /// Sunt cateva tipuri de "complex buffer strategies", scopul fiind acela de a elimina fenomenul de
    /// flickering (palpaire) a ferestrei.
    /// Modul in care va fi implementata aceasta strategie in cadrul proiectului curent va fi triplu buffer-at

    ///                         |------------------------------------------------>|
    ///                         |                                                 |
    ///                 ****************          *****************        ***************
    ///                 *              *   Show   *               *        *             *
    /// [ Ecran ] <---- * Front Buffer *  <------ * Middle Buffer * <----- * Back Buffer * <---- Draw()
    ///                 *              *          *               *        *             *
    ///                 ****************          *****************        ***************

    private Graphics        g;          /*!< Referinta catre un context grafic.*/

    private Tile tile; /*!< variabila membra temporara. Este folosita in aceasta etapa doar pentru a desena ceva pe ecran.*/

    //Avaiable States
    public State gameState; /*!< Referinta catre joc. */
    public State menuState; /*!< Referinta catre pagina de start a jocului. */
    public State introState; /*!< Referinta catre meniu. */
    public State helpState; /*!< Referinta catre sectiunea help. */
    public State pauseState; /*!< Referinta catre seciunea pauza. */
    public State settingState; /*!< Referinta catre setari.  */
    public State winState; /*!< Referinta catre sectiunea de joc castigat. */

    //Input
    private KeyManager keyManager;  /*!< Referinta catre obiectul care gestioneaza intrarile din partea utilizatorului.*/
    private MouseManager mouseManager;  /*!< Referinta catre obiectul care gestioneaza miscarile mouse-ului.*/

    //Camera game
    private GameCamera gameCamera; /*!< Referinta catre obiectul care misca camera in functie de miscarile caracterului.*/

    //Handler
    private Handler handler;   /*!< Referinta catre un obiect a carui sarcina este doar de a retine diverse referinte pentru a fi usor accesibile.*/

    //Database
    private final DataBase dataBase;/*!< Referinta catre baza de date a jocului.*/


    /*! \fn public Game(String title, int width, int height)
        \brief Constructor de initializare al clasei Game.

        Acest constructor primeste ca parametri titlul ferestrei, latimea si inaltimea
        acesteia avand in vedere ca fereastra va fi construita/creata in cadrul clasei Game.

        \param title Titlul ferestrei.
        \param width Latimea ferestrei in pixeli.
        \param height Inaltimea ferestrei in pixeli.
     */
    public Game(String title, int width, int height)
    {
        this.width = width;
        this.height = height;
        this.title = title;

        ///Construirea obiectului de gestiune a evenimentelor de tastatura si mouse
        keyManager = new KeyManager();
        mouseManager = new MouseManager();

        ///Construirea bazei de date a jocului
        dataBase = new DataBase();

        /// Obiectul GameWindow este creat insa fereastra nu este construita
        /// Acest lucru va fi realizat in metoda init() prin apelul
        /// functiei BuildGameWindow();
        wnd = new GameWindow(title, width, height);

        /// Resetarea flagului runState ce indica starea firului de executie (started/stoped)
        runState = false;
    }

    /*! \fn private void init()
        \brief  Metoda construieste fereastra jocului, initializeaza aseturile, listenerul de tastatura etc.

        Fereastra jocului va fi construita prin apelul functiei BuildGameWindow();
        Sunt construite elementele grafice (assets): dale, player, elemente active si pasive.

     */
    private void InitGame() throws UnsupportedAudioFileException, IOException {

        ///Sa ataseaza ferestrei managerul de tastatura si mouse pentru a primi evenimentele furnizate de fereastra.
        wnd.getFrame().addKeyListener(keyManager);
        wnd.getFrame().addMouseListener(mouseManager);
        wnd.getFrame().addMouseMotionListener(mouseManager);
        wnd.GetCanvas().addMouseListener(mouseManager);
        wnd.GetCanvas().addMouseMotionListener(mouseManager);

        /// Este construita fereastra grafica.
        wnd.BuildGameWindow();

        /// Se incarca toate elementele grafice (dale)
        Assets.Init();

        ///Se construieste obiectul de tip shortcut ce va retine o serie de referinte catre elementele importante din program.
        handler= new Handler(this);

        ///Se construieste camera jocului
        gameCamera = new GameCamera(handler,0,0);

        ///Se definesc starile jocului
        winState = new WinState(handler);
        helpState = new HelpState(handler);
        gameState = new GameState(handler);
        introState = new IntroState(handler);
        pauseState = new PauseState(handler);
        settingState = new SettingsState(handler);
        menuState = new MenuState(handler);

        ///Seteaza stare implicita cu care va fi lansat programul in executie
        State.setState(menuState);

    }

    /*! \fn public void run()
        \brief Functia ce va rula in thread-ul creat.

        Aceasta functie va actualiza starea jocului si va redesena tabla de joc (va actualiza fereastra grafica)
     */
    public void run()
    {
        /// Initializeaza obiectul game
        try {
            InitGame();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long oldTime = System.nanoTime();   /*!< Retine timpul in nanosecunde aferent frame-ului anterior.*/
        long curentTime;                    /*!< Retine timpul curent de executie.*/

        /// Apelul functiilor Update() & Draw() trebuie realizat la fiecare 16.7 ms
        /// sau mai bine spus de 60 ori pe secunda.

        final int framesPerSecond   = 60; /*!< Constanta intreaga initializata cu numarul de frame-uri pe secunda.*/
        final double timeFrame      = 1000000000 / framesPerSecond; /*!< Durata unui frame in nanosecunde.*/

        /// Atat timp timp cat threadul este pornit Update() & Draw()
        while (runState == true)
        {
            /// Se obtine timpul curent
            curentTime = System.nanoTime();
            /// Daca diferenta de timp dintre curentTime si oldTime mai mare decat 16.6 ms
            if((curentTime - oldTime) > timeFrame)
            {
                /// Actualizeaza pozitiile elementelor
                Update();
                /// Deseneaza elementele grafica in fereastra.
                Draw();
                oldTime = curentTime;
            }
        }

    }


    /*! \fn public synchronized void start()
                \brief Creaza si starteaza firul separat de executie (thread).

                Metoda trebuie sa fie declarata synchronized pentru ca apelul acesteia sa fie semaforizat.
    */
    public synchronized void StartGame()
    {
        if(runState == false)
        {
            /// Se actualizeaza flagul de stare a threadului
            runState = true;
            /// Se construieste threadul avand ca parametru obiectul Game. De retinut faptul ca Game class
            /// implementeaza interfata Runnable. Threadul creat va executa functia run() suprascrisa in clasa Game.
            gameThread = new Thread(this);
            /// Threadul creat este lansat in executie (va executa metoda run())
            gameThread.start();
        }
        else
        {
            /// Thread-ul este creat si pornit deja
            return;
        }
    }

    /*! \fn public synchronized void stop()
        \brief Opreste executie thread-ului.

        Metoda trebuie sa fie declarata synchronized pentru ca apelul acesteia sa fie semaforizat.
     */
    public synchronized void StopGame()
    {
        if(runState == true)
        {
            /// Actualizare stare thread
            runState = false;
            /// Metoda join() arunca exceptii motiv pentru care trebuie incadrata intr-un block try - catch.
            try
            {
                /// Metoda join() pune un thread in asteptare panca cand un altul isi termina executie.
                /// Totusi, in situatia de fata efectul apelului este de oprire a threadului.
                gameThread.join();
            }
            catch(InterruptedException ex)
            {
                /// In situatia in care apare o exceptie pe ecran vor fi afisate informatii utile pentru depanare.
                ex.printStackTrace();
            }
        }
        else
        {
            /// Thread-ul este oprit deja.
            return;
        }
    }

    /*! \fn private void Update()
        \brief Actualizeaza starea elementelor din joc.

        Metoda este declarata privat deoarece trebuie apelata doar in metoda run()
     */

    private void Update()
    {
        try {
            ///se determina starea tastelor
            keyManager.update();
            ///Trebuie obtinuta starea curenta pentru care urmeaza a se actualiza starea, trebuie sa fie diferita de null.
            if (State.getState() != null) {
                ///Actualizeaza starea curenta a jocului daca exista.
                State.getState().update();
                wnd.getFrame().requestFocusInWindow();
            }
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

    /*! \fn private void Draw()
        \brief Deseneaza elementele grafice in fereastra coresponzator starilor actualizate ale elementelor.

        Metoda este declarata privat deoarece trebuie apelata doar in metoda run()
     */
    private void Draw()
    {
        /// Returnez bufferStrategy pentru canvasul existent
        bs = wnd.GetCanvas().getBufferStrategy();

        /// Verific daca buffer strategy a fost construit sau nu
        if(bs == null)
        {
            /// Se executa doar la primul apel al metodei Draw()
            try
            {
                /// Se construieste tripul buffer
                wnd.GetCanvas().createBufferStrategy(3);
                return;
            }
            catch (Exception e)
            {
                /// Afisez informatii despre problema aparuta pentru depanare.
                e.printStackTrace();
            }
        }

        /// Se obtine contextul grafic curent in care se poate desena.
        g = bs.getDrawGraphics();

        /// Se sterge ce era
        g.clearRect(0, 0, wnd.GetWndWidth(), wnd.GetWndHeight());

        /// operatie de desenare

        ///Trebuie obtinuta starea curenta pentru care urmeaza a se actualiza starea, trebuie sa fie diferita de null.
        if(State.getState()!=null){
            ///Actualizeaza starea curenta a jocului daca exista.
            State.getState().draw(g);
        }

        /// end operatie de desenare

        /// Se afiseaza pe ecran
        bs.show();

        /// Elibereaza resursele de memorie aferente contextului grafic curent (zonele de memorie ocupate de
        /// elementele grafice ce au fost desenate pe canvas).
        g.dispose();
    }

    ///GETTERS

    /*! \fn public KeyManager GetKeyManager()
      \brief Returneaza obiectul care gestioneaza tastatura.
   */
    public KeyManager getKeyManager(){
        return keyManager;
    }

    /*! \fn public KeyManager GetKeyManager()
   \brief Returneaza obiectul care gestioneaza mouse-ul.
    */
    public MouseManager getMouseManager() {
        return mouseManager;
    }


    /*! \fn public GameCamera GetCameraGame()
     \brief Returneaza camera care se centreaza pe caracter.
    */
    public GameCamera getGameCamera(){
        return gameCamera;
    }

    /*! \fn public int GetWidth()
       \brief Returneaza latimea ferestrei
    */
    public int getWidth() {
        return width;
    }

    /*! \fn public int GetHeight()
          \brief Returneaza inaltimea ferestrei
       */
    public int getHeight() {
        return height;
    }

    /*! \fn public static State getPlayState()
     \brief Returneaza state-ul de play.
 */
    public State getGameState() {
        return gameState;
    }


    /*! \fn public static State getMenuState()
    \brief Returneaza state-ul de menu.
    */
    public State getMenuState() {
        return menuState;
    }


    /*! \fn public static State getMenuState()
    \brief Returneaza state-ul de intro.
    */
    public State getIntroState() {
        return introState;
    }


    /*! \fn public static State getMenuState()
    \brief Returneaza state-ul de settings.
    */
    public State getSettingState() {
        return settingState;
    }


    /*! \fn public static State getMenuState()
    \brief Returneaza state-ul de winner.
    */
    public State getWinState() {
        return winState;
    }


    /*! \fn public static State getMenuState()
    \brief Returneaza state-ul de pause.
    */
    public State getPauseState() {
        return pauseState;
    }


    /*! \fn public static State getMenuState()
    \brief Returneaza baza de date a jocului.
    */
    public DataBase getDataBase() {
        return dataBase;
    }

}

