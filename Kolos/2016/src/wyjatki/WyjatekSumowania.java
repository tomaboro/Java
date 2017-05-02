package wyjatki;

/**
 * Created by Tomek on 2017-01-10.
 */
public class WyjatekSumowania extends Exception {
    private String line;
    private int lineNo;

    public WyjatekSumowania(String line, int lineNo) {
        this.line = line;
        this.lineNo = lineNo;
    }

    public String getLine() {
        return line;
    }

    public int getLineNo() {
        return lineNo;
    }

    public String getMessage(){
        return ("Błąd WyjatekSumowania w lini nr: "+ lineNo + ": " + line);
    }

}
