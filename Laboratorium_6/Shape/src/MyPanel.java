import java.awt.*;
import java.awt.geom.*;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.swing.*;

/**
 * Created by Tomek on 27.11.2016.
 */

public class MyPanel extends JPanel {
    LinkedList<Shape> lista = new LinkedList<Shape>();
    public MyPanel() {
        setPreferredSize(new Dimension(400, 400));
    }

    @Override
    protected void paintComponent(Graphics g) {
        //setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
        int y = 20;

        Square s = new Square("Tomek");
        Rectangle r = new Rectangle("Szymek");
        Circle c = new Circle("Piotrek");
        Triangle t = new Triangle("Lukasz");

        lista.add(s);
        lista.add(r);
        lista.add(c);
        lista.add(t);

        s = new Square("Iza");
        r = new Rectangle("Marysia");
        c = new Circle("Karolina");
        t = new Triangle("Anka");

        lista.add(s);
        lista.add(t);
        lista.add(r);
        lista.add(c);

        g.drawString("DRAW:",10,15);
        g.drawString("NAME:",100,15);

        for(int i=0; i<lista.size(); i++) {
            g.setColor(Color.RED);
            lista.get(i).draw(g,y);
            g.setColor(Color.BLUE);
            g.drawString(lista.get(i).name,100,y+30);
            y += 60;
        }

    }
}
