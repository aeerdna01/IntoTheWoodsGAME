package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

import java.awt.image.BufferedImage;

public class Wood2Tile extends Tile{
    public Wood2Tile(int id) {
        super(Assets.lvl2woods, id);
    }

    @Override
    public boolean IsSolid() {
        return true;
    }
}
