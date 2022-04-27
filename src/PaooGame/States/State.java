package PaooGame.States;

import PaooGame.Game;
import PaooGame.Handler;

import java.awt.*;

public abstract class State {

    //State manager
    private static State currentState=null;

    public static void setState(State state){
        currentState=state;
    }

    public static State getState(){
        return currentState;
    }


    //CLASS

    protected Handler handler;

    public State(Handler handler)
    {
        this.handler=handler;
    }

    public abstract void update();
    public abstract void draw(Graphics g);

}
