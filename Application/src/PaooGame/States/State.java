package PaooGame.States;

import PaooGame.Game;
import PaooGame.Handler;

import java.awt.*;
/*! \class State
    \brief Implementeaza notiunea abstracta de stare a jocului/programului.
    Un joc odata ce este lansat in executie nu trebuie "sa arunce jucatorul direct in lupta", este nevoie de
    un meniu care sa contine optiuni: New Game, Load Game, Settings, About etc. Toate aceste optiuni nu sunt altceva
    decat stari ale programului (jocului) ce trebuiesc incarcate si afisate functie de starea curenta.
 */

public abstract class State {

    ///Urmatoarele atribute sunt statice pentru a evita dealocarea spatiului de memorie la trecerea dintr-o stare in alta.
    private static State previousState = null;  /*!< Referinta catre starea anterioara a jocului.*/
    private static State currentState=null;  /*!< Referinta catre starea curenta a jocului: game, meniu, settings, about etc.*/
    protected Handler handler;

    /*! \fn public State(Handler handler)
       \brief Constructorul aferent clasei.
       \param handler pentru scurtatura de referinte.
    */
    public State(Handler handler)
    {
        this.handler=handler;
    }


    /*! \fn public static void setState(State state)
        \brief Seteaza starea curenta a jocului.
        \param state Noua stare a programului (jocului).
     */
    public static void setState(State state){
        previousState = currentState;
        currentState=state;
    }

    /*! \fn public static State getState()
        \brief Returneaza starea curenta a jocului.
    */
    public static State getState(){
        return currentState;
    }

    /*! \fn public static void GetPreviousState()
        \brief Seteaza starea anterioara a jocului.
   */
    public static State GetPreviousState(){
        return previousState;
    }

    ///Metoda abstracta destinata actualizarii starii curente
    public abstract void update();

    ///Metoda abstracta destinata desenarii starii curente
    public abstract void draw(Graphics g);

}
