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
    public long mnoz(String FileName, int row) throws WyjatekMnozenia {
        int LineNo = 0;
        String Line;
        long mnoz = 1;
        File file = new File(FileName);
        try {
            Scanner FileScanner = new Scanner(file);
            while(FileScanner.hasNextLine()) {
                Line = FileScanner.nextLine();
                LineNo++;
                for(int i = 0; i<Line.length(); i++)
                {
                    if ((Character.getNumericValue(Line.charAt(i)) < 0 ) || (Character.getNumericValue(Line.charAt(i)) >9)) throw new WyjatekMnozenia(Line,i);
                    if((LineNo == row) && (Character.getNumericValue(Line.charAt(i)) == 2)) mnoz *= Character.getNumericValue(Line.charAt(i));
                }
            }
        }catch (FileNotFoundException e){
            System.out.println("Pliku nie znaleziono");
        }

        if(LineNo < row || row < 0) throw new WyjatekMnozenia(null,LineNo);
        return mnoz;

    }

    @Override
    public long sumuj(String FileName, int column) throws WyjatekSumowania {
        int LineNo = -1, length = 0;
        String Line;
        long suma = 0;
        File file = new File(FileName);
        boolean notFound = true;
        try {
            Scanner FileScanner = new Scanner(file);
            while(FileScanner.hasNextLine()) {
                Line = FileScanner.nextLine();
                LineNo++;
                length = Line.length();
                for(int i = 0; i<Line.length(); i++)
                {
                    if ((Character.getNumericValue(Line.charAt(i)) < 0 ) || (Character.getNumericValue(Line.charAt(i)) >9)) throw new WyjatekSumowania(Line,LineNo);
                    if(i == column) {
                        suma += Character.getNumericValue(Line.charAt(i));
                        notFound = false;
                    }
                }
            }
        }catch (FileNotFoundException e){
            System.out.println("Pliku nie znaleziono");
        }

        if(column < 0 || notFound) throw new WyjatekSumowania(null,length);

        return suma;
    }
}
