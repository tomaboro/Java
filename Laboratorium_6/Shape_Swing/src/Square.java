import com.sun.prism.Graphics;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by Tomek on 2016-10-25.
 */
public class Square extends Shape {

    public Square (String n,Color c){
        name = n;
        color = c;
    }

    public void draw(java.awt.Graphics g,int y){

        Graphics2D g2d = (Graphics2D) g;

        Rectangle2D rectangle = new Rectangle2D.Double(10, y, 50, 50);

        GradientPaint grad = new GradientPaint(0,0,this.color,100, 0,color.WHITE);
        g2d.setPaint(grad);
        g2d.fill(rectangle);

        BasicStroke dashed = new BasicStroke(2);
        g2d.setColor(Color.darkGray);
        g2d.setStroke(dashed);
        g2d.draw(rectangle);
    }
}
