package PaooGame.Items;

import PaooGame.Graphics.Assets;
import PaooGame.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Item {


    //HANDLER
    public  static Item[] items = new Item[256];
    public static Item diamondItem = new Item(Assets.diamond,"Diamond", 0);
    public static Item diamondRedItem = new Item(Assets.diamondRed,"DiamondRed", 1);

    //CLASS
    public static final int ITEMWIDTH = 64, ITEMHEIGHT = 64, PICKED_UP = -1;

    protected Handler handler;
    protected BufferedImage texture;
    protected String name;
    protected final int id;

    protected int x, y, count; //count for player inventory

    public Item(BufferedImage texture, String name, int id){
        this.texture = texture;
        this.name = name;
        this.id = id;
        count = 1;

        items[id] = this;
    }

    public void update(){

    }

    public void draw(Graphics g){
        if(handler == null)
            return;
        draw(g,(int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()));
    }

    public void draw(Graphics g, int x, int y){
        g.drawImage(texture,x,y, ITEMWIDTH,ITEMHEIGHT,null);
    }

    public Item createNew(int x, int y){
        Item i= new Item(texture, name, id);
        i.setPosition(x, y);
        return i;
    }

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    //getters and setter
    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public BufferedImage getTexture() {
        return texture;
    }

    public void setTexture(BufferedImage texture) {
        this.texture = texture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
