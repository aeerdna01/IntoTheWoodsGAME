package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

import java.awt.image.BufferedImage;

/*! \class Rock2Tile extends Tile
    \brief Abstractizeaza notiunea de dala de tip piatra.
 */
public class Rock2Tile extends Tile{

    /*! \fn public Rock2Tile(int id)
       \brief Constructorul de initializare al clasei
        \param id Id-ul dalei util in desenarea hartii.
   */
    public Rock2Tile(int id) {
        /// Apel al constructorului clasei de baza
        super(Assets.lvl2stone, id);
    }

    /*! \fn public boolean IsSolid()
       \brief Returneaza proprietatea de dala solida (supusa coliziunilor) sau nu.
   */
    @Override
    public boolean IsSolid() {
        return true;
    }
}
