package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

import java.awt.image.BufferedImage;

/*! \class Flower1Tile extends Tile
    \brief Abstractizeaza notiunea de dala de tip floare.
 */
public class Flower1Tile extends Tile{

    /*! \fn public Flower1Tile(int id)
        \brief Constructorul de initializare al clasei
         \param id Id-ul dalei util in desenarea hartii.
    */
    public Flower1Tile(int id) {
        /// Apel al constructorului clasei de baza
        super(Assets.flower1,id);
    }

    /*! \fn public boolean IsSolid()
       \brief Returneaza proprietatea de dala solida (supusa coliziunilor) sau nu.
   */
    @Override
    public boolean IsSolid() {
        return true;
    }
}
