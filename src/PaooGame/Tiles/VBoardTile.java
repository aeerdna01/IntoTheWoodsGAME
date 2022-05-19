package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

import java.awt.image.BufferedImage;

public class VBoardTile extends Tile{
    public VBoardTile(int id) {
        super(Assets.verticalBoard, id);
    }
    @Override
    public boolean IsSolid() {
        return false;
    }

}
