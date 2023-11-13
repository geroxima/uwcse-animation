package essentials;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import javax.imageio.ImageIO;
import uwcse.graphics.GWindow;
import uwcse.graphics.ImageShape;
import uwcse.graphics.Rectangle;

public class ImageDisplay {
    private String file;
    private Image img;
    private ImageShape imgShape;

    public ImageDisplay(String filePath, int x, int y) throws IOException {
        this.file = filePath;
        this.img = ImageIO.read(new File(filePath)); 
        this.imgShape = new ImageShape(img, x, y);
    }

    // Getters for file, img, and imgShape
    public String getFile() {
        return file;
    }

    public Image getImage() {
        return img;
    }

    public ImageShape getImageShape() {
        return imgShape;
    }

    public void stretchToFillWindow(GWindow myWindow) {
        // Get the dimensions of the window
        int windowWidth = myWindow.getWindowWidth();
        int windowHeight = myWindow.getWindowHeight();

        // Resize the image to match the window dimensions
        Image resizedImage = img.getScaledInstance(windowWidth, windowHeight, Image.SCALE_SMOOTH);

        // Update the ImageShape with the resized image
        imgShape.setImage(resizedImage);

        // Move the ImageShape to (0, 0) to fill the entire window
        imgShape.moveTo(0, 0);
    }

    public void alignToBottom(GWindow myWindow) {
        // Get the dimensions of the window
        int windowHeight = myWindow.getWindowHeight();

        // Calculate the new position to align the image to the bottom
        int newX = imgShape.getX();
        int newY = windowHeight - imgShape.getHeight();

        // Move the ImageShape to the new position
        imgShape.moveTo(newX, newY);
    }

    public void setWidthToWindow(GWindow myWindow) {
        // Get the dimensions of the window
        int windowWidth = myWindow.getWindowWidth();

        // Calculate the scaling factor for width
        double scaleFactorWidth = (double) windowWidth / img.getWidth(null);

        // Calculate the new dimensions
        int newWidth = windowWidth;
        int newHeight = (int) (img.getHeight(null) * scaleFactorWidth);

        int originalX = imgShape.getX();
        int originalY = imgShape.getY();

        // Resize the image
        Image resizedImage = img.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

        // Create a new ImageShape with the resized image and original position
        imgShape = new ImageShape(resizedImage, originalX, originalY);

        // Add the ImageShape to the window
        myWindow.add(imgShape);
    }

     public void drawFilledRectangle(GWindow myWindow, Color color) {
        // Get the dimensions of the window
        int windowWidth = myWindow.getWindowWidth();
        int windowHeight = myWindow.getWindowHeight();

        // Create a filled rectangle with the same size as the window
        Rectangle rectangle = new Rectangle(0, 0, windowWidth, windowHeight, color, true);

        // Add the rectangle to the window
        rectangle.addTo(myWindow);
    }


    public void moveTo(int x, int y, int duration) {
        int currentX = imgShape.getX();
        int currentY = imgShape.getY();
        int deltaX = x - currentX;
        int deltaY = y - currentY;
        int steps = duration / 10; // Adjust for desired smoothness
        int stepDelay = duration / steps;
    
        for (int i = 1; i <= steps; i++) {
            int newX = currentX + (deltaX * i / steps);
            int newY = currentY + (deltaY * i / steps);
            imgShape.moveTo(newX, newY);
    
            // Use Thread.sleep to introduce a delay
            try {
                Thread.sleep(stepDelay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
   
   
    // Method to add the image to a GWindow
    public void addTo(GWindow myWindow) {
        myWindow.add(imgShape);
    }


}
