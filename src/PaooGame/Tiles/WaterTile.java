package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

import java.awt.image.BufferedImage;

/*! \class WaterTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip apa.
 */
public class WaterTile extends Tile{

    /*! \fn public WaterTile(int id)
     \brief Constructorul de initializare al clasei
      \param id Id-ul dalei util in desenarea hartii.
 */
    public WaterTile(int id) {
        /// Apel al constructorului clasei de baza
        super(Assets.water,id);
    }

    /*! \fn public boolean IsSolid()
       \brief Returneaza proprietatea de dala solida (supusa coliziunilor) sau nu.
   */
    @Override
    public boolean IsSolid() {
        return true;
    }
}
