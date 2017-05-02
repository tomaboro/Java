/**
 * Created by Tomek on 04.01.2017.
 */
public class Stacja extends Obiekt {
    public Stacja(int x, int y){
        super(x,y);
    }

    public double zapytajSygnal(int x, int y){
        double odleglosc = Math.sqrt((this.x-x)*(this.x-x) + (this.y-y)*(this.y-y));
        return 1000-odleglosc;
    }
}
