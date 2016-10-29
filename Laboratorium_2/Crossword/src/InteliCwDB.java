import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Tomek on 19.10.2016.
 */

public class InteliCwDB extends CwDB {

    public InteliCwDB(String filename) throws FileNotFoundException {
        super(filename);
    }

    public LinkedList<Entry> findAll(String pattern) {
        Pattern pattern1 = Pattern.compile(pattern);
        Matcher m;
        LinkedList<Entry>find = new LinkedList<Entry>();
        for(int i=0;i<getSize();i++){
            m = pattern1.matcher(get(i).getWord());
            if(m.matches()) find.add(new Entry(get(i).getWord(),get(i).getClue()));
        }
        return find;
    }

    public Entry getRandom() {
        Random generator = new Random();
        return get(generator.nextInt(getSize()));
    }

    public Entry getRandom(int length) {
        LinkedList<Entry> find = new LinkedList<Entry>();
        for (int i=0;i<getSize();i++){
            if (get(i).getWord().length() == length) find.add(get(i));
        }
        Random generator = new Random();
        return find.get(generator.nextInt(find.size()));
    }

    public Entry getRandom(String pattern) {
        LinkedList<Entry> find = findAll(pattern);
        Random generator = new Random();
        return find.get(generator.nextInt(find.size()));
    }
}
