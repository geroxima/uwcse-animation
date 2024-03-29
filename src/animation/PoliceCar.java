package animation;

import java.io.IOException;
import essentials.ImageAnimator;
import essentials.ImageDisplay;
import uwcse.graphics.GWindow;

/**
 * Esta clase representa la secuencia de animaciones de la patrulla de policía.
 */
public class PoliceCar {
    
    /**
     * Reproduce la secuencia de animaciones de la patrulla de policía.
     * 
     * @param myWindow La ventana en la que se mostrará la animación.
     * @throws IOException Si ocurre un error al cargar la imagen.
     * @throws InterruptedException Si se interrumpe la ejecución del hilo durante la animación.
     */
    public void play(GWindow myWindow) throws IOException, InterruptedException {
        // Duración de la animación en milisegundos
        final int ANIMATION_DURATION = 4000;
        
        // Rutas de los archivos de imagen
        String[] policeTruck = {
            "assets/gif/police/frame_0_delay-0.1s.png",
            "assets/gif/police/frame_1_delay-0.1s.png",
            "assets/gif/police/frame_2_delay-0.1s.png",
        };

        String[] switches = {
            "assets/gif/switches/frame_00_delay-0.1s.png",
            "assets/gif/switches/frame_01_delay-0.1s.png",
            "assets/gif/switches/frame_02_delay-0.1s.png",
            "assets/gif/switches/frame_03_delay-0.1s.png",
            "assets/gif/switches/frame_04_delay-0.1s.png",
            "assets/gif/switches/frame_05_delay-0.1s.png",
            "assets/gif/switches/frame_06_delay-0.1s.png",
            "assets/gif/switches/frame_07_delay-0.1s.png",
            "assets/gif/switches/frame_08_delay-0.1s.png",
            "assets/gif/switches/frame_09_delay-0.1s.png",
            "assets/gif/switches/frame_10_delay-0.1s.png",
            "assets/gif/switches/frame_11_delay-0.1s.png",
            "assets/gif/switches/frame_12_delay-0.1s.png",
            "assets/gif/switches/frame_13_delay-0.1s.png",
            "assets/gif/switches/frame_14_delay-0.1s.png",
            "assets/gif/switches/frame_15_delay-0.1s.png",
            "assets/gif/switches/frame_16_delay-0.1s.png",
            "assets/gif/switches/frame_17_delay-0.1s.png",
        };

        // Crear elementos de la animación
        ImageDisplay streets = new ImageDisplay("assets/foreground-tileset.png", 0, 0);
        ImageDisplay background = new ImageDisplay("assets/city/city 8/7.png", 0, 0);
        ImageDisplay midground = new ImageDisplay("assets/city/city 7/5.png", 0, 100);

        // Crear animaciones
        ImageAnimator switchesAnimation = new ImageAnimator(switches, 1, myWindow, true, false, false, false, true, true);
        ImageAnimator policeTruckAnimation = new ImageAnimator(policeTruck, 1, myWindow, true, false, false, true, false, false);

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

        // Esperar antes de detener la animación del camión de policía y borrar la ventana
        Thread.sleep(ANIMATION_DURATION - 500);
        policeTruckAnimation.stopAnimation();
        myWindow.erase();

        // Iniciar la presentación de imágenes de interruptores y borrar la ventana al finalizar
        switchesAnimation.startSlideshow();
        myWindow.erase();
    }
}
