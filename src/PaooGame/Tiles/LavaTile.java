package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class LavaTile extends Tile{
    public LavaTile( int id) {
        super(Assets.lava, id);
    }
    @Override
    public boolean IsSolid() {
        return true;
    }
}
