import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.*;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.swing.*;

/**
 * Created by Tomek on 27.11.2016.
 */

public class MyPanel extends JPanel implements MouseListener, MouseMotionListener {

    private LinkedList<Shape> lista;
    private boolean clicked = false;
    private int tmp;
    private int tmp_x;
    private int tmp_y;

    public MyPanel(LinkedList<Shape> _lista) {
        setPreferredSize(new Dimension(400, 400));
        addMouseListener(this);
        addMouseMotionListener(this);
        lista = _lista;
    };

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

    public void mouseDragged(MouseEvent event){

        if(!clicked) {
            tmp = -1;
            for (int i = lista.size()-1; i > -1; i--) {
                if (lista.get(i).isPressed(event.getX(), event.getY())) {
                    tmp_x = event.getX() - lista.get(i).x ;
                    tmp_y = event.getY() - lista.get(i).y;
                    tmp = i;
                    clicked = true;
                    break;
                }
            }
        }
        else if(clicked && tmp != -1){
            lista.get(tmp).moveShape(event.getX()-tmp_x,event.getY()-tmp_y);
        }

        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        clicked = false;
        tmp = -1;
    }

    @Override
    public void mouseClicked(MouseEvent event){
    }

    @Override
    public void mousePressed(MouseEvent event) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e){}
}
