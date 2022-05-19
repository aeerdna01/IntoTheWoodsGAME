package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

import java.awt.image.BufferedImage;

public class Grass2Tile extends Tile{
    public Grass2Tile( int id) {
        super(Assets.lvl2grass, id);
    }
    @Override
    public boolean IsSolid() {
        return false;
    }
}
