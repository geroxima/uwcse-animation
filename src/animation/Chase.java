package animation;

import java.io.IOException;
import essentials.ImageAnimator;
import essentials.ImageDisplay;
import uwcse.graphics.GWindow;

/**
 * Esta clase representa la animación de la persecución.
 */
public class Chase {
    
    /**
     * Reproduce la animación de la persecución.
     * 
     * @param myWindow La ventana en la que se mostrará la animación.
     * @throws InterruptedException Si se interrumpe la ejecución del hilo durante la animación.
     * @throws IOException Si ocurre un error al cargar la imagen.
     */
    public void play(GWindow myWindow) throws InterruptedException, IOException {
        // Duración de la animación en milisegundos
        final int ANIMATION_DURATION = 4000;
        
        // Rutas de los archivos de imagen
        String[] policeTruck = {
            "assets/gif/police/frame_0_delay-0.1s.png",
            "assets/gif/police/frame_1_delay-0.1s.png",
            "assets/gif/police/frame_2_delay-0.1s.png",
        };

        String[] mainCarFrames = {
            "assets/gif/mainCar/frame_0_delay-0.1s.png",
            "assets/gif/mainCar/frame_1_delay-0.1s.png",
            "assets/gif/mainCar/frame_2_delay-0.1s.png",
        };
        
        // Crear animadores de imágenes
        ImageAnimator mainCar = new ImageAnimator(mainCarFrames, 15, myWindow, true, false, true, false, false, false);
        ImageAnimator policeTruckAnimation = new ImageAnimator(policeTruck, 0, myWindow, true, true, false, false, false, false);
        
        // Crear elementos de la animación
        ImageDisplay streets = new ImageDisplay("assets/foreground-tileset.png", 0, 0);
        ImageDisplay background = new ImageDisplay("assets/city/city 8/7.png", 0, 0);
        ImageDisplay midground = new ImageDisplay("assets/city/city 7/5.png", 0, 100);

        // Configurar elementos en la ventana
        background.setWidthToWindow(myWindow);
        background.addTo(myWindow);

        midground.setWidthToWindow(myWindow);
        midground.addTo(myWindow);

        streets.alignToBottom(myWindow);
        streets.addTo(myWindow);

        // Mover la calle hacia la izquierda en un hilo separado
        new Thread(() -> {
            streets.moveTo(-streets.getWidth(), streets.getY(), ANIMATION_DURATION);
        }).start();

        // Iniciar la animación del camión de policía en un hilo separado
        new Thread(() -> {
            policeTruckAnimation.startAnimation();
        }).start();

        // Iniciar la animación del coche principal en un hilo separado
        new Thread(() -> {
            mainCar.startAnimation();
        }).start();

        // Esperar antes de detener la animación y borrar la ventana
        Thread.sleep(ANIMATION_DURATION - 500);
        policeTruckAnimation.stopAnimation();
        mainCar.stopAnimation();
        myWindow.erase();   
    }
}
