import interfejsy.MnoznikInterface;
import interfejsy.SumatorInterface;
import java.io.PrintStream;
import watki.WatekMnozacy;
import watki.WatekSumujacy;
import watki.Wynik;
import wyjatki.WyjatekMnozenia;
import wyjatki.WyjatekSumowania;

public class Main
{
    public static String[] filenames = { "test-1.txt", "test-2.txt", "test-3.txt", "test-4.txt" };
    public static long[] sum_results = { 452L, 434L, 0L, 407L };
    public static long[] mul_results = { 64L, 32L, 64L, 1024L };
    public static int kolumna = 49;
    public static int wiersz = 2;

    public static final void main(String[] paramArrayOfString)
    {

        ArytmetykaPlikowa ap = new ArytmetykaPlikowa();
        try {
            System.out.println(ap.mnoz("testM.txt",2));
        } catch (WyjatekMnozenia wyjatekMnozenia) {
            wyjatekMnozenia.printStackTrace();
        }

        try {
            System.out.println(ap.sumuj("testS.txt",0));
        } catch (WyjatekSumowania wyjatekSumowania) {
            wyjatekSumowania.printStackTrace();
        }


        double d1 = 0.0D;

        ArytmetykaPlikowa localArytmetykaPlikowa1 = new ArytmetykaPlikowa();
        d1 += 1.0D;
        System.out.println("Utworzenie mnoznika. Dobrze!(1/1)");
        ArytmetykaPlikowa localArytmetykaPlikowa2 = new ArytmetykaPlikowa();
        d1 += 1.0D;
        System.out.println("Utworzenie sumatora. Dobrze! (1/1)");
        int i = 0;
        try
        {
            for (int j = 0; j < filenames.length; j++) {
                try
                {
                    try
                    {
                        System.out.println("Rozpoczenie mnozenia pliku: " + filenames[j]);
                        double d2 = localArytmetykaPlikowa1.mnoz(filenames[j], wiersz);
                        System.out.println("Wynik mnozenia: " + d2);
                        if (d2 == mul_results[j])
                        {
                            i += 5;
                            System.out.println("Dobrze!! (5/5)");
                        }
                        else
                        {
                            System.out.println("Zle...");
                        }
                    }
                    catch (WyjatekMnozenia localWyjatekMnozenia1)
                    {
                        System.out.println("Zlapano wyjatek...");
                        if (j == 2)
                        {
                            d1 += 1.0D;
                            System.out.println("Dobrze!(1/1)");
                            System.out.println("Sprawdzam numer lini i linijke.");
                            if (localWyjatekMnozenia1.getLine().compareTo("74324986199524741159O74233319513158123726617319629") == 0)
                            {
                                d1 += 0.5D;
                                System.out.println("Linijka OK.(0.5/0.5)");
                            }
                            else
                            {
                                System.out.println("Kolumna" + localWyjatekMnozenia1.getLine() + "...Zle");
                            }
                            if (localWyjatekMnozenia1.getColNo() == 20)
                            {
                                d1 += 0.5D;
                                System.out.println("Numer Linii OK.(0.5/0.5)");
                            }
                            else
                            {
                                System.out.println("Numer kolumny: " + localWyjatekMnozenia1.getColNo() + "...Zle");
                            }
                        }
                        else
                        {
                            System.out.println("Ale nie tam gdzie trzeba...");
                        }
                    }
                    try
                    {
                        System.out.println("Rozpoczenie sumowania pliku: " + filenames[j]);
                        double d3 = localArytmetykaPlikowa2.sumuj(filenames[j], kolumna);
                        System.out.println("Wynik sumowania: " + d3);
                        if (d3 == sum_results[j])
                        {
                            i += 4;
                            System.out.println("Dobrze!!(4/4)");
                        }
                        else
                        {
                            System.out.println("Zle...");
                        }
                    }
                    catch (WyjatekSumowania localWyjatekSumowania1)
                    {
                        System.out.println("Zlapano wyjatek...");
                        if (j == 2)
                        {
                            d1 += 1.0D;
                            System.out.println("Dobrze.(1/1)");
                            System.out.println("Sprawdzam numer kolumny i linijke.");
                            if (localWyjatekSumowania1.getLine().compareTo("2318971677254791516151551495392297953191112996751O") == 0)
                            {
                                d1 += 0.5D;
                                System.out.println("Linijka OK.(0.5/0.5)");
                            }
                            else
                            {
                                System.out.println("Linia" + localWyjatekSumowania1.getLine() + "...Zle");
                            }
                            if (localWyjatekSumowania1.getLineNo() == 62)
                            {
                                d1 += 0.5D;
                                System.out.println("Numer Linii OK.(0.5/0.5))");
                            }
                            else
                            {
                                System.out.println("Numer Linii: " + localWyjatekSumowania1.getLineNo() + "...Zle");
                            }
                        }
                        else
                        {
                            System.out.println("Ale nie tam gdzie trzeba...");
                        }
                    }
                }
                catch (Exception localException2)
                {
                    System.out.println("Oj... nie nie nie. Nie tak.");
                }
            }
            System.out.println("Tworze watek mnoznika...");
            Wynik localWynik1 = new Wynik();
            WatekMnozacy localWatekMnozacy = new WatekMnozacy(filenames[0], wiersz, localArytmetykaPlikowa1, localWynik1);
            System.out.println("Startuje watek mnoznika...");
            localWatekMnozacy.start();
            d1 += 1.0D;
            System.out.println("Dobrze!(1/1)");

            System.out.println("Tworze watek sumatora...");
            Wynik localWynik2 = new Wynik();
            WatekSumujacy localWatekSumujacy = new WatekSumujacy(filenames[0], kolumna, localArytmetykaPlikowa2, localWynik2);
            System.out.println("Startuje watek sumatora...");
            localWatekSumujacy.start();
            d1 += 1.0D;
            System.out.println("Dobrze!(1/1)");

            System.out.println("Czekam na zakonczenie pray watkow...");
            try
            {
                localWatekMnozacy.join();
                localWatekSumujacy.join();
            }
            catch (InterruptedException localInterruptedException)
            {
                System.out.println("Oj.... nie nie nie. Nie tak.");
                localInterruptedException.printStackTrace();
            }
            System.out.println("Zakonczono monzenie. Wynik: " + localWynik1.getWynik());
            if (localWynik1.getWynik() == mul_results[0])
            {
                d1 += 1.0D;
                System.out.println("Dobrze!!!(1/1)");
            }
            else
            {
                System.out.println("Zle...");
            }
            System.out.println("Zakonczono sumowanie. Wynik: " + localWynik2.getWynik());
            if (localWynik2.getWynik() == sum_results[0])
            {
                d1 += 1.0D;
                System.out.println("Dobrze!!!(1/1)");
            }
            else
            {
                System.out.println("Zle...");
            }
            System.out.println("Testuje wyjatki dla niepoprawnych kolumn sumowania.");
            try
            {
                System.out.println("Ujemne kolumny...");
                localArytmetykaPlikowa2.sumuj(filenames[0], -1);
            }
            catch (WyjatekSumowania localWyjatekSumowania2)
            {
                System.out.println("Zlapano wyjatek (1/1)");
                d1 += 0.25D;
                System.out.println("Linia: " + localWyjatekSumowania2.getLine());
                System.out.println("Ilosc kolumn: " + localWyjatekSumowania2.getLineNo());
                if ((localWyjatekSumowania2.getLine() == null) && (localWyjatekSumowania2.getLineNo() == 50))
                {
                    d1 += 0.25D;
                    System.out.println("OK! (1/1)");
                }
                else
                {
                    System.out.println("Zle.. (0/1)");
                }
            }
            try
            {
                System.out.println("Za duze kolumny...");
                localArytmetykaPlikowa2.sumuj(filenames[0], 100);
            }
            catch (WyjatekSumowania localWyjatekSumowania3)
            {
                System.out.println("Zlapano wyjatek (0.25/0.25)");
                d1 += 0.25D;
                System.out.println("Linia: " + localWyjatekSumowania3.getLine());
                System.out.println("Ilosc kolumn: " + localWyjatekSumowania3.getLineNo());
                if ((localWyjatekSumowania3.getLine() == null) && (localWyjatekSumowania3.getLineNo() == 50))
                {
                    d1 += 0.25D;
                    System.out.println("OK! (0.25/0.25)");
                }
                else
                {
                    System.out.println("Zle.. (0/0.25)");
                }
            }
            System.out.println("Testuje wyjatki dla niepoprawnych wierszy mnozenia.");
            try
            {
                System.out.println("Ujemne wiersze...");
                localArytmetykaPlikowa1.mnoz(filenames[0], -1);
            }
            catch (WyjatekMnozenia localWyjatekMnozenia2)
            {
                System.out.println("Zlapano wyjatek (1/1)");
                d1 += 0.25D;
                System.out.println("Linia: " + localWyjatekMnozenia2.getLine());
                System.out.println("Ilosc wierszy: " + localWyjatekMnozenia2.getColNo());
                if ((localWyjatekMnozenia2.getLine() == null) && (localWyjatekMnozenia2.getColNo() == 100))
                {
                    d1 += 0.25D;
                    System.out.println("OK! (0.25/0.25)");
                }
                else
                {
                    System.out.println("Zle.. (0/0.25)");
                }
            }
            try
            {
                System.out.println("Za duze wiersze...");
                localArytmetykaPlikowa1.mnoz(filenames[0], 100);
            }
            catch (WyjatekMnozenia localWyjatekMnozenia3)
            {
                System.out.println("Zlapano wyjatek (0.25/0.25)");
                d1 += 0.25D;
                System.out.println("Linia: " + localWyjatekMnozenia3.getLine());
                System.out.println("Ilosc wierszy: " + localWyjatekMnozenia3.getColNo());
                if ((localWyjatekMnozenia3.getLine() == null) && (localWyjatekMnozenia3.getColNo() == 100))
                {
                    d1 += 0.25D;
                    System.out.println("OK! (0.25/0.25)");
                }
                else
                {
                    System.out.println("Zle.. (0/1)");
                }
            }
        }
        catch (Exception localException1) {}finally
        {
            System.out.println("SUMA PUNKTOW: " + (d1 + i / (sum_results.length - 1)) + "/21");
        }
    }
}
