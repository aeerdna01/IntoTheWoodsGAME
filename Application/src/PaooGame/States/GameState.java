package PaooGame.States;

import PaooGame.Entities.Movable.Chimera;
import PaooGame.Entities.Movable.Hero;
import PaooGame.Entities.Statics.Tree1;
import PaooGame.Game;
import PaooGame.Graphics.Assets;
import PaooGame.Graphics.AudioLoader;
import PaooGame.Handler;
import PaooGame.Tiles.Tile;
import PaooGame.Worlds.World;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import static java.lang.Thread.sleep;

/*! \class public class GameState extends State
    \brief Implementeaza jocul propriu zis.
 */
public class GameState extends State {

    private Hero hero;
    public static World world;

    /*! \fn public GameState(Handler handler)
       \brief Constructorul de initializare al clasei.
       \param handler O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
   */
    public GameState(Handler handler){

        super(handler);
        world = new World(handler,1);
        handler.setWorld(world);
        try {
            AudioLoader.setVolume(Assets.level1Music, handler.getDataBase().getGameVolume());
            AudioLoader.setVolume(Assets.level1Music,  handler.getDataBase().getGameVolume());
            AudioLoader.setVolume(Assets.level1Music,  handler.getDataBase().getGameVolume());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*! \fn public void Update()
        \brief Actualizeaza starea curenta.
    */
    @Override
    public void update() {

        world.update();
        if (world.getLevel() == 1) {
            if (!Assets.level1Music.isRunning()) { // daca Clipul audio nu este deja pornit
                Assets.level1Music.setFramePosition(0);  // il setam sa inceapa de la frameul 0 ( folositor cand revenim in meniu din playState )
                Assets.level1Music.start(); // pornim clipul audio
            }
        }
        if (world.isLevel1complete()) {
            Assets.level1Music.stop();
        }
        if (world.getLevel() == 2) {
            if (!Assets.level2Music.isRunning()) { // daca Clipul audio nu este deja pornit
                Assets.level2Music.setFramePosition(0);  // il setam sa inceapa de la frameul 0 ( folositor cand revenim in meniu din playState )
                Assets.level2Music.start(); // pornim clipul audio
            }
        }
        if (world.isLevel2complete()) {
            Assets.level2Music.stop();
        }
        if (world.getLevel() == 3) {
            if (!Assets.level3Music.isRunning()) { // daca Clipul audio nu este deja pornit
                Assets.level3Music.setFramePosition(0);  // il setam sa inceapa de la frameul 0 ( folositor cand revenim in meniu din playState )
                Assets.level3Music.start(); // pornim clipul audio
            }
        }

        if (world.isLevel3complete()) {
            Assets.level3Music.stop();
        }

        if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_ESCAPE)) {

            State.setState(handler.getGame().getPauseState());
            Assets.level1Music.stop();
            Assets.level2Music.stop();
            Assets.level2Music.stop();
            try {
                AudioLoader.setVolume(Assets.menuMusic, handler.getDataBase().getMenuVolume());
                if (!Assets.menuMusic.isRunning()) { // daca Clipul audio nu este deja pornit
                    Assets.menuMusic.setFramePosition(0);  // il setam sa inceapa de la frameul 0 ( folositor cand revenim in meniu din playState )
                    Assets.menuMusic.start(); // pornim clipul audio
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /*! \fn public void draw(Graphics g)
         \brief Deseneaza (randeaza) pe ecran starea curenta a meniului.
         \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
    */
    @Override
    public void draw(Graphics g) {
        world.draw(g);

        g.drawImage(Assets.sword,handler.getMouseManager().getMouseX(),handler.getMouseManager().getMouseY(),64,64,null);

        if(world.isPlayerdead())
        {
            g.drawImage(Assets.gameover,0,0,handler.getWidth(),handler.getHeight(),null);

        }

        if(world.isLevel1complete()){
            g.drawImage(Assets.level2unlocked,0,0,handler.getWidth(),handler.getHeight(),null);
        }

        if (world.isLevel2complete())
        {
            g.drawImage(Assets.level3unlocked,0,0,handler.getWidth(),handler.getHeight(),null);
        }

    }

    public static void setWorld(World world) {
        GameState.world = world;
    }
}
