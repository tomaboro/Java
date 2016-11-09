/**
 * Created by Tomek on 2016-11-08.
 */
public class Student extends Pracownik{

    public int compare(Student p1){

        return 1;
    }

    boolean equals(Student p2){

        return true;
    }

    Student(String _pesel, double _brutto){
        super(_pesel,_brutto);
    }

    @Override
    public double getWynagrodzenieNetto() {
        return 0.95*this.getWynagrodzenieBrutto();
    }

    @Override
    public void printPracownik() {
        System.out.println("PESEL: " + this.getPesel() +"\nBRUTTO: " + this.getWynagrodzenieBrutto() + "\nNETTO: " + this.getWynagrodzenieNetto());
    }
}
