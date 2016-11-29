import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Created by Tomek on 2016-10-25.
 */
public class Circle extends Shape {

    public Circle (String n,Color c){
        name = n;
        color = c;
    }

    public void draw(java.awt.Graphics g,int y){

        Graphics2D g2d = (Graphics2D) g;

        Ellipse2D circle = new Ellipse2D.Double(10, y, 50, 50);

        GradientPaint grad = new GradientPaint(0,0,this.color,100, 0,color.WHITE);
        g2d.setPaint(grad);
        g2d.fill(circle);

        BasicStroke dashed = new BasicStroke(2);
        g2d.setColor(Color.darkGray);
        g2d.setStroke(dashed);
        g2d.draw(circle);
    }
}
