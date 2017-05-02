import interfejsy.MnoznikInterface;
import interfejsy.SumatorInterface;
import wyjatki.WyjatekMnozenia;
import wyjatki.WyjatekSumowania;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.System.in;

/**
 * Created by Tomek on 2017-01-10.
 */
public class ArytmetykaPlikowa implements MnoznikInterface, SumatorInterface {
    @Override
    public long mnoz(String FileName, int column) throws WyjatekMnozenia {
        int LineNo = 0, licznik = 0;
        String Line;
        long iloczyn = 1;
        File file = new File(FileName);
        try {
            Scanner FileScanner = new Scanner(file);
            while(FileScanner.hasNextLine()) {
                Line = FileScanner.nextLine();
                LineNo++;
                for(int i = 0; i<Line.length(); i++)
                {
                    if(i == column) {
                        if ((Character.getNumericValue(Line.charAt(i)) < 0 ) || (Character.getNumericValue(Line.charAt(i)) >9)) throw new WyjatekMnozenia(Line,LineNo);
                        if ((Character.getNumericValue(Line.charAt(i)) == 2)) iloczyn *= Character.getNumericValue(Line.charAt(i));
                    }
                }
            }
        }catch (FileNotFoundException e){
            System.out.println("Pliku nie znaleziono");
        }
        return iloczyn;

    }

    @Override
    public long sumuj(String FileName) throws WyjatekSumowania {
        int LineNo = 0;
        String Line;
        long suma = 0;
        File file = new File(FileName);
        try {
            Scanner FileScanner = new Scanner(file);
            while(FileScanner.hasNextLine()) {
                Line = FileScanner.nextLine();
                LineNo++;
                for(int i = 0; i<Line.length(); i++)
                {
                    if ((Character.getNumericValue(Line.charAt(i)) < 0 ) || (Character.getNumericValue(Line.charAt(i)) >9)) throw new WyjatekSumowania(Line,LineNo);
                    suma += Character.getNumericValue(Line.charAt(i));
                }
            }
        }catch (FileNotFoundException e){
            System.out.println("Pliku nie znaleziono");
        }
        return suma;
    }
}
