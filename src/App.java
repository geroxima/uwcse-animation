import javax.swing.*;
import uwcse.graphics.GWindow;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.IOException;

public class App{
    public static void main(String[] args) {
        try {
            GWindow myWindow = new GWindow("Image Window", 1024, 768);
            ImageDisplay myImageDisplay = new ImageDisplay("assets/cyberpunk-street.png", 0, 0);
 
            // Stretch the image to fill the window width
            myImageDisplay.setWidthToWindow(myWindow);

            // Align the image to the bottom of the window
            myImageDisplay.alignToBottom(myWindow);
            
            // Add the image to the GWindow
            myImageDisplay.addTo(myWindow);
            


            myWindow.setExitOnClose();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
