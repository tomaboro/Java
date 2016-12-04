import com.sun.prism.*;

import java.awt.*;
import java.awt.BasicStroke;
import java.awt.geom.Rectangle2D;

/**
 * Created by Tomek on 2016-10-25.
 */
public class Rectangle extends Shape {

    public Rectangle (String n,Color c,int x, int y){
        name = n;
        color = c;
        this.x = x;
        this.y = y;
    }

    public void draw(java.awt.Graphics g){

        Graphics2D g2d = (Graphics2D) g;

        Rectangle2D rectangle = new Rectangle2D.Double(this.x, this.y, 80, 50);


        g2d.setColor(this.color);
        g2d.fill(rectangle);

        BasicStroke dashed = new BasicStroke(2);
        g2d.setColor(Color.darkGray);
        g2d.setStroke(dashed);
        g2d.draw(rectangle);
    }

    public boolean isPressed(int x, int y){
        Rectangle2D rectangle = new Rectangle2D.Double(this.x, this.y, 80, 50);
        return rectangle.contains(x,y);
    }

}
