package PaooGame.Exceptions;
/*! \class UnknownTileException
    \brief Clasa gestioneaza ideea de dala invalida. Daca in fisierul txt incarcat folosit pentru crearea
       hartii exista un numar care nu corespunde pentru nicio dala declarata in vectorul Tile este generata
       exceptia de "UnknownTile".
 */
public class UnknownTileException extends Exception{

    public UnknownTileException(){
        /// Apel al constructorului clasei de baza
        super("Exception! Unknown Tile!");
    }
}
