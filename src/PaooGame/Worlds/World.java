package PaooGame.Worlds;

import PaooGame.Entities.EntityManager;
import PaooGame.Entities.Movable.Chimera;
import PaooGame.Entities.Movable.Hero;
import PaooGame.Entities.Statics.*;
import PaooGame.Handler;
import PaooGame.Items.ItemManager;
import PaooGame.Tiles.Tile;
import PaooGame.Utils.Utils;

import java.awt.*;

public class World {
    private Handler handler;
    private int width, height;
    private int spawnX, spawnY;
    private int[][] tiles;

    //entities
    private EntityManager entityManager;

    //items
    private ItemManager itemManager;

    public World(Handler handler, String path){
        this.handler = handler;
        entityManager = new EntityManager(handler, new Hero(handler, Tile.TILE_WIDTH * 15,Tile.TILE_HEIGHT * 15));
        itemManager = new ItemManager(handler);

       // entityManager.AddEntity(new Monster(handler,Tile.TILE_WIDTH * 20, Tile.TILE_HEIGHT * 13));
        entityManager.AddEntity(new Chimera(handler,Tile.TILE_WIDTH * 20, Tile.TILE_HEIGHT * 13,64,64,1.5f + 0.2f, 15 ));

        entityManager.AddEntity(new Tree1(handler,Tile.TILE_WIDTH * 11, Tile.TILE_HEIGHT * 15));
        entityManager.AddEntity(new Tree1(handler,Tile.TILE_WIDTH * 21, Tile.TILE_HEIGHT * 20));
        entityManager.AddEntity(new Tree1(handler,Tile.TILE_WIDTH * 26, Tile.TILE_HEIGHT * 14));
        entityManager.AddEntity(new Tree1(handler,Tile.TILE_WIDTH * 28, Tile.TILE_HEIGHT * 9));
        entityManager.AddEntity(new Tree1(handler,Tile.TILE_WIDTH * 31, Tile.TILE_HEIGHT * 2));
        entityManager.AddEntity(new Tree1(handler,Tile.TILE_WIDTH * 34, Tile.TILE_HEIGHT * 16));
        entityManager.AddEntity(new Tree1(handler,Tile.TILE_WIDTH * 35, Tile.TILE_HEIGHT * 21));

        entityManager.AddEntity(new Tree2(handler,Tile.TILE_WIDTH * 21, Tile.TILE_HEIGHT * 0));
        entityManager.AddEntity(new Tree2(handler,Tile.TILE_WIDTH * 21, Tile.TILE_HEIGHT * 10));
        entityManager.AddEntity(new Tree2(handler,Tile.TILE_WIDTH * 33, Tile.TILE_HEIGHT * 9));
        entityManager.AddEntity(new Tree2(handler,Tile.TILE_WIDTH * 25, Tile.TILE_HEIGHT * 23));
        entityManager.AddEntity(new Tree2(handler,Tile.TILE_WIDTH * 34, Tile.TILE_HEIGHT * 26));
        entityManager.AddEntity(new Tree2(handler,Tile.TILE_WIDTH * 5, Tile.TILE_HEIGHT * 20));

        entityManager.AddEntity(new Tree3(handler,Tile.TILE_WIDTH * 13, Tile.TILE_HEIGHT * 0));
        entityManager.AddEntity(new Tree3(handler,Tile.TILE_WIDTH * 15, Tile.TILE_HEIGHT * 9));
        entityManager.AddEntity(new Tree3(handler,Tile.TILE_WIDTH * 0, Tile.TILE_HEIGHT * 5));
        entityManager.AddEntity(new Tree3(handler,Tile.TILE_WIDTH * 18, Tile.TILE_HEIGHT * 25));
        entityManager.AddEntity(new Tree3(handler,Tile.TILE_WIDTH * 29, Tile.TILE_HEIGHT * 17));

        entityManager.AddEntity(new Tree4(handler,Tile.TILE_WIDTH * 26, Tile.TILE_HEIGHT * 4));
        entityManager.AddEntity(new Tree4(handler,Tile.TILE_WIDTH * 32, Tile.TILE_HEIGHT * -2));
        entityManager.AddEntity(new Tree4(handler,Tile.TILE_WIDTH * 35, Tile.TILE_HEIGHT * 5));
        entityManager.AddEntity(new Tree4(handler,Tile.TILE_WIDTH * 31, Tile.TILE_HEIGHT * 20));
        entityManager.AddEntity(new Tree4(handler,Tile.TILE_WIDTH * 23, Tile.TILE_HEIGHT * 25));

        loadWorld(path);

        entityManager.getHero().setX(spawnX);
        entityManager.getHero().setY(spawnY);
    }

    public void update(){
        itemManager.update();
        entityManager.update();
    }
    public void draw(Graphics g){
        int xStart=(int)Math.max(0, handler.getGameCamera().getxOffset()/Tile.TILE_WIDTH);
        int xEnd=(int)Math.min(width,(handler.getGameCamera().getxOffset()+ handler.getWidth())/Tile.TILE_WIDTH + 1);
        int yStart=(int)Math.max(0, handler.getGameCamera().getyOffset()/Tile.TILE_HEIGHT);
        int yEnd=(int)Math.min(height,(handler.getGameCamera().getyOffset()+ handler.getHeight())/Tile.TILE_HEIGHT + 1);
        for (int y = yStart; y < yEnd; y++){
            for(int x=xStart; x<xEnd; x++){
                getTile(x,y).draw(g,(int)(x*Tile.TILE_WIDTH- handler.getGameCamera().getxOffset()),(int)(y*Tile.TILE_HEIGHT- handler.getGameCamera().getyOffset()));

            }
        }
        //items
        itemManager.draw(g);
        //entities
        entityManager.draw(g);
    }
    public Tile getTile(int x, int y){

        if(x<0||y<0 || x>= width || y>=height)
            return  Tile.grassTile;
        Tile t = Tile.tiles[tiles[x][y]];
        if(t == null)
            return Tile.edgeTile;
        return t;
    }
    private void loadWorld(String path){

        //temporar code
        /*
        width=5;
        height=5;
        tiles = new int[width][height];

        for(int x=0; x<width; x++) {
            for (int y = 0; y < height; y++) {
                tiles[x][y]=1;
            }
        }
         */
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        width=Utils.parseInt(tokens[0]);
        height=Utils.parseInt(tokens[1]);
        spawnX=Utils.parseInt(tokens[2]);
        spawnY=Utils.parseInt(tokens[3]);

        tiles = new int[width][height];
        for (int y = 0; y < height; y++){
            for(int x=0; x<width; x++){
                tiles[x][y] = Utils.parseInt(tokens[(x+y*width)+4]);
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public ItemManager getItemManager() {
        return itemManager;
    }

    public void setItemManager(ItemManager itemManager) {
        this.itemManager = itemManager;
    }
}
