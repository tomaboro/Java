import java.awt.*;

/**
 * Created by Tomek on 2016-10-25.
 */
public abstract class Shape{
    public String name;
    Color color;

    /**
     * Metoda rysujaca w konsoli dany kształt
     */
    public abstract void draw(Graphics g,int y);
}
