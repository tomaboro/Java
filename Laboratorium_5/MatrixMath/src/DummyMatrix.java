import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by Tomek on 12.11.2016.
 */
public class DummyMatrix extends Matrix {

    public DummyMatrix(int _y, int _x) {
        super(_y, _x);
    }

    public DummyMatrix(double tab[][]) throws TableIsNotMatrixException{
        //try {
            super(tab);
        /*}catch (TableIsNotMatrixException e){
            int max = tab[0].length;
            for(int i=1;i<tab.length-1;i++){
                if(max < tab[i].length ) max = tab[i].length;
            }
            m = new double[tab.length][max];

            for(int i=0; i<m.length; i++){
                for(int j=0;j<m[0].length;j++){
                    m[i][j] = 1;
                }
            }

            for(int i=0; i<tab.length; i++){
                for(int j=0;j<tab[i].length;j++){
                    m[i][j] = tab[i][j];
                }
            }

        }*/
    }

    public DummyMatrix(File file) throws NotMatrixFileException, FileNotFoundException {
        super(file);
    }

    private DummyMatrix filledDummyMatrix(int _y, int _x, int w){
        double tab[][] = new double[_y][_x];

        for (int i = 0; i < _y; i++) {
            for (int j = 0; j < _x; j++) {
                tab[i][j] = w;
            }
        }

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                tab[i][j] = m[i][j];
            }
        }

        try {
            return new DummyMatrix(tab);
        }
        catch(TableIsNotMatrixException e){}

        return new DummyMatrix(_y,_x);
    }

    public DummyMatrix plus(DummyMatrix m2) {
        try {
            return new DummyMatrix(super.plus(m2).m);
        } catch (MatrixDimensionsException e) {
            if (m.length < m2.m.length) {
                if (m[0].length < m2.m[0].length) {
                    return this.filledDummyMatrix(m2.m.length,m2.m[0].length,1).plus(m2);
                }
                else{
                    return this.filledDummyMatrix(m2.m.length,m2.m[0].length,1).plus(m2.filledDummyMatrix(m2.m.length,m2.m[0].length,1));
                }
            }
            else{
                if (m[0].length < m2.m[0].length) {
                    return this.filledDummyMatrix(m.length,m2.m[0].length,1).plus(m2.filledDummyMatrix(m.length,m2.m[0].length,1));
                }
                else {
                    return this.plus(m2.filledDummyMatrix(m.length,m[0].length,1));
                }
            }
        }
        catch(TableIsNotMatrixException e){}

        return new DummyMatrix(1,1);
    }

    public DummyMatrix minus(DummyMatrix m2) {
        try {
            return new DummyMatrix(super.minus(m2).m);
        } catch (MatrixDimensionsException e) {
            if (m.length < m2.m.length) {
                if (m[0].length < m2.m[0].length) {
                    return this.filledDummyMatrix(m2.m.length,m2.m[0].length,1).minus(m2);
                }
                else{
                    return this.filledDummyMatrix(m2.m.length,m2.m[0].length,1).minus(m2.filledDummyMatrix(m2.m.length,m2.m[0].length,1));
                }
            }
            else{
                if (m[0].length < m2.m[0].length) {
                    return this.filledDummyMatrix(m.length,m2.m[0].length,1).minus(m2.filledDummyMatrix(m.length,m2.m[0].length,1));
                }
                else {
                    return this.minus(m2.filledDummyMatrix(m.length,m[0].length,1));
                }
            }
        }
        catch(TableIsNotMatrixException e){}

        return new DummyMatrix(1,1);
    }

    public DummyMatrix razy(DummyMatrix m2) {
        try {
            return new DummyMatrix(super.razy(m2).m);
        } catch (MatrixDimensionsException e) {
            if (m[0].length < m2.m.length){
                return this.filledDummyMatrix(m.length,m2.m.length,1).razy(m2);
            }
            else{
                return this.razy(m2.filledDummyMatrix(m[0].length,m2.m[0].length,1));
            }
        }
        catch(TableIsNotMatrixException e){}

        return new DummyMatrix(1,1);
    }


}
