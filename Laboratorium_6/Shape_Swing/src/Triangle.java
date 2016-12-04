import com.sun.prism.Graphics;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by Tomek on 2016-10-25.
 */
public class Triangle extends Shape {

    public Triangle (String n,Color c,int x, int y){
        name = n;
        color = c;
        this.x = x;
        this.y = y;
    }

    public void draw(java.awt.Graphics g){

        Graphics2D g2d = (Graphics2D) g;

        Polygon polygon  = new Polygon(new int[] {this.x, this.x+30, this.x+60}, new int[] {this.y+50, this.y, this.y+50}, 3);

        g2d.setColor(this.color);
        g2d.fill(polygon);

        BasicStroke dashed = new BasicStroke(2);
        g2d.setColor(Color.darkGray);
        g2d.setStroke(dashed);
        g2d.draw(polygon);
    }

    public boolean isPressed(int x, int y){
        Polygon polygon  = new Polygon(new int[] {this.x, this.x+30, this.x+60}, new int[] {this.y+50, this.y, this.y+50}, 3);
        return polygon.contains(x,y);
    }
}
