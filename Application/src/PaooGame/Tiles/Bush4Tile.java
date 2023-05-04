package PaooGame.Tiles;

import PaooGame.Graphics.Assets;
/*! \class Bush4Tile extends Tile
    \brief Abstractizeaza notiunea de dala de tip tufis.
 */
public class Bush4Tile extends Tile{

    /*! \fn public Bush4Tile(int id)
 \brief Constructorul de initializare al clasei
 \param id Id-ul dalei util in desenarea hartii.
*/
    public Bush4Tile(int id) {
        /// Apel al constructorului clasei de baza
        super(Assets.lvl2bush1,id);
    }

    /*! \fn public boolean IsSolid()
       \brief Returneaza proprietatea de dala solida (supusa coliziunilor) sau nu.
   */
    @Override
    public boolean IsSolid() {
        return true;
    }
}
