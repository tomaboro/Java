package wyjatki;

/**
 * Created by Tomek on 2017-01-10.
 */
public class WyjatekMnozenia extends Exception {
    private String line;
    private int lineNo;

    public WyjatekMnozenia(String line, int lineNumber) {
        this.line = line;
        this.lineNo = lineNumber;
    }

    public String getLine() {
        return line;
    }

    public int getColNo() {
        return lineNo;
    }

    public String getMessage(){
        return ("Błąd WyjatekMnozenia w kolumnie: "+ lineNo + ": " + line);
    }
}
