package PaooGame.Entities.Statics;

import PaooGame.Graphics.Assets;
import PaooGame.Handler;
import PaooGame.Tiles.Tile;

import java.awt.*;

public class Fire extends StaticEntity{


    public Fire(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILE_WIDTH*1, Tile.TILE_HEIGHT *2);

        bounds.x = 0;
        bounds.y = (int) (height / 1.5f);
        bounds.width = width - 7;
        bounds.height = (int) (height - height / 1.5f);
    }

    @Override
    public void update() {

    }


    @Override
    public void draw(Graphics g) {
        //g.setColor(Color.pink);
        //g.fillRect((int)(x + bounds.x), (int)(y + bounds.y), bounds.width, bounds.height);
        g.drawImage(Assets.fire,(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()), width, height,null);
    }

    @Override
    public void die() {

    }
}