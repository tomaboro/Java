import java.io.*;

/**
 * Created by Tomek on 2016-10-17.
 */
public class Matrix {

    public int m[][];
    private int y;
    private int x;

    public Matrix (int[][] tab, int _y, int _x){
        m = new int[_y][_x];
        y = _y;
        x = _x;
        for(int i = 0; i<y; i++){
            for(int j = 0; j<x ; j++){
                m[i][j] = tab[i][j];
            }
        }
    }

    public Matrix (int _y, int _x){
        y = _y;
        x = _x;
        m = new int[y][x];
        for(int i = 0; i<y; i++){
            for(int j = 0; j<x; j++){
                m[i][j] = 0;
            }
        }
    }

    public void printMatrix(){
        for(int i = 0; i<y; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print(m[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public Matrix plus (Matrix m2){
        Matrix m3 = new Matrix (y,x);
        if(x == m2.x && y ==m2.y){
            for(int i = 0; i<y; i++){
                for(int j = 0; j<x ; j++){
                    m3.m[i][j] = m[i][j] + m2.m[i][j];
                }
            }
        }
        else{
            System.out.println("Nie mozna dodac macierzy z powodu złych wymiarów!");
            System.out.println("Zwracam macierz zerową wymiarów"  + y +" ma " + x);
        }
        return m3;
    }

    public Matrix minus (Matrix m2){
        Matrix m3 = new Matrix (y,x);
        if(x == m2.x && y ==m2.y){
            for(int i = 0; i<y; i++){
                for(int j = 0; j<x ; j++){
                    m3.m[i][j] = m[i][j] - m2.m[i][j];
                }
            }
        }
        else{
            System.out.println("Nie mozna odjac macierzy z powodu złych wymiarów!");
            System.out.println("Zwracam macierz zerową wymiarów"  + y +" ma " + x);
        }

        return m3;
    }

    public Matrix razy (Matrix m2){
        Matrix m3 = new Matrix (y,m2.x);
        if(x == m2.y){
            for(int i = 0; i<y; i++){
                for(int j = 0; j<m2.x ; j++){
                    int s = 0;
                    for(int k=0; k<x; k++){
                        s = s + m[i][k] * m2.m[k][j];
                    }
                    m3.m[i][j] = s;
                }
            }
        }
        else{
            System.out.println("Nie mozna pomnozyc macierzy z powodu złych wymiarów!");
            System.out.println("Zwracam macierz zerową wymiarów"  + y +" ma " + m2.x);
        }
        return m3;
    }

}
