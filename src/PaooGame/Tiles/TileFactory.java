package PaooGame.Tiles;

public class TileFactory {

    public Tile createTile(int id){
        switch(id){
            case 0: return new EdgeTile(id);
            case 1: return new WaterTile(id);
            case 2: return new GrassTile(id);
            case 3: return new WoodTile(id);
            case 4: return new Bush1Tile(id);
            case 5: return new Bush2Tile(id);
            case 6: return new Bush3Tile(id);
            case 7: return new RockTile(id);
            case 8: return new Flower1Tile(id);
            case 9: return new Flower2Tile(id);
            case 10: return new Mushroom1Tile(id);
            case 11: return new Mushroom2Tile(id);
            case 12:  return new SoilPTile(id);
            case 13: return new SoilTTile(id);
            case 14: return new Grass2Tile(id);
            case 15: return new Rock2Tile(id);
            case 16: return new VBoardTile(id);
            case 17: return new HBoardTile(id);
            case 18: return new DVBoardTile(id);
            case 19: return new DHBoardTile(id);
            case 20: return new Bush4Tile(id);
            case 21: return new Bush5Tile(id);
            case 22: return new Wood2Tile(id);
            case 23: return new Grass3Tile(id);
            case 24: return new LavaTile(id);
            case 25: return new PavementTile(id);

            default: return null;
        }
    }
}
