package animation;
import essentials.SoundPlayer;
import uwcse.graphics.GWindow;

public class App {
    public static void main(String[] args) {
        // Create a GWindow
        GWindow myWindow = new GWindow("Image Window", 1024, 768);
        SoundPlayer soundPlayer = new SoundPlayer("assets/sounds/Rubadub.wav");
            
            // Reproduce la canción
            

        try {
            myWindow.setExitOnClose();
            soundPlayer.play();
            // Reproduce la intro
            Intro.play(myWindow);
            FirstScene.play(myWindow);
            myWindow.erase();
            CarInterior.play(myWindow);
            myWindow.erase();
            GifImages.play(myWindow);

            
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
