package PaooGame.Worlds;

import PaooGame.Entities.EntityManager;
import PaooGame.Entities.Movable.Achlys;
import PaooGame.Entities.Movable.Chimera;
import PaooGame.Entities.Movable.Gorgona;
import PaooGame.Entities.Movable.Hero;
import PaooGame.Entities.Statics.*;
import PaooGame.Exceptions.EmptyWorldFileException;
import PaooGame.Exceptions.UnknownTileException;
import PaooGame.Graphics.Assets;
import PaooGame.Handler;
import PaooGame.States.State;
import PaooGame.Tiles.Tile;
import PaooGame.Utils.Utils;

import java.awt.*;


/*! \class public class World
    \brief Implementeaza notiunea de harta a jocului.
 */

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
    private boolean level3complete = false;

    private EntityManager entityManager;

    public World(Handler handler, int level){
        this.handler = handler;
        if(level == 1)
        {
            Hero.setLevel(1);
            loadLevel1();
        }
        if(level == 2)
        {
            Hero.setLevel(2);
            loadLevel2();
        }
        if(level == 3)
        {
            Hero.setLevel(3);
            loadLevel3();
        }
    }

    public void loadLevel1(){
        level = 1;
        Hero.setLevel(level);
        entityManager = new EntityManager(handler, new Hero(handler, Tile.TILE_WIDTH * 15,Tile.TILE_HEIGHT * 15));


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

        //loadWorld("res/worlds/empty_world.txt");
        loadWorld("res/worlds/world1.txt");

        entityManager.getHero().setX(spawnX);
        entityManager.getHero().setY(spawnY);
    }
    public void loadLevel2(){
        level = 2;
        Hero.setLevel(level);
        entityManager = new EntityManager(handler, new Hero(handler, Tile.TILE_WIDTH * 15,Tile.TILE_HEIGHT * 15));

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
        Hero.setLevel(level);
        entityManager = new EntityManager(handler, new Hero(handler, Tile.TILE_WIDTH * 20,Tile.TILE_HEIGHT * 20));


        entityManager.AddEntity(new Achlys(handler,Tile.TILE_WIDTH * 17, Tile.TILE_HEIGHT * 20));

        entityManager.AddEntity(new Castle(handler,Tile.TILE_WIDTH * 19, Tile.TILE_HEIGHT * 8));

        entityManager.AddEntity(new Wall(handler,Tile.TILE_WIDTH * 1, Tile.TILE_HEIGHT * 15));
        entityManager.AddEntity(new Wall(handler,Tile.TILE_WIDTH * 7, Tile.TILE_HEIGHT * 15));
        entityManager.AddEntity(new Wall(handler,Tile.TILE_WIDTH * 10, Tile.TILE_HEIGHT * 15));
        entityManager.AddEntity(new Wall(handler,Tile.TILE_WIDTH * 1, Tile.TILE_HEIGHT * 5));
        entityManager.AddEntity(new Wall(handler,Tile.TILE_WIDTH * 4, Tile.TILE_HEIGHT * 5));


        entityManager.AddEntity(new Tree7(handler,Tile.TILE_WIDTH * 9, Tile.TILE_HEIGHT * 2));
        entityManager.AddEntity(new Tree7(handler,Tile.TILE_WIDTH * 11, Tile.TILE_HEIGHT * 8));
        entityManager.AddEntity(new Tree7(handler,Tile.TILE_WIDTH * 19 , Tile.TILE_HEIGHT * 5));
        entityManager.AddEntity(new Tree7(handler,Tile.TILE_WIDTH * 24, Tile.TILE_HEIGHT * 10));
        entityManager.AddEntity(new Tree7(handler,Tile.TILE_WIDTH * 19, Tile.TILE_HEIGHT * 17));
        entityManager.AddEntity(new Tree7(handler,Tile.TILE_WIDTH * 10, Tile.TILE_HEIGHT * 20));

        entityManager.AddEntity(new Fire(handler,Tile.TILE_WIDTH * 22, Tile.TILE_HEIGHT * 13));
        entityManager.AddEntity(new Fire(handler,Tile.TILE_WIDTH * 5, Tile.TILE_HEIGHT * 13));
        entityManager.AddEntity(new Fire(handler,Tile.TILE_WIDTH * 30, Tile.TILE_HEIGHT * 13));
        entityManager.AddEntity(new Fire(handler,Tile.TILE_WIDTH * 28, Tile.TILE_HEIGHT * 5));
        entityManager.AddEntity(new Fire(handler,Tile.TILE_WIDTH * 10, Tile.TILE_HEIGHT * 23));

        loadWorld("res/worlds/world3.txt");

        entityManager.getHero().setX(spawnX);
        entityManager.getHero().setY(spawnY);
    }


    public void update(){
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

        if(level == 3){
            tempscore = entityManager.getHero().score;
            if(tempscore >= 1){
                level3complete = true;
                Assets.level3Music.stop();
                State.setState(handler.getGame().winState);
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
                if (level == 2) {
                    loadLevel1();
                }
                if (level == 3) {
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

        entityManager.draw(g);
    }
    public Tile getTile(int x, int y) {
        Tile t = null;
        try {
            if (x < 0 || y < 0 || x >= width || y >= height)
                //return Tile.grassTile;
                throw new UnknownTileException();
            t = Tile.tiles[tiles[x][y]];
            if (t == null)
                //return Tile.edgeTile;
                throw new UnknownTileException();
        } catch (UnknownTileException e) {
            System.out.println(e.getMessage());
        }
        return t;
    }

    private void loadWorld(String path) {
        try {
            String file = Utils.loadFileAsString(path);
            if(file.length() != 0)
            {
            String[] tokens = file.split("\\s+");
            width = Utils.parseInt(tokens[0]);
            height = Utils.parseInt(tokens[1]);
            spawnX = Utils.parseInt(tokens[2]);
            spawnY = Utils.parseInt(tokens[3]);

            tiles = new int[width][height];
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
                }
            }
            }
            else
            {
                throw new EmptyWorldFileException();
            }
        } catch (EmptyWorldFileException e) {
            System.out.println(e.getMessage());
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

    public boolean isLevel3complete() {
        return level3complete;
    }


}
