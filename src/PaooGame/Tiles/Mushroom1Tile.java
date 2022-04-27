package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

import java.awt.image.BufferedImage;

public class Mushroom1Tile extends Tile{

    public Mushroom1Tile(int id) {
        super(Assets.mushroom1,id);
    }
    @Override
    public boolean IsSolid() {
        return true;
    }
}
