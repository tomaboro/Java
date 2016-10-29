import java.util.*;
import java.io.*;

/**
 * Created by Tomek on 19.10.2016.
 */
public class CwDB {

    private LinkedList<Entry> dict;

    public CwDB(String filename) throws FileNotFoundException{
        createDB(filename);
    }

    public void add(String word, String clue){
        Entry tmp = new Entry(word,clue);
        dict.add(tmp);
    }

    public Entry get(String word){
        for(int i=0;i<dict.size();i++){
            if(word.equals(dict.get(i).getWord())) return dict.get(i);
        }
        return null;
    }

    public Entry get(int i){
        return dict.get(i);
    }

    public void remove(String word){}

    public void saveDB(String filename) throws FileNotFoundException {
        PrintWriter zapis = new PrintWriter(filename);
        for(int i=0; i<dict.size(); i++){
            zapis.println(dict.get(i).getWord());
            zapis.println(dict.get(i).getClue());
        }
        zapis.close();

    }

    public int getSize() {
        return dict.size();
    }

    protected void createDB(String filename) throws  FileNotFoundException{

        Scanner odczyt = new Scanner(new File(filename));

        String _word;
        String _clue;

        _word = odczyt.nextLine();
        _clue = odczyt.nextLine();
        while(_word!=null && _clue!=null){
            add(_word,_clue);
            _word = odczyt.nextLine();
            _clue = odczyt.nextLine();
        }
        System.out.println(odczyt.nextLine());
    }

}
