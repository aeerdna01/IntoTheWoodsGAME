package PaooGame.Exceptions;
/*! \class EmptyWorldFileException
    \brief Clasa gestioneaza ideea de harta invalida. Daca fisierul txt incarcat este gol este generata
    exceptia de "EmptyWorldFileException".
 */
public class EmptyWorldFileException extends Exception{
    public EmptyWorldFileException(){
        /// Apel al constructorului clasei de baza
        super("Exception! Empty world file!");
    }
}
