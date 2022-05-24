package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

import java.awt.image.BufferedImage;


/*! \class soilTTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip pavaj.
 */
public class SoilTTile extends Tile{

    /*! \fn public SoilTTile(int id)
     \brief Constructorul de initializare al clasei
      \param id Id-ul dalei util in desenarea hartii.
 */
    public SoilTTile(int id) {
        /// Apel al constructorului clasei de baza
        super(Assets.soilT,id);
    }

    /*! \fn public boolean IsSolid()
       \brief Returneaza proprietatea de dala solida (supusa coliziunilor) sau nu.
   */
    @Override
    public boolean IsSolid() {
        return false;
    }
}
