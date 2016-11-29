import java.awt.*;
import java.util.LinkedList;

/**
 * Created by Tomek on 27.11.2016.
 */
public class Test {
    public static void main(String[] args) {
        LinkedList<Shape> lista = new LinkedList<>();

        Square s = new Square("Tomek", Color.CYAN);
        Rectangle r = new Rectangle("Szymek", Color.yellow);
        Circle c = new Circle("Piotrek", Color.PINK);
        Triangle t = new Triangle("Lukasz", Color.green);

        lista.add(s);
        lista.add(r);
        lista.add(c);
        lista.add(t);

        s = new Square("Iza",Color.MAGENTA);
        r = new Rectangle("Marysia", Color.gray);
        c = new Circle("Karolina", Color.blue);
        t = new Triangle("Anka", Color.orange);

        lista.add(s);
        lista.add(t);
        lista.add(r);
        lista.add(c);

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyFrame(lista);
            }
        });
    }
}