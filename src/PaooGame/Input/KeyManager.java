package PaooGame.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

    private boolean[] keys;
    public boolean up, down, left, right;
    public boolean attack;
    public boolean restart;
    public boolean quit;
    public boolean escape;
    public boolean play;

    private boolean[] justPressed, cantPress;

    public void update(){
        for(int i = 0; i< keys.length;i++)
        {
            if(cantPress[i] && !keys[i]){
                cantPress[i] = false;
            }else if(justPressed[i]){
                cantPress[i] = true;
                justPressed[i] = false;
            }
            if(!cantPress[i] && keys[i]){
                justPressed[i] = true;
            }
        }

        up = keys[KeyEvent.VK_W];
        down = keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_D];
        attack = keys[KeyEvent.VK_SPACE];

        quit = keys[KeyEvent.VK_Q];
        restart = keys[KeyEvent.VK_R];
        escape = keys[KeyEvent.VK_ESCAPE];
        play = keys[KeyEvent.VK_ENTER];

    }

    public KeyManager(){
        keys = new boolean[256];
        justPressed = new boolean[keys.length];
        cantPress = new boolean[keys.length];

    }

    public boolean keyJustPressed(int keyCode){
        if(keyCode < 0 || keyCode >= keys.length)
            return false;
        return justPressed[keyCode];
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
            return;
        keys[e.getKeyCode()]=true;
        //System.out.println("Pressed!");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
            return;
        keys[e.getKeyCode()]=false;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

}
