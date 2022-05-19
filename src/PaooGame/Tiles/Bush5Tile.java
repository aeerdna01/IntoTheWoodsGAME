package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class Bush5Tile extends Tile{
    public Bush5Tile(int id) {
        super(Assets.lvl2bush2,id);
    }
    @Override
    public boolean IsSolid() {
        return true;
    }
}
