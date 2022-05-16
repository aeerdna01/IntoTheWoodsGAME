package PaooGame.States;

import PaooGame.Entities.Movable.Hero;
import PaooGame.Entities.Statics.Tree1;
import PaooGame.Game;
import PaooGame.Graphics.Assets;
import PaooGame.Handler;
import PaooGame.Tiles.Tile;
import PaooGame.Worlds.World;

import java.awt.*;

public class GameState extends State {

    private Hero hero;
    private World world;


    public GameState(Handler handler){

        super(handler);
        world = new World(handler, "res/worlds/world1.txt");
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
        //g.drawImage(Assets.player,0,0,null);

        world.draw(g);

        //hero.draw(g);
        // tree.draw(g);
        //Tile.tiles[7].draw(g,3*Tile.TILE_WIDTH,3*Tile.TILE_HEIGHT);
    }
}
