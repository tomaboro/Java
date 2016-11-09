import java.util.LinkedList;

/**
 * Created by Tomek on 2016-11-08.
 */
public class Kadry {
    public LinkedList<Pracownik> lista = new LinkedList();

    public void addPracownik(){

    }

    public Pracownik findPracownik(Pesel _pesel){
        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i).getPesel().getPesel().equals(_pesel.getPesel())) return lista.get(i);
        }
        System.out.println("W bazie nie ma pracownika o takim nr pesel");
        return lista.getFirst();
    }

    public int findPracownikIndex(Pesel _pesel){
        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i).getPesel().getPesel().equals(_pesel.getPesel())) return i;
        }
        System.out.println("W bazie nie ma pracownika o takim nr pesel");
        return -1;
    }

    public void deletePracownik(Pesel _pesel){
        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i).getPesel().getPesel().equals(_pesel.getPesel())) lista.remove(i);
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

}
