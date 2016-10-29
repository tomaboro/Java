/**
 * Created by Tomek on 19.10.2016.
 */
public class Entry {
    private String word;
    private String clue;

    public Entry(String _word, String _clue){
        word = _word;
        clue = _clue;
    }
    public String getWord(){
        return word;
    }
    public String getClue(){
        return clue;
    }
}
