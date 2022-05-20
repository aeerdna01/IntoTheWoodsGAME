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

    public static Tile edgeTile        = new EdgeTile(0);
    public static Tile waterTile       = new WaterTile(1);
    public static Tile grassTile       = new GrassTile(2);
    public static Tile woodTile        = new WoodTile(3);
    public static Tile bush1Tile       = new Bush1Tile(4);
    public static Tile bush2Tile       = new Bush2Tile(5);
    public static Tile bush3Tile       = new Bush3Tile(6);
    public static Tile rockTile        = new RockTile(7);
    public static Tile flower1Tile     = new Flower1Tile(8);
    public static Tile flower2Tile     = new Flower2Tile(9);
    public static Tile mushroom1Tile   = new Mushroom1Tile(10);
    public static Tile mushroom2Tile   = new Mushroom2Tile(11);
    public static Tile soilPTile       = new SoilPTile(12);
    public static Tile soilTTile       = new SoilTTile(13);
    public static Tile lvl2grass      = new Grass2Tile(14);
    public static Tile lvl2stone       = new Rock2Tile(15);
    public static Tile verticalBoard   = new VBoardTile(16);
    public static Tile horizontalBoard = new HBoardTile(17);
    public static Tile DverticalBoard  = new DVBoardTile(18);
    public static Tile DorizontalBoard = new DHBoardTile(19);
    public static Tile bush4Tile       = new Bush4Tile(20);
    public static Tile bush5Tile       = new Bush5Tile(21);
    public static Tile wood2Tile        = new Wood2Tile(22);
    public static Tile lvl3grass        = new Grass3Tile(23);
    public static Tile lava             = new LavaTile(24);
    public static Tile pavement         = new PavementTile(25);

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
