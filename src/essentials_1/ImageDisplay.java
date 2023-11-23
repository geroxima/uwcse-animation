package essentials;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import uwcse.graphics.GWindow;
import uwcse.graphics.ImageShape;

/*
 * Esta clase construye un objeto de tipo Image que permite mostrar una imagen en una ventana.
 */

public class ImageDisplay extends ImageShape {
    // Atributos
    private String file;
    private Image img;

    /*
     * Este constructor crea un objeto ImageDisplay.
     * @param filePath es la ruta de la imagen.
     * @param x es la posición en el eje x donde se mostrará la imagen.
     * @param y es la posición en el eje y donde se mostrará la imagen.
     * @throws IOException es la excepción que se lanza si no se encuentra la imagen.
     */
    public ImageDisplay(String filePath, int x, int y) throws IOException {
        super(ImageIO.read(new File(filePath)), x, y);
        this.file = filePath;
        this.img = ImageIO.read(new File(filePath));
    }

    // Getters y setters
    public String getFile() {
        return file;
    }

    public Image getImage() {
        return img;
    }

    /*
     * Este metodo alinea el objeto de tipo ImageDisplay al borde inferior de la ventana.
     * @param myWindow es la ventana donde se mostrará la imagen.
     */
    public void alignToBottom(GWindow myWindow) {
        // Get the dimensions of the window
        int windowHeight = myWindow.getWindowHeight();

        // Calculate the new position to align the image to the bottom
        int newX = this.getX();
        int newY = windowHeight - this.getHeight();

        // Move the ImageShape to the new position
        this.moveTo(newX, newY);
    }

    /*
     * Este método alinea el objeto de tipo ImageDisplay a la derecha de la ventana.
     * @param myWindow es la ventana donde se mostrará la imagen.
     */
    public void alignToRight(GWindow myWindow) {
        int windowWidth = myWindow.getWindowWidth();
        int newX = windowWidth - this.getWidth();
        int newY = this.getY();
        this.moveTo(newX, newY);
    }

    /*
     * Este método alinea el objeto de tipo ImageDisplay a la izquierda de la ventana.
     * @param myWindow es la ventana donde se mostrará la imagen.
     */
    public void alignToLeft(GWindow myWindow) {
        int newX = 0;
        int newY = this.getY();
        this.moveTo(newX, newY);
    }
    /*
     * Este metodo alinea el objeto de tipo ImageDisplay al centro de la ventana.
     * @param myWindow es la ventana donde se mostrará la imagen.
     */
    public void alignToCenter(GWindow myWindow) {
        int windowWidth = myWindow.getWindowWidth();
        int windowHeight = myWindow.getWindowHeight();
        int newX = (windowWidth - this.getWidth()) / 2;
        int newY = (windowHeight - this.getHeight()) / 2;
        this.moveTo(newX, newY);
    }

    /*
     * Este metodo dimensiona el objeto de tipo ImageDisplay para que ocupe todo el ancho de la ventana.
     * @param myWindow es la ventana donde se mostrará la imagen.
     */
    public void setWidthToWindow(GWindow myWindow) {
        int windowWidth = myWindow.getWindowWidth();
        double scaleFactorWidth = (double) windowWidth / this.getImage().getWidth(null);
        int newWidth = windowWidth;
        int newHeight = (int) (this.getImage().getHeight(null) * scaleFactorWidth);
        Image resizedImage = this.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        this.setImage(resizedImage);
        myWindow.add(this);
    }

    /*
     * Este metodo dimensiona el objeto de tipo ImageDisplay para que ocupe todo el alto de la ventana.
     * @param myWindow es la ventana donde se mostrará la imagen.
     */
    public void setHeightToWindow(GWindow myWindow) {
        int windowHeight = myWindow.getWindowHeight();
        double scaleFactorHeight = (double) windowHeight / this.getImage().getHeight(null);
        int newHeight = windowHeight;
        int newWidth = (int) (this.getImage().getWidth(null) * scaleFactorHeight);
        int originalX = this.getX();
        int originalY = this.getY();
        Image resizedImage = this.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        this.setImage(resizedImage);
        this.moveTo(originalX, originalY);
    }

    /*
     * Este metodo mueve el objeto de tipo ImageDisplay a una posición determinada.
     * @param x es la posición en el eje x donde se mostrará la imagen.
     * @param y es la posición en el eje y donde se mostrará la imagen.
     */
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
