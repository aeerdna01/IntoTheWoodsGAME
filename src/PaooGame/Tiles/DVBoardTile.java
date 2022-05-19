package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class DVBoardTile extends Tile{
    public DVBoardTile(int id) {
        super(Assets.damagedVerticalBoard, id);
    }
    @Override
    public boolean IsSolid() {
        return false;
    }
}
