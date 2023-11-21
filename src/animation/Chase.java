package animation;

import java.io.IOException;

import essentials.ImageAnimator;
import essentials.ImageDisplay;
import uwcse.graphics.GWindow;

public class Chase {
    public void play(GWindow myWindow) throws InterruptedException, IOException {
        final int ANIMATION_DURATION = 4000;

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
        // Inicializar el objeto mainCar
        ImageAnimator mainCar = new ImageAnimator(mainCarFrames, 15, myWindow, true, false, true, false, false, false);

        ImageDisplay streets = new ImageDisplay("assets/foreground-tileset.png", 0, 0);
        ImageDisplay background = new ImageDisplay("assets/city/city 8/7.png", 0, 0);
        ImageDisplay midground = new ImageDisplay("assets/city/city 7/5.png", 0, 100);

       

        ImageAnimator policeTruckAnimation = new ImageAnimator(policeTruck, 0, myWindow, true, true, false, false, false, false);

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

        new Thread(() -> {
            mainCar.startAnimation();
        }).start();
        
        Thread.sleep(ANIMATION_DURATION-500);
        policeTruckAnimation.stopAnimation();
        mainCar.stopAnimation();
        myWindow.erase();   
    }
}
