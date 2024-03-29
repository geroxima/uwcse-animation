package essentials;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Clase que proporciona funcionalidades para reproducir sonidos.
 */
public class SoundPlayer {

    private Clip clip;

    /**
     * Constructor que crea un objeto SoundPlayer para el archivo de sonido especificado.
     *
     * @param soundFilePath Ruta del archivo de sonido.
     */
    public SoundPlayer(String soundFilePath) {
        try {
            // Cargar el archivo de sonido
            File soundFile = new File(soundFilePath);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);

            // Obtener un Clip para reproducir el sonido
            clip = AudioSystem.getClip();

            // Abrir el clip de audio con el flujo de entrada de audio proporcionado
            clip.open(audioInputStream);
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reproduce el sonido.
     */
    public void play() {
        if (clip != null) {
            // Inicia la reproducción del sonido
            clip.start();
        }
    }

    /**
     * Detiene la reproducción del sonido.
     */
    public void stop() {
        if (clip != null) {
            // Detiene la reproducción del sonido
            clip.stop();
        }
    }

    /**
     * Cierra el clip para liberar los recursos asociados.
     */
    public void close() {
        if (clip != null) {
            // Cierra el clip para liberar recursos
            clip.close();
        }
    }
}
