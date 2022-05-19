package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class Bush4Tile extends Tile{
    public Bush4Tile(int id) {
        super(Assets.lvl2bush1,id);
    }
    @Override
    public boolean IsSolid() {
        return true;
    }
}
