import uwcse.graphics.*;
import java.awt.Font;
import java.awt.*;

public class App{
    public static void main(String[] args){
        Font newFont = new Font("Cascadia Code PL", Font.BOLD, 20);
        GWindow window = new GWindow("Hello World", 300, 300);
        window.setExitOnClose();
        Oval oval = new Oval(50, 50, 100, 100, java.awt.Color.RED, false);
        
        Oval oval2 = new Oval(10, 50, 100, 100, java.awt.Color.CYAN, true);
        Oval oval3 = new Oval(90, 50, 100, 100, java.awt.Color.BLUE, false);
        window.add(oval2);
        window.add(oval); window.add(oval3);
        TextShape text = new TextShape("Hello, World!", 50, 100, java.awt.Color.BLUE);
        text.setFont(newFont);
        window.add(text);
        // Define the coordinates of the triangle's three vertices
        int x1 = 400;
        int y1 = 100;
        int x2 = 200;
        int y2 = 100;
        int x3 = 150;
        int y3 = 200;

        // Create a new triangle with custom vertices, color, and fill
        Triangle triangle = new Triangle(x1, y1, x2, y2, x3, y3, java.awt.Color.RED, true);

        // Add the triangle to the GWindow to display it
        triangle.addTo(window);
        
    }   
}
