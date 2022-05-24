package PaooGame.States;

import PaooGame.Entities.Movable.Hero;
import PaooGame.Graphics.Assets;
import PaooGame.Graphics.AudioLoader;
import PaooGame.Handler;
import PaooGame.Entities.EntityManager;
import java.awt.*;
import java.sql.SQLException;

public class PauseState extends State {

    public PauseState(Handler handler) {
        super(handler);
        AudioLoader.setVolume(Assets.menuMusic,100);
        if (!Assets.menuMusic.isRunning()) { // daca Clipul audio nu este deja pornit
            Assets.menuMusic.setFramePosition(0);  // il setam sa inceapa de la frameul 0 ( folositor cand revenim in meniu din playState )
            Assets.menuMusic.start(); // pornim clipul audio
        }
    }

    @Override
    public void update() {
       //ystem.out.println(handler.getMouseManager().getMouseX() + " " +handler.getMouseManager().getMouseY());
        //resume
        if(handler.getMouseManager().getMouseX() >= 335  && handler.getMouseManager().getMouseX() <= 530){
            if(handler.getMouseManager().getMouseY() >= 167 && handler.getMouseManager().getMouseY() <= 236) {
                if(handler.getMouseManager().isLeftPressed())
                {
                    Assets.menuMusic.stop();
                    State.setState(State.GetPreviousState());
                }
            }
        }

        //save
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

        //quit
        if(handler.getMouseManager().getMouseX() >= 344  && handler.getMouseManager().getMouseX() <= 526){
            if(handler.getMouseManager().getMouseY() >= 357 && handler.getMouseManager().getMouseY() <= 407) {
                if(handler.getMouseManager().isLeftPressed())
                {
                    System.exit(0);
                }
            }
        }

    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(Assets.pause, 0, 0, handler.getWidth(), handler.getHeight(), null);
        g.drawImage(Assets.sword,handler.getMouseManager().getMouseX(),handler.getMouseManager().getMouseY(),64,64,null);
    }

}
