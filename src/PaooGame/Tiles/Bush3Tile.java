package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

import java.awt.image.BufferedImage;

public class Bush3Tile extends Tile{
    public Bush3Tile(int id) {
        super(Assets.bush3,id);
    }
    @Override
    public boolean IsSolid() {
        return true;
    }

}
