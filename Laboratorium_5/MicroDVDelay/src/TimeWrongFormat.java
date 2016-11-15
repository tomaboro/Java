/**
 * Created by Tomek on 14.11.2016.
 */
public class TimeWrongFormat extends Exception {
    private int line;
    private String message;
    public TimeWrongFormat(int _line,String s){
        line = _line;
        message = s;
    }

    public void print(){
        System.out.println("Wystąpił błąd TimeWrongFormat w linii " + line +"\n          " + message);
    }
}
