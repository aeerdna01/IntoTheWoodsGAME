package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

import java.awt.image.BufferedImage;

public class Flower2Tile extends Tile{
    public Flower2Tile(int id) {
        super(Assets.flower2,id);
    }
    @Override
    public boolean IsSolid() {
        return true;
    }
}
