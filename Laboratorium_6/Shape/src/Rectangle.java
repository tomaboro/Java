import com.sun.prism.*;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by Tomek on 2016-10-25.
 */
public class Rectangle extends Shape {

    public Rectangle(String n){name = n;}

    public void draw(java.awt.Graphics g,int y){
        Graphics2D g2d = (Graphics2D) g;
        Rectangle2D rectangle = new Rectangle2D.Double(10, y, 80, 50);
        g2d.draw(rectangle);
    }
}
