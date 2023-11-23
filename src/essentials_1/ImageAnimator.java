package essentials;
import java.io.IOException;
import uwcse.graphics.GWindow;
/*
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
    private boolean alignToRigth;
    private boolean alignToLeft;
    private boolean alignToCenter;
    private boolean setWidthToWindow;
    private boolean isRunning;
    private boolean setHeightToWindow;

    /*
     * Este constructor crea un objeto ImageAnimator.
     * @param imagePaths es un array de rutas de imágenes.
     * @param animationDuration es la duración de la animación en milisegundos.
     * @param myWindow es la ventana donde se mostrará la animación.
     * @param alignToBottom es un booleano que indica si la imagen debe alinearse a la parte inferior de la ventana.
     * @param alignToLeft es un booleano que indica si la imagen debe alinearse a la izquierda de la ventana.
     * @param alignToRight es un booleano que indica si la imagen debe alinearse a la derecha de la ventana.
     * @param alignToCenter es un booleano que indica si la imagen debe alinearse al centro de la ventana.
     * @param setWidthToWindow es un booleano que indica si la imagen debe ajustar su ancho al ancho de la ventana.
     * @param setHeightToWindow es un booleano que indica si la imagen debe ajustar su alto al alto de la ventana.
     * @throws IOException es la excepción que se lanza si no se encuentra la imagen.
     */
    public ImageAnimator(String[] imagePaths, int animationDuration, GWindow myWindow, boolean alignToBottom, boolean alignToLeft, boolean alignToRight, boolean alignToCenter, boolean setWidthToWindow, boolean setHeightToWindow) {
        this.imagePaths = imagePaths;
        this.currentIndex = 0;
        this.myWindow = myWindow;
        this.animationDuration = animationDuration;
        this.alignToBottom = alignToBottom;
        this.setWidthToWindow = setWidthToWindow;
        this.setHeightToWindow = setHeightToWindow;
        this.alignToLeft = alignToLeft;
        this.alignToRigth = alignToRight;
        this.alignToCenter = alignToCenter;

        // Asegurar que myWindow no sea null
        if (myWindow == null) {
            throw new IllegalArgumentException("GWindow cannot be null");
        }

        // Inicializar la primera imagen y ajustar su tamaño al tamaño de la ventana
        try {
            this.currentImageDisplay = new ImageDisplay(imagePaths[0], -1024, -768);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * Este método inicia la animación, recorriendo el array de imágenes y creando un bucle infinito.
     */
    public void startAnimation() {
        isRunning = true;
        while (true) {
            for (int i = 0; i < imagePaths.length; i++) {
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
    
    // Este método mueve la imagen actual a la siguiente imagen en el array.
    private void moveToNextImage() {

        if (!isRunning) {
            return;
        }

        currentIndex = (currentIndex + 1) % imagePaths.length;
        try {
            ImageDisplay nextImageDisplay = new ImageDisplay(imagePaths[currentIndex], 0, 0);
            
            if (setHeightToWindow){
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

            if (alignToRigth) {
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

    /*
     * Este método detiene la animación actual.
     */
    public void stopAnimation() {
        isRunning = false;
        myWindow.erase();
        if (currentImageDisplay != null) {
            currentImageDisplay.removeFromWindow();
            currentImageDisplay = null;
        }
    }

    /*
     * Este método inicia el slideshow, un tipo especial que recorre el array de imagenes sin ningun bucle.
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