/**
 * Created by Tomek on 2016-10-17.
 */
public class Main {
    public static  void main( String [] argvc){
        int[][] tab1 = new int[1][3];
        int[][] tab2 = new int[1][3];

        tab1[0][0] = 1;
        tab1[0][1] = 2;
        tab1[0][2] = 3;

        tab2[0][0] = 1;
        tab2[0][1] = 2;
        tab2[0][2] = 3;


        Matrix m1 = new Matrix(tab1,1,3);
        Matrix m2 = new Matrix(tab2,1,3);
        Matrix m3 = new Matrix(1,3);

        m1.printMatrix();
        m2.printMatrix();

        m3 = m1.plus(m2);

        m3.printMatrix();

        m3 = m1.minus(m2);

        m3.printMatrix();

        tab2 = new int[3][1];

        tab2[0][0] = 1;
        tab2[1][0] = 2;
        tab2[2][0] = 3;

        m2 = new Matrix(tab2,3,1);

        m3 = m1.razy(m2);

        m3.printMatrix();
    }
}
