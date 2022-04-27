package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

import java.awt.image.BufferedImage;

public class Bush1Tile extends Tile{
    public Bush1Tile(int id) {
        super(Assets.bush1,id);
    }
    @Override
    public boolean IsSolid() {
        return true;
    }

}
