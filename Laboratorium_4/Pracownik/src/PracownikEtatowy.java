/**
 * Created by Tomek on 2016-11-08.
 */
public class PracownikEtatowy extends Pracownik {

    PracownikEtatowy(Pesel _pesel, double _brutto){
        super(_pesel,_brutto);
    }

    PracownikEtatowy(){
        super();
    }

    @Override
    public double getWynagrodzenieNetto() {
        return 0.8*this.getWynagrodzenieBrutto();
    }

    @Override
    public void printPracownik() {
        System.out.println("PESEL: " + this.getPesel().getPesel() +"\nBRUTTO: " + this.getWynagrodzenieBrutto() + "\nNETTO: " + this.getWynagrodzenieNetto());
    }
}
