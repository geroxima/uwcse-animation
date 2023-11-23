package animation;

import java.io.IOException;
import essentials.ImageDisplay;
import essentials.SoundPlayer;
import uwcse.graphics.GWindow;

/**
 * Esta clase es la que contiene el método main que ejecuta el programa.
 * 
 * @author Adán Alvarez
 */

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Constantes
        final int PAUSE = 4000;

        // Inicialización de los objetos

        GWindow myWindow = new GWindow("Image Window", 1024, 768); // Se crea la ventana
        SoundPlayer soundPlayer = new SoundPlayer("assets/sounds/Rubadub.wav"); // Se crea el reproductor de sonido
        Intro intro = new Intro(); // Se crea la intro
        FirstScene firstScene = new FirstScene(); // Se crea la primera escena
        CarInterior interior = new CarInterior(); // Se crea el interior del vehiculo
        GifImages flashyImages = new GifImages(); // Se crea la escena de los gifs parpadeantes
        PoliceCar policeCar = new PoliceCar(); // Se crea la escena de la patrulla de policía
        Chase chase = new Chase(); // Se crea la persecución
        ImageDisplay credits = new ImageDisplay("assets/credits.png", 0, 0); // Se crea la imagen de los créditos

        myWindow.setExitOnClose(); // Se cierra el programa al cerrar la ventana
        soundPlayer.play(); // Se reproduce el sonido
        intro.play(myWindow); // Se reproduce la intro
        firstScene.play(myWindow); // Se reproduce la primera escena
        interior.play(myWindow); // Se reproduce el interior del vehiculo
        Thread.sleep(PAUSE); // Se espera 4 segundos
        flashyImages.play(myWindow); // Se reproduce la escena de los gifs parpadeantes
        policeCar.play(myWindow); // Se reproduce la escena de la patrulla de policía
        chase.play(myWindow); // Se reproduce la persecución
        credits.addTo(myWindow); // Se añaden los créditos a la ventana
    }
}