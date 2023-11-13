import uwcse.graphics.*;
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;

public class Intro {
    public static void play(GWindow myWindow) throws IOException {
        // Create an ImageDisplay for the foreground image
        ImageDisplay foreground = new ImageDisplay("assets/costa-sprites/costa-foreground.png", 0, 0);
        ImageDisplay midground = new ImageDisplay("assets/costa-sprites/costa-bridge.png", 0, 300);
        ImageDisplay background = new ImageDisplay("assets/costa-sprites/costa-clouds.png", 100, 0);
        TextShape title = new TextShape("Encarnación, 2023", 70, (myWindow.getWindowHeight() - 100), Color.WHITE, Font.decode("Arial-BOLD-30"));

        midground.drawFilledRectangle(myWindow, new Color(112, 157, 207, 255));

        background.addTo(myWindow);
        midground.addTo(myWindow);
        foreground.addTo(myWindow);
        title.addTo(myWindow);

        foreground.alignToBottom(myWindow);
        int endX = -250; // Ending at the left

        // Define the duration of the movement in milliseconds
        int moveDuration = 7000; // Adjust as needed

        // Move the foreground image from right to left
        playImage(foreground, endX, foreground.getImageShape().getY(), moveDuration);
        playImage(midground, 300, midground.getImageShape().getY(), moveDuration);
        playImage(background, -200, background.getImageShape().getY(), moveDuration);
    }

    public static void playImage(ImageDisplay image, int endX, int endY, int duration) {
        new Thread(() -> image.moveTo(endX, endY, duration)).start();
    }
}
