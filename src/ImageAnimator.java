import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.Timer;
import uwcse.graphics.GWindow;
import java.awt.event.ActionListener;

public class ImageAnimator {
    private ImageDisplay[] imageDisplays;
    private int currentIndex;
    private GWindow myWindow;
    private Timer timer;
    private int frameDelay; // Delay in milliseconds between frames

    public ImageAnimator(ImageDisplay[] imageDisplays, GWindow myWindow, int frameDelay) {
        this.imageDisplays = imageDisplays;
        this.currentIndex = 0;
        this.myWindow = myWindow;
        this.frameDelay = frameDelay;

        // Create a timer to schedule the display of images
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                displayNextImage();
            }
        };
        timer = new Timer(this.frameDelay, taskPerformer);
    }

    // Method to start the animation
    public void startAnimation() {
        // Start the timer
        timer.start();
    }

    // Method to stop the animation
    public void stopAnimation() {
        // Stop the timer
        timer.stop();
    }

    // Method to display the next image in the array
    private void displayNextImage() {
        if (currentIndex < imageDisplays.length) {
            // Clear the window
            myWindow.erase();
            imageDisplays[currentIndex].setWidthToWindow(myWindow);
            // Add the current image to the window
            imageDisplays[currentIndex].addTo(myWindow);
            // Increment the index for the next image
            currentIndex++;

            // If there are more images, schedule the display of the next one
            if (currentIndex < imageDisplays.length) {
                timer.setInitialDelay(frameDelay);
                timer.restart();
            }
        } else {
            // If all images have been displayed, stop the animation
            stopAnimation();
        }
    }

    public static void main(String[] args) {
        try {
            // Assuming the images are in the "resources" folder inside your project
            String[] imageNames = {
                "assets/neocity/frame_00_delay-0.15s.png",
                "assets/neocity/frame_01_delay-0.15s.png",
                "assets/neocity/frame_02_delay-0.15s.png",
                "assets/neocity/frame_03_delay-0.15s.png",
                "assets/neocity/frame_04_delay-0.15s.png",
                "assets/neocity/frame_05_delay-0.15s.png",
                "assets/neocity/frame_06_delay-0.15s.png",
                "assets/neocity/frame_07_delay-0.15s.png",
                "assets/neocity/frame_08_delay-0.15s.png",
                "assets/neocity/frame_09_delay-0.15s.png",
                "assets/neocity/frame_10_delay-0.15s.png",
                "assets/neocity/frame_11_delay-0.15s.png",
                "assets/neocity/frame_12_delay-0.15s.png",
                "assets/neocity/frame_13_delay-0.15s.png",
                "assets/neocity/frame_14_delay-0.15s.png",
                "assets/neocity/frame_15_delay-0.15s.png",
                "assets/neocity/frame_16_delay-0.15s.png",
                "assets/neocity/frame_17_delay-0.15s.png",
                "assets/neocity/frame_18_delay-0.15s.png",
                "assets/neocity/frame_19_delay-0.15s.png",
                "assets/neocity/frame_20_delay-0.15s.png",
                "assets/neocity/frame_21_delay-0.15s.png",
                "assets/neocity/frame_22_delay-0.15s.png",
                "assets/neocity/frame_23_delay-0.15s.png",
                "assets/neocity/frame_24_delay-0.15s.png",
                "assets/neocity/frame_25_delay-0.15s.png",
                "assets/neocity/frame_26_delay-0.15s.png",
                "assets/neocity/frame_27_delay-0.15s.png",
                "assets/neocity/frame_28_delay-0.15s.png",
                "assets/neocity/frame_29_delay-0.15s.png",
                "assets/neocity/frame_30_delay-0.15s.png",
                "assets/neocity/frame_31_delay-0.15s.png",
                "assets/neocity/frame_32_delay-0.15s.png",
                "assets/neocity/frame_33_delay-0.15s.png",
                "assets/neocity/frame_34_delay-0.15s.png",
                "assets/neocity/frame_35_delay-0.15s.png",
                "assets/neocity/frame_36_delay-0.15s.png",
                "assets/neocity/frame_37_delay-0.15s.png",
                "assets/neocity/frame_38_delay-0.15s.png",
                "assets/neocity/frame_39_delay-0.15s.png",
                "assets/neocity/frame_40_delay-0.15s.png",
                "assets/neocity/frame_41_delay-0.15s.png"
            };
            
            String[] numbers = {
                "assets/number_one.png", 
                "assets/number_two.png", 
                "assets/number_three.png", 
                "assets/number_four.png"};
            
                // Create a GWindow
                GWindow myWindow = new GWindow("Image Animation", 500, 500);
                int frameDelay = 15;

                String soundFilePath = "assets/sounds/Rubadub.wav"; // Replace with the path to your sound file
                SoundPlayer soundPlayer = new SoundPlayer(soundFilePath);

                // Play the sound
                soundPlayer.play();
            
                while (true) {
                    ImageDisplay[] imageDisplays = new ImageDisplay[numbers.length];
                    for (int i = 0; i < numbers.length; i++) {
                        imageDisplays[i] = new ImageDisplay(numbers[i], 0, 0);
                    }
            
                    // Create an ImageAnimator with the array of ImageDisplays and the GWindow
                    ImageAnimator imageAnimator = new ImageAnimator(imageDisplays, myWindow, frameDelay);
            
                    // Start the animation
                    imageAnimator.startAnimation();
            
                    // Wait for the animation to finish
                    while (imageAnimator.currentIndex < imageDisplays.length) {
                        try {
                            Thread.sleep(150); // Adjust the sleep time if needed
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                       
                    }
                    myWindow.setExitOnClose();                    
                    // Reset currentIndex to start the animation from the beginning
                    imageAnimator.currentIndex = 0;
                }
                
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
