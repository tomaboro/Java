import java.awt.*;
import java.awt.geom.*;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.swing.*;

/**
 * Created by Tomek on 27.11.2016.
 */

public class MyPanel extends JPanel {

    LinkedList<Shape> lista;

    public MyPanel(LinkedList<Shape> _lista) {
        setPreferredSize(new Dimension(400, 400));
        lista = _lista;
    };

    @Override
    protected void paintComponent(Graphics g) {
        int y = 20;

        g.clearRect (0, 0, this.getWidth(), this.getHeight());
        g.drawString("FIGURE:",10,15);
        g.drawString("NAME:",100,15);

        for(int i=0; i<lista.size(); i++) {
            lista.get(i).draw(g,y);
            g.drawString(lista.get(i).name,100,y+30);
            y += 60;
        }

        setPreferredSize(new Dimension(400,y));
    }
}
