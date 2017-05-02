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
    public static long[] sum_results = { 23140L, 23131L, 0L, 23145L };
    public static long[] mul_results = { 1024L, 256L, 2048L, 1024L };
    public static int kolumna = 2;

    public static final void main(String[] paramArrayOfString)
    {
        ArytmetykaPlikowa ap = new ArytmetykaPlikowa();
        try {
            System.out.println(ap.mnoz("testM.txt",2));
        } catch (WyjatekMnozenia wyjatekMnozenia) {
            wyjatekMnozenia.printStackTrace();
        }

        try {
            System.out.println(ap.sumuj("testS.txt"));
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
        for (int j = 0; j < filenames.length; j++) {
            try
            {
                try
                {
                    System.out.println("Rozpoczenie mnozenia pliku: " + filenames[j]);
                    double d2 = localArytmetykaPlikowa1.mnoz(filenames[j], kolumna);
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
                catch (WyjatekMnozenia localWyjatekMnozenia)
                {
                    System.out.println("Zlapano wyjatek...");
                    if (j == 2)
                    {
                        d1 += 1.0D;
                        System.out.println("Dobrze!(1/1)");
                        System.out.println("Sprawdzam numer lini i linijke.");
                        if (localWyjatekMnozenia.getLine().compareTo("87O83646182799346313767754317819363333118982642191") == 0)
                        {
                            d1 += 0.5D;
                            System.out.println("Linijka OK.(0.5/0.5)");
                        }
                        if (localWyjatekMnozenia.getLineNo() == 78)
                        {
                            d1 += 0.5D;
                            System.out.println("Numer Linii OK.(0.5/0.5)");
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
                    double d3 = localArytmetykaPlikowa2.sumuj(filenames[j]);
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
                catch (WyjatekSumowania localWyjatekSumowania)
                {
                    System.out.println("Zlapano wyjatek...");
                    if (j == 2)
                    {
                        d1 += 1.0D;
                        System.out.println("Dobrze.(1/1)");
                        System.out.println("Sprawdzam numer lini i linijke.");
                        if (localWyjatekSumowania.getLine().compareTo("38298213783131473527721581O48144513491373226651381") == 0)
                        {
                            d1 += 0.5D;
                            System.out.println("Linijka OK.(0.5/0.5)");
                        }
                        if (localWyjatekSumowania.getLineNo() == 57)
                        {
                            d1 += 0.5D;
                            System.out.println("Numer Linii OK.(0.5/0.5))");
                        }
                    }
                    else
                    {
                        System.out.println("Ale nie tam gdzie trzeba...");
                    }
                }
            }
            catch (Exception localException)
            {
                System.out.println("Oj... nie nie nie. Nie tak.");
            }
        }
        System.out.println("Tworze watek mnoznika...");
        Wynik localWynik1 = new Wynik();
        WatekMnozacy localWatekMnozacy = new WatekMnozacy(filenames[0], kolumna, localArytmetykaPlikowa1, localWynik1);
        System.out.println("Startuje watek mnoznika...");
        localWatekMnozacy.start();
        d1 += 1.0D;
        System.out.println("Dobrze!(1/1)");

        System.out.println("Tworze watek sumatora...");
        Wynik localWynik2 = new Wynik();
        WatekSumujacy localWatekSumujacy = new WatekSumujacy(filenames[0], localArytmetykaPlikowa2, localWynik2);
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
        System.out.println("SUMA PUNKTOW: " + (d1 + i / (sum_results.length - 1)) + "/19");
    }
}
