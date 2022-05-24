package PaooGame.Graphics;

import javax.sound.sampled.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/*! \class public class Assets
    \brief Clasa incarca fiecare element grafic necesar jocului.

    Game assets include tot ce este folosit intr-un joc: imagini, sunete, harti etc.
 */
public class Assets {

    /// Referinte catre elementele grafice (dale) utilizate in joc.

    ///Referinte folosite pentru a gestiona timpul dintre atacurile eroului.
    static boolean passed = false;
    static long now;
    static long then;

    /// Referinte catre miscarile caracterelor

    ///Erou
    public static BufferedImage[] hero_attack_down;
    public static BufferedImage[] hero_attack_up;
    public static BufferedImage[] hero_attack_left;
    public static BufferedImage[] hero_attack_right;

    public static BufferedImage[] hero_walk_down;
    public static BufferedImage[] hero_walk_up;
    public static BufferedImage[] hero_walk_left;
    public static BufferedImage[] hero_walk_right;

    ///Enemy 1 - Chimera
    public static BufferedImage[] chimera_walk_down;
    public static BufferedImage[] chimera_walk_up;
    public static BufferedImage[] chimera_walk_left;
    public static BufferedImage[] chimera_walk_right;

    ///Enemy 2 - Gorgona
    public static BufferedImage[] gorgona_walk_down;
    public static BufferedImage[] gorgona_walk_up;
    public static BufferedImage[] gorgona_walk_left;
    public static BufferedImage[] gorgona_walk_right;

    ///Enemy 3 - Achlys
    public static BufferedImage[] achlys_walk_down;
    public static BufferedImage[] achlys_walk_up;
    public static BufferedImage[] achlys_walk_left;
    public static BufferedImage[] achlys_walk_right;


    ///Referinte  imaginile butoanelor implementate
    public static BufferedImage[] btn_start;
    public static BufferedImage[] btn_back;


    ///Referinte catre obiectele din level 1
    public static BufferedImage tree1;
    public static BufferedImage tree2;
    public static BufferedImage tree3;
    public static BufferedImage tree4;

    ///Referinte catre dalele din level 1
    public static BufferedImage stone;
    public static BufferedImage water;
    public static BufferedImage grass;
    public static BufferedImage bush1;
    public static BufferedImage bush2;
    public static BufferedImage bush3;
    public static BufferedImage wood;
    public static BufferedImage flower1;
    public static BufferedImage flower2;
    public static BufferedImage edge;
    public static BufferedImage soilP;
    public static BufferedImage soilT;
    public static BufferedImage mushroom1;
    public static BufferedImage mushroom2;

    ///Referinte catre obiectele din level 2
    public static BufferedImage tree5;
    public static BufferedImage tree6;
    public static BufferedImage wall;

    ///Referinte catre dalele din level 2
    public static BufferedImage lvl2grass;
    public static BufferedImage lvl2stone;
    public static BufferedImage verticalBoard;
    public static BufferedImage damagedVerticalBoard;
    public static BufferedImage horizontalBoard;
    public static BufferedImage damagedHorizontalBoard;
    public static BufferedImage lvl2bush1;
    public static BufferedImage lvl2bush2;
    public static BufferedImage lvl2woods;


    ///Referinte catre obiectele din level 3
    public static BufferedImage castle;
    public static BufferedImage fire;
    public static BufferedImage tree7;

    ///Referinte catre dalele din level 3
    public static BufferedImage pavement;
    public static BufferedImage lvl3grass;
    public static BufferedImage lava;

    ///Referinta catre obiectul de tip diamand
    public static BufferedImage blueDiamond;

    ///Referinta catre obiectul de tip inima
    public static BufferedImage heart;

    ///Referinta catre imaginea folosita pentru mouse
    public static BufferedImage sword;

    ///Referinte catre background-ul din fecare state din joc
    public static BufferedImage menu1;
    public static BufferedImage intro;
    public static BufferedImage help;
    public static BufferedImage pause;
    public static BufferedImage settings;
    public static BufferedImage win;
    public static BufferedImage gameover;
    public static BufferedImage level2unlocked;
    public static BufferedImage level3unlocked;

