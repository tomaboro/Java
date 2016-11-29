import com.sun.prism.Graphics;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by Tomek on 2016-10-25.
 */
public class Triangle extends Shape {

    public Triangle(String n){name = n;}

    public void draw(java.awt.Graphics g,int y){
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawPolygon(new int[] {10, 40, 70}, new int[] {y+50, y, y+50}, 3);
    }
}
