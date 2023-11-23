package animation;
import java.io.IOException;
import essentials.*;
import uwcse.graphics.*;

/*
 * Esta clase representa la secuencia de animaciones de la patrulla de policia.
 */

public class PoliceCar {
    /*
     * Este metodo reproduce la secuencia de animaciones de la patrulla de policia.
     */
    public void play (GWindow myWindow) throws IOException, InterruptedException {
        // Duración de la animación en milisegundos00
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

        ImageDisplay streets = new ImageDisplay("assets/foreground-tileset.png", 0, 0);
        ImageDisplay background = new ImageDisplay("assets/city/city 8/7.png", 0, 0);
        ImageDisplay midground = new ImageDisplay("assets/city/city 7/5.png", 0, 100);

        ImageAnimator switchesAnimation = new ImageAnimator(switches, 1, myWindow, true, false, false, false, true, true);

        ImageAnimator policeTruckAnimation = new ImageAnimator(policeTruck, 1, myWindow, true, false, false, true, false, false);

        background.setWidthToWindow(myWindow);
        background.addTo(myWindow);

        midground.setWidthToWindow(myWindow);
        midground.addTo(myWindow);

        streets.alignToBottom(myWindow);
        streets.addTo(myWindow);

        new Thread(() -> {
            streets.moveTo(-streets.getWidth(), streets.getY(), ANIMATION_DURATION);
        }).start();

        new Thread(() -> {
            policeTruckAnimation.startAnimation();
        }).start();
        
        Thread.sleep(ANIMATION_DURATION-500);
        policeTruckAnimation.stopAnimation();
        myWindow.erase();

        switchesAnimation.startSlideshow();
        myWindow.erase();
    }
}