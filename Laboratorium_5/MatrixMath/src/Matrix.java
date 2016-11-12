import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Tomek on 2016-10-17.
 */
public class Matrix {

    protected double m[][];

    public Matrix (double[][] tab) throws TableIsNotMatrixException{
        if(tab[0].length==0) throw new TableIsNotMatrixException();
        for(int i=0; i<tab.length-1; i++){
            if(tab[i].length!=tab[i+1].length) throw new TableIsNotMatrixException();
        }
        m = tab.clone();
    }

    public Matrix (int _y, int _x){
        m = new double[_y][_x];
        for(int i = 0; i<_y; i++){
            for(int j = 0; j<_x; j++){
                m[i][j] = 0;
            }
        }
    }

    public Matrix(File file) throws NotMatrixFileException, FileNotFoundException{
        Scanner in = null;
        try {
            in = new Scanner(file);
            Scanner line;

            LinkedList<double[]> lista = new LinkedList<double[]>();
            LinkedList<Double> sublista;

            while(in.hasNextLine()){
                line = new Scanner(in.nextLine());
                sublista = new LinkedList<Double>();

                while (line.hasNextDouble()) {
                    sublista.add(line.nextDouble());
                }

                if(lista.size() != 0 && sublista.size() != lista.getLast().length) throw new NotMatrixFileException();

                double subtab[] = new double[sublista.size()];


                for(int i=0; i<sublista.size(); i++){
                    subtab[i] = sublista.get(i);
                }

                lista.add(subtab.clone());
            }

            m = new double[lista.size()][];

            for(int i=0; i<lista.size(); i++){
                m[i] = lista.get(i);
            }

        }catch (FileNotFoundException e){
            System.out.println("Nie znaleziono pliku");
            throw e;
        }
        finally {
            in.close();
            System.out.println("Zamykam plik");
        }
    }

    public void printMatrix(){
        for(int i = 0; i<m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public Matrix plus (Matrix m2) throws MatrixDimensionsException{
        Matrix m3 = new Matrix (m.length,m[0].length);
        if(m[0].length != m2.m[0].length || m.length !=m2.m.length) throw new MatrixDimensionsException();
        for(int i = 0; i<m.length; i++){
            for(int j = 0; j<m[0].length ; j++){
                m3.m[i][j] = m[i][j] + m2.m[i][j];
            }
        }
        return m3;
    }

    public Matrix minus (Matrix m2) throws MatrixDimensionsException{
        Matrix m3 = new Matrix (m.length,m[0].length);
        if(m[0].length != m2.m[0].length || m.length !=m2.m.length) throw new MatrixDimensionsException();
        for(int i = 0; i<m.length; i++){
            for(int j = 0; j<m[0].length ; j++){
                m3.m[i][j] = m[i][j] - m2.m[i][j];
            }
        }
        return m3;
    }

    public Matrix razy (Matrix m2) throws MatrixDimensionsException{
        Matrix m3 = new Matrix (m.length,m2.m[0].length);
        if(m[0].length != m2.m.length) throw new MatrixDimensionsException();
        for(int i = 0; i<m.length; i++){
            for(int j = 0; j<m2.m[0].length ; j++){
                double s = 0;
                for(int k=0; k<m[0].length; k++){
                    s = s + m[i][k] * m2.m[k][j];
                }
                m3.m[i][j] = s;
            }
        }
        return m3;
    }
}
