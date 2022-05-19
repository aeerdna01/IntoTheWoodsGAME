package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

import java.awt.image.BufferedImage;

public class HBoardTile extends Tile{
    public HBoardTile(int id) {
        super(Assets.horizontalBoard, id);
    }
    @Override
    public boolean IsSolid() {
        return false;
    }
}
