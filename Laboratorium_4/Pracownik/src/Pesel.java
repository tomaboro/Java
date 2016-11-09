/**
 * Created by Tomek on 2016-10-17.
 */
public class Pesel {

    public static String Pesel = "";

    public static boolean checkFormat() {

        if(!checkLength()) return false;

        for(int i=0; i<10; i++){
            if (Character.getNumericValue(Pesel.charAt(i)) > 9 || Character.getNumericValue(Pesel.charAt(i)) < 0) return false;
        }

        return true;
    }

    public static boolean checkLength(){
        if(Pesel.length()!= 11) return false;
        return true;
    }

    public static boolean checkControlSum() {
        int suma = 0;

        if(checkFormat() && checkLength()){
            suma = Character.getNumericValue(Pesel.charAt(0)) + 3*Character.getNumericValue(Pesel.charAt(1))
                    + 7*Character.getNumericValue(Pesel.charAt(2)) + 9*Character.getNumericValue(Pesel.charAt(3))
                    + Character.getNumericValue(Pesel.charAt(4)) + 3*Character.getNumericValue(Pesel.charAt(5))
                    + 7*Character.getNumericValue(Pesel.charAt(6)) + 9*Character.getNumericValue(Pesel.charAt(7))
                    + Character.getNumericValue(Pesel.charAt(8)) + 3*Character.getNumericValue(Pesel.charAt(9));

            suma = suma % 10;

            if(suma!=0) suma = 10 - suma;

            if(suma == Character.getNumericValue(Pesel.charAt(10))) return true;
        }

        return false;
    }

    public static boolean checkControlSum(String _pesel) {

        Pesel = _pesel;

        return checkControlSum();
    }

}
