package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

/*! \class PavementTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip pavaj.
 */
public class PavementTile extends Tile{

    /*! \fn public PavementTile(int id)
       \brief Constructorul de initializare al clasei
        \param id Id-ul dalei util in desenarea hartii.
   */
    public PavementTile( int id) {
        /// Apel al constructorului clasei de baza
        super(Assets.pavement, id);
    }

    /*! \fn public boolean IsSolid()
       \brief Returneaza proprietatea de dala solida (supusa coliziunilor) sau nu.
   */
    @Override
    public boolean IsSolid() {
        return false;
    }
}
