/**
 * Created by Tomek on 2017-01-10.
 */
public class ReprezentacjaPierwsze extends Reprezentacja {
    Long reprezentacjaWewnetrzna;

    public ReprezentacjaPierwsze(Long obj) {
        this.reprezentacjaWewnetrzna = obj;
    }

    @Override
    boolean porownaj(ReprezentacjaP rep) {
        //if (this.reprezentacjaWewnetrzna/((Long)rep.reprezentacjaWewnetrzna) == 0) return true;
        return false;
    }
}
