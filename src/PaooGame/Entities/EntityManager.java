package PaooGame.Entities;

import PaooGame.Entities.Movable.Hero;
import PaooGame.Handler;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class EntityManager {

    private Handler handler;
    private Hero hero;
    private ArrayList<Entity> entities;//doesn t have a size

    private Comparator<Entity> renderSorter = new Comparator<Entity>() {
        @Override
        public int compare(Entity a, Entity b) {
            if(a.getY() + a.getHeight() < b.getY() + b.getHeight())
                return -1;
            return 1;
        }
    };

    public EntityManager(Handler handler, Hero hero){
        this.handler=handler;

        this.hero=hero;

        entities = new ArrayList<Entity>();

        AddEntity(hero);
    }

    public void update(){
        Iterator<Entity> it = entities.iterator();

        while(it.hasNext()){
            Entity e = it.next();
            e.update();
            if(!e.isActive())
                it.remove();
        }
        entities.sort(renderSorter);
    }

    public void draw(Graphics g){
        for(Entity e:entities){
            e.draw(g);
        }

        hero.postRender(g);
    }


    public void AddEntity(Entity e){
        entities.add(e);
    }

    //getters and setter

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }
}
