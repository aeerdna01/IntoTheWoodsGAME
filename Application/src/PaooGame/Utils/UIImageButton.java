package PaooGame.Utils;

import PaooGame.UI.ClickListener;
import PaooGame.UI.UIObject;

import java.awt.*;
import java.awt.image.BufferedImage;

/*! \class UIImageButton
    \brief Gestioneaza partea de interfata a jocului, extinde notiunea de obiect grafic > butoane.

 */
public class UIImageButton extends UIObject {

    private BufferedImage[] images;
    private ClickListener clicker;

    public UIImageButton(float x, float y, int width, int height, BufferedImage[] images, ClickListener clicker) {
        super(x, y, width, height);
        this.images = images;
        this.clicker = clicker;
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics g) {
        if(hovering)
            g.drawImage(images[1], (int) x, (int) y, width, height, null);
        else
            g.drawImage(images[0], (int) x, (int) y, width, height, null);
    }

    @Override
    public void onClick() {
        clicker.onClick();
    }
}
