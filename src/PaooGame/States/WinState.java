package PaooGame.States;

import PaooGame.Graphics.Assets;
import PaooGame.Handler;
import PaooGame.UI.ClickListener;
import PaooGame.UI.UIManager;
import PaooGame.Utils.UIImageButton;

import java.awt.*;
import java.sql.SQLException;

public class WinState extends State{

    private UIManager uiManager;

    public WinState(Handler handler) {
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
         Assets.level3Music.stop();
        uiManager.update();
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(Assets.win,0,0,handler.getWidth(), handler.getHeight(), null);
        g.setColor(Color.black);
        g.setFont(new Font("Serif", Font.PLAIN, 48));
        try {
            g.drawString("Score: ", 503, 285);
            g.drawString(Integer.toString(handler.getDataBase().getScore()), 640, 286);

        } catch (SQLException e) {
            System.err.println(e);
        }
        uiManager.draw(g);
        g.drawImage(Assets.sword,handler.getMouseManager().getMouseX(),handler.getMouseManager().getMouseY(),64,64,null);

    }
}
