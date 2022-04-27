package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

import java.awt.image.BufferedImage;

public class Bush2Tile extends Tile{
    public Bush2Tile(int id) {
        super(Assets.bush2,id);
    }
    @Override
    public boolean IsSolid() {
        return true;
    }

}
