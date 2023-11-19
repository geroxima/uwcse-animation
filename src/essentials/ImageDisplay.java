package essentials;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import javax.imageio.ImageIO;
import uwcse.graphics.GWindow;
import uwcse.graphics.ImageShape;
import uwcse.graphics.Rectangle;

public class ImageDisplay extends ImageShape {
    private String file;
    private Image img;

    public ImageDisplay(String filePath, int x, int y) throws IOException {
        super(ImageIO.read(new File(filePath)), x, y);
        this.file = filePath;
        this.img = ImageIO.read(new File(filePath)); 
    }

    // Getters for file and img
    public String getFile() {
        return file;
    }

    public Image getImage() {
        return img;
    }

    public void alignToBottom(GWindow myWindow) {
        // Get the dimensions of the window
        int windowHeight = myWindow.getWindowHeight();
    
        // Calculate the new position to align the image to the bottom
        int newX = this.getX();
        int newY = windowHeight - this.getHeight();
    
        // Move the ImageShape to the new position
        this.moveTo(newX, newY);
    }

    public void setWidthToWindow(GWindow myWindow) {
        // Get the dimensions of the window
        int windowWidth = myWindow.getWindowWidth();
    
        // Calculate the scaling factor for width
        double scaleFactorWidth = (double) windowWidth / this.getImage().getWidth(null);
    
        // Calculate the new dimensions
        int newWidth = windowWidth;
        int newHeight = (int) (this.getImage().getHeight(null) * scaleFactorWidth);
    
        int originalX = this.getX();
        int originalY = this.getY();
    
        // Resize the image
        Image resizedImage = this.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
    
        // Create a new ImageShape with the resized image and original position
        this.setImage(resizedImage);
    
        // Add the ImageShape to the window
        myWindow.add(this);
    }

    public void moveTo(int x, int y, int duration) {
        int currentX = this.getX();
        int currentY = this.getY();
        int deltaX = x - currentX;
        int deltaY = y - currentY;
        int steps = duration / 10; // Adjust for desired smoothness
        int stepDelay = duration / steps;
    
        for (int i = 1; i <= steps; i++) {
            int newX = currentX + (deltaX * i / steps);
            int newY = currentY + (deltaY * i / steps);
            this.moveTo(newX, newY);
    
            // Use Thread.sleep to introduce a delay
            try {
                Thread.sleep(stepDelay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}