package PaooGame.Tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

/*! \class public class Tile
    \brief Retine toate dalele intr-un vector si ofera posibilitatea regasirii dupa un id.
 */
public class Tile
{
    private static final int NO_TILES   = 32;
    public static Tile[] tiles          = new Tile[NO_TILES];       /*!< Vector de referinte de tipuri de dale.*/

    /// De remarcat ca urmatoarele dale sunt statice si publice. Acest lucru imi permite sa le am incarcate
    /// o singura data in memorie

    private final static TileFactory factory = new TileFactory();

    public static Tile edgeTile        = factory.createTile(0);
    public static Tile waterTile       = factory.createTile(1);
    public static Tile grassTile       = factory.createTile(2);
    public static Tile woodTile        = factory.createTile(3);
    public static Tile bush1Tile       = factory.createTile(4);
    public static Tile bush2Tile       = factory.createTile(5);
    public static Tile bush3Tile       = factory.createTile(6);
    public static Tile rockTile        = factory.createTile(7);
    public static Tile flower1Tile     = factory.createTile(8);
    public static Tile flower2Tile     = factory.createTile(9);
    public static Tile mushroom1Tile   = factory.createTile(10);
    public static Tile mushroom2Tile   = factory.createTile(11);
    public static Tile soilPTile       = factory.createTile(12);
    public static Tile soilTTile       = factory.createTile(13);
    public static Tile lvl2grass      = factory.createTile(14);
    public static Tile lvl2stone       =factory.createTile(15);
    public static Tile verticalBoard   =factory.createTile(16);
    public static Tile horizontalBoard =factory.createTile(17);
    public static Tile DverticalBoard  = factory.createTile(18);
    public static Tile DorizontalBoard = factory.createTile(19);
    public static Tile bush4Tile       = factory.createTile(20);
    public static Tile bush5Tile       = factory.createTile(21);
    public static Tile wood2Tile        = factory.createTile(22);
    public static Tile lvl3grass        = factory.createTile(23);
    public static Tile lava             = factory.createTile(24);
    public static Tile pavement         =factory.createTile(25);

    public static final int TILE_WIDTH  = 32;                       /*!< Latimea unei dale.*/
    public static final int TILE_HEIGHT = 32;                       /*!< Inaltimea unei dale.*/

    protected BufferedImage img;                                    /*!< Imaginea aferenta tipului de dala.*/
    protected final int id;                                         /*!< Id-ul unic aferent tipului de dala.*/

    /*! \fn public Tile(BufferedImage texture, int id)
        \brief Constructorul aferent clasei.

        \param image Imaginea corespunzatoare dalei.
        \param id Id-ul dalei.
     */
    public Tile(BufferedImage image, int idd)
    {
        img = image;
        id = idd;

        tiles[id] = this;
    }

    /*! \fn public void Update()
        \brief Actualizeaza proprietatile dalei.
     */
    public void update()
    {

    }

    /*! \fn public void Draw(Graphics g, int x, int y)
        \brief Deseneaza in fereastra dala.

        \param g Contextul grafic in care sa se realizeze desenarea
        \param x Coordonata x in cadrul ferestrei unde sa fie desenata dala
        \param y Coordonata y in cadrul ferestrei unde sa fie desenata dala
     */
    public void draw(Graphics g, int x, int y)
    {
        // Desenare dala
        g.drawImage(img, x, y, TILE_WIDTH, TILE_HEIGHT, null);
    }

    /*! \fn public boolean IsSolid()
        \brief Returneaza proprietatea de dala solida (supusa coliziunilor) sau nu.
     */
    public boolean IsSolid()
    {
        return false;
    }

    /*! \fn public int GetId()
        \brief Returneaza id-ul dalei.
     */

    public int GetId()
    {
        return id;
    }
}
