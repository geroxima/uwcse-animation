package animation;
import uwcse.graphics.*;
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;

import essentials.Dinosaurio;
import essentials.ImageDisplay;
import essentials.MainCar;

/**
 * Esta clase representa la introducción de la anmación.
 * @param myWindow es la ventana donde se mostrará la animación.
 * @throws IOException es la excepción que se lanza si no se encuentra la imagen.
 */

public class Intro {
    public static void play(GWindow myWindow) throws IOException {
        int windowWidth = myWindow.getWindowWidth();
        int windowHeight = myWindow.getWindowHeight();
        
        // Create an ImageDisplay for the foreground image
        ImageDisplay foreground = new ImageDisplay("assets/costa-sprites/costa-foreground.png", 0, 0);
        ImageDisplay midground = new ImageDisplay("assets/costa-sprites/costa-bridge.png", 0, 300);
        ImageDisplay background = new ImageDisplay("assets/city/city 2/1.png", 0, 0);
        TextShape title = new TextShape("Encarnación, 2023", 70, (myWindow.getWindowHeight() - 100), Color.WHITE, Font.decode("Arial-BOLD-30"));
        
        background.setWidthToWindow(myWindow);
        background.addTo(myWindow);
        midground.addTo(myWindow);
        foreground.addTo(myWindow);
        title.addTo(myWindow);

        // MainCar car = new MainCar(myWindow, 0, 600);
        // car.addPartsToWindow(myWindow);

        // Dinosaurio dino = new Dinosaurio(myWindow);
        // dino.ponerDinosaurio(myWindow);
    
        foreground.alignToBottom(myWindow);
        int endX = -250; // Ending at the left

        // Define the duration of the movement in milliseconds
        int moveDuration = 7000; // Adjust as needed

        // Move the foreground image from right to left
        playImage(foreground, endX, foreground.getImageShape().getY(), moveDuration);
        playImage(midground, 300, midground.getImageShape().getY(), moveDuration);
    }

    public static void playImage(ImageDisplay image, int endX, int endY, int duration) {
        new Thread(() -> image.moveTo(endX, endY, duration)).start();
    }
}
