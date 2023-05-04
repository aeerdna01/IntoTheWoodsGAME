package PaooGame.Entities;

import PaooGame.Entities.Movable.Chimera;
import PaooGame.Entities.Movable.Hero;
import PaooGame.Handler;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

/*! \class EntityManager
    \brief. Clasa care gestioneaza toate entitatile din joc print-un vector.
 */
public class EntityManager {

    private Handler handler;  /*!< O referinte catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.*/
    private Hero hero; /*!< O referinte catre eroul jocului.*/
    private ArrayList<Entity> entities;  /*!< Referinta catre un vector ce retine toate entitatile din joc.*/

    ///Se foloseste renderSorter pentru randarea enititatilor in ordinea dorita
    private Comparator<Entity> renderSorter = new Comparator<Entity>() { ///compara entitatile
        @Override
        public int compare(Entity a, Entity b) {
            if(a.getY() + a.getHeight() < b.getY() + b.getHeight()) ///compara coordonatele entitatile pe axa Y in partea jos astfel se aduna Height
                return -1; ///a trebuie randat inaintea lui b, a are coordonata Y mai mica decat b
            return 1;  ///a trebuie randat dupa b
        }
    };

    public EntityManager(Handler handler, Hero hero){
        this.handler=handler;

        this.hero=hero;

        entities = new ArrayList<Entity>();

        AddEntity(hero);
    }

    ///Metoda prin care se actualizeaza vectorul de entitati
    public void update(){
        Iterator<Entity> it = entities.iterator();

        while(it.hasNext()){
            Entity e = it.next();
            e.update();
            if(!e.isActive()) ///se verifica flag-ul active
                it.remove(); ///daca este fals, se sterge entitatea din vector/joc
        }
        entities.sort(renderSorter); ///se sorteaza entitatile din joc
    }

    ///Metoda prin care se apeleaza draw(g) si sunt desenate entitatile
    public void draw(Graphics g){
        for(Entity e:entities){
            e.draw(g);
        }

    }

    ///Metoda prin care se adauga o noua entitate in joc
    public void AddEntity(Entity e){
        entities.add(e);
    }

    ///Getters and setters

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
