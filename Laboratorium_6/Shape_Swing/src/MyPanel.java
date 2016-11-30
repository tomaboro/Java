import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.*;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.swing.*;

/**
 * Created by Tomek on 27.11.2016.
 */

public class MyPanel extends JPanel implements MouseListener {

    LinkedList<Shape> lista;
    boolean clicked = false;
    int tmp;

    public MyPanel(LinkedList<Shape> _lista) {
        setPreferredSize(new Dimension(400, 400));
        addMouseListener(this);
        lista = _lista;
    };

    public void mouseClicked(MouseEvent event){
        /*if(!clicked) {
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).isPressed(event.getX(), event.getY())) {
                    tmp = i;
                    clicked = true;
                    lista.get(tmp).x = event.getX();
                    lista.get(tmp).y = event.getY();
                    break;
                }
            }
        }
        else{
            if(tmp != -1) {
                lista.get(tmp).x = event.getX();
                lista.get(tmp).y = event.getY();
                tmp = -1;
            }
            clicked = false;
            repaint();
        }*/
        }

    @Override
    protected void paintComponent(Graphics g) {

        g.clearRect (0, 0, this.getWidth(), this.getHeight());
        g.drawString("FIGURE:",10,15);
        g.drawString("NAME:",100,15);

        for(int i=0; i<lista.size(); i++) {
            lista.get(i).draw(g);
            g.drawString(lista.get(i).name,lista.get(i).x + 100,lista.get(i).y+30);;
        }

        setPreferredSize(new Dimension(400,1000));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println();
    }

    @Override
    public void mousePressed(MouseEvent event) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).isPressed(event.getX(), event.getY())) {
                lista.get(i).x = event.getX();
                lista.get(i).y = event.getY();
                break;
            }
        }
        repaint();
        System.out.println((tmp++) + ": mousePressed");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("mouseEntered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("mouseExited");
    }
}
