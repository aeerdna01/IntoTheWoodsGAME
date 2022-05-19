package PaooGame.States;

import PaooGame.Graphics.Assets;
import PaooGame.Handler;
import PaooGame.UI.UIManager;

import java.awt.*;

public class IntroState extends State{

    private UIManager uiManager;

    public IntroState(Handler handler) {
        super(handler);

    }

    @Override
    public void update() {
        System.out.println(handler.getMouseManager().getMouseX() + " " +handler.getMouseManager().getMouseY());

        if(handler.getMouseManager().getMouseX() >= 154 && handler.getMouseManager().getMouseX() <= 345){
            if(handler.getMouseManager().getMouseY() >= 55 && handler.getMouseManager().getMouseY() <= 120) {
                if(handler.getMouseManager().isLeftPressed())
                {
                    State.setState(handler.getGame().gameState);

                }
            }
        }

        if(handler.getMouseManager().getMouseX() >= 153 && handler.getMouseManager().getMouseX() <= 337){
            if(handler.getMouseManager().getMouseY() >= 235 && handler.getMouseManager().getMouseY() <= 290) {
                if(handler.getMouseManager().isLeftPressed())
                {
                    State.setState(handler.getGame().helpState);

                }
            }
        }

    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(Assets.intro,0,0,handler.getWidth(),handler.getHeight(),null);
        g.drawImage(Assets.sword,handler.getMouseManager().getMouseX(),handler.getMouseManager().getMouseY(),64,64,null);
    }
}
