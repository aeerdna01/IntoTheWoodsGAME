package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

/*! \class DVBoardTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip scandura.
 */
public class DVBoardTile extends Tile{

    /*! \fn public DVBoardTile(int id)
        \brief Constructorul de initializare al clasei
         \param id Id-ul dalei util in desenarea hartii.
    */
    public DVBoardTile(int id) {
        /// Apel al constructorului clasei de baza
        super(Assets.damagedVerticalBoard, id);
    }

    /*! \fn public boolean IsSolid()
       \brief Returneaza proprietatea de dala solida (supusa coliziunilor) sau nu.
   */
    @Override
    public boolean IsSolid() {
        return false;
    }
}
