package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

import java.awt.image.BufferedImage;

public class SoilTTile extends Tile{
    public SoilTTile(int id) {
        super(Assets.soilT,id);
    }
    @Override
    public boolean IsSolid() {
        return false;
    }
}
