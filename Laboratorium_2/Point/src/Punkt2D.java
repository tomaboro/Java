/**
 * Created by Tomek on 2016-10-18.
 */

public class Punkt2D {
    private double x;
    private double y;

    Punkt2D(double _x, double _y){
        setX(_x);
        setY(_y);
    }

    public double getX(){
        return x;
    }


    public double getY(){ return y; }

    public void setX(double _x){
        x = _x;
    }

    public void setY(double _y){
        y = _y;
    }

    public double distance(Punkt2D p2){
        return Math.sqrt( Math.pow(p2.x - x,2) + Math.pow(p2.y - y,2) );

    }
}
