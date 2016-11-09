/**
 * Created by Tomek on 2016-11-08.
 */
public class Student extends Pracownik{

    Student(Pesel _pesel, double _brutto){
        super(_pesel,_brutto);
    }

    Student(){
        super();
    }

    @Override
    public double getWynagrodzenieNetto() {
        return 0.95*this.getWynagrodzenieBrutto();
    }

    @Override
    public void printPracownik() {
        System.out.println("PESEL: " + this.getPesel().getPesel() +"\nBRUTTO: " + this.getWynagrodzenieBrutto() + "\nNETTO: " + this.getWynagrodzenieNetto());
    }
}
