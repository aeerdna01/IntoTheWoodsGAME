package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

import java.awt.image.BufferedImage;

/*! \class RockTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip piatra.
 */
public class RockTile extends Tile{

    /*! \fn public RockTile(int id)
     \brief Constructorul de initializare al clasei
      \param id Id-ul dalei util in desenarea hartii.
 */
    public RockTile(int id) {
        /// Apel al constructorului clasei de baza
        super(Assets.stone,id);
    }

    /*! \fn public boolean IsSolid()
       \brief Returneaza proprietatea de dala solida (supusa coliziunilor) sau nu.
   */
    @Override
    public boolean IsSolid() {
        return true;
    }

}
