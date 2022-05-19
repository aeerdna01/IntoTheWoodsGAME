package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

import java.awt.image.BufferedImage;

public class DHBoardTile extends Tile{

    public DHBoardTile(int id) {
        super(Assets.damagedHorizontalBoard, id);
    }
    @Override
    public boolean IsSolid() {
        return false;
    }
}
