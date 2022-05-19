package PaooGame.States;

import PaooGame.Game;
import PaooGame.Graphics.Assets;
import PaooGame.Handler;
import PaooGame.UI.ClickListener;
import PaooGame.UI.UIManager;
import PaooGame.Utils.UIImageButton;

import java.awt.*;

public class MenuState extends State {

    private UIManager uiManager;

    public MenuState(Handler handler){

        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);

        uiManager.addObject(new UIImageButton(780, 590, 48, 48, Assets.btn_start, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(uiManager);
                State.setState(handler.getGame().introState);
            }
        }));

    }
    @Override
    public void update() {
        System.out.println(handler.getMouseManager().getMouseX() + " " +handler.getMouseManager().getMouseY());
        /*if(handler.getMouseManager().isLeftPressed() && handler.getMouseManager().isRightPressed())
            State.setState(handler.getGame().gameState);*/
        uiManager.update();

        //temporary to go directly to the game state

        /*handler.getMouseManager().setUiManager(null);
        State.setState(handler.getGame().gameState);*/
    }

    @Override
    public void draw(Graphics g) {

        g.drawImage(Assets.menu1,0,0,handler.getWidth(), handler.getHeight(), null);
        uiManager.draw(g);
        g.drawImage(Assets.sword,handler.getMouseManager().getMouseX(),handler.getMouseManager().getMouseY(),64,64,null);
    }
}
