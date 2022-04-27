package PaooGame.Entities.Statics;

import PaooGame.Graphics.Assets;
import PaooGame.Handler;
import PaooGame.Tiles.Tile;

import java.awt.*;

public class Tree3 extends StaticEntity{


    public Tree3(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILE_WIDTH * 5, Tile.TILE_HEIGHT * 5);
        bounds.x = 45;
        bounds.y = (int) (height / 1.5f);
        bounds.width = width - 90;
        bounds.height = (int) (height - height / 1.5f);

    }

    @Override
    public void update() {

    }


    @Override
    public void draw(Graphics g) {
        //g.setColor(Color.green);
        //g.fillRect((int)(x + bounds.x), (int)(y + bounds.y), bounds.width, bounds.height);
        g.drawImage(Assets.tree3,(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()), width, height,null);
    }

    @Override
    public void die() {

    }
}
