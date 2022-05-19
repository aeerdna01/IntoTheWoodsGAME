package PaooGame.Entities.Statics;

import PaooGame.Graphics.Assets;
import PaooGame.Handler;
import PaooGame.Tiles.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BlueDiamond extends StaticEntity{

    private BufferedImage image;


    public BlueDiamond(Handler handler, float x, float y) {
        super(handler, x, y, 64, 64);

        image = Assets.blueDiamond;

        this.health = 1;
        bounds.x = 25;
        bounds.y = (int) (height / 1.3f);
        bounds.width = width - 50;
        bounds.height = (int) (height - height / 1.3f);
    }

    @Override
    public void update() {
        collected();
    }

    public void collected() {
        Rectangle ar = new Rectangle();
        ar.width = this.width;
        ar.height = this.height;
        ar.x = (int) this.getX();
        ar.y = (int) this.getY();

        if (handler.getWorld().getEntityManager().getHero().getCollisionBounds(0, 0).intersects(ar)) {
            this.die();
            handler.getWorld().getEntityManager().getHero().addScore(5);
        }
    }

    @Override
    public boolean isEnemy()
    {
        return false;
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image,(int)(x-handler.getGame().getGameCamera().getxOffset()),
                (int)(y-handler.getGame().getGameCamera().getyOffset()),width,height,null);
    }

    @Override
    public void die() {
        this.active = false;
    }
}
