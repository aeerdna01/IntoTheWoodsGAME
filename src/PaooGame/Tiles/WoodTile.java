package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

import java.awt.image.BufferedImage;

public class WoodTile extends Tile{
    public WoodTile(int id) {
        super(Assets.wood,id);
    }
    @Override
    public boolean IsSolid() {
        return true;
    }
}
