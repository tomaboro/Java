import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by Tomek on 12.11.2016.
 */
public class DummyMatrix extends Matrix {
    public DummyMatrix(int _y, int _x){
        super(_y,_x);
    }

    public DummyMatrix(double tab[][]) throws TableIsNotMatrixException{
        super(tab);
    }

    public DummyMatrix(File file) throws NotMatrixFileException, FileNotFoundException{
        super(file);
    }
}
