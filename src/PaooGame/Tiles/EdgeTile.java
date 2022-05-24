package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

import java.awt.image.BufferedImage;

/*! \class EdgeTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip piatra.
 */

public class EdgeTile extends Tile{

    /*! \fn public EdgeTile(int id)
        \brief Constructorul de initializare al clasei
         \param id Id-ul dalei util in desenarea hartii.
    */
    public EdgeTile(int id) {
        /// Apel al constructorului clasei de baza
        super(Assets.edge,id);
    }

    /*! \fn public boolean IsSolid()
        \brief Returneaza proprietatea de dala solida (supusa coliziunilor) sau nu.
    */
    @Override
    public boolean IsSolid() {
        return true;
    }
}
