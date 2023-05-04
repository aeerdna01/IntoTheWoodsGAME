package PaooGame.Entities.Statics;

import PaooGame.Graphics.Assets;
import PaooGame.Handler;
import PaooGame.Tiles.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Heart extends StaticEntity{

    private BufferedImage image;

    public Heart(Handler handler, float x, float y) {
        super(handler, x, y, 64, 64);

        image = Assets.heart;

        bounds.x=10;
        bounds.y=(int)(height/2f);
        bounds.width=width-10;
        bounds.width=(int)(height-height/3f);

        this.health=1;

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
            handler.getWorld().getEntityManager().getHero().addHealth(1);
        }
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

    @Override
    public boolean isEnemy()
    {
        return false;
    }


}
