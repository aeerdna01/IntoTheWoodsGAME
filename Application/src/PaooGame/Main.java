package PaooGame;

import PaooGame.GameWindow.GameWindow;
/*! \class Main
    \brief Where the game starts.
 */
public class Main
{
    public static void main(String[] args)
    {
        //new GameWindow("title",1335,931);
        //new Game("tile game!",400,400);
        Game paooGame = new Game("IntoTheWoods", 850,650);
        paooGame.StartGame();
    }
}
