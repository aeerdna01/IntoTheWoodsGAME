package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

import java.awt.image.BufferedImage;

public class EdgeTile extends Tile{
    public EdgeTile(int id) {
        super(Assets.edge,id);
    }
    @Override
    public boolean IsSolid() {
        return true;
    }
}
