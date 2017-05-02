import java.awt.*;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

/**
 * Created by Tomek on 04.01.2017.
 */
public class Rysuj extends JPanel {
    private Pole mapa;

    public Rysuj(Pole mapa) {
        setSize(new Dimension(650,650));
        mapa.robot.getX();
        this.mapa = mapa;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        Rectangle2D rectangle = new Rectangle2D.Double(mapa.robot.getX()*10, mapa.robot.getY()*10, 10, 10);
        g2d.setColor(Color.green);
        g2d.fill(rectangle);
        g2d.draw(rectangle);

        for(int i=0; i<mapa.stacje.size(); i++){
            Rectangle2D rectangle1 = new Rectangle2D.Double(mapa.stacje.get(i).getX()*10, mapa.stacje.get(i).getY()*10, 10, 10);
            g2d.setColor(Color.RED);
            g2d.fill(rectangle1);
            g2d.draw(rectangle1);
        }

        for(int i=0; i<mapa.gwiazdki.size(); i++){
            Rectangle2D rectangle2 = new Rectangle2D.Double(mapa.gwiazdki.get(i).getX()*10, mapa.gwiazdki.get(i).getY()*10, 10, 10);
            g2d.setColor(Color.YELLOW);
            g2d.fill(rectangle2);
            g2d.draw(rectangle2);
        }

        for(int i=0; i<mapa.najsilniejsze.size(); i++){
            Rectangle2D rectangle2 = new Rectangle2D.Double(mapa.najsilniejsze.get(i).getX()*10, mapa.najsilniejsze.get(i).getY()*10, 10, 10);
            g2d.setColor(Color.BLACK);
            g2d.fill(rectangle2);
            g2d.draw(rectangle2);
        }

        for(int i=0; i<mapa.wspolne.size(); i++){
            Rectangle2D rectangle2 = new Rectangle2D.Double(mapa.wspolne.get(i).getX()*10, mapa.wspolne.get(i).getY()*10, 10, 10);
            g2d.setColor(Color.BLUE);
            g2d.fill(rectangle2);
            g2d.draw(rectangle2);
        }

        Rectangle2D rectangle1 = new Rectangle2D.Double(mapa.robot.znajdzNajblizszaGwiazdke(mapa.gwiazdki).getX()*10, mapa.robot.znajdzNajblizszaGwiazdke(mapa.gwiazdki).getY()*10, 10, 10);
        g2d.setColor(Color.CYAN);
        g2d.fill(rectangle1);
        g2d.draw(rectangle1);

        System.out.println(Boolean.toString(mapa.czyRobotWTrojkacie(5.00)));
        System.out.println(Boolean.toString(mapa.czyRobotWTrojkacieAPIT()));

        JTextArea question = new JTextArea("Our method: " + Boolean.toString(mapa.czyRobotWTrojkacie(5)));
        question.setEditable(false);

        JTextArea question1 = new JTextArea("APIT: " + Boolean.toString(mapa.czyRobotWTrojkacieAPIT()));
        question1.setEditable(false);

        this.add(question);
        this.add(question1);

    }
}
