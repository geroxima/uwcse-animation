package animation;
import java.awt.Image;

import essentials.*;
import uwcse.graphics.*;

public class GifImages {
    public static void play (GWindow myWindow) throws InterruptedException{
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

        String[] headGif = {
            "assets/gif/head/frame_0_delay-0.04s.png",
            "assets/gif/head/frame_1_delay-0.04s.png",
            "assets/gif/head/frame_2_delay-0.04s.png",
            "assets/gif/head/frame_3_delay-0.04s.png",
            "assets/gif/head/frame_4_delay-0.04s.png",
            "assets/gif/head/frame_5_delay-0.04s.png",
            "assets/gif/head/frame_6_delay-0.04s.png",
            "assets/gif/head/frame_7_delay-0.04s.png",
        };

        String[] armGif = {
            "assets/gif/arm/frame_00_delay-0.03s.png",
            "assets/gif/arm/frame_01_delay-0.03s.png",
            "assets/gif/arm/frame_02_delay-0.03s.png",
            "assets/gif/arm/frame_03_delay-0.03s.png",
            "assets/gif/arm/frame_04_delay-0.03s.png",
            "assets/gif/arm/frame_05_delay-0.03s.png",
            "assets/gif/arm/frame_06_delay-0.03s.png",
            "assets/gif/arm/frame_07_delay-0.03s.png",
            "assets/gif/arm/frame_08_delay-0.03s.png",
            "assets/gif/arm/frame_09_delay-0.03s.png",
            "assets/gif/arm/frame_10_delay-0.03s.png",
            "assets/gif/arm/frame_11_delay-0.03s.png",
            "assets/gif/arm/frame_12_delay-0.03s.png",
            "assets/gif/arm/frame_13_delay-0.03s.png",
            "assets/gif/arm/frame_14_delay-0.03s.png",
            "assets/gif/arm/frame_15_delay-0.03s.png",
            "assets/gif/arm/frame_16_delay-0.03s.png",
            "assets/gif/arm/frame_17_delay-0.03s.png",
            "assets/gif/arm/frame_18_delay-0.03s.png",
            "assets/gif/arm/frame_19_delay-0.03s.png",
            "assets/gif/arm/frame_20_delay-0.03s.png",
            "assets/gif/arm/frame_21_delay-0.03s.png",
            "assets/gif/arm/frame_22_delay-0.03s.png",
            "assets/gif/arm/frame_23_delay-0.03s.png",
            "assets/gif/arm/frame_24_delay-0.03s.png",
            "assets/gif/arm/frame_25_delay-0.03s.png",
            "assets/gif/arm/frame_26_delay-0.03s.png",
            "assets/gif/arm/frame_27_delay-0.03s.png",
            "assets/gif/arm/frame_28_delay-0.03s.png",
            "assets/gif/arm/frame_29_delay-0.03s.png",
            "assets/gif/arm/frame_30_delay-0.03s.png",
            "assets/gif/arm/frame_31_delay-0.03s.png",
            "assets/gif/arm/frame_32_delay-0.03s.png",
            "assets/gif/arm/frame_33_delay-0.03s.png",
            "assets/gif/arm/frame_34_delay-0.03s.png",
            "assets/gif/arm/frame_35_delay-0.03s.png",
            "assets/gif/arm/frame_36_delay-0.03s.png",
            "assets/gif/arm/frame_37_delay-0.03s.png",
            "assets/gif/arm/frame_38_delay-0.03s.png",
            "assets/gif/arm/frame_39_delay-0.03s.png",
            "assets/gif/arm/frame_40_delay-0.03s.png",
            "assets/gif/arm/frame_41_delay-0.03s.png",
            "assets/gif/arm/frame_42_delay-0.03s.png",
            "assets/gif/arm/frame_43_delay-0.03s.png",
            
        };

        String[] hackGIf = {
            "assets/gif/hack/frame_00_delay-0.04s.png",
            "assets/gif/hack/frame_01_delay-0.04s.png",
            "assets/gif/hack/frame_02_delay-0.04s.png",
            "assets/gif/hack/frame_03_delay-0.04s.png",
            "assets/gif/hack/frame_04_delay-0.04s.png",
            "assets/gif/hack/frame_05_delay-0.04s.png",
            "assets/gif/hack/frame_06_delay-0.04s.png",
            "assets/gif/hack/frame_07_delay-0.04s.png",
            "assets/gif/hack/frame_08_delay-0.04s.png",
            "assets/gif/hack/frame_09_delay-0.04s.png",
            "assets/gif/hack/frame_10_delay-0.04s.png",
            "assets/gif/hack/frame_11_delay-0.04s.png",
            "assets/gif/hack/frame_12_delay-0.04s.png",
            "assets/gif/hack/frame_13_delay-0.04s.png",
            "assets/gif/hack/frame_14_delay-0.04s.png",
            "assets/gif/hack/frame_15_delay-0.04s.png",
            "assets/gif/hack/frame_16_delay-0.04s.png",
            "assets/gif/hack/frame_17_delay-0.04s.png",
            "assets/gif/hack/frame_18_delay-0.04s.png",
            "assets/gif/hack/frame_19_delay-0.04s.png",
            "assets/gif/hack/frame_20_delay-0.04s.png",
            "assets/gif/hack/frame_21_delay-0.04s.png",
            "assets/gif/hack/frame_22_delay-0.04s.png",
            "assets/gif/hack/frame_23_delay-0.04s.png",
            "assets/gif/hack/frame_24_delay-0.04s.png",
            "assets/gif/hack/frame_25_delay-0.04s.png",
            "assets/gif/hack/frame_26_delay-0.04s.png",
            "assets/gif/hack/frame_27_delay-0.04s.png",
            "assets/gif/hack/frame_28_delay-0.04s.png",
            "assets/gif/hack/frame_29_delay-0.04s.png",
            "assets/gif/hack/frame_30_delay-0.04s.png",
            "assets/gif/hack/frame_31_delay-0.04s.png",
            "assets/gif/hack/frame_32_delay-0.04s.png",
      

        };

        ImageAnimator hands = new ImageAnimator(handsGif, 2, myWindow, false, false, true);
        ImageAnimator arm = new ImageAnimator(armGif, 1, myWindow, true, true, true);
        ImageAnimator head = new ImageAnimator(headGif, 1, myWindow, true, true, true);
        ImageAnimator hack = new ImageAnimator(hackGIf, 1, myWindow, true, true, true);

        hands.startSlideshow();
        head.startSlideshow();
        arm.startSlideshow();
        hack.startSlideshow();  
    }

    public static void main (String[] args) throws InterruptedException{
        GWindow myWindow = new GWindow("GifImages", 1024, 768);
        GifImages.play(myWindow);
        myWindow.setExitOnClose();
    }
}
