package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

import java.awt.image.BufferedImage;

public class Flower1Tile extends Tile{
    public Flower1Tile(int id) {
        super(Assets.flower1,id);
    }
    @Override
    public boolean IsSolid() {
        return true;
    }
}
