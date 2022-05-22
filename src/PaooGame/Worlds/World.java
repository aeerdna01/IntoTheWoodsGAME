package PaooGame.Worlds;

import PaooGame.Entities.EntityManager;
import PaooGame.Entities.Movable.Achlys;
import PaooGame.Entities.Movable.Chimera;
import PaooGame.Entities.Movable.Gorgona;
import PaooGame.Entities.Movable.Hero;
import PaooGame.Entities.Statics.*;
import PaooGame.Handler;
import PaooGame.Items.ItemManager;
import PaooGame.States.State;
import PaooGame.Tiles.Tile;
import PaooGame.Utils.Utils;

import java.awt.*;

public class World {
    private Handler handler;
    private int width, height;
    private int spawnX, spawnY;
    private int[][] tiles;

    private int level;
    private int tempscore;
    private boolean playerdead=false;

    private boolean level1complete = false;
    private boolean level2complete = false;

    //entities
    private EntityManager entityManager;

    //items
    private ItemManager itemManager;

    public World(Handler handler){
        this.handler = handler;
        loadLevel1();
    }

    public void loadLevel1(){
        level = 1;
        entityManager = new EntityManager(handler, new Hero(handler, Tile.TILE_WIDTH * 15,Tile.TILE_HEIGHT * 15));

        itemManager = new ItemManager(handler);

        entityManager.AddEntity(new BlueDiamond(handler,Tile.TILE_WIDTH * 22, Tile.TILE_HEIGHT * 13));
        entityManager.AddEntity(new BlueDiamond(handler,Tile.TILE_WIDTH * 5, Tile.TILE_HEIGHT * 13));
        entityManager.AddEntity(new BlueDiamond(handler,Tile.TILE_WIDTH * 30, Tile.TILE_HEIGHT * 13));
        entityManager.AddEntity(new BlueDiamond(handler,Tile.TILE_WIDTH * 28, Tile.TILE_HEIGHT * 5));
        entityManager.AddEntity(new BlueDiamond(handler,Tile.TILE_WIDTH * 10, Tile.TILE_HEIGHT * 23));


        entityManager.AddEntity(new Chimera(handler,Tile.TILE_WIDTH * 24, Tile.TILE_HEIGHT * 13));
       // entityManager.AddEntity(new Chimera(handler,Tile.TILE_WIDTH * 28, Tile.TILE_HEIGHT * 17));
       // entityManager.AddEntity(new Chimera(handler,Tile.TILE_WIDTH * 29, Tile.TILE_HEIGHT * 5));


        entityManager.AddEntity(new Heart(handler,Tile.TILE_WIDTH * 24, Tile.TILE_HEIGHT * 17));
        entityManager.AddEntity(new Heart(handler,Tile.TILE_WIDTH * 10, Tile.TILE_HEIGHT * 25));
        entityManager.AddEntity(new Heart(handler,Tile.TILE_WIDTH * 29, Tile.TILE_HEIGHT * 2));
        entityManager.AddEntity(new Heart(handler,Tile.TILE_WIDTH * 7, Tile.TILE_HEIGHT * 13));
        entityManager.AddEntity(new Heart(handler,Tile.TILE_WIDTH * 2, Tile.TILE_HEIGHT * 2));

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

        loadWorld("res/worlds/world1.txt");

        entityManager.getHero().setX(spawnX);
        entityManager.getHero().setY(spawnY);
    }
    public void loadLevel2(){
        level = 2;
        entityManager = new EntityManager(handler, new Hero(handler, Tile.TILE_WIDTH * 15,Tile.TILE_HEIGHT * 15));

        itemManager = new ItemManager(handler);

        entityManager.AddEntity(new BlueDiamond(handler,Tile.TILE_WIDTH * 22, Tile.TILE_HEIGHT * 13));
        entityManager.AddEntity(new BlueDiamond(handler,Tile.TILE_WIDTH * 5, Tile.TILE_HEIGHT * 13));
        entityManager.AddEntity(new BlueDiamond(handler,Tile.TILE_WIDTH * 30, Tile.TILE_HEIGHT * 13));
        entityManager.AddEntity(new BlueDiamond(handler,Tile.TILE_WIDTH * 28, Tile.TILE_HEIGHT * 5));
        entityManager.AddEntity(new BlueDiamond(handler,Tile.TILE_WIDTH * 10, Tile.TILE_HEIGHT * 23));

        entityManager.AddEntity(new Gorgona(handler,Tile.TILE_WIDTH * 24, Tile.TILE_HEIGHT * 13));

        entityManager.AddEntity(new Tree5(handler,Tile.TILE_WIDTH * 16, Tile.TILE_HEIGHT * 12));
        entityManager.AddEntity(new Tree5(handler,Tile.TILE_WIDTH * 15, Tile.TILE_HEIGHT * 0));
        entityManager.AddEntity(new Tree5(handler,Tile.TILE_WIDTH * 26 , Tile.TILE_HEIGHT * 2));
        entityManager.AddEntity(new Tree5(handler,Tile.TILE_WIDTH * 6, Tile.TILE_HEIGHT * 21));
        entityManager.AddEntity(new Tree5(handler,Tile.TILE_WIDTH * 27, Tile.TILE_HEIGHT * 23));

        entityManager.AddEntity(new Tree6(handler,Tile.TILE_WIDTH * 9, Tile.TILE_HEIGHT * 2));
        entityManager.AddEntity(new Tree6(handler,Tile.TILE_WIDTH * 11, Tile.TILE_HEIGHT * 9));
        entityManager.AddEntity(new Tree6(handler,Tile.TILE_WIDTH * 19 , Tile.TILE_HEIGHT * 5));
        entityManager.AddEntity(new Tree6(handler,Tile.TILE_WIDTH * 24, Tile.TILE_HEIGHT * 10));
        entityManager.AddEntity(new Tree6(handler,Tile.TILE_WIDTH * 19, Tile.TILE_HEIGHT * 17));
        entityManager.AddEntity(new Tree6(handler,Tile.TILE_WIDTH * 10, Tile.TILE_HEIGHT * 26));

        entityManager.AddEntity(new Wall(handler,Tile.TILE_WIDTH * 1, Tile.TILE_HEIGHT * 16));
        entityManager.AddEntity(new Wall(handler,Tile.TILE_WIDTH * 7, Tile.TILE_HEIGHT * 16));
        entityManager.AddEntity(new Wall(handler,Tile.TILE_WIDTH * 10, Tile.TILE_HEIGHT * 16));
        entityManager.AddEntity(new Wall(handler,Tile.TILE_WIDTH * 1, Tile.TILE_HEIGHT * 5));
        entityManager.AddEntity(new Wall(handler,Tile.TILE_WIDTH * 3, Tile.TILE_HEIGHT * 5));
        entityManager.AddEntity(new Wall(handler,Tile.TILE_WIDTH * 31, Tile.TILE_HEIGHT * 12));


        loadWorld("res/worlds/world2.txt");

        entityManager.getHero().setX(spawnX);
        entityManager.getHero().setY(spawnY);
    }

