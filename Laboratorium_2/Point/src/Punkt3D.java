/**
 * Created by Tomek on 2016-10-18.
 */
public class Punkt3D extends  Punkt2D {
    private double z;

    Punkt3D(double _x, double _y, double _z){
        super(_x,_y);
        z = _z;
    }

    public double getZ(){
        return z;
    }

    public void setZ(double _z){
        z = _z;
    }

    public double distance(Punkt3D p2){
        return Math.sqrt( Math.pow(p2.getX() - getX(),2) + Math.pow(p2.getY() - getY(),2) + Math.pow(p2.z - z,2) );

    }
}
