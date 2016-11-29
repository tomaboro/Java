import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Created by Tomek on 2016-10-25.
 */
public class Circle extends Shape {

    public Circle (String n){name = n;}

    public void draw(java.awt.Graphics g,int y){
        Graphics2D g2d = (Graphics2D) g;
        Ellipse2D circle = new Ellipse2D.Double(10, y, 50, 50);
        g2d.draw(circle);
    }
}
