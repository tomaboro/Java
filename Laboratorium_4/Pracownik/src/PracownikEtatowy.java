/**
 * Created by Tomek on 2016-11-08.
 */
public class PracownikEtatowy extends Pracownik {

    public int compare(PracownikEtatowy p1){

        return 1;
    }

    boolean equals(PracownikEtatowy p2){

        return true;
    }

    PracownikEtatowy(String _pesel, double _brutto){
        super(_pesel,_brutto);
    }

    @Override
    public double getWynagrodzenieNetto() {
        return 0.8*this.getWynagrodzenieBrutto();
    }

    @Override
    public void printPracownik() {
        System.out.println("PESEL: " + this.getPesel() +"\nBRUTTO: " + this.getWynagrodzenieBrutto() + "\nNETTO: " + this.getWynagrodzenieNetto());
    }
}
