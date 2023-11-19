package animation;
import java.awt.Image;

import essentials.*;
import uwcse.graphics.*;

public class GifImages {
    public static void play (GWindow myWindow){
        String[] handsGif = {
            "assets/gif/hands/frame_00_delay-0.04s.png",
            "assets/gif/hands/frame_01_delay-0.04s.png",
            "assets/gif/hands/frame_02_delay-0.04s.png",
            "assets/gif/hands/frame_03_delay-0.04s.png",
            "assets/gif/hands/frame_04_delay-0.04s.png",
            "assets/gif/hands/frame_05_delay-0.04s.png",
            "assets/gif/hands/frame_06_delay-0.04s.png",
            "assets/gif/hands/frame_07_delay-0.04s.png",
            "assets/gif/hands/frame_08_delay-0.04s.png",
            "assets/gif/hands/frame_09_delay-0.04s.png",
            "assets/gif/hands/frame_10_delay-0.04s.png",
            "assets/gif/hands/frame_11_delay-0.04s.png",
            "assets/gif/hands/frame_12_delay-0.04s.png",
            "assets/gif/hands/frame_13_delay-0.04s.png",
            "assets/gif/hands/frame_14_delay-0.04s.png",
            "assets/gif/hands/frame_15_delay-0.04s.png",
            "assets/gif/hands/frame_16_delay-0.04s.png",
            "assets/gif/hands/frame_17_delay-0.04s.png",
            "assets/gif/hands/frame_18_delay-0.04s.png",
            "assets/gif/hands/frame_19_delay-0.04s.png",
            "assets/gif/hands/frame_20_delay-0.04s.png",
            "assets/gif/hands/frame_21_delay-0.04s.png",
            "assets/gif/hands/frame_22_delay-0.04s.png",
            "assets/gif/hands/frame_23_delay-0.04s.png",
            "assets/gif/hands/frame_24_delay-0.04s.png",
            "assets/gif/hands/frame_25_delay-0.04s.png",
            "assets/gif/hands/frame_26_delay-0.04s.png",
            "assets/gif/hands/frame_27_delay-0.04s.png",
            "assets/gif/hands/frame_28_delay-0.04s.png",
            "assets/gif/hands/frame_29_delay-0.04s.png"
        };

        String[] spaceGif = {
            "assets/gif/space/frame_00_delay-0.04s.png",
            "assets/gif/space/frame_01_delay-0.04s.png",
            "assets/gif/space/frame_02_delay-0.04s.png",
            "assets/gif/space/frame_03_delay-0.04s.png",
            "assets/gif/space/frame_04_delay-0.04s.png",
            "assets/gif/space/frame_05_delay-0.04s.png",
            "assets/gif/space/frame_06_delay-0.04s.png",
            "assets/gif/space/frame_07_delay-0.04s.png",
            "assets/gif/space/frame_08_delay-0.04s.png",
            "assets/gif/space/frame_09_delay-0.04s.png",
            "assets/gif/space/frame_10_delay-0.04s.png",
            "assets/gif/space/frame_11_delay-0.04s.png",
            "assets/gif/space/frame_12_delay-0.04s.png",
            "assets/gif/space/frame_13_delay-0.04s.png",
            "assets/gif/space/frame_14_delay-0.04s.png",
            "assets/gif/space/frame_15_delay-0.04s.png",
            "assets/gif/space/frame_16_delay-0.04s.png",
            "assets/gif/space/frame_17_delay-0.04s.png",
            "assets/gif/space/frame_18_delay-0.04s.png",
            "assets/gif/space/frame_19_delay-0.04s.png",
            "assets/gif/space/frame_20_delay-0.04s.png",
            "assets/gif/space/frame_21_delay-0.04s.png",
            "assets/gif/space/frame_22_delay-0.04s.png",
        };


        ImageAnimator hands = new ImageAnimator(handsGif, 4, myWindow, false, false);
        ImageAnimator space = new ImageAnimator(spaceGif, 1, myWindow, true, false);

        new Thread(() -> {
            space.startAnimation();
        }).start();

        new Thread(() -> {
            hands.startAnimation();
        }).start();

        
        

    }




    public static void main (String[] args){
        GWindow myWindow = new GWindow("GifImages", 1024, 768);
        GifImages.play(myWindow);
    }
}
