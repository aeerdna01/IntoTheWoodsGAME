package PaooGame.Tiles;

import PaooGame.Graphics.Assets;


/*! \class Grass3Tile extends Tile
    \brief Abstractizeaza notiunea de dala de tip iarba.
 */
public class Grass3Tile extends Tile{

    /*! \fn public Grass3Tile(int id)
        \brief Constructorul de initializare al clasei
         \param id Id-ul dalei util in desenarea hartii.
    */
    public Grass3Tile( int id) {
        /// Apel al constructorului clasei de baza
        super(Assets.lvl3grass, id);
    }

    /*! \fn public boolean IsSolid()
       \brief Returneaza proprietatea de dala solida (supusa coliziunilor) sau nu.
   */
    @Override
    public boolean IsSolid() {
        return false;
    }
}
