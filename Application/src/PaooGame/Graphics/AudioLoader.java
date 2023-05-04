package PaooGame.Graphics;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/*! \class AudioLoader
    \brief Clasa ce contine o metoda statica pentru incarcarea unui sunet din memorie. ( de tip .wav )
 */

public class AudioLoader {

      /*! \fn  public static AudioInputStream loadAudio(String path)
        \brief Incarca un stream audio intr-un obiect AudioInputStream si returneaza o referinta catre acesta.
        \param path Calea relativa pentru localizarea sunetului.
     */
    public static AudioInputStream LoadAudio(String path) throws UnsupportedAudioFileException, IOException {
        /// se gestioneaza cu exceptii deoarece exista situatii in care fisierul sursa sa nu poate fi accesat

        File file = new File(path);
        AudioInputStream ais = null;
        try{
            ais = AudioSystem.getAudioInputStream(file);
            return ais;
        }catch  (UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*! \fn   public static void setVolume(Clip song, int volume)
        \brief Seteaza volumul pentru un obiect de tip clip.
*/
    public static void setVolume(Clip song, int volume) {
        FloatControl control = (FloatControl) song.getControl(FloatControl.Type.MASTER_GAIN);
        float range = control.getMinimum();
        float result = range * (1 - volume / 100.0f);
        control.setValue(result);
    }
}
