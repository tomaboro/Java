/**
 * Created by Tomek on 04.01.2017.
 */
public class Obiekt {
    protected int x;
    protected int y;

    public Obiekt(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {

        return x;
    }

    public int getY() {
        return y;
    }
}
