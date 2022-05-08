package PaooGame.Entities.Statics;

import PaooGame.Graphics.Assets;
import PaooGame.Handler;
import PaooGame.Tiles.Tile;

import java.awt.*;

public class Crystal extends StaticEntity{


    public Crystal(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILE_WIDTH * 3, Tile.TILE_HEIGHT * 3);
        bounds.x = 25;
        bounds.y = (int) (height / 1.3f);
        bounds.width = width - 50;
        bounds.height = (int) (height - height / 1.3f);
    }

    @Override
    public void update() {

    }


    @Override
    public void draw(Graphics g) {
        //g.setColor(Color.blue);
        //g.fillRect((int)(x + bounds.x), (int)(y + bounds.y), bounds.width, bounds.height);
        g.drawImage(Assets.crystal,(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()), width, height,null);
    }

    @Override
    public void die() {

    }

}
