package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

import java.awt.image.BufferedImage;

public class Mushroom2Tile extends Tile{

    public Mushroom2Tile(int id) {
        super(Assets.mushroom2,id);
    }
    @Override
    public boolean IsSolid() {
        return true;
    }
}
