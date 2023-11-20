package animation;

import java.awt.Color;

import uwcse.graphics.*;

public class CarInterior {
    private static uwcse.graphics.Polygon windshield;
    private static uwcse.graphics.Polygon sideWindow1;
    private static uwcse.graphics.Polygon sideWindow2;
    private static uwcse.graphics.Polygon mainPanel;
    private static uwcse.graphics.Polygon sidePanel;
    private static uwcse.graphics.Polygon steeringWheel;

    private static uwcse.graphics.Polygon keyboard;

    private static Rectangle bar1;
    private static Rectangle bar2;
    private static Rectangle bar3;

    private static boolean isAnimatingBars = false;


    public static void animateBars() throws InterruptedException {
        int animationDuration = 5; // Duración de cada paso de la animación en milisegundos
        isAnimatingBars = true;

        while (isAnimatingBars) {
            // Aumentar el tamaño de las barras
            for (int i = 0; i < 75; i++) {
                animateBar(bar1, 0, -2, 50, 200 + i);
                animateBar(bar2, 0, -3, 50, 150 + i);
                animateBar(bar3, 0, -4, 50, 300 + i);
                Thread.sleep(animationDuration);
            }

            // Reducir el tamaño de las barras (ping-pong)
            for (int i = 75; i >= 0; i--) {
                animateBar(bar1, 0, 2, 50, 200 + i);
                animateBar(bar2, 0, 3, 50, 150 + i);
                animateBar(bar3, 0, 4, 50, 300 + i);
                Thread.sleep(animationDuration);
            }
        }
    }

    public static void stopAnimatingBars() {
        isAnimatingBars = false;
    }

    private static void animateBar(Rectangle bar, int deltaX, int deltaY, int newWidth, int newHeight) {
        // Mover y cambiar el tamaño de la barra

        bar.moveBy(deltaX, deltaY);
        bar.resize(newWidth, newHeight);
    }

    public static void play(GWindow myWindow) throws InterruptedException {
        Rectangle background = new Rectangle(
                0, 0,
                myWindow.getWindowWidth(), myWindow.getWindowHeight(),
                new Color(43, 0, 0), true
        );

        // Crear el objeto windshield (parabrisas)
        windshield = new uwcse.graphics.Polygon();
        windshield.setColor(new Color(128, 0, 0)); // Establecer el color del parabrisas
        // Añadir vértices al parabrisas
        windshield.addPoint(0, 0);
        windshield.addPoint(1024, 0);
        windshield.addPoint(850, 350);
        windshield.addPoint(200, 350);

        // Crear el objeto sideWindow1 (ventana lateral 1)
        sideWindow1 = new uwcse.graphics.Polygon();
        sideWindow1.setColor(new Color(255, 85, 85)); // Establecer el color de la ventana lateral
        // Añadir vértices a sideWindow1
        sideWindow1.addPoint(0, 78);
        sideWindow1.addPoint(150, 350);
        sideWindow1.addPoint(0, 428);

        // Crear el objeto sideWindow2 (ventana lateral 2)
        sideWindow2 = new uwcse.graphics.Polygon();
        sideWindow2.setColor(new Color(255, 85, 85)); // Establecer el color de la ventana lateral
        // Añadir vértices a sideWindow2
        sideWindow2.addPoint(1024, 78);
        sideWindow2.addPoint(1024, 428);
        sideWindow2.addPoint(900, 350);

        // Crear el objeto mainPanel
        mainPanel = new uwcse.graphics.Polygon();
        mainPanel.setColor(new Color(36, 28, 28)); // Establecer el color del panel principal
        // Añadir vértices al mainPanel
        mainPanel.addPoint(0, 480);
        mainPanel.addPoint(200, 385);
        mainPanel.addPoint(850, 385);
        mainPanel.addPoint(1024, 480);
        mainPanel.addPoint(1024, 600);
        mainPanel.addPoint(610, 600);
        mainPanel.addPoint(590, 630);
        mainPanel.addPoint(630, 780);
        mainPanel.addPoint(400, 775);
        mainPanel.addPoint(450, 630);
        mainPanel.addPoint(440, 600);
        mainPanel.addPoint(0, 600);

        // Crear barras de información
        Color barColor = new Color(212, 0, 0);
        bar1 = new Rectangle(50, 400, 50, 50, barColor, true);
        bar2 = new Rectangle(125, 450, 50, 100, barColor, true);
        bar3 = new Rectangle(200, 300, 50, 250, barColor, true);

        steeringWheel = new uwcse.graphics.Polygon();
        steeringWheel.setColor(new Color(72, 62, 55));
        // Añadir vértices al steeringWheel
        steeringWheel.addPoint(16, 486); //1
        steeringWheel.addPoint(51, 445); //2
        steeringWheel.addPoint(100, 460);  //3
        steeringWheel.addPoint(82, 486); // 4
        steeringWheel.addPoint(314, 486); // 5
        steeringWheel.addPoint(300, 460); //6
        steeringWheel.addPoint(323, 445); //7
        steeringWheel.addPoint(370, 486); //8
        steeringWheel.addPoint(370, 632); //9
        steeringWheel.addPoint(307, 680); //10
        steeringWheel.addPoint(290, 650); //11
        steeringWheel.addPoint(314, 590); //12
        steeringWheel.addPoint(75, 590); //13
        steeringWheel.addPoint(115, 650); //14
        steeringWheel.addPoint(100, 680); //15
        steeringWheel.addPoint(20, 632); //16

        //Teclado del panel
        keyboard = new uwcse.graphics.Polygon();
        keyboard.setColor(new Color(170, 170, 255));
        keyboard.addPoint(300, 522);
        keyboard.addPoint(370, 400);
        keyboard.addPoint(755, 400);
        keyboard.addPoint(825, 522);


        
        // Añadir el fondo a la ventana
        myWindow.add(background);

        // Añadir el parabrisas a la ventana
        windshield.addTo(myWindow);

        // Añadir las ventanas laterales a la ventana
        sideWindow1.addTo(myWindow);
        sideWindow2.addTo(myWindow);

        // Añadir el panel principal a la ventana
        mainPanel.addTo(myWindow);

        // Añadir el teclado a la ventana
        myWindow.add(keyboard);

        // Añadir las barras a la ventana
        bar1.addTo(myWindow);
        bar2.addTo(myWindow);
        bar3.addTo(myWindow);

        // Añadir el volante a la ventana
        steeringWheel.addTo(myWindow);

        // Crear el objeto sidePanel
        sidePanel = new uwcse.graphics.Polygon();
        sidePanel.setColor(new Color(255, 42, 42)); // Establecer el color del panel lateral
        // Añadir vértices al sidePanel
        sidePanel.addPoint(825, 300);
        sidePanel.addPoint(1024, 230);
        sidePanel.addPoint(1024, 610);
        sidePanel.addPoint(825, 488);

        // Añadir el sidePanel a la ventana
        sidePanel.addTo(myWindow);
        
        
        new Thread(() -> {
            try {
                animateBars();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        
        new Thread(() -> {
            try {
                Thread.sleep(4000);
                stopAnimatingBars();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }).start();   
        


        
    }

    public static void main(String[] args) {
        GWindow myWindow = new GWindow("Image Window", 1024, 768);
        try {

            CarInterior.play(myWindow);
            myWindow.setExitOnClose();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
