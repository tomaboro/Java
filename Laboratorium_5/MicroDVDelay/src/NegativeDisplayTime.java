/**
 * Created by Tomek on 2016-11-14.
 */
public class NegativeDisplayTime extends Exception {
    private int line;
    private String message;
    public NegativeDisplayTime(int _line,String s){
        line = _line;
        message = s;
    }

    public void print(){
        System.out.println("Wystąpił błąd NegativeDisplayTime w linii " + line +"\n          " + message);
    }
}
