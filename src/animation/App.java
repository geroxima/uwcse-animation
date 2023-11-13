package animation;
import essentials.SoundPlayer;
import uwcse.graphics.GWindow;

public class App {
    public static void main(String[] args) {
        // Create a GWindow
        GWindow myWindow = new GWindow("Image Window", 1024, 768);

        try {
            // Reproduce la intro
            Intro.play(myWindow);
            SoundPlayer soundPlayer = new SoundPlayer("assets/sounds/Rubadub.wav");
            
            // Reproduce la canción
            soundPlayer.play();


            myWindow.setExitOnClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
