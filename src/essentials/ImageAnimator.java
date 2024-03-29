package essentials;

import java.io.IOException;
import uwcse.graphics.GWindow;

/**
 * Esta clase construye un objeto que permite animar una secuencia de imágenes.
 */
public class ImageAnimator {

    // Atributos
    private String[] imagePaths;
    private int currentIndex;
    private ImageDisplay currentImageDisplay;
    private int animationDuration;
    private GWindow myWindow;
    private boolean alignToBottom;
    private boolean alignToLeft;
    private boolean alignToRight;
    private boolean alignToCenter;
    private boolean setWidthToWindow;
    private boolean setHeightToWindow;
    private boolean isRunning;

    /**
     * Constructor para crear un objeto ImageAnimator.
     *
     * @param imagePaths        Array de rutas de imágenes.
     * @param animationDuration Duración de la animación en milisegundos.
     * @param myWindow          Ventana donde se mostrará la animación.
     * @param alignToBottom     Indica si la imagen debe alinearse a la parte inferior de la ventana.
     * @param alignToLeft       Indica si la imagen debe alinearse a la izquierda de la ventana.
     * @param alignToRight      Indica si la imagen debe alinearse a la derecha de la ventana.
     * @param alignToCenter     Indica si la imagen debe alinearse al centro de la ventana.
     * @param setWidthToWindow  Indica si la imagen debe ajustar su ancho al ancho de la ventana.
     * @param setHeightToWindow Indica si la imagen debe ajustar su alto al alto de la ventana.
     * @throws IOException Excepción lanzada si no se encuentra la imagen.
     */
    public ImageAnimator(String[] imagePaths, int animationDuration, GWindow myWindow,
                         boolean alignToBottom, boolean alignToLeft, boolean alignToRight,
                         boolean alignToCenter, boolean setWidthToWindow, boolean setHeightToWindow)
            throws IOException {
        this.imagePaths = imagePaths;
        this.currentIndex = 0;
        this.myWindow = myWindow;
        this.animationDuration = animationDuration;
        this.alignToBottom = alignToBottom;
        this.alignToLeft = alignToLeft;
        this.alignToRight = alignToRight;
        this.alignToCenter = alignToCenter;
        this.setWidthToWindow = setWidthToWindow;
        this.setHeightToWindow = setHeightToWindow;
        this.isRunning = false;

        // Asegurar que myWindow no sea null
        if (myWindow == null) {
            throw new IllegalArgumentException("GWindow cannot be null");
        }

        // Inicializar la primera imagen y ajustar su tamaño al tamaño de la ventana
        this.currentImageDisplay = new ImageDisplay(imagePaths[0], -1024, -768);
    }

    /**
     * Inicia la animación, recorriendo el array de imágenes y creando un bucle infinito.
     */
    public void startAnimation() {
        isRunning = true;
        while (isRunning) {
            for (String imagePath : imagePaths) {
                // Mostrar la imagen actual
                currentImageDisplay.addTo(this.myWindow);

                // Ajustar el tamaño de la imagen al tamaño de la ventana
                // Mover a la siguiente imagen
                moveToNextImage();

                // Esperar para dar la sensación de animación
                try {
                    Thread.sleep(animationDuration);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Quitar la imagen actual
                currentImageDisplay.removeFromWindow();
            }
        }
    }

    
    //  Mueve la imagen actual a la siguiente imagen en el array.
    private void moveToNextImage() {
        if (!isRunning) {
            return;
        }

        currentIndex = (currentIndex + 1) % imagePaths.length;
        try {
            ImageDisplay nextImageDisplay = new ImageDisplay(imagePaths[currentIndex], 0, 0);

            if (setHeightToWindow) {
                nextImageDisplay.setHeightToWindow(myWindow);
            }

            if (alignToCenter) {
                nextImageDisplay.alignToCenter(myWindow);
            }

            if (setWidthToWindow) {
                nextImageDisplay.setWidthToWindow(myWindow);
            }

            if (alignToLeft) {
                nextImageDisplay.alignToLeft(myWindow);
            }

            if (alignToRight) {
                nextImageDisplay.alignToRight(myWindow);
            }

            if (alignToBottom) {
                nextImageDisplay.alignToBottom(myWindow);
            }

            nextImageDisplay.addTo(this.myWindow);
            if (currentImageDisplay != null) {
                currentImageDisplay.removeFromWindow();
            }
            currentImageDisplay = nextImageDisplay;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Detiene la animación actual.
     */
    public void stopAnimation() {
        isRunning = false;
        myWindow.erase();
        if (currentImageDisplay != null) {
            currentImageDisplay.removeFromWindow();
            currentImageDisplay = null;
        }
    }

    /**
     * Inicia el slideshow, un tipo especial que recorre el array de imágenes sin ningún bucle.
     */
    public void startSlideshow() {
        // Mostrar todas las imágenes en el array sin quitarlas
        for (String imagePath : imagePaths) {
            try {
                ImageDisplay nextImageDisplay = new ImageDisplay(imagePath, 0, 0);
                nextImageDisplay.setWidthToWindow(myWindow);
                nextImageDisplay.alignToBottom(myWindow);

                nextImageDisplay.addTo(this.myWindow);

                currentImageDisplay = nextImageDisplay;

                // Esperar para dar la sensación de slideshow
                Thread.sleep(animationDuration);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
