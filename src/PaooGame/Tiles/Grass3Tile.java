package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class Grass3Tile extends Tile{
    public Grass3Tile( int id) {
        super(Assets.lvl3grass, id);
    }
    @Override
    public boolean IsSolid() {
        return false;
    }
}
