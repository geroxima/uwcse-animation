package animation;

import java.io.IOException;
import essentials.ImageAnimator;
import essentials.ImageDisplay;
import uwcse.graphics.GWindow;

/**
 * Esta clase representa la primera escena de la animación en la que se muestra el auto principal.
 */
public class FirstScene {
    
    /**
     * Reproduce la primera escena de la animación.
     * 
     * @param myWindow La ventana en la que se mostrará la animación.
     * @throws IOException Si ocurre un error al cargar la imagen.
     * @throws InterruptedException Si se interrumpe la ejecución del hilo durante la animación.
     */
    public void play(GWindow myWindow) throws IOException, InterruptedException {
        // Rutas de los archivos de imagen
        String[] mainCarFrames = {
            "assets/gif/mainCar/frame_0_delay-0.1s.png",
            "assets/gif/mainCar/frame_1_delay-0.1s.png",
            "assets/gif/mainCar/frame_2_delay-0.1s.png",
        };
        
        // Inicializar el objeto mainCar
        ImageAnimator mainCar = new ImageAnimator(mainCarFrames, 15, myWindow, true, false, false, true, false, false);

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
            streets.moveTo(-streets.getWidth(), streets.getY(), 4000);
        }).start();

        // Iniciar la animación del coche principal en un hilo separado
        new Thread(() -> {
            mainCar.startAnimation();
        }).start();

        // Esperar antes de detener la animación y borrar la ventana
        Thread.sleep(3500);

        mainCar.stopAnimation();

        myWindow.erase();
    }
}