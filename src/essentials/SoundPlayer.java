package essentials;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

public class SoundPlayer {
    private Clip clip;

    public SoundPlayer(String soundFilePath) {
        try {
            // Load the sound file
            File soundFile = new File(soundFilePath);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);

            // Get a Clip to play the sound
            clip = AudioSystem.getClip();

            // Open the audio clip with the provided audio input stream
            clip.open(audioInputStream);
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
    }

    public void play() {
        if (clip != null) {
            // Start playing the sound
            clip.start();
        }
    }

    public void stop() {
        if (clip != null) {
            // Stop playing the sound
            clip.stop();
        }
    }

    public void close() {
        if (clip != null) {
            // Close the clip to release resources
            clip.close();
        }
    }
}
