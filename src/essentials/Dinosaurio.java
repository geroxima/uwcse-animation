
package essentials;
import java.awt.Color;
import uwcse.graphics.GWindow;
import uwcse.graphics.Oval;
import uwcse.graphics.Rectangle;
import uwcse.graphics.Triangle;

/**
 * @author tania schulz
 */
public class Dinosaurio {
    
    /** Metodo constructor del dinosaurio
    * @param w Ventana donde se ubica el dinosaurio
    */
    public Dinosaurio(GWindow w){ 
        // Cabeza del dinosaurio
        cabeza = new Oval (800, 260, 160, 90, new Color(10, 120, 130), true);
        // Cuello del dinosaurio
        cuello = new Rectangle (900, 290, 55, 260, new Color(10, 120, 130), true);
        // Cuerpo del dinosaurio
        cuerpo = new Oval (900, 450, 420, 225, new Color(10, 120, 130), true);
        // Ojos del dinosaurio
        ojo1 = new Oval (875, 280, 20, 25, Color.BLACK, true);
        ojo2 = new Oval (850, 285, 15, 20, Color.BLACK, true);
        // Brillos de los ojos del dinosaurio
        bri1 = new Oval (880, 292, 8, 8, Color.WHITE, true);
        bri2 = new Oval (852, 292, 8, 8, Color.WHITE, true);
        //Mejillas del dinosaurio
        mej1 = new Oval (825, 305, 22, 15, Color.PINK, true);
        mej2 = new Oval (890, 310, 22, 15, Color.PINK, true);
        //Patas del dinosaurio
        pata1 = new Rectangle (970, 630, 55, 165, new Color(10, 120, 130), true);
        pata2 = new Rectangle (1035, 630, 55, 165, new Color(10, 120, 130), true);
        pata3 = new Rectangle (1140, 630, 55, 165, new Color(10, 120, 130), true);
        pata4 = new Rectangle (1205, 630, 55, 165, new Color(10, 120, 130), true);
    }

    /** Metodo que coloca al dinosaurio
    * @param w Ventana donde se ubica el dinosaurio
    */
    public void ponerDinosaurio (GWindow w){
        cuello.addTo(w);
        cabeza.addTo(w);
        ojo1.addTo(w);
        ojo2.addTo(w);
        bri1.addTo(w);
        bri2.addTo(w);
        mej1.addTo(w);
        mej2.addTo(w);
        pata1.addTo(w);
        pata2.addTo(w);
        pata3.addTo(w);
        pata4.addTo(w);
        cuerpo.addTo(w);
    }

    /** Metodo que mueve al dinosaurio hacia la izquierda
    * @param w Ventana donde se ubica el dinosaurio
    */
    public void moverIzquierda(GWindow w) {
        cabeza.moveTo(cabeza.getX() - 1, cabeza.getY());
        cuello.moveTo(cuello.getX() - 1, cuello.getY());
        ojo1.moveTo(ojo1.getX() - 1, ojo1.getY());
        ojo2.moveTo(ojo2.getX() - 1, ojo2.getY());
        bri1.moveTo(bri1.getX() - 1, bri1.getY());
        bri2.moveTo(bri2.getX() - 1, bri2.getY());
        mej1.moveTo(mej1.getX() - 1, mej1.getY());
        mej2.moveTo(mej2.getX() - 1, mej2.getY());
        pata1.moveTo(pata1.getX() - 1, pata1.getY());
        pata2.moveTo(pata2.getX() - 1, pata2.getY());
        pata3.moveTo(pata3.getX() - 1, pata3.getY());
        pata4.moveTo(pata4.getX() - 1, pata4.getY());
        cuerpo.moveTo(cuerpo.getX() - 1, cuerpo.getY());
    }

    /** Metodo que mueve al dinosaurio hacia arriba
    * @param w Ventana donde se ubica el dinosaurio
    */
    public void moverArriba(GWindow w) {
        cabeza.moveTo(cabeza.getX(), cabeza.getY() - 1);
        cuello.moveTo(cuello.getX(), cuello.getY() - 1);
        ojo1.moveTo(ojo1.getX(), ojo1.getY() - 1);
        ojo2.moveTo(ojo2.getX(), ojo2.getY() - 1);
        bri1.moveTo(bri1.getX(), bri1.getY() - 1);
        bri2.moveTo(bri2.getX(), bri2.getY() - 1);
        mej1.moveTo(mej1.getX(), mej1.getY() - 1);
        mej2.moveTo(mej2.getX(), mej2.getY() - 1);
        pata1.moveTo(pata1.getX(), pata1.getY() - 1);
        pata2.moveTo(pata2.getX(), pata2.getY() - 1);
        pata3.moveTo(pata3.getX(), pata3.getY() - 1);
        pata4.moveTo(pata4.getX(), pata4.getY() - 1);
        cuerpo.moveTo(cuerpo.getX(), cuerpo.getY() - 1);
    }

//Variables de instancia
private final Oval cabeza;
private final Rectangle cuello;
private final Oval cuerpo;
private final Oval ojo1;
private final Oval ojo2;
private final Oval mej1;
private final Oval mej2;
private final Rectangle pata1;
private final Rectangle pata2;
private final Rectangle pata3;
private final Rectangle pata4;
private final Oval bri1;
private final Oval bri2;
//new Color (0, 155, 150, 1)
}
