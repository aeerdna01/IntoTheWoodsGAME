package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

import java.awt.image.BufferedImage;
/*! \class DHBoardTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip scandura.
 */
public class DHBoardTile extends Tile{

    /*! \fn public DHBoardTile(int id)
        \brief Constructorul de initializare al clasei
         \param id Id-ul dalei util in desenarea hartii.
    */
    public DHBoardTile(int id) {
        /// Apel al constructorului clasei de baza
        super(Assets.damagedHorizontalBoard, id);
    }

    /*! \fn public boolean IsSolid()
        \brief Returneaza proprietatea de dala solida (supusa coliziunilor) sau nu.
    */
    @Override
    public boolean IsSolid() {
        return false;
    }
}
