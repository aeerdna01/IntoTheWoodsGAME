package PaooGame.States;

import PaooGame.Entities.Movable.Hero;
import PaooGame.Graphics.Assets;
import PaooGame.Graphics.AudioLoader;
import PaooGame.Handler;
import PaooGame.UI.UIManager;
import PaooGame.Worlds.World;

import java.awt.*;
import java.sql.SQLException;

public class IntroState extends State{

    private UIManager uiManager;

    public IntroState(Handler handler) {
        super(handler);
        try{
        AudioLoader.setVolume(Assets.menuMusic,handler.getDataBase().getMenuVolume());
         } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update() {
        if (!Assets.menuMusic.isRunning()) { // daca Clipul audio nu este deja pornit
            Assets.menuMusic.setFramePosition(0);  // il setam sa inceapa de la frameul 0 ( folositor cand revenim in meniu din playState )
            Assets.menuMusic.start(); // pornim clipul audio
        }
       // System.out.println(handler.getMouseManager().getMouseX() + " " +handler.getMouseManager().getMouseY());

        //new game
        if(handler.getMouseManager().getMouseX() >= 154 && handler.getMouseManager().getMouseX() <= 345){
            if(handler.getMouseManager().getMouseY() >= 55 && handler.getMouseManager().getMouseY() <= 120) {
                if(handler.getMouseManager().isLeftPressed())
                {
                    Assets.menuMusic.stop();
                    handler.getGame().gameState = new GameState(handler);
                    State.setState(handler.getGame().gameState);
                    World w = new World(handler,1);
                    GameState.setWorld(w);
                    handler.setWorld(GameState.world);
                   // Hero.getInstance(handler,0,0).setLevel(1);
                }
            }
        }

        //help
        if(handler.getMouseManager().getMouseX() >= 153 && handler.getMouseManager().getMouseX() <= 337){
            if(handler.getMouseManager().getMouseY() >= 235 && handler.getMouseManager().getMouseY() <= 290) {
                if(handler.getMouseManager().isLeftPressed())
                {
                    //Assets.MenuMusic.stop();
                    State.setState(handler.getGame().helpState);

                }
            }
        }

        //load game
        if(handler.getMouseManager().getMouseX() >= 159 && handler.getMouseManager().getMouseX() <= 343){
            if(handler.getMouseManager().getMouseY() >= 140 && handler.getMouseManager().getMouseY() <= 197) {
                if(handler.getMouseManager().isLeftPressed())
                {
                    Assets.menuMusic.stop();
                    try{
                        Hero.getInstance(handler,0,0).setX(handler.getGame().getDataBase().getHeroX());
                        Hero.getInstance(handler,0,0).setY(handler.getGame().getDataBase().getHeroY());
                        Hero.getInstance(handler,0,0).setHealth(handler.getGame().getDataBase().getHeroHealth());
                       // Hero.getInstance(handler,0,0).setScore(handler.getGame().getDataBase().getScore());
                        handler.getWorld().getEntityManager().getHero().setScore(handler.getGame().getDataBase().getScore());

                        if(handler.getGame().getDataBase().getLevel() == 1)
                        {
                            handler.getGame().gameState = new GameState(handler);
                            State.setState(handler.getGame().gameState);
                            World w = new World(handler,1);
                            GameState.setWorld(w);
                            handler.setWorld(GameState.world);
                        }
                        if(handler.getGame().getDataBase().getLevel() == 2)
                        {
                            handler.getGame().gameState = new GameState(handler);
                            State.setState(handler.getGame().gameState);
                            World w = new World(handler,2);
                            GameState.setWorld(w);
                            handler.setWorld(GameState.world);
                        }
                        if(handler.getGame().getDataBase().getLevel() == 3)
                        {
                            handler.getGame().gameState = new GameState(handler);
                            State.setState(handler.getGame().gameState);
                            World w = new World(handler,3);
                            GameState.setWorld(w);
                            handler.setWorld(GameState.world);
                        }



                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
        //settings
        if(handler.getMouseManager().getMouseX() >= 152 && handler.getMouseManager().getMouseX() <= 340){
            if(handler.getMouseManager().getMouseY() >= 326 && handler.getMouseManager().getMouseY() <= 379) {
                if(handler.getMouseManager().isLeftPressed())
                {

                    State.setState(handler.getGame().settingState);

                }
            }
        }
        //quit
        if(handler.getMouseManager().getMouseX() >= 152 && handler.getMouseManager().getMouseX() <= 337){
            if(handler.getMouseManager().getMouseY() >= 414 && handler.getMouseManager().getMouseY() <= 465 ) {
                if(handler.getMouseManager().isLeftPressed())
                {
                    System.exit(0);
                }
            }
        }

    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(Assets.intro,0,0,handler.getWidth(),handler.getHeight(),null);
        g.drawImage(Assets.sword,handler.getMouseManager().getMouseX(),handler.getMouseManager().getMouseY(),64,64,null);
    }
}
