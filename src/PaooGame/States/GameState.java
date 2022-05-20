package PaooGame.States;

import PaooGame.Entities.Movable.Hero;
import PaooGame.Entities.Statics.Tree1;
import PaooGame.Game;
import PaooGame.Graphics.Assets;
import PaooGame.Handler;
import PaooGame.Tiles.Tile;
import PaooGame.Worlds.World;

import java.awt.*;

import static java.lang.Thread.sleep;

public class GameState extends State {

    private Hero hero;
    private World world;


    public GameState(Handler handler){

        super(handler);
        world = new World(handler);
        handler.setWorld(world);

        //hero = new Hero(handler,300,300);
        //tree = new Tree(handler, 100,200);
    }

    @Override
    public void update() {

        world.update();

        //hero.update();
        //tree.update();

    }

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
}
