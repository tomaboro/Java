import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by Tomek on 2016-11-08.
 */
public class Kadry {
    public LinkedList<Pracownik> lista = new LinkedList();

    public Pracownik findPracownik(String _pesel){
        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i).getPesel().equals(_pesel)) return lista.get(i);
        }
        System.out.println("W bazie nie ma pracownika o takim nr pesel");
        return lista.getFirst();
    }

    public int findPracownikIndex(String _pesel){
        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i).getPesel().equals(_pesel)) return i;
        }
        System.out.println("W bazie nie ma pracownika o takim nr pesel");
        return -1;
    }

    public void deletePracownik(String _pesel){
        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i).getPesel().equals(_pesel)) lista.remove(i);
        }
    }

    public void addPracownik(Pracownik _pracownik){
        lista.add(_pracownik);
    }

    public double getBruttoPracownik(int i){
        return lista.get(i).getWynagrodzenieBrutto();
    }

    public void setBruttoPracownik(int i,double _brutto){
        lista.get(i).setWynagrodzenieBrutto(_brutto);
    }

    public double getNettoPracownik(int i){
        return lista.get(i).getWynagrodzenieNetto();
    }

    public void print(){
        for(int i=0; i<lista.size(); i++){
            lista.get(i).printPracownik();
            System.out.println("#####################");
        }
    }

    public void sort(){
        LinkedList<Pracownik> wynik = new LinkedList<>();
        Student tmp = new Student("96070612014",1000);

        while(lista.size()>0){
            int min = 0;

            for(int i=0; i<lista.size(); i++){
                if(tmp.compare(lista.get(min),lista.get(i)) > 0) min = i;
            }

            wynik.add(lista.get(min));
            lista.remove(min);
        }

        lista = (LinkedList<Pracownik>) wynik.clone();

    }

}
