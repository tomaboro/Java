import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Created by Tomek on 2016-10-25.
 */
public class Circle extends Shape {

    public Circle (String n,Color c,int x, int y){
        name = n;
        color = c;
        this.x = x;
        this.y = y;
    }

    public void draw(java.awt.Graphics g){

        Graphics2D g2d = (Graphics2D) g;

        Ellipse2D circle = new Ellipse2D.Double(this.x, this.y, 50, 50);


        g2d.setColor(this.color);
        g2d.fill(circle);

        BasicStroke dashed = new BasicStroke(2);
        g2d.setColor(Color.darkGray);
        g2d.setStroke(dashed);
        g2d.draw(circle);
    }

    public boolean isPressed(int x, int y){
        Ellipse2D circle = new Ellipse2D.Double(this.x, this.y, 50, 50);
        return circle.contains(x,y);
    }

}
