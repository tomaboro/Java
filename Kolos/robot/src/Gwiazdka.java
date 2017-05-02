import java.util.LinkedList;

/**
 * Created by Tomek on 04.01.2017.
 */
public class Gwiazdka extends Obiekt {
    double []sygnaly = new double[3];
    public Gwiazdka(int x, int y, LinkedList<Stacja> stacje){
        super(x,y);
        for(int i = 0; i < stacje.size();++i){
            sygnaly[i] = zapytajSygnał(stacje.get(i));
        }
    }

    public double zapytajSygnał(Stacja s){
        return s.zapytajSygnal(this.x,this.y);
    }
}
