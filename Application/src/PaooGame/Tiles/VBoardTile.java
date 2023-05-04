package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

import java.awt.image.BufferedImage;

/*! \class VBoardTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip scandura.
 */
public class VBoardTile extends Tile{

    /*! \fn public VBoardTile(int id)
     \brief Constructorul de initializare al clasei
      \param id Id-ul dalei util in desenarea hartii.
 */
    public VBoardTile(int id) {
        /// Apel al constructorului clasei de baza
        super(Assets.verticalBoard, id);
    }

    /*! \fn public boolean IsSolid()
       \brief Returneaza proprietatea de dala solida (supusa coliziunilor) sau nu.
   */
    @Override
    public boolean IsSolid() {
        return false;
    }

}
