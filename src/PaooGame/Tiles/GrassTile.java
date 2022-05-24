package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

import java.awt.image.BufferedImage;

/*! \class GrassTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip iarba.
 */
public class GrassTile extends Tile {

    /*! \fn public GrassTile(int id)
        \brief Constructorul de initializare al clasei
         \param id Id-ul dalei util in desenarea hartii.
    */
    public GrassTile(int id) {
        /// Apel al constructorului clasei de baza
        super(Assets.grass,id);
    }

    /*! \fn public boolean IsSolid()
       \brief Returneaza proprietatea de dala solida (supusa coliziunilor) sau nu.
   */
    @Override
    public boolean IsSolid() {
        return false;
    }
}
