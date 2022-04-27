package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

import java.awt.image.BufferedImage;

public class SoilPTile extends Tile{
    public SoilPTile(int id) {
        super(Assets.soilP,id);
    }
    @Override
    public boolean IsSolid() {
        return false;
    }
}
