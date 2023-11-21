package animation;
import java.awt.Color;
import java.awt.Rectangle;
import java.io.IOException;

import essentials.ImageDisplay;
import essentials.SoundPlayer;
import uwcse.graphics.GWindow;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Create a GWindow
        GWindow myWindow = new GWindow("Image Window", 1024, 768);
        SoundPlayer soundPlayer = new SoundPlayer("assets/sounds/Rubadub.wav");
        Intro intro = new Intro();
        FirstScene firstScene = new FirstScene();
        CarInterior interior = new CarInterior();
        GifImages flashyImages = new GifImages();
        PoliceCar policeCar = new PoliceCar();
        Chase chase = new Chase();
        ImageDisplay credits = new ImageDisplay("assets/credits.png", 0, 0);
        
        myWindow.setExitOnClose();
        soundPlayer.play();
        intro.play(myWindow);
        firstScene.play(myWindow);
        interior.play(myWindow);
        Thread.sleep(4000);
        flashyImages.play(myWindow);
        policeCar.play(myWindow);
        chase.play(myWindow);
        credits.addTo(myWindow);
    }
}
