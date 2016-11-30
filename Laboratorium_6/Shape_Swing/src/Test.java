import java.awt.*;
import java.util.LinkedList;

/**
 * Created by Tomek on 27.11.2016.
 */
public class Test {
    public static void main(String[] args) {
        LinkedList<Shape> lista = new LinkedList<>();
        int y = 20;

        Square s = new Square("Tomek", Color.CYAN, 10, y);
        y += 60;
        Rectangle r = new Rectangle("Szymek", Color.yellow, 10, y);
        y += 60;
        Circle c = new Circle("Piotrek", Color.PINK, 10, y);
        y += 60;
        Triangle t = new Triangle("Lukasz", Color.green, 10, y);
        y += 60;

        lista.add(s);
        lista.add(r);
        lista.add(c);
        lista.add(t);

        s = new Square("Iza",Color.MAGENTA, 10, y);
        y += 60;
        r = new Rectangle("Marysia", Color.gray, 10, y);
        y += 60;
        c = new Circle("Karolina", Color.blue, 10, y);
        y += 60;
        t = new Triangle("Anka", Color.orange, 10, y);
        y += 60;

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