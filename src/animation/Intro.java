package animation;

import uwcse.graphics.*;
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import essentials.ImageAnimator;
import essentials.ImageDisplay;

/**
 * Esta clase representa la introducción de la animación.
 */
public class Intro {

    /**
     * Reproduce las animaciones definidas en esta clase.
     * 
     * @param myWindow La ventana en la que se mostrará la animación.
     * @throws IOException Si ocurre un error al cargar la imagen.
     * @throws InterruptedException Si se interrumpe la ejecución del hilo durante la animación.
     */
    public void play(GWindow myWindow) throws IOException, InterruptedException {
        // Definir las constantes
        final int MOVE_DURATION = 5000;

        // Crear los elementos de la animación
        ImageDisplay foreground = new ImageDisplay("assets/costa-sprites/costa-foreground.png", 0, 0);
        ImageDisplay midground = new ImageDisplay("assets/costa-sprites/costa-bridge.png", 0, 350);
        ImageDisplay background = new ImageDisplay("assets/city/big-bc.png", 0, 0);
        TextShape title = new TextShape("Encarnación, 2023", 70, (myWindow.getWindowHeight() - 100), Color.WHITE, Font.decode("Arial-BOLD-30"));

        // Añadir todos los elementos a la ventana
        background.setWidthToWindow(myWindow);
        background.addTo(myWindow);
        midground.addTo(myWindow);
        foreground.addTo(myWindow);
        title.addTo(myWindow);
        foreground.alignToBottom(myWindow);

        playImage(foreground, -250, foreground.getY(), MOVE_DURATION);
        playImage(midground, 300, midground.getY(), MOVE_DURATION);

        Thread.sleep(4200);

        String[] imageNames = {
            "assets/city/city 2/5.png",
            "assets/city/city 2/6.png",
            "assets/city/city 3/5.png",
            "assets/city/city 4/5.png",
            "assets/city/city 5/2.png",
            "assets/city/city 5/3.png",
            "assets/city/city 5/4.png",
            "assets/city/city 6/4.png",
            "assets/city/city 7/4.png",
            "assets/city/city 7/5.png",
            "assets/city/city 8/4.png",
            "assets/city/city 8/5.png",
        };
        // Duración de la animación entre imágenes en milisegundos
        int animationDuration = 200;

        ImageAnimator imageAnimator = new ImageAnimator(imageNames, animationDuration, myWindow, true, false, false, false, true, false);

        background.moveTo(0, -1050, 4500);
        imageAnimator.startSlideshow();

        midground.moveTo(0, 500, 300);
        foreground.moveTo(0, 500, 300);

        myWindow.remove(midground);
        myWindow.remove(foreground);
        Thread.sleep(900);

        myWindow.erase();
    }

    /**
     * Mueve una imagen a una posición en la ventana en un tiempo determinado.
     * 
     * @param image La imagen que se moverá.
     * @param endX La coordenada x final.
     * @param endY La coordenada y final.
     * @param duration La duración de la animación en milisegundos.
     */
    public void playImage(ImageDisplay image, int endX, int endY, int duration) {
        new Thread(() -> image.moveTo(endX, endY, duration)).start();
    }
}
