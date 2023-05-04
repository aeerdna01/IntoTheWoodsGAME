package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

import java.awt.image.BufferedImage;

/*! \class HBoardTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip scandura.
 */
public class HBoardTile extends Tile{

    /*! \fn public HBoardTile(int id)
        \brief Constructorul de initializare al clasei
         \param id Id-ul dalei util in desenarea hartii.
    */
    public HBoardTile(int id) {
        /// Apel al constructorului clasei de baza
        super(Assets.horizontalBoard, id);
    }

    /*! \fn public boolean IsSolid()
           \brief Returneaza proprietatea de dala solida (supusa coliziunilor) sau nu.
       */
    @Override
    public boolean IsSolid() {
        return false;
    }
}
