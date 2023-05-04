package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

import java.awt.image.BufferedImage;

/*! \class WoodTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip lemn.
 */
public class WoodTile extends Tile{

    /*! \fn public WoodTile(int id)
     \brief Constructorul de initializare al clasei
      \param id Id-ul dalei util in desenarea hartii.
 */
    public WoodTile(int id) {
        /// Apel al constructorului clasei de baza
        super(Assets.wood,id);
    }

    /*! \fn public boolean IsSolid()
       \brief Returneaza proprietatea de dala solida (supusa coliziunilor) sau nu.
   */
    @Override
    public boolean IsSolid() {
        return true;
    }
}
