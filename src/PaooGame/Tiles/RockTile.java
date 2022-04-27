package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

import java.awt.image.BufferedImage;

public class RockTile extends Tile{

    public RockTile(int id) {
        super(Assets.stone,id);
    }
    @Override
    public boolean IsSolid() {
        return true;
    }

}
