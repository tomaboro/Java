import java.io.FileNotFoundException;

/**
 * Created by Tomek on 19.10.2016.
 */
public class Test {
    public static void main(String[] args){
        try {
            CwDB db = new CwDB("123");
        }
        catch(FileNotFoundException e){ System.out.println(e);}
    }
}