    public void loadLevel3(){
        level = 3;
        entityManager = new EntityManager(handler, new Hero(handler, Tile.TILE_WIDTH * 20,Tile.TILE_HEIGHT * 20));

        itemManager = new ItemManager(handler);

        entityManager.AddEntity(new BlueDiamond(handler,Tile.TILE_WIDTH * 22, Tile.TILE_HEIGHT * 13));
        entityManager.AddEntity(new BlueDiamond(handler,Tile.TILE_WIDTH * 5, Tile.TILE_HEIGHT * 13));
        entityManager.AddEntity(new BlueDiamond(handler,Tile.TILE_WIDTH * 30, Tile.TILE_HEIGHT * 13));
        entityManager.AddEntity(new BlueDiamond(handler,Tile.TILE_WIDTH * 28, Tile.TILE_HEIGHT * 5));
        entityManager.AddEntity(new BlueDiamond(handler,Tile.TILE_WIDTH * 10, Tile.TILE_HEIGHT * 23));

        entityManager.AddEntity(new Achlys(handler,Tile.TILE_WIDTH * 17, Tile.TILE_HEIGHT * 20));

        entityManager.AddEntity(new Castle(handler,Tile.TILE_WIDTH * 19, Tile.TILE_HEIGHT * 8));


        loadWorld("res/worlds/world3.txt");

        entityManager.getHero().setX(spawnX);
        entityManager.getHero().setY(spawnY);
    }


    public void update(){
        itemManager.update();
        entityManager.update();

        if(level == 1){
            tempscore = entityManager.getHero().score;

            if(tempscore >= 1){
                level1complete = true;
                if(handler.getKeyManager().play) {
                    level1complete = false;
                    loadLevel2();
                }
            }
        }

        if(level == 2){
            tempscore = entityManager.getHero().score;
            if(tempscore >= 1){
                level2complete = true;
                if(handler.getKeyManager().play) {
                    level2complete = false;
                    loadLevel3();
                }
            }
        }

        if(entityManager.getHero().isDead()){
            playerdead = true;
            if (handler.getKeyManager().quit) {
                playerdead = false;
                loadLevel1();
                State.setState(handler.getGame().introState);
            }
            else if(handler.getKeyManager().restart) {
                playerdead = false;
                if (level == 1) {
                    loadLevel1();
                }
            }
        }
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

    public boolean isPlayerdead() {
        return playerdead;
    }

    public void setPlayerdead(boolean playerdead) {
        this.playerdead = playerdead;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isLevel1complete() {
        return level1complete;
    }

    public boolean isLevel2complete() {
        return level2complete;
    }


}
