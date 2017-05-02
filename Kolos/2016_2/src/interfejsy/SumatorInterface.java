package interfejsy;

import wyjatki.WyjatekSumowania;

/**
 * Created by Tomek on 2017-01-10.
 */
public interface SumatorInterface {
    public long sumuj(String FileName, int column) throws WyjatekSumowania;
}
