package essentials;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import uwcse.graphics.GWindow;
import uwcse.graphics.ImageShape;

/**
 * Esta clase construye un objeto de tipo ImageDisplay que permite mostrar una imagen en una ventana.
 */
public class ImageDisplay extends ImageShape {

    // Atributos
    private String file;
    private Image img;

    /**
     * Constructor que crea un objeto ImageDisplay.
     *
     * @param filePath Ruta de la imagen.
     * @param x         Posición en el eje x donde se mostrará la imagen.
     * @param y         Posición en el eje y donde se mostrará la imagen.
     * @throws IOException Excepción lanzada si no se encuentra la imagen.
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

    /**
     * Alinea el objeto de tipo ImageDisplay al borde inferior de la ventana.
     *
     * @param myWindow Ventana donde se mostrará la imagen.
     */
    public void alignToBottom(GWindow myWindow) {
        int windowHeight = myWindow.getWindowHeight();
        int newX = this.getX();
        int newY = windowHeight - this.getHeight();
        this.moveTo(newX, newY);
    }

    /**
     * Alinea el objeto de tipo ImageDisplay a la derecha de la ventana.
     *
     * @param myWindow Ventana donde se mostrará la imagen.
     */
    public void alignToRight(GWindow myWindow) {
        int windowWidth = myWindow.getWindowWidth();
        int newX = windowWidth - this.getWidth();
        int newY = this.getY();
        this.moveTo(newX, newY);
    }

    /**
     * Alinea el objeto de tipo ImageDisplay a la izquierda de la ventana.
     *
     * @param myWindow Ventana donde se mostrará la imagen.
     */
    public void alignToLeft(GWindow myWindow) {
        int newX = 0;
        int newY = this.getY();
        this.moveTo(newX, newY);
    }

    /**
     * Alinea el objeto de tipo ImageDisplay al centro de la ventana.
     *
     * @param myWindow Ventana donde se mostrará la imagen.
     */
    public void alignToCenter(GWindow myWindow) {
        int windowWidth = myWindow.getWindowWidth();
        int windowHeight = myWindow.getWindowHeight();
        int newX = (windowWidth - this.getWidth()) / 2;
        int newY = (windowHeight - this.getHeight()) / 2;
        this.moveTo(newX, newY);
    }

    /**
     * Dimensiona el objeto de tipo ImageDisplay para que ocupe todo el ancho de la ventana.
     *
     * @param myWindow Ventana donde se mostrará la imagen.
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

    /**
     * Dimensiona el objeto de tipo ImageDisplay para que ocupe todo el alto de la ventana.
     *
     * @param myWindow Ventana donde se mostrará la imagen.
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

    /**
     * Mueve el objeto de tipo ImageDisplay a una posición determinada con una animación suave.
     *
     * @param x       Posición en el eje x donde se mostrará la imagen.
     * @param y       Posición en el eje y donde se mostrará la imagen.
     * @param duration Duración de la animación en milisegundos.
     */
    public void moveTo(int x, int y, int duration) {
        int currentX = this.getX();
        int currentY = this.getY();
        int deltaX = x - currentX;
        int deltaY = y - currentY;
        int steps = duration / 10; // Ajustar para la suavidad deseada
        int stepDelay = duration / steps;
        for (int i = 1; i <= steps; i++) {
            int newX = currentX + (deltaX * i / steps);
            int newY = currentY + (deltaY * i / steps);
            this.moveTo(newX, newY);

            // Usar Thread.sleep para introducir un retraso
            try {
                Thread.sleep(stepDelay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
