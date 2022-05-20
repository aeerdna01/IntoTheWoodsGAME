package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class PavementTile extends Tile{
    public PavementTile( int id) {
        super(Assets.pavement, id);
    }
    @Override
    public boolean IsSolid() {
        return false;
    }
}
