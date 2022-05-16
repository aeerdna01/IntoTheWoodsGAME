package PaooGame.Graphics;

import java.awt.image.BufferedImage;

/*! \class public class Assets
    \brief Clasa incarca fiecare element grafic necesar jocului.

    Game assets include tot ce este folosit intr-un joc: imagini, sunete, harti etc.
 */
public class Assets {
    /// Referinte catre elementele grafice (dale) utilizate in joc.

    static boolean passed=false;
    static long now;
    static long then;
    static boolean monster_passed = false;
    static long monster_then, monster_now;

    public static BufferedImage[] hero_walk_down;
    public static BufferedImage[] hero_walk_up;
    public static BufferedImage[] hero_walk_left;
    public static BufferedImage[] hero_walk_right;

    public static BufferedImage[] hero_attack_down;
    public static BufferedImage[] hero_attack_up;
    public static BufferedImage[] hero_attack_left;
    public static BufferedImage[] hero_attack_right;

    public static BufferedImage[] chimera_walk_down;
    public static BufferedImage[] chimera_walk_up;
    public static BufferedImage[] chimera_walk_left;
    public static BufferedImage[] chimera_walk_right;

    public static BufferedImage[] hero_die;

    public static BufferedImage monster1;


    public static BufferedImage[] btn_start;
    public static BufferedImage[] btn_play;
    public static BufferedImage[] btn_back;


    public static BufferedImage tree1;
    public static BufferedImage tree2;
    public static BufferedImage tree3;
    public static BufferedImage tree4;


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

    public static BufferedImage diamond;
    public static BufferedImage diamondRed;

    public static BufferedImage menu1;
    public static BufferedImage intro;
    public static BufferedImage help;

