/**
 * Created by Tomek on 2016-10-25.
 */
public class Main {
    public static void main (String[] args) {
        Triangle t = new Triangle("Pawełek");
        Circle c = new Circle("Tomek");
        Rectangle r = new Rectangle("Iza");
        Square s = new Square("Eustachy");
        s.draw();
        t.draw();
        r.draw();
        c.draw();
    }
}