    ///Referinte catre obiectele de tip audio din joc
    public static AudioInputStream menuSound;
    public static AudioInputStream level1Sound;
    public static AudioInputStream level2Sound;
    public static AudioInputStream level3Sound;

    ///Referinte catre obiecte de tip clip in care putem incarca un element audio
    public static Clip menuMusic;
    public static Clip level1Music;
    public static Clip level2Music;
    public static Clip level3Music;


    /*! \fn public static void Init()
        \brief Functia initializaza referintele catre elementele grafice utilizate.

        Aceasta functie poate fi rescrisa astfel incat elementele grafice incarcate/utilizate
        sa fie parametrizate. Din acest motiv referintele nu sunt finale.
     */
    public static void Init() throws UnsupportedAudioFileException, IOException {
        /// Se creaza temporar un obiect SpriteSheet initializat prin intermediul clasei ImageLoader
        ///Sprite hero
        SpriteSheet hero = new SpriteSheet(ImageLoader.LoadImage("/textures/sprites/cavaler_walk.png"), 64, 64);
        SpriteSheet hero_attack = new SpriteSheet(ImageLoader.LoadImage("/textures/sprites/cavaler_attack.png"), 192, 180);
        ///Sprite enemy 1
        SpriteSheet enemy_lvl1 = new SpriteSheet(ImageLoader.LoadImage("/textures/sprites/chimera_walk.png"), 64, 64);
        ///Sprite enemy 2
        SpriteSheet enemy_lvl2 = new SpriteSheet(ImageLoader.LoadImage("/textures/sprites/gorgona_walk.png"),64,64);
        ///Sprite enemy 3
        SpriteSheet enemy_lvl3 = new SpriteSheet(ImageLoader.LoadImage("/textures/sprites/achlys_walk.png"),64,64);
        ///Sprite level 1
        SpriteSheet level1 = new SpriteSheet(ImageLoader.LoadImage("/textures/sprites/level1.png"), 32, 32);
        ///Sprite level 2
        SpriteSheet level2 = new SpriteSheet(ImageLoader.LoadImage("/textures/sprites/level2.png"), 32, 32);
        ///Sprite level 3
        SpriteSheet level3 = new SpriteSheet(ImageLoader.LoadImage("/textures/sprites/level3.png"),32,32);

        ///initializare obiecte tip audio
        menuSound = AudioLoader.LoadAudio("C:/Users/Andreea/Desktop/PAOO/New folder/IntoTheWoodsGAME/IntoTheWoodsGAME/res/textures/music/menu2.wav");
        level1Sound = AudioLoader.LoadAudio("C:\\Users\\Andreea\\Desktop\\PAOO\\New folder\\IntoTheWoodsGAME\\IntoTheWoodsGAME\\res\\textures\\music\\level1.wav");
        level2Sound = AudioLoader.LoadAudio("C:\\Users\\Andreea\\Desktop\\PAOO\\New folder\\IntoTheWoodsGAME\\IntoTheWoodsGAME\\res\\textures\\music\\level2.wav");
        level3Sound = AudioLoader.LoadAudio("C:\\Users\\Andreea\\Desktop\\PAOO\\New folder\\IntoTheWoodsGAME\\IntoTheWoodsGAME\\res\\textures\\music\\level3.wav");

        ///initializare obiecte tip clip
        try{
            menuMusic = AudioSystem.getClip();
            menuMusic.open(menuSound);
            level1Music = AudioSystem.getClip();
            level1Music.open(level1Sound);
            level2Music = AudioSystem.getClip();
            level2Music.open(level2Sound);
            level3Music = AudioSystem.getClip();
            level3Music.open(level3Sound);
        }catch (LineUnavailableException | IOException e) {
            System.err.println("Eroare la incarcarea sunetelor in Assets.");
        }

        /// Se obtin subimaginile corespunzatoare elementelor necesare.

        ///Buton "play game"
        btn_start = new BufferedImage[2];
        btn_start[0] = ImageLoader.LoadImage("/textures/buttons/buttonPlayN.png");
        btn_start[1] = ImageLoader.LoadImage("/textures/buttons/buttonPlayP.png");

        ///Buton "back in menu"
        btn_back = new BufferedImage[2];
        btn_back[0] = ImageLoader.LoadImage("/textures/buttons/backN.png");
        btn_back[1] = ImageLoader.LoadImage("/textures/buttons/backP.png");

        ///Hero walk animation
        hero_walk_down = new BufferedImage[9]; //9 frame-uri pentru animatia de mutare in jos
        hero_walk_up = new BufferedImage[9]; //9 frame-uri pentru animatia de mutare in sus
        hero_walk_right = new BufferedImage[9];//9 frame-uri pentru animatia de mutare in dreapta
        hero_walk_left = new BufferedImage[9]; //9 frame-uri pentru animatia de mutare in stanga
        for (int i = 0; i < 9; i++)
            hero_walk_left[i] = hero.crop(i, 1);
        for (int i = 0; i < 9; i++)
            hero_walk_right[i] = hero.crop(i, 3);
        for (int i = 0; i < 9; i++)
            hero_walk_up[i] = hero.crop(i, 0);
        for (int i = 0; i < 9; i++)
            hero_walk_down[i] = hero.crop(i, 2);

        ///Enemy 1 walk animation
        chimera_walk_down = new BufferedImage[7];
        chimera_walk_up = new BufferedImage[7];
        chimera_walk_right = new BufferedImage[7];
        chimera_walk_left = new BufferedImage[7];
        for (int i = 0; i < 7; i++)
            chimera_walk_left[i] = enemy_lvl1.crop(i, 1);
        for (int i = 0; i < 7; i++)
            chimera_walk_right[i] = enemy_lvl1.crop(i, 3);
        for (int i = 0; i < 7; i++)
            chimera_walk_up[i] = enemy_lvl1.crop(i, 0);
        for (int i = 0; i < 7; i++)
            chimera_walk_down[i] = enemy_lvl1.crop(i, 2);

        ///Enemy 2 walk animation
        gorgona_walk_down = new BufferedImage[9];
        gorgona_walk_up = new BufferedImage[9];
        gorgona_walk_right = new BufferedImage[9];
        gorgona_walk_left = new BufferedImage[9];
        for (int i = 0; i < 9; i++)
            gorgona_walk_left[i] = enemy_lvl2.crop(i, 1);
        for (int i = 0; i < 9; i++)
            gorgona_walk_right[i] = enemy_lvl2.crop(i, 3);
        for (int i = 0; i < 9; i++)
            gorgona_walk_up[i] = enemy_lvl2.crop(i, 0);
        for (int i = 0; i < 9; i++)
            gorgona_walk_down[i] = enemy_lvl2.crop(i, 2);

        ///Enemy 3 walk animation
        achlys_walk_down = new BufferedImage[9];
        achlys_walk_up = new BufferedImage[9];
        achlys_walk_right = new BufferedImage[9];
        achlys_walk_left = new BufferedImage[9];
        for (int i = 0; i < 9; i++)
            achlys_walk_left[i] = enemy_lvl3.crop(i, 1);
        for (int i = 0; i < 9; i++)
            achlys_walk_right[i] = enemy_lvl3.crop(i, 3);
        for (int i = 0; i < 9; i++)
            achlys_walk_up[i] = enemy_lvl3.crop(i, 0);
        for (int i = 0; i < 9; i++)
            achlys_walk_down[i] = enemy_lvl3.crop(i, 2);

        ///Hero attack animation
        hero_attack_left = new BufferedImage[6];
        hero_attack_right = new BufferedImage[6];
        hero_attack_up = new BufferedImage[6];
        hero_attack_down = new BufferedImage[6];
        for (int i = 0; i < 6; i++)
            hero_attack_left[i] = hero_attack.crop(i, 1);
        for (int i = 0; i < 6; i++)
            hero_attack_right[i] = hero_attack.crop(i, 3);
        for (int i = 0; i < 6; i++)
            hero_attack_up[i] = hero_attack.crop(i, 0);
        for (int i = 0; i < 6; i++)
            hero_attack_down[i] = hero_attack.crop(i, 2);

        ///dale level 1
        edge = level1.crop(0, 0);
        grass = level1.crop(2, 3);
        water = level1.crop(1, 0);
        wood = level1.crop(0, 1);
        bush1 = level1.crop(0, 2);
        bush2 = level1.crop(0, 3);
        bush3 = level1.crop(1, 2);
        stone = level1.crop(1, 3);
        flower1 = level1.crop(0, 4);
        flower2 = level1.crop(1, 4);
        mushroom1 = level1.crop(0, 5);
        mushroom2 = level1.crop(1, 5);
        soilP = level1.crop(1, 1);
        soilT = level1.crop(2, 0);

        ///dale level 2
        lvl2grass = level2.crop(1,0);
        lvl2stone = level2.crop(0,0);
        verticalBoard = level2.crop(0,1);
        damagedVerticalBoard = level2.crop(1,1);
        horizontalBoard = level2.crop(0,2);
        damagedHorizontalBoard = level2.crop(1,2);
        lvl2bush1 = level2.crop(0,3);
        lvl2bush2 = level2.crop(0,4);
        lvl2woods = level2.crop(0,5);

        ///dale level 3
        lvl3grass = level3.crop(0,0);
        lava = level3.crop(0,1);
        pavement = level3.crop(0,2);


        ///obiecte level 1
        tree1 = ImageLoader.LoadImage("/textures/objects/tree1.png");
        tree2 = ImageLoader.LoadImage("/textures/objects/tree2.png");
        tree3 = ImageLoader.LoadImage("/textures/objects/tree3.png");
        tree4 = ImageLoader.LoadImage("/textures/objects/tree4.png");

        ///obiecte level 2
        tree5 = ImageLoader.LoadImage("/textures/objects/tree5.png");
        tree6 = ImageLoader.LoadImage("/textures/objects/tree6.png");
        wall = ImageLoader.LoadImage("/textures/objects/wall.png");

        ///obiecte level 3
        castle = ImageLoader.LoadImage("/textures/objects/castle.png");
        fire = ImageLoader.LoadImage("/textures/objects/fire.png");
        tree7 = ImageLoader.LoadImage("/textures/objects/tree7.png");


        ///obiect diamant
        blueDiamond = ImageLoader.LoadImage("/textures/objects/blueDiamond.png");
        ///obiect inima
        heart = ImageLoader.LoadImage("/textures/objects/heart.png");

        ///imagine pentru mouse
        sword = ImageLoader.LoadImage("/textures/objects/sword.png");

        ///backgrounds game
        menu1 = ImageLoader.LoadImage("/textures/menu/menu1.png");
        intro = ImageLoader.LoadImage("/textures/menu/menu2.png");
        help = ImageLoader.LoadImage("/textures/menu/help.png");
        gameover = ImageLoader.LoadImage("/textures/menu/gameover.png");
        level2unlocked = ImageLoader.LoadImage("/textures/menu/level2unlocked.png");
        level3unlocked = ImageLoader.LoadImage("/textures/menu/level3unlocked.png");
        pause = ImageLoader.LoadImage("/textures/menu/pause.png");
        settings = ImageLoader.LoadImage("/textures/menu/settings.png");
        win = ImageLoader.LoadImage("/textures/menu/win.png");

    }

    ///functie pentru a pune un timer intre atacurile player-ului
    public static boolean attackTimeElapsed() {
        if (!passed) {
            then = System.nanoTime();
            passed = true;
        }
        now = System.nanoTime();
        if (now - then > 1000000000 / 0.7) {
            passed = false;
            return true;
        }
        return false;
    }
}
