package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

import java.awt.image.BufferedImage;

public class Rock2Tile extends Tile{
    public Rock2Tile(int id) {
        super(Assets.lvl2stone, id);
    }
    @Override
    public boolean IsSolid() {
        return true;
    }
}
