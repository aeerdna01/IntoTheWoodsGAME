package PaooGame.States;

import PaooGame.Graphics.Assets;
import PaooGame.Handler;
import PaooGame.UI.ClickListener;
import PaooGame.UI.UIManager;
import PaooGame.Utils.UIImageButton;

import java.awt.*;

public class HelpState extends State{

    private UIManager uiManager;

    public HelpState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);

        uiManager.addObject(new UIImageButton(752, 40, 48, 48, Assets.btn_back, new ClickListener() {
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
        uiManager.update();
    }

    @Override
    public void draw(Graphics g) {


        g.drawImage(Assets.help,0,0,handler.getWidth(), handler.getHeight(), null);
        uiManager.draw(g);
        g.drawImage(Assets.sword,handler.getMouseManager().getMouseX(),handler.getMouseManager().getMouseY(),64,64,null);

    }
}
