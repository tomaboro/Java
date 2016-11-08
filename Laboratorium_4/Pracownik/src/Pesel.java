import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by Tomek on 2016-10-17.
 */
public class Pesel {

    private String Pesel;

    public Pesel(String _pesel){
        if (checkControlSum(_pesel)) Pesel=_pesel;
        else throw new IllegalStateException("Błędny format numeru pesel");
    }

    /*Pesel(){
        while(true) {
            Scanner odczyt = new Scanner(System.in);
            System.out.print("Podaj PESEL: ");
            String _pesel = odczyt.next();
            if (check(_pesel)) {
                Pesel = _pesel;
                break;
            }
            System.out.println("Błędny pesel");
        }
    }*/

    public String getPesel(){
        return Pesel;
    }

    public static boolean checkFormat(String _pesel) {

        if(!checkLength(_pesel)) return false;

        for(int i=0; i<10; i++){
           if (Character.getNumericValue(_pesel.charAt(i)) > 9 || Character.getNumericValue(_pesel.charAt(i)) < 0) return false;
        }

        return true;
    }

    public static boolean checkLength(String _pesel){
        if(_pesel.length()!= 11) return false;
        return true;
    }

    public static boolean checkControlSum(String _pesel) {
        int suma = 0;

        if(checkFormat(_pesel) && checkLength(_pesel)){
            suma = Character.getNumericValue(_pesel.charAt(0)) + 3*Character.getNumericValue(_pesel.charAt(1))
                    + 7*Character.getNumericValue(_pesel.charAt(2)) + 9*Character.getNumericValue(_pesel.charAt(3))
                    + Character.getNumericValue(_pesel.charAt(4)) + 3*Character.getNumericValue(_pesel.charAt(5))
                    + 7*Character.getNumericValue(_pesel.charAt(6)) + 9*Character.getNumericValue(_pesel.charAt(7))
                    + Character.getNumericValue(_pesel.charAt(8)) + 3*Character.getNumericValue(_pesel.charAt(9));

            suma = suma % 10;

            if(suma!=0) suma = 10 - suma;

            if(suma == Character.getNumericValue(_pesel.charAt(10))) return true;
        }

        return false;
    }

    public static boolean check(String _string){
        return checkControlSum(_string);
    }


}
