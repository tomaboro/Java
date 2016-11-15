/**
 * Created by Tomek on 14.11.2016.
 */
public class LineWrongFormat extends Exception {
    private int line;
    private String message;
    public LineWrongFormat(int _line,String s){
        line = _line;
        message = s;
    }

    public void print(){
        System.out.println("Wystąpił błąd LineWrongFormat w linii " + line +"\n          " + message);
    }
}
