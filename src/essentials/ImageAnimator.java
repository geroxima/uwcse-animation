package essentials;

import java.io.IOException;

import uwcse.graphics.GWindow;

public class ImageAnimator {
    private String[] imagePaths;
    private int currentIndex;
    private ImageDisplay currentImageDisplay;
    private int animationDuration;
    private GWindow myWindow;
    private boolean alignToBottom;
    private boolean setWidthToWindow;
    private boolean isRunning;
    private boolean setHeightToWindow;

    public ImageAnimator(String[] imagePaths, int animationDuration, GWindow myWindow, boolean alignToBottom, boolean setWidthToWindow, boolean setHeightToWindow) {
        this.imagePaths = imagePaths;
        this.currentIndex = 0;
        this.myWindow = myWindow;
        this.animationDuration = animationDuration;
        this.alignToBottom = alignToBottom;
        this.setWidthToWindow = setWidthToWindow;
        this.setHeightToWindow = setHeightToWindow;

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

            if (setWidthToWindow) {
                nextImageDisplay.setWidthToWindow(myWindow);
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

    public void stopAnimation() {
        isRunning = false;
        myWindow.erase();
        if (currentImageDisplay != null) {
            currentImageDisplay.removeFromWindow();
            currentImageDisplay = null;
        }
    }


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

     public static void main(String[] args) throws InterruptedException {
         // Ejemplo de uso para el slideshow
         String[] imageNames = {
             "assets/gif/mainCar/frame_0_delay-0.1s.png",
             "assets/gif/mainCar/frame_1_delay-0.1s.png",
             "assets/gif/mainCar/frame_2_delay-0.1s.png",
         };
         int animationDuration = 10; // Duración de la animación entre imágenes en milisegundos
         ImageAnimator imageAnimator = new ImageAnimator(imageNames, animationDuration, new GWindow(500, 500), true, false, false);
     
         // Alinear las imágenes en la parte inferior
        imageAnimator.startAnimation();
        Thread.sleep(5000);
        imageAnimator.stopAnimation();
        
     
         // O bien, sin alineación en la parte inferior
         // imageAnimator.startSlideshow(false);
     }
}
