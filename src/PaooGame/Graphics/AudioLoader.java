package PaooGame.Graphics;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AudioLoader {


    public static AudioInputStream LoadAudio(String path) throws UnsupportedAudioFileException, IOException {

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

    public static void setVolume(Clip song, int volume) {
        FloatControl control = (FloatControl) song.getControl(FloatControl.Type.MASTER_GAIN);
        float range = control.getMinimum();
        float result = range * (1 - volume / 100.0f);
        control.setValue(result);
    }
}
