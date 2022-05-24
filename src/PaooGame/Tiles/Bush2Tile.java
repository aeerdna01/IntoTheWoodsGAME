package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

import java.awt.image.BufferedImage;
/*! \class Bush2Tile extends Tile
    \brief Abstractizeaza notiunea de dala de tip tufis.
 */
public class Bush2Tile extends Tile{

    /*! \fn public Bush2Tile(int id)
 \brief Constructorul de initializare al clasei
 \param id Id-ul dalei util in desenarea hartii.
*/
    public Bush2Tile(int id) {
        /// Apel al constructorului clasei de baza
        super(Assets.bush2,id);
    }

    /*! \fn public boolean IsSolid()
       \brief Returneaza proprietatea de dala solida (supusa coliziunilor) sau nu.
   */
    @Override
    public boolean IsSolid() {
        return true;
    }

}
