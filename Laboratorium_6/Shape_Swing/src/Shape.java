import java.awt.*;

/**
 * Created by Tomek on 2016-10-25.
 */
public abstract class Shape{
    public int x;
    public int y;

    public String name;
    Color color;

    public abstract boolean isPressed(int x, int y);

    public void moveShape(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * Metoda rysujaca w konsoli dany kształt
     */
    public abstract void draw(Graphics g);
}
