import uwcse.graphics.GWindow;

public class App {
    public static void main(String[] args) {
        // Create a GWindow
        GWindow myWindow = new GWindow("Image Window", 1024, 768);

        try {
            // Call the play method from the Intro class
            Intro.play(myWindow);
            SoundPlayer soundPlayer = new SoundPlayer("assets/sounds/Rubadub.wav");
            soundPlayer.play();





            myWindow.setExitOnClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
