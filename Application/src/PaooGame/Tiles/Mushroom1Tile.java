package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

import java.awt.image.BufferedImage;

/*! \class Mushroom1Tile extends Tile
    \brief Abstractizeaza notiunea de dala de tip ciuperca.
 */
public class Mushroom1Tile extends Tile{

    /*! \fn public Mushroom1Tile(int id)
        \brief Constructorul de initializare al clasei
         \param id Id-ul dalei util in desenarea hartii.
    */
    public Mushroom1Tile(int id) {
        /// Apel al constructorului clasei de baza
        super(Assets.mushroom1,id);
    }

    /*! \fn public boolean IsSolid()
       \brief Returneaza proprietatea de dala solida (supusa coliziunilor) sau nu.
   */
    @Override
    public boolean IsSolid() {
        return true;
    }
}
