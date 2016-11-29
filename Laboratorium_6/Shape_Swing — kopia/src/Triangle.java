import com.sun.prism.Graphics;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by Tomek on 2016-10-25.
 */
public class Triangle extends Shape {

    public Triangle (String n,Color c){
        name = n;
        color = c;
    }

    public void draw(java.awt.Graphics g,int y){

        Graphics2D g2d = (Graphics2D) g;

        Polygon polygon  = new Polygon(new int[] {10, 40, 70}, new int[] {y+50, y, y+50}, 3);

        GradientPaint grad = new GradientPaint(0,0,this.color,100, 0,color.WHITE);
        g2d.setPaint(grad);
        g2d.fill(polygon);

        BasicStroke dashed = new BasicStroke(2);
        g2d.setColor(Color.darkGray);
        g2d.setStroke(dashed);
        g2d.draw(polygon);
    }
}
