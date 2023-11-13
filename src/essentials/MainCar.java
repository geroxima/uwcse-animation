package essentials;

import uwcse.graphics.*;
import java.awt.Color;

public class MainCar {
    private Polygon body;
    private Oval wheel1;
    private Oval wheel2;
    private Line window1;
    private Line window2;
    private Line window3;

    public MainCar(GWindow w, int x, int y) {
        // Crea un polígono que representa el cuerpo del auto (Rectángulo)
        body = new Polygon();
        body.addPoint(x, y);
        body.addPoint(x + 50, y - 50);
        body.addPoint(x + 300, y - 200);
        body.addPoint(x + 50, y - 200);
        body.setColor(Color.RED); // Asigna un color al cuerpo del auto
        // Agrega todas las partes al GWindow
        addPartsToWindow(w);
    }

    public void addPartsToWindow(GWindow w) {
        body.addTo(w);
    }
}
