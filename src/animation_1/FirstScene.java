package animation;

import java.io.IOException;

import essentials.ImageAnimator;
import essentials.ImageDisplay;
import uwcse.graphics.GWindow;

/*
 * Esta clase representa la primera escena de la animación en la que se muestra el auto principal.
 */
public class FirstScene {
    /*
     * Este metodo reproduce la primera escena de la animación.
     */
    public void play (GWindow myWindow) throws IOException, InterruptedException {
        // Rutas de los archivos de imagen
        String[] mainCarFrames = {
            "assets/gif/mainCar/frame_0_delay-0.1s.png",
            "assets/gif/mainCar/frame_1_delay-0.1s.png",
            "assets/gif/mainCar/frame_2_delay-0.1s.png",
        };
        // Inicializar el objeto mainCar
        ImageAnimator mainCar = new ImageAnimator(mainCarFrames, 15, myWindow, true, false, false, true, false, false);

        ImageDisplay streets = new ImageDisplay("assets/foreground-tileset.png", 0, 0);
        ImageDisplay background = new ImageDisplay("assets/city/city 8/7.png", 0, 0);

        ImageDisplay midground = new ImageDisplay("assets/city/city 7/5.png", 0, 100);
        
        background.setWidthToWindow(myWindow);
        background.addTo(myWindow);

        midground.setWidthToWindow(myWindow);
        midground.addTo(myWindow);
        
        streets.alignToBottom(myWindow);
        streets.addTo(myWindow);

        new Thread(() -> {
            streets.moveTo(-streets.getWidth(), streets.getY(), 4000);
        }).start();

        new Thread(() -> {
            mainCar.startAnimation();
        }).start();

        Thread.sleep(3500);

        mainCar.stopAnimation();

        myWindow.erase();
    }
}