    /*! \fn public static void Init()
        \brief Functia initializaza referintele catre elementele grafice utilizate.

        Aceasta functie poate fi rescrisa astfel incat elementele grafice incarcate/utilizate
        sa fie parametrizate. Din acest motiv referintele nu sunt finale.
     */
    public static void Init() {
        /// Se creaza temporar un obiect SpriteSheet initializat prin intermediul clasei ImageLoader
        SpriteSheet hero = new SpriteSheet(ImageLoader.LoadImage("/textures/characters_sprite/cavaler_walk.png"),64,64);
        SpriteSheet hero_attack = new SpriteSheet(ImageLoader.LoadImage("/textures/characters_sprite/cavaler_attack.png"),192,180);
        SpriteSheet hero_dead = new SpriteSheet( ImageLoader.LoadImage("/textures/characters_sprite/cavaler_dead.png"),64,64);
        SpriteSheet enemy_lvl1_walk = new SpriteSheet(ImageLoader.LoadImage("/textures/characters_sprite/chimera_walk.png"),64,64);
        SpriteSheet level1 = new SpriteSheet(ImageLoader.LoadImage("/textures/objects/level1.png"), 32,32);
        /// Se obtin subimaginile corespunzatoare elementelor necesare.

        btn_start = new BufferedImage[2];
        btn_start[0] = ImageLoader.LoadImage("/textures/buttons/buttonPlayN.png");
        btn_start[1] = ImageLoader.LoadImage("/textures/buttons/buttonPlayP.png");

        btn_play = new BufferedImage[2];
        btn_play[0] = ImageLoader.LoadImage("/textures/buttons/PlayN.png");
        btn_play[1] = ImageLoader.LoadImage("/textures/buttons/PlayP.png");

        btn_back = new BufferedImage[2];
        btn_back[0] = ImageLoader.LoadImage("/textures/buttons/backN.png");
        btn_back[1] = ImageLoader.LoadImage("/textures/buttons/backP.png");


        monster1 = enemy_lvl1_walk.crop(0,1);
        hero_die = new BufferedImage[6];
        for(int i=0;i<6;i++)
            hero_die[i] = hero_dead.crop(i, 0);


        chimera_walk_down =new BufferedImage[7];
        chimera_walk_up =new BufferedImage[7];
        chimera_walk_right =new BufferedImage[7];
        chimera_walk_left =new BufferedImage[7];

        for(int i=0;i<7;i++)
            chimera_walk_left[i] = enemy_lvl1_walk.crop(i, 1);
        for(int i=0;i<7;i++)
            chimera_walk_right[i] = enemy_lvl1_walk.crop(i, 3);
        for(int i=0;i<7;i++)
            chimera_walk_up[i] = enemy_lvl1_walk.crop(i,0);
        for(int i=0;i<7;i++)
            chimera_walk_down[i] = enemy_lvl1_walk.crop(i,2);


        hero_walk_down =new BufferedImage[9];
        hero_walk_up =new BufferedImage[9];
        hero_walk_right =new BufferedImage[9];
        hero_walk_left =new BufferedImage[9];
        for(int i=0;i<9;i++)
            hero_walk_left[i] = hero.crop(i, 1);
        for(int i=0;i<9;i++)
            hero_walk_right[i] = hero.crop(i, 3);
        for(int i=0;i<9;i++)
            hero_walk_up[i] = hero.crop(i,0);
        for(int i=0;i<9;i++)
            hero_walk_down[i] = hero.crop(i,2);


        hero_attack_left  = new BufferedImage[6];
        hero_attack_right = new BufferedImage[6];
        hero_attack_up    = new BufferedImage[6];
        hero_attack_down  = new BufferedImage[6];
        for(int i=0;i<6;i++)
            hero_attack_left[i] = hero_attack.crop(i , 1);
        for(int i=0;i<6;i++)
            hero_attack_right[i] = hero_attack.crop(i, 3);
        for(int i=0;i<6;i++)
            hero_attack_up[i] = hero_attack.crop(i,0);
        for(int i=0;i<6;i++)
            hero_attack_down[i] = hero_attack.crop(i,2);

        edge = level1.crop(0,0);
        grass = level1.crop(2,3);
        water=level1.crop(1,0);
        wood = level1.crop(0,1);
        bush1 = level1.crop(0,2);
        bush2 = level1.crop(0,3);
        bush3 = level1.crop(1,2);
        stone = level1.crop(1,3);
        flower1 = level1.crop(0,4);
        flower2 = level1.crop(1,4);
        mushroom1 = level1.crop(0,5);
        mushroom2 = level1.crop(1,5);
        soilP = level1.crop(1,1);
        soilT = level1.crop(2,0);


        tree1 = ImageLoader.LoadImage("/textures/objects/tree1.png");
        tree2 = ImageLoader.LoadImage("/textures/objects/tree2.png");
        tree3 = ImageLoader.LoadImage("/textures/objects/tree3.png");
        tree4 = ImageLoader.LoadImage("/textures/objects/tree4.png");

        diamond = ImageLoader.LoadImage("/textures/objects/diamond.png");
        diamondRed = ImageLoader.LoadImage("/textures/objects/diamondRed.png");

        menu1 = ImageLoader.LoadImage("/textures/menu/menu1.png");
        intro = ImageLoader.LoadImage("/textures/menu/menu2.png");
        help = ImageLoader.LoadImage("/textures/menu/help.png");

    }

    public static boolean attackTimeElapsed()
    {
        if(!passed)
        {
            then = System.nanoTime();
            passed = true;
        }
        now = System.nanoTime();
        if(now-then>1000000000/0.16)
        {
            passed = false;
            return true;
        }
        return false;
    }

    public static boolean monsterAttackTimeElapsed()
    {
        if(!monster_passed)
        {
            monster_then = System.nanoTime();
            monster_passed = true;
        }
        monster_now = System.nanoTime();
        if(monster_now-monster_then>1000000000/1.66)
        {
            monster_passed = false;
            return true;
        }
        return false;
    }


    //Folosesc aceasta functie pentru a pune un delay la atacul player-ului pentru ca damage-ul sa fie dat dupa acest delay, nu inainte
    public static boolean secondElapsed()
    {
        if(!passed)
        {
            then= System.nanoTime();
            passed=true;
        }
        now=System.nanoTime();
        if(now-then>=1000000000)
        {
            passed=false;
            return true;
        }
        return false;
    }
}
